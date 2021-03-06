[![Build Status](https://travis-ci.org/dkittle/tictactoe.svg?branch=master)](https://travis-ci.org/dkittle/tictactoe)

# Tic Tac Toe Backend

## Update November 2016
I think started HorribleScalaGame in November of 2014. It didn't start with that name but it certainly deserves it now.

I've since done a solution that uses pattern matching to check the state of the board. I think there is a better way
of representing a list of patterns to match against.

In another repo I've experimented with using a Finite State Machine for the game - I actually like that approach :)

## Background

This is a programming exercise that I pair with developers on to see how they work toward a solution and how they take feedback.  When I was at Kijiji, we had candidates use Java for this exercise.

This code is a scala implementation I wrote when I was learning Scala during a bookclub reading of Seven Languages in Seven Weeks by Bruce Tate.  Obviously room for improvement :)

## How the exercise was run

Regardless of whether they have done TDD or not, we always started with tests.  From there we evolve a solution until it works and all parties are happy with it.

We always started by with the initial requirement - a method to tell if the game was won or not.  All candidates would start with a method that returned a Boolean.  Once there was a solution, we'd refine by asking them to refactor so that the method returns who won the game.

## The Exercise

This programming exercise involves creating a backend to manage a game of Tic Tac Toe.

The code should (eventually) allow moves and allow a frontend client to determine the current player and know when a game is won (and who won it).

As ever, there should be tests :)

## Execution

The code should be exercised by running the tests
```
sbt test
```