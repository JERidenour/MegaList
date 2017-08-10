package CreativeToolBox.Megalist

import scala.io.Source
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
import scala.util.Random

object GenerateList{
    def main(args: Array[String]) {

        val inputFile = "src/main/resources/Dylan_Thomas.txt"
        val bufferedSource = Source.fromFile(inputFile)
        val fileContents = bufferedSource.getLines.mkString(" ")
        bufferedSource.close

        /*
        * Note: the order parameter is basically how many words there are per node
        */
        var chain = MarkovChain(fileContents, 2)
        //val maxLength = 3
	//var outString = ""
        //for ( i <- 1 to 300 ) {

        //    var randInt = Random.nextInt( (maxLength) ) 
        //    outString += "\n " + chain.simulate(randInt)

        //}

	////val outString = chain.simulate(100)
	////println(outString))

	//val outputFile = "src/main/resources/Output.txt"
	//Files.write(Paths.get(outputFile),outString 
	//    .getBytes(StandardCharsets.UTF_8))

        for(s <- chain.states){

            //for each state, get companion states
            var keyWord = s.split(" ").last
            var compStates = chain.states.filter( (a:String) => a.split(" ").head == keyWord)
            
            println(s) 
            println(compStates) 
            //for each companion state, get prob and write edge
            
            

        }
    }
}
