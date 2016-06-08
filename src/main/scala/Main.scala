/**
  * Created by aksiksi on 5/23/16.
  */
package tn.btx

import akka.actor._

import spray.json._
import DefaultJsonProtocol._

class EchoActor extends Actor {
  def receive = {
    case x: String => println(x)
    case x: Int => println(x)
    case x: List[Int] => println(x)
    case _ => println("Unknown!")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    // Spray-json
    val p = "[1,2,3]"
    val ast = p.parseJson
    val obj = ast.convertTo[List[Int]]

    // Akka
    val system = ActorSystem("hello-bitcoin")

    val actor = system.actorOf(Props[EchoActor], "echo-actor")

    actor ! "Hello!"
    actor ! 123
    actor ! List(1,2,3)
    actor ! "Bye!"

    system.terminate()
  }
}
