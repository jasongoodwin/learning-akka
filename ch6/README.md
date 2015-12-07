CHAPTER6 - Akka Cluster Demo
============================

Inventory
---------
akkademaid-scala - Clusterable Workers
akkademaid-java - Clusterable Workers
akkademaid-client-java - Cluster-aware client demo
akkademaid-client-scala - Cluster aware client demo

Akkamaid
--------
These projects are very simple distributed article parse workers and a client to use them. 

First, we'll want to start the worker services. We can start a couple.

These are the projects with the workers: 
- akkademaid-scala
- akkademaid-java

To start the application, you'll need to have one node running on the configured port as a known contact point:

    activator run

The default port - 2552 - is configured in the src/main/resources/application.conf file.

Once that is running, you can start other instances of the application which will connect to that port and join the cluster. You can specify the running port of other instances via command line like so:

    activator run \
    -Dakka.remote.netty.tcp.port=2551 \
    -Dcom.sun.management.jmxremote.port=9551 \
    -Dcom.sun.management.jmxremote.authenticate=false \
    -Dcom.sun.management.jmxremote.ssl=false

You can use a random port as well:

    activator run \
    -Dakka.remote.netty.tcp.port=0 \
    -Dcom.sun.management.jmxremote.port=9551 \
    -Dcom.sun.management.jmxremote.authenticate=false \
    -Dcom.sun.management.jmxremote.ssl=false

Note that we also add JMX details there to be able to remotely manage the application. You can install Akka's cluster manager tools and gracefully have nodes leave the cluster like so:

    ./akka-cluster localhost 9552 leave akka.tcp://Akkademy@127.0.0.1:2552

Where 2552 is the port that the node is running on.

Once the service is running, you can run the appropriate client:

    activator run

The client will send an unparsed html article to a random node. That node will parse the article and send back the response. The response will be printed in the client.

The service is a dynamically scalable worker queue - you can add more nodes dynamically as needed to handle as much work as you need to! This is a very cool capability - to be able to scale out your projects without a lot of complexity in code is a great book.

