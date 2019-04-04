package Models

import java.io.Serializable

class DFATable : Serializable {

    /* 2D Array
        state   a
         0      57
     */
    var regularStates: HashMap<Pair<Int, String>, Int> = HashMap()
    var finalStates: HashSet<Int> = HashSet()


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DFATable

        if (regularStates != other.regularStates) return false
        if (finalStates != other.finalStates) return false

        return true
    }

    override fun hashCode(): Int {
        var result = regularStates.hashCode()
        result = 31 * result + finalStates.hashCode()
        return result
    }


    override fun toString(): String {
        return "DFATable(regularStates=$regularStates, finalStates=$finalStates)"
    }


}