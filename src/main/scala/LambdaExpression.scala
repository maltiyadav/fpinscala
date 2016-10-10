/*
trait LambdaExpression[A, F[_]] {

  def map[B](x: F[A])(f: A=> B): F[B]
}

object LambdaExpression{

  implicit def OptionIsLambdaExpression[A]:LambdaExpression[A, Option] = new LambdaExpression[A, Option] {
    override def map[B](x: Option[A])(f: A => B):Option[B] =  Some(f(x.get))
  }
}

object Application extends App{

  val sum = (a: Int) => a

  implicitly[LambdaExpression[Int, Option]].map(Option(5))(sum)
}*/


object LambdaExpression  extends App{

  def add[A](x: A)(f:A => A): A ={
    f(x)
  }
  val sum = (a: Int) =>  a+10

  val a = add(5)(sum)
  println("a>>>>>>>>>>>>>>>>>"+a)
}