import scala.collection.immutable.HashMap

object Rest {

//  5
  def discountProducts(products: Map[String, Int]) = {
    products map { case (k, v) => (k, v * 0.9) }
  }

  // 6
  def printTuple(vals : (Int, String, Double)) = {
    val (val1, val2, val3) = vals
    println(s"Wartosc 1: $val1")
    println(s"Wartosc 2: $val2")
    println(s"Wartosc 3: $val3")
  }

  // 7
  def printProductPrice(price: Option[Int]) = price match {
    case Some(value) => s"$value groszy"
    case None => "Nie znaleziono ceny dla tego produktu"
  }

//   8
  def removeZeros(nums: List[Int]) : List[Int] = nums match {
    case List() => List()
    case (0) :: xs => removeZeros(xs)
    case (x) :: (xs: List[Int]) => List(x) ++ removeZeros(xs)
  }

//  9
  def increaseByOne(nums: List[Int]) : List[Int] = {
    nums.map { (v) => v + 1 }
  }

//  10
  def specificNums(nums: List[Double]) : List[Double] = {
    nums.filter(num => num >= -5.0 && num <= 12.0).map(Math.abs(_))
  }

  def main(args: Array[String]): Unit = {
    val products = Map("snikers" -> 100, "knopers" -> 150, "guma turbo" -> 2137)

    // 5
    println("5")
    println(discountProducts(products))

    // 6
    println("\n-------6")
    printTuple(100, "Ala ma kota", 21.37)

    // 7
    println("\n-------7")
    println("Cena knopersa - " + printProductPrice(products.get("knopers")))
    println("Cena coli - " + printProductPrice(products.get("cola")))

//    8
    val nums = List(1,2,0,-1,2,0,0,0,5,0,99)
    println("\n-------8")
    println("Remove zeros from " + nums)
    println(removeZeros(nums))

//    9
    println("\n-------9")
    println("Increase by 1 in " + nums)
    println(increaseByOne(nums))

//    10
    val realNums = List(-6, -5, -5.01, 0, 1, 5, -2, 8, 12, 12.01, 33)
    println("\n-------10")
    println("Increase by 1 in " + realNums)
    println(specificNums(realNums))
  }
}