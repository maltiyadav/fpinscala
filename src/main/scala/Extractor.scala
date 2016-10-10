/**
  * In scala , object has special type unapply method for extracting
  *  some input data.
  *  It generally comes with apply method but it is not necessary .
  *  An extractor has the opposite role of a constructor
  *  There is main two point which are as follows
  *  1) Its purpose is to ‘extract’ the inputs that were present before the ‘apply’ operation.
  *  2) Reverse the effect of apply method.
  *  3) An unapply method must accept a single argument.
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  * The return type of an unapply should be chosen as follows:
  *  1) If it is just a test, return a Boolean. For instance case even()
  *  2) If it returns a single sub-value of type T, return a Option[T]
  *  3) If you want to return several sub-values T1,...,Tn, group them in an optional tuple Option[(T1,...,Tn)].
  */


// Can we achieve this using case class ?

object ExtractorWithApply{

  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = {
    if (z % 2 == 0) Some(z / 2) else None
  }

}

object ExtractorWithApplyTest extends App{

  // calling apply method of `Extractor object`
  // the result of `calledApply` would be 42
  val calledApply = ExtractorWithApply(21)

  calledApply match {
    // `case Extractor(x)` : Calling unapply method of `Extractor object`
    //  `calledApply`'s value would be pass to unapply method
    // `x` would be hold result of `unapply method`
    case ExtractorWithApply(x) => println("x>>>>>>>>>>>>>" + x)
  }

}


object ExtractorWithoutApply {
  def unapply(x : Int) : Option[String] =
    if(x == 0) Some("Hello, World") else None
}

/**
  * Let's suppose myInt = 0. Then what happens?
  * In this case ExtractorWithoutApply.unapply(0) gets called, and as you can see, will return Some("Hello, World").
  * The contents of the Option will get assigned to str so in the end, the above pattern match will print out "Hello, world".
  * But what if myInt = 1? Then Foo.unapply(1) returns None so the corresponding expression for that pattern does not get called.
  * In the case of assignments, like val Foo(str) = x this is syntactic sugar for:
  * val str : String = ExtractorWithoutApply.unapply(x) match {
  *   case Some(s) => s
  *   case None    => throw new scala.MatchError(x)
  * }
  */
object ExtractorWithoutApplyTest extends App {
  val myInt = 0
  myInt match {
    case ExtraExtractorBooleanTestrWithoutApply(str) => println(str)
  }
}

object ExtractorBooleanTest extends App{

  def unapply(z: Int): Option[Boolean] = {
    println("z>>>>>>>>>>>>>>>>>" +z)
    Some(true)
  }

  0 match {
    case ExtractorBooleanTest(x) => println("x>>>>>>>>>>>>" + x)
  }

}
