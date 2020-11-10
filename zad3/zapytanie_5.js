printjson(
    db.people.aggregate([
    {'$match': { "$expr": { "$gte": [{ "$year": { $dateFromString: { dateString: "$birth_date" } } }, 2000] } }},
    { $unwind: "$location"},
    {
      "$group" : {
        _id: { first_name: "$first_name", last_name: "$last_name"},
        cities:  { $push: "$location.city" }
      }
    },
  ]).toArray()
)
