package typelambdas

object TypeLambdas {

  type MyList = [T] =>> List[T]
  type MapWithStringKey = [T] =>> Map[String, T]
  type SpecialEither = [T,E] =>> Either[E, Option[T]]
  
  val addressBook: MapWithStringKey[Int] = Map()
  val specialEither: SpecialEither[Int, String] = Right(Some(1))
  
  trait Monad [M[_]] {
    def pure[A](value: A): M[A]
    def flatMap[A,B](ma: M[A])(transfomation: A => M[B]): M[B]
  }
  
  class EitherMonad[E] extends Monad[[T] =>> Either[E,T]] {
    override def pure[A](value: A): Either[E, A] = ???
    override def flatMap[A, B](ma: Either[E,A])(transfomation: A => Either[E,B]): Either[E,B] = ???
  }

  def main(args: Array[String]): Unit = {
    
  }
}
