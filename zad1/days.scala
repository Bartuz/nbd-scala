object Days {
  val SEPARATOR = ", "

  // 1.a
  def stringifyDays(days: List[String]): String = {
    var string = new StringBuilder
    for (day <- days) {
      string ++= day
      string ++= SEPARATOR
    }
    string.toString().dropRight(SEPARATOR.length())
  }

// 1.b
  def stringifyDaysOnlyP(days: List[String]): String = {
    var string = new StringBuilder
    for (day <- days) {
        if (day.startsWith("P")) {
          string ++= day
          string ++= SEPARATOR
        }
    }
    string.toString().dropRight(SEPARATOR.length())
  }
//1.c
  def stringifyDaysWhile(days: List[String]): String = {
    var idx = 0
    var string = new StringBuilder
    while (idx < days.length) {
      string ++= days(idx)
      string ++= SEPARATOR
      idx += 1
    }
    string.toString().dropRight(SEPARATOR.length())
  }
//2.a
  def stringifyDaysRecur(days: List[String]): String = days match {
    case List() => ""
    case (x: String) :: Nil => x
    case (x: String) :: (xs: List[String]) => x + SEPARATOR + stringifyDaysRecur(xs)
  }
//2.b
  def stringifyDaysRecurRev(days: List[String]): String = days match {
    case List() => ""
    case (x: String) :: Nil => x
    case (x: String) :: (xs: List[String]) => stringifyDaysRecurRev(xs) + SEPARATOR + x
  }
//3
  def stringifyDaysTailRec(days: List[String], acc: String = ""): String = days match {
    case List() => acc
    case (x: String) :: Nil => stringifyDaysTailRec(Nil, acc + x)
    case (x: String) :: (xs: List[String]) => stringifyDaysTailRec(xs, acc + x + ", ")
  }
//4.a
  def stringifyDaysFoldl(days: List[String]): String = {
    val string = days.foldLeft("") { (acc, day) => acc + day + SEPARATOR }

   string.dropRight(SEPARATOR.length)
  }

  //4.b
  def stringifyDaysFoldr(days: List[String]): String = {
    val string = days.foldRight("") { (acc, day) => acc + SEPARATOR + day }

    string.dropRight(SEPARATOR.length)
  }

  //4.c
  def stringifyDaysFoldlOnlyP(days: List[String]): String = {
    val string = days.foldLeft("") { (acc, day) =>  if (day.startsWith("P")) acc  + day + SEPARATOR  else acc }

    string.dropRight(SEPARATOR.length)
  }

  def main(args: Array[String]) {
    val days = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")



    // 1.a
    println("1.a")
    println(stringifyDays(days))

    // 1.b
    println("---\n1.b")
    println(stringifyDays(days.filter(day => day.startsWith("P"))))

    println("---\n1.b")
    println(stringifyDaysOnlyP(days))

    // 1.c
    println("---\n1.c")
    println(stringifyDaysWhile(days))

    // 2.a
    println("---\n2.a")
    println(stringifyDaysRecur(days))

    // 2.b
    println("---\n2.b")
    println(stringifyDaysRecurRev(days))

    // 3
    println("---\n3")
    println(stringifyDaysTailRec(days))

    // 4.a
    println("---\n4.a")
    println(stringifyDaysFoldl(days))

    // 4.b
    println("---\n4.b")
    println(stringifyDaysFoldr(days))

    // 4.c
    println("---\n4.c")
    println(stringifyDaysFoldlOnlyP(days))
  }
}
