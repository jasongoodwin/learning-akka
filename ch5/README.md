CHAPTER5
========

Chapter covers different router and dispatcher usage for taking better advantage of hardware. Also covers how to use a separate dispatcher for blocking work to keep actors lively.

Inventory
---------
- akkademaid-java - Java examples for chapter 5
- akkademaid-scala - Scala examples for chapter 5

Running the Tests
-----------------

### akkademaid-java
Run the tests
    cd akkademaid-java
    activator test

#### Expected Output

	ReadFilesWithActorsTest Took: 9439
	BalancingPoolTest Took: 9494
	ActorsAssignedToDispatcherTest Took: 9647
	ReadFilesWithFuturesTest Took: 14553
	[info] Passed: Total 4, Failed 0, Errors 0, Passed 4

### akkademaid-scala
Runt the tests
    cd akkademaid-scala
    activator test

#### Expected Output

	ActorsInBalacingPool took: 13789
	[info] BalancingPoolSpec:
	[info] BalancingPool
	[info] - should do work concurrently
	Actors took: 15465
	[info] ArticleParseWithActorsSpec:
	[info] ArticleParseActor
	[info] - should do work concurrently
	ActorsAssignedToDispatcher took: 15626
	[info] AssignActorsToDispatcherTest:
	[info] ActorsAssignedToDispatcher
	[info] - should do work concurrently
	Futures took: 18049
	[info] ArticleParseWithFuturesSpec:
	[info] ArticleParser
	[info] - should do work concurrently with futures
	[info] Run completed in 18 seconds, 705 milliseconds.
	[info] Total number of tests run: 4
	[info] Suites: completed 4, aborted 0
	[info] Tests: succeeded 4, failed 0, canceled 0, ignored 0, pending 0
	[info] All tests passed.
	[success] Total time: 20 s, completed 3-Dec-2015 12:48:24 AM
