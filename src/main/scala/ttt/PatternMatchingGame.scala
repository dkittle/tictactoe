package ttt


object PatternMatchingGame {

  val x = 'X'
  val o = 'O'
  val blank = ' '

  def areSameNotNull(xs: Array[Character]): Boolean = {
    xs.size > 1 && xs(0) != blank && xs.count(_ == xs(0)) == xs.size
  }

  def whoWon(game: Array[Character]): Character = game match {
    case Array(a, b, c, _*) if areSameNotNull(Array(a,b,c)) => a
    case Array(_, _, _, a, b, c, _*) if areSameNotNull(Array(a,b,c)) => a
    case Array(_, _, _, _, _, _, a, b, c) if areSameNotNull(Array(a,b,c)) => a
    case Array(a, _, _, b, _, _, c, _, _) if areSameNotNull(Array(a,b,c)) => a
    case Array(_, a, _, _, b, _, _, c, _) if areSameNotNull(Array(a,b,c)) => a
    case Array(_, _, a, _, _, b, _, _, c) if areSameNotNull(Array(a,b,c)) => a
    case Array(_, _, a, _, b, _, c, _, _) if areSameNotNull(Array(a,b,c)) => a
    case Array(a, _, _, _, b, _, _, _, c) if areSameNotNull(Array(a,b,c)) => a
    case _ => blank
  }
}
