package CreativeToolBox.Megalist

import scala.io.Source

object GenerateList{
    def main(args: Array[String]) {

        val filename = "src/main/resources/training_data.txt"
        val bufferedSource = Source.fromFile(filename)
        val fileContents = bufferedSource.getLines.mkString
        bufferedSource.close

        var chain = MarkovChain(fileContents, 5)
        val maxLength = 4
        for ( i <- 1 to 10 ) {

            var randChar = scala.util.Random.alphanumeric.filter(_.isLetter).head
            var randInt = scala.util.Random.nextInt( (maxLength) ) 
            println(chain.simulate(randChar, randInt))

        }
    }
}
