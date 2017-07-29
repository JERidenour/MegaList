package CreativeToolBox.Megalist

class MarkovChain {

    private var _state = ""

    def state = _state

    def state_= (in:String):Unit = _state = in

    override def toString: String = {
        this.state
    }

}

object MarkovChain {



}
