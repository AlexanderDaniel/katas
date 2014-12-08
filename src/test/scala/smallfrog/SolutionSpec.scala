package smallfrog

import org.specs2.mutable.Specification
import Solution._

class SolutionSpec extends Specification {

  "small frog" should {
    {
      solution(10, 85, 30) === 3
    }.eg

    {
      solution(10, 100, 10) === 9
    }.eg
  }
}
