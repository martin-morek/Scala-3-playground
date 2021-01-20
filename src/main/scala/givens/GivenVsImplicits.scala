package givens

object GivenVsImplicits {
  
  // implicit conversion
  case class Person(name: String) {
    def greet: String = s"Hey, my name is $name"
  }
  
  implicit def stringToPerson(string: String): Person = Person(string)
  "John".greet
 
  given stringToPerson as Conversion[String, Person] {
   def apply(string: String) = Person(string)
  } 
  
  import scala.language.implicitConversions
  "Jack".greet
  
  // syntax ambiguities
//  implicit val size: Int = 42
//  def getMap(implicit size: Int): Map[String, Int] = ???
//  getMap(2)("Sarah")
  
  
  given sizeX as Int = 50
  def getMap2(using size: Int): Map[String, Int] = ???
  
  getMap2(using 20)("Nick")
  getMap2("Nick")
  
}
