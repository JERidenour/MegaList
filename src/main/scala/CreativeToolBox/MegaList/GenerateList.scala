package CreativeToolBox.Megalist

import scala.io.Source

object GenerateList{
    def main(args: Array[String]) {

        val filename = "src/main/resources/training_data.txt"
        val bufferedSource = Source.fromFile(filename)
        val fileContents = bufferedSource.getLines.mkString
        bufferedSource.close

        var chain = MarkovChain(fileContents, 5)
        val randChar = scala.util.Random.alphanumeric.filter(_.isLetter).head
        println(chain.simulate(randChar, 2))
    }
}
