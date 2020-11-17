printjson(db.people.find().forEach( function (x) {
  x.weight = parseFloat(x.weight);
  x.height = parseFloat(x.height);
  db.people.save(x);
}));
