package com.example

import akka.actor.ActorSystem
import akka.agent.Agent

object ScalaAgentExample {
  val system = ActorSystem()
  implicit val ec = system.dispatcher

  def apply() = {
    val account = Agent(25)
    val ammountToWithdraw = 20

    account.send { i =>
      if(ammountToWithdraw < i) {
        i - 20
      } else i
    }
    Thread.sleep(1000)

    println(account.get) //5

    account.send { i =>
      if(ammountToWithdraw < i) {
        i - 20
      } else i
    }
    Thread.sleep(1000)

    println(account.get) //still 5
  }

  def multipleTransactions() = {
    import scala.concurrent.stm._
    val wifeAccount = Agent(25)
    val husbandAccount = Agent(0)
    val wasSuccess1 = atomic { txn =>
      if(wifeAccount() >= 20) {
        wifeAccount.send(_ - 20)
        husbandAccount.send(_ + 20)
        true
      } else false
    }

    println("success?: " + wasSuccess1) //true

    val wasSuccess2 = atomic { txn =>
      if(wifeAccount() >= 20) {
        wifeAccount.send(_ - 20)
        husbandAccount.send(_ + 20)
        true
      } else false
    }

    println("success?: " + wasSuccess2) //false


  }
}
