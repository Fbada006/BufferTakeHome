# Buffer Android Takehome

Welcome to the Android takehome task repository, thank you for taking your time to be here!

## Task 1: Technical task

We've been given the following design, which is for the Queue within a Buffer account:

![Queue design screenshot](https://github.com/bufferapp/***REMOVED***/blob/master/art/queue_design.png)

Your task is to implement this design and in-order to do this you'll need to retrieve the data for the updates, which is stored in a local database. This repository contains the foundations of the project which should be enough to get started.

The project contains a database which holds the three updates (these will be initiated when the first read is made on the database). Each of these updates contains an ID (the primary key), update content in the form of text and the time that the update is scheduled to go out at.

Since creating the database, our designer added the ability to support an imageUrl on an update - so you'll need to update the database to reflect this change. This imageUrl is nullable, so for the sake of the design you only need to provide it on one of the updates. You can use any imageUrl that you'd like for the sample data :)

The buildSrc module of the project contains a collection of preferred dependencies copied over from our other apps. You can use dependencies outside of these if they feel necessary - but sticking with these helps to keep things consistant across out projects (for example, it would be great to see the use of RxJava for async work, Dagger for Dependency Injection and View Models from the architecture components library). Dagger is also already configured in the Core module, meaning that for however you handle the Queue area, you'll be able to inject components for that screen.

## Task 2: Pull request review

You'll notice that in this repository there is an open pull request (PR) from a feature implementation. This PR needs to be reviewed before we merge it in - so as the second part of this interview stage you'll need to review the code in this PR.
