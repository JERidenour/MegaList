package CreativeToolBox.Megalist

object GenerateList{
    def main(args: Array[String]) {

        val testString = "bbbabbabbbbaba"             
        var chain = MarkovChain(testString, 3)
        println(chain.toString)

    }
}
