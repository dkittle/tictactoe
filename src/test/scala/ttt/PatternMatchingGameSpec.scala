package ttt

import org.scalatest.{FlatSpec, Matchers}

class PatternMatchingGameSpec extends FlatSpec with Matchers {

  import PatternMatchingGame._

  "areSameNotNull" should "return false with an empty Array" in {
    areSameNotNull(Array.empty) should be (false)
  }

  "areSameNotNull" should "return false with an Array of one x" in {
    areSameNotNull(Array(x)) should be (false)
  }

  "areSameNotNull" should "return false with an Array of one o" in {
    areSameNotNull(Array(o)) should be (false)
  }

  "areSameNotNull" should "return false with an Array of one blank square" in {
    areSameNotNull(Array(blank)) should be (false)
  }

  "areSameNotNull" should "return false with an Array starting with a blank square" in {
    areSameNotNull(Array(blank, x)) should be (false)
  }

  "areSameNotNull" should "return false with an Array of xox" in {
    areSameNotNull(Array(x, o, x)) should be (false)
  }

  "areSameNotNull" should "return true with an Array of xxx" in {
    areSameNotNull(Array(x, x, x)) should be (true)
  }

  "areSameNotNull" should "return true with an Array of oooo" in {
    areSameNotNull(Array(o,o,o,o)) should be (true)
  }

  "whoWon" should "return x if x takes the top row" in {
    whoWon(Array(x,x,x,o,x,o,o,o,x)) should be (x)
  }

  "whoWon" should "return o if o takes the top row" in {
    whoWon(Array(o,o,o,x,o,x,x,x,o)) should be (o)
  }

  "whoWon" should "return x if x takes the middle row" in {
    whoWon(Array(o,x,o,x,x,x,o,o,x)) should be (x)
  }

  "whoWon" should "return x if x takes the last row" in {
    whoWon(Array(o,x,o,o,o,x,x,x,x)) should be (x)
  }

  "whoWon" should "return o if o takes the first column" in {
    whoWon(Array(o,x,o,o,x,x,o,x,x)) should be (o)
  }

  "whoWon" should "return o if o takes the second column" in {
    whoWon(Array(x,o,o,x,o,x,o,o,x)) should be (o)
  }

  "whoWon" should "return o if o takes the last column" in {
    whoWon(Array(x,x,o,o,x,o,x,o,o)) should be (o)
  }

  "whoWon" should "return x if x takes first diagonal" in {
    whoWon(Array(x,o,x,o,x,o,o,x,x)) should be (x)
  }

  "whoWon" should "return x if x takes second diagonal" in {
    whoWon(Array(o,o,x,x,x,o,x,o,o)) should be (x)
  }

}
