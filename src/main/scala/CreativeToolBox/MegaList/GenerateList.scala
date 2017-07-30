package CreativeToolBox.Megalist

import scala.io.Source

object GenerateList{
    def main(args: Array[String]) {

        val filename = "src/main/resources/dylan_thomas.txt"
        val bufferedSource = Source.fromFile(filename)
        val fileContents = bufferedSource.getLines.mkString(" ")
        bufferedSource.close

        /*
        * Note: order 3 adds two words at a time, order 4 three words, etc
        */
        var chain = MarkovChain(fileContents, 2)
        val maxLength = 4
        for ( i <- 1 to 10 ) {

            var randInt = scala.util.Random.nextInt( (maxLength-1) ) 
            println(chain.simulate(randInt))

        }

//            var randChar = scala.util.Random.alphanumeric.filter(_.isLetter).head
//            println(chain.simulate(100))

    }
}
