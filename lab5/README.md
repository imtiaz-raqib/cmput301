# **LAB 5**

In this lab, we were taught how to use FireBase database to save all our tweets from lonelyTwiter.

We learnt how to setup and initialize the database within Android Studio.

[Click Here](https://github.com/imtiazraqib/lonelyTwitter/commit/7d6151a2bfbb6d7dd2ab4ee8c65de998f2b39899) to see the implementation of what we did in the lab in lonelyTwiiter.

----------

**Lab Participation Exercise (Firebase)**

- Add a UniqueID to your Tweet class
- You can use java.util.UUID for this
- Save the normal tweets to the database with their uniqueID as the key (each tweet is child of its UniqueID)
- Add two tweets to the database.
- Change tweet.message for two of your tweets using Firebase console.
- For one of them add \U to the start of the message.
- For other one add \L to the start of the message.
- Monitor database changes
- If a tweet message starts with \U then convert the tweet message to all upper case
- If a tweet message starts with \L then convert the tweet message to all lower case
- Log in this format: “Tweet {ID}: {message}”

[Click here to see the completed implementation](https://github.com/imtiazraqib/lonelyTwitter/commit/2ecee0c670401712b72972bc8364aef365a78e05)