package fpinscala.gettingstarted

object Fibonacci extends App{

  def fib(n: Int): Int ={
    @annotation.tailrec
    def go(n: Int, first: Int, pre: Int): Int ={
      if(n<3){
        pre
      } else{
        go(n-1, pre, first+pre)
      }

    }
    go(n, 0, 1)
  }
  println("7th fibonacci number>>>>>>>>>>"+fib(1))
}