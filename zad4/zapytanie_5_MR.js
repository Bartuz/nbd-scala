var mapFc = function() {
  this.credit.forEach(credit => {
    emit(null, { count: 1, bal: parseFloat(credit.balance) });
  });
}

var reduceFc = function(key, values) {
  var output = { count: 0, bal: 0 };

  values.forEach(value => {
    output.bal += value.bal;
    output.count += value.count
  });

  return output;
}

var finalize = function(key, value) {
  result = { }
  result.bal_sum = value.bal
  result.bal_avg = value.bal / value.count

  return result;
}

printjson(db.people.mapReduce(
  mapFc,
  reduceFc,
  {
    out: "zapytanie_5_mr",
    finalize: finalize,
    query: { "nationality": "Poland", "sex": "Female" }
  }
));
printjson(db.zapytanie_5_mr.find({}).toArray())
