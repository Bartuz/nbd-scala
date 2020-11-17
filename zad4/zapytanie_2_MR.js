var mapFc = function() {
  this.credit.forEach(credit => {
    emit(credit.currency, parseFloat(credit.balance));
  });
}

var reduceFc = function(currency, values) {
  return Array.sum(values)
}

printjson(db.people.mapReduce(
  mapFc,
  reduceFc,
  {
    out: "zapytanie_2_mr",
  }
));
printjson(db.zapytanie_2_mr.find({}).toArray())
