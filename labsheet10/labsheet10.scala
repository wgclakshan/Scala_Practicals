import scala.compiletime.ops.string
import scala.io.StdIn

object q1 {

    def calculateAverage ( celcius : Array[Float] ) : Float = {
        val fahrenheit = celcius.map(c=>(c*9/5)+32);
        val sum = fahrenheit.reduce((x,y)=>x+y);
        sum/fahrenheit.length;
    }

    def main(args : Array[String]) = {
        println("Enter the space seperated list of celcius temperatures :- ");
        val temperature : String = scala.io.StdIn.readLine();
        val celcius_list = temperature.split(" ").map(_.toFloat);
        println(s"Average Fahrenheit Temperature : ${calculateAverage(celcius_list)}");
    }
} 

object q2 {
    def countLetterOccurences (word : Array[String]) : Int = {
        val words_length = word.map(x => x.length());
        val totalCharacters = words_length.reduce((x,y) => x+y);
        totalCharacters;
    }

    def main(args : Array[String]) = {
        println("Enter the list of space seperated words :- ");
        val line = scala.io.StdIn.readLine();
        val list = line.split(" ");
        println(s"Total count of letter occurrences: ${countLetterOccurences(list)}");
    }
}
