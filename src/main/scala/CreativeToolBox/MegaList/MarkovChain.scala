package CreativeToolBox.Megalist

class MarkovChain {

    private var _initialState = ""

    def initialState = _initialState

    def initialState_= (in:String):Unit = _initialState = in

    override def toString: String = {
        this.initialState
    }
}

object MarkovChain {

    def apply(ss: String) = {

        var mc = new MarkovChain
        mc.initialState = ss
        mc

    }
}
