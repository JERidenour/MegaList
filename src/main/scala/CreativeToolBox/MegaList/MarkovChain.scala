package CreativeToolBox.Megalist

import scala.collection.mutable.ArrayBuffer

class MarkovChain {

    var states = new ArrayBuffer[String]
    private var _currentState = " " 
    
    def currentState = _currentState
    
    def currentState_= (in: String):Unit = _currentState = in

    def simulate(sChar: Char, length: Int): String = {
        var possibleStates = this.states.filter( _(0) == sChar )
        // TODO: handle cases where filter argument returns false
        val rnd = new scala.util.Random
        var index = rnd.nextInt( possibleStates.length )
        this.currentState = possibleStates.apply(index) 
        
        var simulatedChain = new ArrayBuffer[String]
        while ( simulatedChain.length < (length + 1)  ) {
            simulatedChain += this.currentState
            possibleStates = this.states
                .filter(  _(0) == this.currentState( this.currentState.length-1 ) )
            index = rnd.nextInt( possibleStates.length )
            this.currentState = possibleStates.apply(index)
            // TODO: make sure the index is always valid
            simulatedChain += this.currentState
        }
        simulatedChain.mkString
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
