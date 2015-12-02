package com.example

import akka.actor.ActorRef
import akka.event.{LookupClassification, EventBus}

class ScalaLookupClassifier extends EventBus with LookupClassification {
    type Event = EventBusMessage
    type Classifier = String
    type Subscriber = ActorRef

    override protected def classify(event: Event): Classifier = event.topic

    override protected def publish(event: Event, subscriber: Subscriber): Unit = {
      subscriber ! event.msg
    }

    override protected def compareSubscribers(a: Subscriber, b: Subscriber): Int =
      a.compareTo(b)

    //initial size of the index data structure
    override protected def mapSize: Int = 128
}
