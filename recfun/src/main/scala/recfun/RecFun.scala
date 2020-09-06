package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }

    println(pascal(0, 2))
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == r)
      return 1
    if (c == 0)
      return 1
    if (c > r)
      throw new java.lang.IllegalArgumentException

    pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def isBalanced(chars: List[Char], counter: Int): Boolean = {
      if (counter < 0)
        return false
      if (chars.isEmpty)
        return counter == 0
      val head: Char = chars.head
      isBalanced(chars.tail, counter + findCount(head))
    }

    def findCount(char: Char): Int = {
      if (char == '(')
        return 1
      if (char == ')')
        return -1
      0
    }

    isBalanced(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
