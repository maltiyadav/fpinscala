package fpinscala.gettingstarted

object Factorial extends App{

  // A function definition using local tail recursion
  def fact1(n: Int): Int ={
    @annotation.tailrec
    def go(n: Int, acc: Int): Int ={
      if(n < 1) acc else go(n-1, n*acc)
    }
    go(n, 1)
  }

  // A function definition using the loop
  def fact2(n: Int): Int ={
    var i = n
    var r = 1
    while(i > 0){
      r = r*i
      i-=1
    }
    r
  }

  printf("Factorial of 5 by using tail recursion>>>>>>>"+fact1(5))
  println("\n")
  printf("Factorial of 5 by using while loop>>>>>>>"+fact2(5))
  println("\n")
}