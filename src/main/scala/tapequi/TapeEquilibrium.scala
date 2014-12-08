package tapequi

/**
 * Source [[https://codility.com/programmers/]]
 */
object TapeEquilibrium {

  def solution(a: Array[Int]): Int = {
    (sumsFromLeft(a) zip sumsFromRight(a)).map { case (l, r) =>
      math.abs(l - r)
    }.min
  }

  def sumsFromLeft(a: Array[Int]): Seq[Int] =
    a.scanLeft(0)(_ + _).drop(1).dropRight(1)

  def sumsFromRight(a: Array[Int]): Seq[Int] =
    a.scanRight(0)(_ + _).drop(1).dropRight(1)

}
