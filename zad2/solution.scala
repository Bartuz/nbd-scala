object Solution {

//  1
  def explainDay(day : String) = day match {
    case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Workday!"
    case "Saturday" | "Sunday" => "Enjoy the weekend"
    case _ => "Unknown day"
  }

//  2
  class KontoBankowe() {
    private var _stanKonta = 0

    def stanKonta = _stanKonta

    def this(pierwotnyStan : Int) = {
      this()
      this._stanKonta = pierwotnyStan
    }

    def wplata(ilosc : Int) = {
      this._stanKonta += ilosc
    }
    def wyplata(ilosc : Int) = {
    this._stanKonta -= ilosc
    }
  }

  // 3

  def greetOsoba(osoba : Osoba) = osoba match {
    case Osoba("Filip" , "Bartuzi") => "O, to ja"
    case Osoba("Adam" , "Mickiewicz") => "Litwo, ojczyzna moja"
    case Osoba("Witek" , "Gombrowicz") => "Jak sie zachowac wobec krowy?"
    case _  => "Hejka nieznajomy"
  }

//  4
  def apply(num : Int, func : Int => Int) = {
    func(func(func(num)))
  }

  def main(args: Array[String]): Unit = {

    // 1
    println("\n-------1")
    println("Monday " + explainDay("Monday"))
    println("Friday " + explainDay("Friday"))
    println("Saturday " + explainDay("Saturday"))
    println("Niedziela " + explainDay("Niedziela"))

//    2
    println("\n-------2")
    val konto1 = new KontoBankowe()
    val konto2 = new KontoBankowe(1000)
    println(s"konto1 balans -  " + konto1.stanKonta)
    println(s"konto2 balans -  " + konto2.stanKonta)
    println("wplata 100 konto 1")
    konto1.wplata(100)
    println(s"konto1 balans -  " + konto1.stanKonta)
    println("wyplata 20 konto 1")
    konto1.wyplata(20)
    println(s"konto1 balans -  " + konto1.stanKonta)

//    3
    val filip = new Osoba("Filip", "Bartuzi")
    val adas = new Osoba("Adam", "Mickiewicz")
    val witek = new Osoba("Witek", "Gombrowicz")
    val alojzy = new Osoba("Alojzy", "Alojzy")

    println("\n-------3")
    println("Filip " + greetOsoba(filip))
    println("adas " + greetOsoba(adas))
    println("Witek " + greetOsoba(witek))
    println("Alojzy " + greetOsoba(alojzy))

//    4
    println("\n-------4")
    println("apply(2, +1) = " + apply(2, (num : Int) => num + 1  ))
    println("apply(2, * 2) = " + apply(2, (num : Int) =>  num * 2 ))
    println("apply(2, 0) = " +  apply(2, (_) => 0  ))

    // 5
    println("\n-------5")
    val osoba = new Osoba2("Human","Being")
    
    val student = new Osoba2("Student","Being") with Student

    val emp = new Osoba2("Pracownik","Beuing") with Pracownik
    emp.pensja = 100

    val teacher = new Osoba2("Nauczyciel","Being") with Nauczyciel
    teacher.pensja = 100

    val student_emp = new Osoba2("Stud-Emp","Beingż") with Student with Pracownik
    student_emp.pensja = 100

    val emp_stud = new Osoba2("Emp-Stud","Being") with Pracownik with Student
    emp_stud.pensja = 100



    println("osoba.podatek = " + osoba.podatek)
    println("student.podatek = " + student.podatek)
    println("emp.podatek = " + emp.podatek)
    println("teacher.podatek = " + teacher.podatek)
    println("student_emp.podatek = " + student_emp.podatek)
    println("emp_stud.podatek = " + emp_stud.podatek)
  }
}
