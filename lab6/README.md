# **LAB 6**

In this lab, we learnt how to have testing done in Android Studio. We set up a JUnit test that runs on the local JVM or an instrumented test that runs on a device.

[Click here]() to see the implementation of the lab in our lonelyTwitter app.

----------

**Lab Participation Exercise (JUnit and TDD)**

Start working on LonelyTwitter (Default project)

[

-- git clone https://github.com/Jakaria08/lonelyTwitter.git

-- cd lonelyTwitter

-- git checkout origin/lab6_test -B lab6_start

]

Add the following methods and their test cases:

_**addTweet()**_ -- should throw an IllegalArgumentException when one tries to add a duplicate tweet

_**getTweets()**_ -- should return a list of tweets in chronological order

_**hasTweet()**_ -- should return true if there is a tweet that equals() another tweet

_**getCount()**_ -- should accurately count up the tweets


[Click here to see the completed implementation]()