
var mapFc = function() {
  emit(this.sex, { count: 1, height: this.height, weight: this.weight });
}

var reduceFc = function(sex, values) {
  var output = { count: 0, weight: 0, height: 0 };

  values.forEach(value => {
    output.weight += value.weight;
    output.height += value.height;
    output.count += value.count
  });

  return output;
}

var finalize = function(key, value) {
  result = { }
  result.avg_weight = value.weight / value.count
  result.avg_height = value.height / value.count

  return result;
}

printjson(db.people.mapReduce(
  mapFc,
  reduceFc,
  {
    out: "zapytanie_1_mr",
    finalize: finalize
  }
));
printjson(db.zapytanie_1_mr.find({}).toArray())
