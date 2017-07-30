package CreativeToolBox.Megalist

import scala.collection.mutable.ArrayBuffer

class MarkovChain {

    var states = new ArrayBuffer[String]
    private var _currentState = " " 
    
    def currentState = _currentState
    
    def currentState_= (in: String):Unit = _currentState = in

    def simulate(sChar: Char): String = {
        val possibleStates = this.states.filter( _(0) == sChar )
        var rnd = new scala.util.Random
        var index = rnd.nextInt( possibleStates.length )
        this.currentState = possibleStates.apply(index) 
        this.currentState
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
