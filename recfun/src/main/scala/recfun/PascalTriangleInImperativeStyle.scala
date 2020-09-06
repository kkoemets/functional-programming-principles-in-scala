package recfun

object PascalTriangleInImperativeStyle {
  def main(args: Array[String]): Unit = {
    printPascal(5)
  }

  def printPascal(size: Int) = {
    var previousArray = new Array[Int](size)
    for (i <- 0 until size) {
      val currentArray = new Array[Int](i + 1)
      currentArray(0) = 1
      currentArray(i) = 1
      for (j <- 1 until i) {
        currentArray(j) = previousArray(j - 1) + previousArray(j)
      }
      println(currentArray.mkString(" "))
      previousArray = currentArray
    }
  }
}