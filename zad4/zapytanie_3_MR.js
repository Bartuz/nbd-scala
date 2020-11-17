var mapFc = function() {
  emit('jobs', this.job )
}

var reduceFc = function(key, values) {
  var result = {}
  values.forEach((k, v) => {
    result[k] = true
  })

  return result
}

var finalize = function(key, value) {
  return Object.keys(value)
}

printjson(db.people.mapReduce(
  mapFc,
  reduceFc,
  {
    out: "zapytanie_3_mr",
    finalize,
  }
));
printjson(db.zapytanie_3_mr.find({}).toArray())
