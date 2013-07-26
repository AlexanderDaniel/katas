package equi

object Equi {

  def equi(a: Array[Int]): Int = {
    val pairs = sumsLeftToRight(a) zip sumsRightToLeft(a)
    val conditionIsTrue = pairs map { case (l,r) => l==r }
    val indicesWhereConditionIsTrue = conditionIsTrue.zipWithIndex filter { case (b,_) => b } map {case (_,i) => i}
    indicesWhereConditionIsTrue.headOption.getOrElse(-1)
  }

  def sumsLeftToRight(a: Array[Int]): Array[Int] =
    if (a.isEmpty)
      Array()
    else
      a.dropRight(1)
      .scanLeft(0) { (z,x) =>
        z+x
      }

  def sumsRightToLeft(a: Array[Int]): Array[Int] =
    if (a.isEmpty)
      Array()
    else
      a.drop(1).scanRight(0) { (x, z) =>
        x+z
      }

}
