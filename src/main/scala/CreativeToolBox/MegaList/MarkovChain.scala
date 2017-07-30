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
    def simulate(sChar: Char, len: Int): String = {

        // get the set of states which start with sChar
        var possibleStates = this.states.filter( _(0) == sChar )
        if( possibleStates.length==0 ){ 
            possibleStates = this.states.filter( _(0)=='A' )  
        }

        // draw at random from the resulting population, set this as current state
        val rnd = new scala.util.Random
        var index = rnd.nextInt( possibleStates.length )
        val initialState = possibleStates.apply(index) 
        this.currentState = initialState

        // repeat either until the desired length is achived        
        // or until the model runs out of states
        var sim = new ArrayBuffer[String]
        while ( sim.length < (len + 1)  ) {
            sim += this.currentState
    
            //TODO: implement this for words, not letters:
            possibleStates = this.states
                .filter(  _(0) == this.currentState( this.currentState.length-1 ) )

            // if there are no possible states, revert to the initial state 
            // otherwise update
            if( possibleStates.length==0 ){
                this.currentState = initialState
            } else {
                index = rnd.nextInt( possibleStates.length )
                this.currentState = possibleStates.apply(index)
            }
        }

        // use letters:
        //sim.mkString
        // use words:
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
        // to use letters
        //for(i <- 0 to (in.length-order)){ mc.states += in.substring(i, i+order)  }
        // to use words
        val wordList = in.split("\\s+")
        for(i <- 0 to (wordList.length-order)){ 
            mc.states += wordList.slice(i, i+order).mkString(" ")
         }
        mc

    }
}
