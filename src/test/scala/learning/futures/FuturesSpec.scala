package learning.futures

import org.specs2.mutable.Specification
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.concurrent.TimeUnit

class FuturesSpec extends Specification {

  "executing futures sequentially" should {
    // See also http://stackoverflow.com/questions/13836725/sequentially-combine-arbitrary-number-of-futures-in-scala
    "run them one after the other" in {
      def task(n: Int): Future[Unit] = Future {
        println(s"$n is sleeping...")
        TimeUnit.SECONDS.sleep(1)
        println(s"$n is awake")
        ()
      }
      val future: Future[Unit] = List(1, 2, 3).foldLeft(Future(())) {
        (z, x) => z flatMap {
          _ => task(x)
        }
      }
      Await.result(future, Duration.Inf) === ()
    }
  }

  "the futures start running as soon as they are created" should {
    "demonstrate that" in {
      def task(n: Int): Future[Int] = Future {
        println(s"the futures start running as soon as they are created: $n is sleeping")
        TimeUnit.SECONDS.sleep(1)
        n
      }
      val futures: List[Future[Int]] = List(1, 2, 3) map task
      val future: Future[List[Int]] = Future.sequence(futures)
      Await.result(future, Duration.Inf) === List(1, 2, 3)
    }
  }
}