package CreativeToolBox.Megalist

import scala.collection.mutable.ArrayBuffer

class MarkovChain {

    var states = new ArrayBuffer[String]

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
    def apply(in: String) = {

        var mc = new MarkovChain
        in.split("\\s+").distinct.foreach { mc.states.append(_) }
        mc

    }
}
