package learning.futures

import org.specs2.mutable.Specification
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.concurrent.TimeUnit

class FuturesSpec extends Specification {

  "executing futures sequentially" should {
    // See also http://stackoverflow.com/questions/13836725/sequentially-combine-arbitrary-number-of-futures-in-scala
    "run them one after the other (task returns Unit)" in {
      def task(n: Int): Future[Unit] = Future {
        println(s"$n is sleeping...")
        TimeUnit.SECONDS.sleep(1)
        println(s"$n is awake")
        ()
      }
      val combinedFuture: Future[Unit] = List(1, 2, 3).foldLeft(Future(())) {
        (future, x) => future flatMap {
          _ => task(x)
        }
      }
      Await.result(combinedFuture, Duration.Inf) === ()
    }

//    "run them one after the other but I want the results" in {
//      def task(n: Int): Future[Int] = Future {
//        println(s"I want the results: $n is sleeping...")
//        TimeUnit.SECONDS.sleep(1)
//        println(s"$n is awake")
//        n
//      }
//      val futures: List[Future[Int]] = List(1,2,3).scanLeft(Future(0)) {
//        (z, x) => z map { result =>
//          task(x)
//          result
//        }
//      }
//      val future: Future[List[Int]] = Future.sequence(futures)
//
//    }
  }



  "the futures start running as soon as they are created" should {
    // See also comment http://stackoverflow.com/a/11158557/1388926 of Viktor Klang in
    // http://stackoverflow.com/questions/11157552/how-to-combined-futures-of-different-types-into-one-new-future-without-using-zip
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