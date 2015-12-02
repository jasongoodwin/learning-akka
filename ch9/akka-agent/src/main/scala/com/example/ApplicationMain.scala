package com.example

object ApplicationMain extends App {
  JavaAgentExample.apply()
  ScalaAgentExample.apply()
  ScalaAgentExample.multipleTransactions()
}