package potter

object PotterKata {

  def minPriceForBasket(bookNumbers: Seq[Int]): Double = {
    val biggestSet = bookNumbers.toSet
    basePrice * discounts(biggestSet.size) * bookNumbers.size
  }

  private val discounts = Map(
    2 -> 0.95,
    3 -> 0.9,
    4 -> 0.8,
    5 -> 0.75
  ).withDefaultValue(1.00)

  private val basePrice = 8.0
}
