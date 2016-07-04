package fpinscala.gettingstarted

object AbsoluteValue{

  def abs(n: Int) =if(n > 0) n else -n

  def formatAbs(n: Int): String ={
    val msg = "The absolute value of %d is %d"
    msg.format(n, abs(n))
  }

  def main (args: Array[String]): Unit = {
    println("Absolute value>>>>>"+formatAbs(5))
  }
}