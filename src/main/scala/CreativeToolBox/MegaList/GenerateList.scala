package CreativeToolBox.Megalist

import scala.io.Source

object GenerateList{
    def main(args: Array[String]) {

        val filename = "src/main/resources/training_data.txt"
        val bufferedSource = Source.fromFile(filename)
        val fileContents = bufferedSource.getLines.mkString
        bufferedSource.close

        var chain = MarkovChain(fileContents, 4)
        println(chain.simulate(' ', 5))
    }
}
