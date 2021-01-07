package opaquetypes

object OpaqueTypes {
  
  object SocialNetwork {
    opaque type Name = String
    
    // 1 - companion object
    object Name {
      def fromString(s: String): Option[Name] =
        if(s.isEmpty || s.charAt(0).isLower) None else Some(s)
    }
    
    // 2 - extension method
    extension(n: Name) {
      def length: Int = n.length
    }
  }
  
  import SocialNetwork._
  
  object Graphics {
    opaque type Color = Int
    opaque type ColorFilter <: Color = Int
    
    val Red: Color = 0xFF000000
    val Green: Color = 0x00FF0000
    val Blue: Color = 0x0000FF00
    
    val halfTransparency: ColorFilter = 0x80
  }
  
  import Graphics._
  case class OverlayFilter(color: Color)
  
  val fadeLayer = OverlayFilter(halfTransparency)

  def main(args: Array[String]): Unit = {
    val nameOption = Name.fromString("Martin")
    nameOption.foreach(println)
    
    val nameLength = nameOption.map(_.length)
    nameLength.foreach(println)
    
  }

}
