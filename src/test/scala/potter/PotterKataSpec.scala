package potter

import org.specs2.mutable.Specification
import PotterKata._

class PotterKataSpec extends Specification {

  "minPriceForBasket" should {
    (0.0 === minPriceForBasket(Seq())).eg
    (8.0 === minPriceForBasket(Seq(anyBook))).eg
    (16.0 === minPriceForBasket(Seq(anyBook, anyBook))).eg
    (24.0 === minPriceForBasket(Seq(anyBook, anyBook, anyBook))).eg

    (8 * 2 * 0.95 === minPriceForBasket(twoDifferentBooks)).eg
    (8 * 3 * 0.9 === minPriceForBasket(threeDifferentBooks)).eg
    (8 * 4 * 0.8 === minPriceForBasket(fourDifferentBooks)).eg
    (8 * 5 * 0.75 === minPriceForBasket(fiveDifferentBooks)).eg
  }

  private val anyBook = 0

  private val twoDifferentBooks = Seq(0, 1)
  private val threeDifferentBooks = Seq(0, 1, 2)
  private val fourDifferentBooks = Seq(0, 1, 2, 3)
  private val fiveDifferentBooks = Seq(0, 1, 2, 3, 4)

  private val twoSameBooksOutOfThree = Seq(0, 0, 1)

}
