package CreativeToolBox.Megalist

import scala.collection.mutable.ArrayBuffer

class MarkovChain {

    var states = new ArrayBuffer[String]
    private var _currentState = " " 
    
    def currentState = _currentState
    
    def currentState_= (in: String):Unit = _currentState = in

    /*
    * Simulate a path of length [[len]] through the markov chain
    * with initial state chosen randomly from states starting with [[sChar]].
    */
    def simulate(len: Int): String = {

        // draw at random from all possible states, set this as current state
        val rnd = new scala.util.Random
        var index = rnd.nextInt( this.states.length )
        val initialState = this.states.apply(index) 
        this.currentState = initialState

        // repeat either until the desired length is achived        
        // or until the model runs out of states
        var sim = new ArrayBuffer[String]
        while ( sim.length < (len + 1)  ) {
            val wordList = this.currentState.split("\\s+")
            sim += wordList.tail.mkString(" ")
  
            // valid states are those whose first word matches
            // the last word of the current state
            val possibleStates = this.states
                .filter(  _.split("\\s+").apply(0) == wordList.apply(wordList.length-1) )

            // if there are no possible states, revert to the initial state 
            // otherwise update
            if( possibleStates.length==0 ){
                this.currentState = initialState
            } else {
                index = rnd.nextInt( possibleStates.length )
                this.currentState = possibleStates.apply(index)
            }
        }

        sim.mkString(" ")
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
        val wordList = in.split("\\s+")
        for(i <- 0 to (wordList.length-order)){ 
            mc.states += wordList.slice(i, i+order).mkString(" ")
         }
        mc

    }
}
