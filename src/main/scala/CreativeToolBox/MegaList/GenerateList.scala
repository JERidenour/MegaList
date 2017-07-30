package CreativeToolBox.Megalist

object GenerateList{
    def main(args: Array[String]) {

        val testString = "bbbabbabbbbaba"             
        var chain = MarkovChain(testString)
        println(chain.toString)

    }
}
