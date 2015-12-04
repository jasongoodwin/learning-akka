CHAPTER3
========

The sample indicate how to string together caching and article parsing behavior using message passing to co-ordinate between multiple actors. 

There is an ask demo which is simpler, but has more memory overhead.
Then there is a tell demo which is more efficient, but is more advanced and can take a bit more effort to understand. Where greater efficiency is needed, tell can be more efficient and has less areas that can timeout

Inventory
---------
- akkademaid-java		
- akkademaid-scala

Running the Tests
-----------------
change into the folder of your choice
run the tests

    cd akkademaid-java
or
    cd akkademaid-scala

    activator run
