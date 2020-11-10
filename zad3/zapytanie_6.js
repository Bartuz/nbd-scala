printjson(
  db.people.insert({
    sex: "Male",
    first_name: "Filip",
    last_name: "Bartuzi",
    job: "Student",
    email: "s12539@pjwstk.edu.pl",
    location: { city: "Bydgoszcz", adress: { streetname: "Dluga", streetnumber: "123"} },
    description: "hehehehehe",
    height: "175.5",
    weight: "80.4",
    birth_date: "1995-04-03T02:12:23Z",
    nationality: "Poland",
    credit: [{
      type: "mbank",
      number: "123123123123",
      currency: "EUR",
      balance: "2137"
    }]
  })
)
