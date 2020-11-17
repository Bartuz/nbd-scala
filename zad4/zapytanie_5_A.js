printjson(
  db.people.aggregate([
    {'$match': { "sex": "Female", "nationality": "Poland" }},
    { $unwind: "$credit"},
    {
      "$group" : {
        _id: null,
        avg_bal:  { $avg: { $toDouble: "$credit.balance"} },
        sum_bal:  { $sum: { $toDouble: "$credit.balance"} }
      }
    },
    { "$project": { avg_bal: true, sum_bal: true, _id:false} },
  ]).toArray()
);
