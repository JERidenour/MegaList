package CreativeToolBox.Megalist

import scala.io.Source
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
import scala.util.Random

object GenerateList{
    def main(args: Array[String]) {

        val inputFile = "src/main/resources/The_quran.txt"
        val bufferedSource = Source.fromFile(inputFile)
        val fileContents = bufferedSource.getLines.mkString(" ")
        bufferedSource.close

        /*
        * Note: the order parameter is basically how many words there are per node
        */
        var chain = MarkovChain(fileContents, 2)
        val maxLength = 3
	var outString = ""
        for ( i <- 1 to 300 ) {

            var randInt = Random.nextInt( (maxLength) ) 
            outString += "\n " + chain.simulate(randInt)

        }

	//val outString = chain.simulate(100)
	//println(outString))

	val outputFile = "src/main/resources/Output.txt"
	Files.write(Paths.get(outputFile),outString 
	    .getBytes(StandardCharsets.UTF_8))

    }
}
