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

    (8 + (8 * 2 * 0.95) === minPriceForBasket(twoSameBooksOutOfThree)).eg
    (8 * 2 * 0.95 + 8 * 2 * 0.95 === minPriceForBasket(twoSetsOfTwoBooks)).eg
    (8 * 4 * 0.8 + 8 * 2 * 0.95 === minPriceForBasket(oneSetOfFourBooksAndOneOfTwo)).eg
    (8 * 5 * 0.75 + 8 === minPriceForBasket(oneSetOfFiveAndAnotherOne)).eg
    (2 * (5 * 0.75 * 8) === minPriceForBasket(twoSetsOfFiveBook)).eg
    (8 * 3 * 0.9 + 8 * 2 * 0.95 === minPriceForBasket(oneSetOfThreeAndOneOfTwo)).eg
  }

  "diff" should {
    (Seq() === diff(Seq(), Set())).eg
    (Seq() === diff(Seq(anyBook), Set(anyBook))).eg
    (Seq(anyBook) === diff(Seq(anyBook), Set())).eg
    (Seq(0) === diff(Seq(0, 1), Set(1))).eg
    (Seq(1) === diff(Seq(0, 1), Set(0))).eg
    (Seq(0) === diff(Seq(0, 0, 1), Set(0, 1))).eg
    (Seq(0, 1, 2) === diff(Seq(0, 0, 1, 1, 2, 2), Set(0, 1, 2))).eg
  }

  private val anyBook = 0

  private val twoDifferentBooks = Seq(0, 1)
  private val threeDifferentBooks = Seq(0, 1, 2)
  private val fourDifferentBooks = Seq(0, 1, 2, 3)
  private val fiveDifferentBooks = Seq(0, 1, 2, 3, 4)

  private val fiveBooks = (0 to 4).toSeq

  private val twoSameBooksOutOfThree = Seq(0, 0, 1)
  private val twoSetsOfTwoBooks = Seq(0, 0, 1, 1)
  private val oneSetOfFourBooksAndOneOfTwo = Seq(0, 1, 2, 3, 0, 2)
  private val oneSetOfFiveAndAnotherOne = Seq(0, 1, 2, 3, 4, 1)
  private val twoSetsOfFiveBook = fiveBooks ++ fiveBooks
  private val oneSetOfThreeAndOneOfTwo = Seq(0, 1, 2, 0, 1)
}