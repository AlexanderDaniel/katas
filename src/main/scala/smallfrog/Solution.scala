package smallfrog

/**
 * Source [[https://codility.com/programmers/]]
 */
object Solution {

  def solution(X: Int, Y: Int, D: Int): Int = {
    val diff = Y-X
    val steps = diff / D
    if (diff % D == 0) steps else steps + 1
  }
}
