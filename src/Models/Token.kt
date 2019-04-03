package Models

import java.io.Serializable

class Token(val Name: String, var State: Int) : Serializable {


    override fun toString(): String {
        return "Token(Name='$Name', State=$State)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Token

        if (Name != other.Name) return false
        if (State != other.State) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Name.hashCode()
        result = 31 * result + State
        return result
    }
}