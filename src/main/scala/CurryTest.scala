/**
  * Created by malti on 9/5/16.
  */
object CurryTest extends App {
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  def modN(n: Int)(x: Int) = (x % n) == 0

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

  println(filter(nums, modN(2)))
  println(filter(nums, modN(3)))

  print("2nd Example start here..............")


  def sum(list: List[Int], f:Int => Int): List[Int] ={
    list.map(l => f(l))
  }
  def add(n: Int)(x: Int) = n + x
  println(sum(nums,add(10)))

}