package Models

class State {

    var currentState: State? = null
    var nextState: State? = null
    var value: String = "NOT_SET"
    var label: Int = 0


    override fun toString(): String {
        return "State(currentState=$currentState, nextState=$nextState, value='$value', label=$label)"
    }


}