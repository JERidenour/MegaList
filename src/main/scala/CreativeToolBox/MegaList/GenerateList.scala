package CreativeToolBox.Megalist

import scala.io.Source
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
import sys.process._
import scala.util.Random
import net.graphviz._

object GenerateList{
    def main(args: Array[String]) {

        val inputFile = "src/main/resources/dylan_thomas.txt"
        val bufferedSource = Source.fromFile(inputFile)
        val fileContents = bufferedSource.getLines.mkString(" ")
        bufferedSource.close

        /*
        * Note: the order parameter is basically how many words there are per node
        */
        println("initializeing Markov chain")
        var chain = MarkovChain(fileContents, 2)
        //val maxLength = 3
	//var outString = ""
        //for ( i <- 1 to 300 ) {

        //    var randInt = Random.nextInt( (maxLength) ) 
        //    outString += "\n " + chain.simulate(randInt)

        //}

	////val outString = chain.simulate(100)
	////println(outString))

	//val outputFile = "src/main/resources/Output.txt"
	//Files.write(Paths.get(outputFile),outString 
	//    .getBytes(StandardCharsets.UTF_8))

        println("initializeing Dot object")
        var dot = new Dot()
        chain.states.foreach { dot.nodeBuffer += Node.apply(_)  }

        for(s <- chain.states){

            //for each state, get companion states
            var keyWord = s.split(" ").last
            var compStates = chain.states.filter( (a:String) => a.split(" ").head == keyWord)
            var N = compStates.length.toDouble
    
            for(cs <- compStates){
            
                //for each companion state, get prob and write edge
                var prob = (compStates.filter( (a:String)  => a  == cs ).length + 1) / N
                dot.edgeBuffer += Edge.apply(s, cs)
            }
        }

        println("writing Dot to file")
        Files.write(Paths.get("src/main/resources/mcGraph.dot"), 
            dot.toString.getBytes(StandardCharsets.UTF_8))

        println("executing system call to graphviz")
        // system call to graphviz
        "neato src/main/resources/mcGraph.dot -Tpng -osrc/main/resources/mcGraph.png " !


    }
}
