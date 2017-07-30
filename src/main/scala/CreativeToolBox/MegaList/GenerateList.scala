package CreativeToolBox.Megalist

object GenerateList{
    def main(args: Array[String]) {

        val testString = "bbb bbb " +
            "bbb bba " +
            "bbb bba " + 
            "bba bab " +
            "bab aba " + 
            "bab abb " + 
            "bab abb " + 
            "bab abb " + 
            "abb bbb " + 
            "abb bbb " + 
            "abb bba " +
            "aba bab" 
             
        var chain = MarkovChain(testString)
        println(chain.toString)

    }
}
