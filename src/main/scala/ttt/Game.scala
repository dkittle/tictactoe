package ttt

/**
 * Created by don on 14-08-12.
 */
class Game {

  private val board = Array.ofDim[Int](9)
  private var currentPlayer = 1;


  def makeMove(row: Int, column: Int): Boolean = {
    if (row < 0 || row > 2 || column < 0 || column > 2)
      return false

    val position = column + (row * 3)

    if (board(position) != 0)
      return false

    board(position) = currentPlayer
    togglePlayer
    return true
  }

  def whoWon() : WinningPlayer.Value = {

    var winner = checkRowsForWinner()
    if (winner != WinningPlayer.Neither)
      return winner

    winner = checkColumnsForWinner()
    if (winner != WinningPlayer.Neither)
      return winner

    winner = checkDiagonalsForWinner()
    if (winner != WinningPlayer.Neither)
      return winner

    if (checkAllMovesMade() == true)
      return WinningPlayer.Neither
    return WinningPlayer.KeepPlaying
  }

  def whoIsCurrentPlayer() : WinningPlayer.Value = {
    return whatPlayerIsThis(currentPlayer)
  }

  private def whatPlayerIsThis(playerNumber : Int) : WinningPlayer.Value = {
    if(playerNumber == 1)
      return WinningPlayer.X
    if(playerNumber == -1)
      return WinningPlayer.O
    return WinningPlayer.Neither
  }

  private def checkRowsForWinner() : WinningPlayer.Value = {
    for (row <- 0 to 2) {
      val position = row * 3
      val cells = List(board(position), board(position + 1), board(position + 2))
      if (checkCellsForSamePlayer(cells) == true)
        return whatPlayerIsThis(cells(0))
    }
    return WinningPlayer.Neither
  }

  private def checkColumnsForWinner() : WinningPlayer.Value = {
    for (column <- 0 to 2) {
      val cells = List(board(column), board(column + 3), board(column + 6))
      if (checkCellsForSamePlayer(cells) == true)
        return whatPlayerIsThis(cells(0))
    }
    return WinningPlayer.Neither
  }

  private def checkDiagonalsForWinner() : WinningPlayer.Value = {
    var cells = List(board(0), board(4), board(8))
    if (checkCellsForSamePlayer(cells) == true)
      return whatPlayerIsThis(cells(0))
    cells = List(board(2), board(4), board(6))
    if (checkCellsForSamePlayer(cells) == true)
      return whatPlayerIsThis(cells(0))
    return WinningPlayer.Neither
  }

  private def checkCellsForSamePlayer(cells: List[Int]): Boolean = {
    if (scala.math.abs(cells.foldLeft(0)((sum, value) => sum + value)) == cells.size) return true
    return false
  }

  private def togglePlayer(): Unit = {
    currentPlayer *= -1
  }

  private def checkAllMovesMade() : Boolean = {
    for (player <- board if (player == 0))
      return false
    return true
  }

}


object WinningPlayer extends Enumeration {
  val X, O, Neither, KeepPlaying = Value
}