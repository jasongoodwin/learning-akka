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
NOTE: There is a bug in the scala-java8-compat lib that is fixed in 0.6.0. The book was published citing 0.6.0 but I think 0.6.0 as published in Maven Central has an issue with one of its dependencies that causes it to fail on import however 0.7.0 is fine to use. If anything, check maven central and use the latest.

"org.scala-lang.modules" %% "scala-java8-compat" % "0.7.0"

# Up to date code

If there are any errors etc, I'll fix them on github.
The link to the code on github is: https://github.com/jasongoodwin/learning-akka/
