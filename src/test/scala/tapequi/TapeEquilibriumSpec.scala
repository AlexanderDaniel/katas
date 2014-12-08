package tapequi

import org.specs2.mutable.Specification
import TapeEquilibrium._

class TapeEquilibriumSpec extends Specification {

  "TapeEquilibrium" should {

    {
      solution(Array(3,1,2,4,3)) === 1
    }.eg

  }

  "sumsFromLeft" should {
    {
      sumsFromLeft(Array(3,1,2,4,3)) === Seq(3,4,6,10)
    }.eg
  }

  "sumsFromRight" should {
    {
      sumsFromRight(Array(3,1,2,4,3)) === Seq(10, 9, 7, 3)
    }.eg
  }
}
