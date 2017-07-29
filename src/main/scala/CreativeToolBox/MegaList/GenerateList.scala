package CreativeToolBox.Megalist

object GenerateList{
    def main(args: Array[String]) {

        val testString = "This is a string for testing not a string to use"
        var chain = MarkovChain(testString)
        println(chain.toString)

    }
}
