package equi

import org.specs2.mutable.Specification
import Equi._

class EquiSpec extends Specification {

  "equi" should {
    {
      equi(Array()) === -1
    }.eg

    {
      equi(Array(7)) === 0
    }.eg

    {
      equi(Array(3,1,3)) === 1
    }.eg

    {
      equi(Array(-7, 1, 5, 2, -4, 3, 0)) === 3
    }.eg

  }

  "sumsLeftToRight" should {
    {
      sumsLeftToRight(Array()) === Array()
    }.eg

    {
      sumsLeftToRight(Array(7)) === Array(0)
    }.eg

    {
      sumsLeftToRight(Array(3, 5)) === Array(0, 3)
    }.eg

    {
      sumsLeftToRight(Array(-7, 2, 1, 4)) === Array(0, -7, -5, -4)
    }.eg

    {
      sumsLeftToRight(Array(-7, 1, 5, 2, -4, 3, 0)) === Array(0, -7, -6, -1, 1, -3, 0)
    }.eg
  }

  "sumsRightToLeft" should {
    {
      sumsRightToLeft(Array()) === Array()
    }.eg

    {
      sumsRightToLeft(Array(7)) === Array(0)
    }.eg

    {
      sumsRightToLeft(Array(3, 5)) === Array(5, 0)
    }.eg

    {
      sumsRightToLeft(Array(-7, 2, 1, 4)) === Array(7, 5, 4, 0)
    }.eg

    {
      sumsRightToLeft(Array(-7, 1, 5, 2, -4, 3, 0)) === Array(7, 6, 1, -1, 3, 0, 0)
    }.eg

  }

}
