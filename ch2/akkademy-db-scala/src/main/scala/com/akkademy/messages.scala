package com.akkademy

package object messages {
  sealed trait Request
  case class Get(key: String) extends Request
  case class Set(key: String, value: String) extends Request
  case class SetIfNotExists(key: String, value: Object) extends Request
  case class Delete(key: String) extends Request

  trait Response
  trait Ok extends Response
  trait NotOk extends Response
}
