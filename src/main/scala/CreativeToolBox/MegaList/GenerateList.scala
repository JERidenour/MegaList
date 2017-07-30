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
        var chain = MarkovChain(fileContents, 3)
        val maxLength = 3
//        for ( i <- 1 to 15 ) {
//
//            var randInt = scala.util.Random.nextInt( (maxLength) ) 
//	    println(randInt + 1 )
//            println(chain.simulate(randInt))
//
//        }

	//println(chain.simulate(100))

	val outputFile = "src/main/resources/Output.txt"
	Files.write(Paths.get(outputFile), chain.simulate(100).getBytes(StandardCharsets.UTF_8))

    }
}
