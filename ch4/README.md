CHAPTER4
========

Chapter examples contain examples of proxies to the database that contain connected state and will stash messages until the remote database is confirmed available.

Contains stash w/ hotswap example as well as FSM example building on the database example. It shows how you might handle connect events in the hotswap exampl, and then extends on it to demonstrate how you might bunch messages and send them all at once to avoid extra messages going over the network.

Prerequisites
-------------
The akkademy-db-java and akkademy-db-scala projects have been updated to 0.1.0-SNAPSHOT with new messages and behavior to support the Connect message as well as bunching behavior by handling lists of requests.

You'll need to publish local the library.

    cd akkademy-db-java
    activator publish-local

    cd akkademy-db-scala
    activator publish-local

Inventory
---------
akkademy-db-java - updated db
akkademy-db-scala - updated db
akkademy-db-client-java - client with hotswap/stash and fsm examples
akkademy-db-client-scala - client with hotswap/stash and fsm examples

Running the Tests
-----------------
After publishing the db, you can run the tests:

    activator test
