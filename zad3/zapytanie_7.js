printjson(
  db.people.remove({
    $expr: {
      $gt: [{$toDouble: "$height"}, 190]
    }
  })
)
