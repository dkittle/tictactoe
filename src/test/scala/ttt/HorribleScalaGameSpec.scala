package ttt

import org.scalatest.FunSuite
import ttt.WinningPlayer._

/**
 * See my note in the implementation class - worst Scala I've written.
  *
  * Saving it in case I need a smile :)
  *
 */
class HorribleScalaGameSpec extends FunSuite {

  test("that game is not over with no moves") {
    val game = new HorribleScalaGame
    assert(game.whoWon() == KeepPlaying)
  }

  test("that game is not over with one move") {
    val game = new HorribleScalaGame
    assert(game.makeMove(0,0) == true)
    assert(game.whoWon() == KeepPlaying)
  }

  test("that one cannot make an out of bounds move") {
    val game = new HorribleScalaGame
    assert(game.makeMove(-1, -1) == false)
    assert(game.makeMove(-1, 0) == false)
    assert(game.makeMove(0, -1) == false)
    assert(game.makeMove(3, 3) == false)
    assert(game.makeMove(3, 0) == false)
    assert(game.makeMove(0, 3) == false)
  }

  test("that the player number starts with X") {
    val game = new HorribleScalaGame
    assert(game.whoIsCurrentPlayer() == X)
  }

  test("that the player gets set to O for after first move") {
    val game = new HorribleScalaGame
    assert(game.whoIsCurrentPlayer() == X)
    assert(game.makeMove(0,0) == true)
    assert(game.whoIsCurrentPlayer() == O)
  }

  test("that the same move cannot be made twice") {
    val game = new HorribleScalaGame
    assert(game.whoIsCurrentPlayer() == X)
    assert(game.makeMove(0,0) == true)
    assert(game.whoIsCurrentPlayer() == O)
    assert(game.makeMove(0,0) == false)
  }

  test("that game can be won by nobody") {
    val game = new HorribleScalaGame
    assert(game.makeMove(0, 0) == true)
    assert(game.makeMove(0, 1) == true)
    assert(game.makeMove(0, 2) == true)
    assert(game.makeMove(1, 2) == true)
    assert(game.makeMove(1, 0) == true)
    assert(game.makeMove(1, 1) == true)
    assert(game.makeMove(2, 1) == true)
    assert(game.makeMove(2, 0) == true)
    assert(game.makeMove(2, 2) == true)
    assert(game.whoWon() == Neither)
  }

  test("that game can be won by X in any row") {
    for (row <- 0 to 2) {
      val game = new HorribleScalaGame
      assert(game.makeMove(row, 0) == true)
      assert(game.makeMove((row + 1) % 3, 0) == true)
      assert(game.makeMove(row, 1) == true)
      assert(game.makeMove((row + 1) % 3, 1) == true)
      assert(game.makeMove(row, 2) == true)
      assert(game.whoWon() == X)
    }
  }

  test("that game can be won by O in any row") {
    for (row <- 0 to 2) {
      val game = new HorribleScalaGame
      assert(game.makeMove((row + 1) % 3, 0) == true)
      assert(game.makeMove(row, 0) == true)
      assert(game.makeMove((row + 1) % 3, 1) == true)
      assert(game.makeMove(row, 1) == true)
      assert(game.makeMove((row + 2) % 3, 1) == true)
      assert(game.makeMove(row, 2) == true)
      assert(game.whoWon() == O)
    }
  }

  test("that game can be won by X in any column") {
    for (column <- 0 to 2) {
      val game = new HorribleScalaGame
      assert(game.makeMove(0, column) == true)
      assert(game.makeMove(1, (column + 1) % 3) == true)
      assert(game.makeMove(1, column) == true)
      assert(game.makeMove(2, (column + 2) % 3) == true)
      assert(game.makeMove(2, column) == true)
      assert(game.whoWon() == X)
    }
  }

  test("that game can be won by Y in any column") {
    for (column <- 0 to 2) {
      val game = new HorribleScalaGame
      assert(game.makeMove(1, (column + 1) % 3) == true)
      assert(game.makeMove(0, column) == true)
      assert(game.makeMove(2, (column + 2) % 3) == true)
      assert(game.makeMove(1, column) == true)
      assert(game.makeMove(0, (column + 1) % 3) == true)
      assert(game.makeMove(2, column) == true)
      assert(game.whoWon() == O)
    }
  }

  test("that game can be won by X in either diagonal") {
    var game = new HorribleScalaGame
    assert(game.makeMove(0, 0) == true)
    assert(game.makeMove(0, 1) == true)
    assert(game.makeMove(1, 1) == true)
    assert(game.makeMove(1, 0) == true)
    assert(game.makeMove(2, 2) == true)
    assert(game.whoWon() == X)
    game = new HorribleScalaGame
    assert(game.makeMove(0, 2) == true)
    assert(game.makeMove(0, 1) == true)
    assert(game.makeMove(1, 1) == true)
    assert(game.makeMove(1, 0) == true)
    assert(game.makeMove(2, 0) == true)
    assert(game.whoWon() == X)
  }

  test("that game can be won by Y in either diagonal") {
    var game = new HorribleScalaGame
    assert(game.makeMove(0, 2) == true)
    assert(game.makeMove(0, 0) == true)
    assert(game.makeMove(1, 0) == true)
    assert(game.makeMove(1, 1) == true)
    assert(game.makeMove(0, 1) == true)
    assert(game.makeMove(2, 2) == true)
    assert(game.whoWon() == O)
    game = new HorribleScalaGame
    assert(game.makeMove(0, 1) == true)
    assert(game.makeMove(0, 2) == true)
    assert(game.makeMove(0, 0) == true)
    assert(game.makeMove(1, 1) == true)
    assert(game.makeMove(1, 2) == true)
    assert(game.makeMove(2, 0) == true)
    assert(game.whoWon() == O)
  }

}
