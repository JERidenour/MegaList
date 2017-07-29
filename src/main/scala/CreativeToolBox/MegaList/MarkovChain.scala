package CreativeToolBox.Megalist

class MarkovChain {

    private var _startState = ""

    def startState = _startState

    def startState_= (in:String):Unit = _startState = in

    override def toString: String = {
        this.startState
    }
}

object MarkovChain {

    def apply(ss: String) = {

        var mc = new MarkovChain
        mc.startState = ss
        mc

    }
}
