# learning-akka

Code From "Learning Akka", Jason Goodwin. 
The book is to be published by Packt Publishing Dec 2015

# Organization
Each chapter's example is separated into a different folder. Navigate to the folder and read the README.md file. 
The README.md file will explain the contents of each folder, any preparation needed to run the tests, how to run the tests, and will document expected output.

Any questions please feel free to either raise a github ticket or mailme at 

    jay.michael.goodwin 
    @ 
    gmail.com
    
# Notes at time of publishing 
NOTE: There is a bug in the scala-java8-compat lib that is fixed in 0.6.0 which should hopefully be released around the time the book hits the press.
0.6.0 is not released at the time the book went to printing and when the code was placed on Packt for the book.
You should try to the examples but if you are one of the first readers then you might bump into a problem so you'd need to publish the library locally for yourself to use.

## How to locally publish the scala java8 compat library for the examples:
checkout the library 

    git clone https://github.com/scala/scala-java8-compat.git

update the build.sbt to have the version 0.6.0

and run 

    activator publish-local

Then the examples will work (if there is an issue).
The library will be published by the time you read this very likely.
