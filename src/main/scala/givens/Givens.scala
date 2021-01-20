package givens

case class Person(surname: String, name: String, age: Int)

object Givens {
  
  val personOrdering: Ordering[Person] = new Ordering[Person] {
    override def compare(x: Person, y: Person): Int =
      x.surname.compareTo(y.surname)
  }
  
  val peopleList: List[Person] = List(
    Person("Wick", "John", 35),
    Person("Smith", "Adam", 27)
  )
  
  def listPeople(list: List[Person])(ordering: Ordering[Person]):List[Person] = list.sorted(personOrdering)
  def someOtherMethodRequiringOrdering(personX: Person, personY: Person)(ordering: Ordering[Person]): Int = 0
  
//  1 direct import
  import StadnardValues.standardPersonOrdering
  
//  2 import type
//  import StadnardValues.{given Ordering[Person]}

//  3 import all givens
//  import StadnardValues.{given _ }
  
  def someMethodRequiringStandardOrdering(people: List[Person])(using ordering: Ordering[Person]): List[Person] =
    people.sorted(personOrdering)
    
//  given Ordering[Option[T]] from Ordering[T] in scope
  given optionOrdering[T](using normalOrdering: Ordering[T]) as Ordering[Option[T]] {
    override def compare(x: Option[T], y: Option[T]): Int = (x, y) match {
      case (None, None) => 0
      case (None, _) => -1
      case (_, None) => 1
      case (Some(a), Some(b)) => normalOrdering.compare(a,b)  
    }
  }
  
  def sortThing[T](things: List[T])(using ordering: Ordering[T]) = ???
  
  val maybePeople: List[Option[Person]] = List()
  sortThing(maybePeople)
  
  
  def main(args: Array[String]): Unit = {
    listPeople(peopleList)(personOrdering).foreach(println)
    someMethodRequiringStandardOrdering(peopleList).foreach(println)
  }
}

object StadnardValues {
  given standardPersonOrdering as Ordering[Person] {
    override def compare(x: Person, y: Person): Int =
      x.surname.compareTo(y.surname)
  }
}
