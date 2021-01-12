package infixmethods

import scala.annotation.targetName

object InfixMethods {

  case class Person(name: String) {
    infix def likes(movie: String): String = s"$name likes $movie"
  }
  
  val person = Person("John")
  person.likes("Titanic")
  person likes "Titanic"
  
  extension (person: Person) {
    infix def enjoys(musicGenere: String): String = s"${person.name} listens to $musicGenere"

    @targetName("livesAt")
    def <*>(city: String): String = s"${person.name} lives in $city" 
  }
  
  def main(args: Array[String]): Unit = {
    println(person enjoys "Rock")
    
    println(person <*> "New York")
  }
}
