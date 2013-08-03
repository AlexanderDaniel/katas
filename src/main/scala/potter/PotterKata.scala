package potter

object PotterKata {

  def minPriceForBasket(bookNumbers: Seq[Int]): Double = {
    val biggestSet = bookNumbers.toSet
    biggestSet.size match {
      case setSize if setSize<=1 => basePrice*bookNumbers.size
      case setSize => priceForSet(setSize) + minPriceForBasket(diff(bookNumbers, biggestSet))
    }
  }

  def priceForSet(setSize: Int): Double = {
    basePrice * discounts(setSize) * setSize
  }

  def diff(bookNumbers: Seq[Int], set: Set[Int]): Seq[Int] =
    bookNumbers.diff(set.toSeq)

  private val discounts = Map(
    2 -> 0.95,
    3 -> 0.9,
    4 -> 0.8,
    5 -> 0.75
  ).withDefaultValue(1.00)

  private val basePrice = 8.0
}
