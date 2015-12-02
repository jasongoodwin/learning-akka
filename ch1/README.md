CHAPTER1
========

Inventory
---------

- akkademy-db-java - Java Example 
- akkademy-db-scala - Scala Example

Running the Tests
-----------------
After completing chapter 1 content, you should ensure you can run the unit tests.

- Change into your desired project
- Run: 
    $ activator test

Expected Output of Java Project
-------------------------------

    [INFO] [12/02/2015 02:06:22.346] [pool-6-thread-4] [akka://default/user/$$a] Received Set request: Set{key='key', value=value}
    [info] Passed: Total 1, Failed 0, Errors 0, Passed 1
    [success] Total time: 3 s, completed 2-Dec-2015 2:06:22 AM

Expected Output of Scala Project
--------------------------------

    [INFO] [12/02/2015 02:07:40.691] [pool-6-thread-2-ScalaTest-running-AkkademyDbSpec] [akka://default/user/$$a] received SetRequest - key: key value: value
    [info] AkkademyDbSpec:
    [info] akkademyDb
    [info]   given SetRequest
    [info]   - should place key/value into map
    [info] Run completed in 1 second, 159 milliseconds.
    [info] Total number of tests run: 1
    [info] Suites: completed 1, aborted 0
    [info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0
    [info] All tests passed.
    [success] Total time: 3 s, completed 2-Dec-2015 2:07:40 AM
