package traits

object Traits {
  
  // traits arguments 
  trait Talker(subject: String) {
    def talkTo(another: Talker): String = ""
  }
  
  class Person(name: String) extends Talker("rock music")
  
  class RockFan extends Talker("rock music")
  class RockFantastic extends RockFan with Talker
  
  trait BrokenRecord extends Talker
  class AnnoyingFrined extends BrokenRecord with Talker("history")

  def main(args: Array[String]): Unit = {
    
  }

}
