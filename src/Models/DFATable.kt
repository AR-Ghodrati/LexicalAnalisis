package Models

import java.io.Serializable

class DFATable : Serializable {

    // 2D Array
    var values: MutableList<MutableList<Int>> = ArrayList()


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DFATable

        if (values != other.values) return false

        return true
    }

    override fun hashCode(): Int {
        return values.hashCode()
    }

    override fun toString(): String {
        return "DFATable(values=$values)"
    }


}