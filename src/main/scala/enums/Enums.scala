package enums

import scala.util.Try

object Enums {
  
  enum Permissions {
    case READ, WRITE, EXEC, NONE
  }
  
  enum PermissionsWithBits(val bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXEC extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
    
    def toHex: String = Integer.toHexString(bits)
  }

  def getPermissionIndex(permission: Permissions): Int = permission.ordinal
  def allPermission(): Array[Permissions] = Permissions.values
  def getPermissionByName(name: String): Option[Permissions] = Try(Permissions.valueOf(name)).toOption

  def main(args: Array[String]): Unit = {
    allPermission().foreach(println)
    
    println(getPermissionIndex(Permissions.WRITE))
    
    println(getPermissionByName("WRITE"))
  }

}
