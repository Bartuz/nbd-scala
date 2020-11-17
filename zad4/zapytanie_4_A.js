printjson(
  db.people.aggregate([
    { "$project": { nationality: '$nationality', bmi: { $divide: ['$weight', { $multiply: [ { $divide: ['$height', 100] } , { $divide: ['$height', 100] }] }] } }  },
    { $group: { _id: '$nationality', bmi_min: { $min: '$bmi' }, bmi_max: { $max: '$bmi' }, bmi_avg: { $avg: '$bmi' } } }
  ]).toArray()
);
