package indentation

object Indentation {

  val condtion = if 2 > 3 then "bigger" else "smaller"

   for 
    n <- List(1,2,3)
    c <- List("a", "b", "c") 
   yield s"$n$c"
  
  def compute(n: Int): Int = 
    println("computing")
    42

  class Animal:
    def eat(): Unit =
      println("Eating")
  
  

  def main(args: Array[String]): Unit = {
    
  }
}
