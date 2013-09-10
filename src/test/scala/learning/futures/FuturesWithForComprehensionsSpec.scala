package learning.futures

import org.specs2.mutable.Specification
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class FuturesWithForComprehensionsSpec extends Specification {

  case class TstException() extends Exception

  private def tst: Future[String] =
    for {
      a <- Future("a")
      intermediateAssignment = {
        throw TstException()
      }
      b <- Future(a + "b")
    } yield b

  "todo" should {
    "todo" in {
      val future = tst
      Await.ready(future, Duration.Inf)
      future.value.get === Failure(TstException())
    }
  }
}
