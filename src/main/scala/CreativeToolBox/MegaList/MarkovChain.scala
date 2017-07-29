package CreativeToolBox.Megalist

import scala.collection.mutable.ArrayBuffer

class MarkovChain {

    var states = new ArrayBuffer[String]

    override def toString: String = {
        this.states.mkString(", ")
    }
}

object MarkovChain {

    def apply(in: String) = {

        var mc = new MarkovChain
        in.split("\\s+").distinct.foreach { mc.states.append(_) }
        mc

    }
}
