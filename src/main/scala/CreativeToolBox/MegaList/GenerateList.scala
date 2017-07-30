package CreativeToolBox.Megalist

import scala.io.Source
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets

object GenerateList{
    def main(args: Array[String]) {

        val inputFile = "src/main/resources/Full_Collection_of_Dylan_Thomas.txt"
        val bufferedSource = Source.fromFile(inputFile)
        val fileContents = bufferedSource.getLines.mkString(" ")
        bufferedSource.close

        /*
        * Note: order 3 adds two words at a time, order 4 three words, etc
        */
        var chain = MarkovChain(fileContents, 2)
        val maxLength = 3
	var outString = ""
        for ( i <- 1 to 300 ) {

            var randInt = scala.util.Random.nextInt( (maxLength) ) 
            outString += "\n " + chain.simulate(randInt)

        }

	//val outString = chain.simulate(100)
	//println(outString))

	val outputFile = "src/main/resources/Output.txt"
	Files.write(Paths.get(outputFile),outString 
	    .getBytes(StandardCharsets.UTF_8))

    }
}
