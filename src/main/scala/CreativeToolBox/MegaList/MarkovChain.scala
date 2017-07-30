package CreativeToolBox.Megalist

import scala.collection.mutable.ArrayBuffer

class MarkovChain {

    var states = new ArrayBuffer[String]

    def simulate(sChar: Char): String = {
        val possibleStates = this.states.filter( _(0) == sChar )
        var rnd = new scala.util.Random
        var index = 0 + rnd.nextInt( ( (possibleStates.length-1) - 0) + 1 )
        possibleStates.apply(index) 
    } 

    /*
    * Return the state strings separated by comma
    */
    override def toString: String = {
        this.states.mkString(", ")
    }
}

object MarkovChain {

    /*
    * Return a MarkovChain object with states for each word in a string
    */
    def apply(in: String, order: Int) = {

        var mc = new MarkovChain
        for(i <- 0 to (in.length-order)){ mc.states += in.substring(i, i+order)  }
        mc

    }
}
