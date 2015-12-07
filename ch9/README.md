CHAPTER9
========

Inventory
---------
- akka-logging - Akka Logging Configuration Example 
- akka-agent - Java and Scala agent demonstration	
- akka-event-bus - Java and Scala event bus demonstration

akka-logging
------------
Example of akka project with logging configuration (slf4j + logback.)

You can run the application like so:

    cd akka-logging
    activator run

You'll see output like this:

    logger log1-Slf4jLogger started
    Default Loggers started
    LoggingActor received event: message1
    LoggingActor received event: message2
    LoggingActor received event: message3
    shutting down: StandardOutLogger started

This will also create a log folder which will contain an application log file.
The project has files in the src/resources folder for log configuration (application.conf, logback.xml.) 

akka-agent
----------
Example of using Java and Scala agents. The main executes both the Java and Scala agent example code.

run the application like this:

    cd akka-agent
    activator run

Expected output:

	[info] Running com.example.ApplicationMain
	5
	5
	5
	5
	success?: true
	success?: false

akka-event-bus
--------------
Demonstrates Pub/Sub behavior with Java and Scala Akka Event Bus. Application main calls very simple code via scala (readable for java devs) invoking the scala and java versions of the event bus implementation.

To run

    cd akka-event-bus
    activator run

Expected output:

    [info] Running com.example.ApplicationMain
    guess we received a greeting! msg: java event bus greeting
    guess we received a greeting! msg: scala event bus greeting
