package types

import java.io.File

object NewTypes {

  // 1 - literal types
  val aNumber: Int = 3
  val three: 3 = 3
  
  def passNumber(n: Int) = println(n)
  passNumber(20)
  passNumber(three)
  
  def passThree(n: 3) = println(n)
  passThree(3)
  
  val pi: 3.14 = 3.14
  val truth: true = true
  val myFavouriteLanguage: "Scala" = "Scala"
  
  def doSomethingWihtYourLife(meaning: Option[42]) = meaning.foreach(println)
  
  // 2 - union types
  def ambivalneMethod(arg: String | Int) = arg match {
    case _: String => println(s"string $arg")
    case _: Int => println(s"integer $arg")
  }
  
  ambivalneMethod("Name")
  ambivalneMethod(1)
  
  type ErrorOr[T] = T | "error"
  def handleResource(file: ErrorOr[File]): Unit = file match {
    case _: File => println("file")
    case _: "error" => println("error")
  }
  
  val intOrDouble: Double = if (43 > 0) 0.0 else 43
  val aIntOrDouble: Int | Double  = if (43 > 0) 0.0 else 43
  
  // 3 - intersection types
  trait Camera {
    def takePhoto = println("snap")
    def use = println("using camera")
  }
  
  trait Phone{
    def makeCall = println("ring")
    def use = println("using phone")
  }
  
  def userSmartDevice(sp: Camera & Phone) = {
    sp.takePhoto
    sp.makeCall
    
    sp.use
  }
  
  class SmartPhone extends Camera with Phone {
    override def use: Unit = println("using smart")
  }
  
  userSmartDevice(new SmartPhone)
  
  trait HostConfig
  trait HostController{
    def get: Option[HostConfig]
  }
  
  trait PortConfig
  trait PortController{
    def get: Option[PortConfig]
  }
  
  def getConfigs(controller: HostController & PortController): Option[HostConfig & PortConfig] = controller.get
  
  def main(args: Array[String]): Unit = {
    
  }
}
