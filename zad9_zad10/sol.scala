object Sol {

  trait Maybe[A] {
    def applyFunction(func: A => Any) : Maybe[_]
    def getOrElse[B](value: B) : Any
    def map[B](fun: A => B): Maybe[_]
    def flatMap[B](fun: A => Maybe[_]): Maybe[_]
  }

  class Yes[A](val value:A) extends Maybe[A] {
    override def applyFunction(func: A => Any): Maybe[_] = new Yes[Any](func(value))
    override def getOrElse[B](otherVal: B): A = value
    override def map[B](fun: A => B): Maybe[B] = new Yes(fun(value))
    override def flatMap[B](fun: A => Maybe[_]): Maybe[_] = fun(value)
  }

  class No extends Maybe[Nothing] {
    override def applyFunction(func: Nothing => Any): Maybe[_] = new No()
    override def getOrElse[B](value: B): B = value
    override def map[B](fun: Nothing => B): Maybe[_] = new No()
    override def flatMap[B](fun: Nothing => Maybe[_]): Maybe[_] = new No()
  }

  def dzielniki() = for {
    num <- Iterator.from(0)
    dzielnik <- 1 until num + 1
    if num % dzielnik == 0
  } yield(num, dzielnik)


  def main(args: Array[String]): Unit = {

    println("\n------z1")
    val containerInt = new Container(5)
    def math(num: Int): Float = 2.5f * num - 1
    println("getContent(): " + containerInt.getContent())
    println("applyFunc(math): " + containerInt.applyFunction(math))

    val containerString = new Container("hello world")
    def upperCase(n: String): String = n.toUpperCase()
    println("getContent(): " + containerInt.getContent())
    println("applyFunc(uppercase): " + containerString.applyFunction(upperCase))

    println("\n------z2")

    val y = new Yes(5)
    val n = new No()

    println("y: " + y.isInstanceOf[Maybe[_]])
    println("n: " + n.isInstanceOf[Maybe[_]])

    println("\n------z3")
    println("y: " + y.applyFunction((value: Int) => value + 3))
    println("n: " + n.applyFunction((value: Int) => value + 3))

    println("\n------z4")

    println("getOrElse: ")
    println(n.getOrElse(y.getOrElse(new No())))

    println("\n------z5")


    val iter =  dzielniki().buffered
    println(iter.next())
    iter take 18 foreach println
    println(iter.next())



    println("\n------z6")

    val map = (list : List[Int]) => list.map(value => value + 1)
    val flatMap = (list : List[Int]) => new Yes(list.map(value => value + 1))


    val no = new No()
    val yes = new Yes(List(9, 9, 7))
    println(no.map(map).getOrElse("nie ma nic"))
    println(no.map(flatMap).getOrElse("nie ma nic"))
    println(yes.map(map).getOrElse("nie ma nic"))
    println(yes.map(flatMap).getOrElse("nie ma nic"))
  }
}
