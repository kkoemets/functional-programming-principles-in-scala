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
      1
    else if (c == 0)
      1
    else if (c > r)
      throw new java.lang.IllegalArgumentException
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def isBalanced(chars: List[Char], counter: Int): Boolean = {
      if (counter < 0)
        false
      else if (chars.isEmpty)
        counter == 0
      else
        isBalanced(chars.tail, counter + findCount(chars.head))
    }

    def findCount(char: Char): Int = {
      if (char == '(')
        1
      else if (char == ')')
        -1
      else
        0
    }

    isBalanced(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (money < 0)
      0
    else if (coins.isEmpty)
      0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
