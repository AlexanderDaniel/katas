package potter

/**
 * [[http://www.codingdojo.org/cgi-bin/wiki.pl?KataPotter]]
 *
 * See doc/potter/PotterKata.pdf for a visualization of the discounts.
 *
 * Other implementations:
 * - We did the Potter Kata at the [[https://github.com/scala-vienna/dojo-2013-08/blob/master/src/main/scala/dojo/PotterKata.scala Vienna Scala User Group]]
 * - [[https://github.com/pebrc/dojo-2013-08/blob/master/src/main/scala/dojo/PotterKata.scala  Peter Brachwitz]]
 *
 * Interesting discussions and blog posts:
 * - [[https://groups.google.com/forum/#!topic/software_craftsmanship/e_If0tXusyQ]]
 * - [[http://gogognome.nl/2013/01/potter-kata-solution/]]
 * - [[http://www.pirrmann.net/potter-kata/]]
 * - [[http://www.pirrmann.net/potter-kata-going-further-not-following-the-rule/]]
 */
object PotterKata {

  def minPriceForBasket(bookNumbers: Seq[Int]): Double = {
    val biggestSet = bookNumbers.toSet
    biggestSet.size match {
      case setSize if setSize <= 1 => basePrice * bookNumbers.size
      case setSize => pricesForSetVariations(bookNumbers, biggestSet).min
    }
  }

  /**
   * If the size of the biggest set is 5 the method also calculates the price
   * of the subsets with size 4.
   *
   * I cannot prove why this approach works but if you look at the
   * doc/potter/PotterKata.pdf spreadsheet it makes sense.
   */
  def pricesForSetVariations(bookNumbers: Seq[Int], biggestSet: Set[Int]): Seq[Double] = {
    val size = biggestSet.size
    for {
      setSize <- size to (if (size == 5) 4 else size) by -1
      set <- biggestSet.subsets(setSize)
    } yield priceForSet(set.size) + minPriceForBasket(diff(bookNumbers, set))
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
