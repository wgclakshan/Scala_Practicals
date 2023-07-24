import scala.io.StdIn

object ceasarcipher {
  def encryption(str: String, key: Int): String = {
    val normalizedKey = key % 26
    val encryptedStr = str.map { char =>
      if (char.isUpper && char + normalizedKey > 'Z') {
        ('A' + char + normalizedKey - 'Z' - 1).toChar
      } else if (char.isLower && char + normalizedKey > 'z') {
        ('a' + char + normalizedKey - 'z' - 1).toChar
      } else {
        (char + normalizedKey).toChar
      }
    }
    encryptedStr
  }

  def decryption(str : String, key : Int) :String = {
    val normalizedKey = key%26
    val decryptedstr = str.map {char =>
      if(char.isUpper && char - normalizedKey < 'A'){
        (-'A'+(char-normalizedKey)+'Z'+1).toChar
      }else if(char.isLower && char-normalizedKey < 'a'){
        (-'a'+(char-normalizedKey)+'z'+1).toChar
      }else{
        (char - normalizedKey).toChar
      }
    }
    decryptedstr
  }

  def cipher(str : String,function :(String,Int) => String,key : Int) : String = {
    function(str,key)
  }

  def main(args: Array[String]): Unit = {
    print("Enter the string to encrypt: ")
    val str = StdIn.readLine()
    print("Enter the key to be used: ")
    val key = StdIn.readInt()
    val encryptedstr = cipher(str,encryption,key)
    val decryptedstr = cipher(encryptedstr,decryption,key)
    println(s"Encrypted String: $encryptedstr")
    println(s"Decrypted Text: $decryptedstr")
  }
}


