package CreativeToolBox.Megalist

object GenerateList{
    def main(args: Array[String]) {

        //val testString = "bbbabbabbbbaba"             
        val testString = "this is a test string with actual words"             
        var chain = MarkovChain(testString, 3)
        println(chain.simulate('t', 5))
    }
}
