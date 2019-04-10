package Models

import java.io.Serializable

class Token(
    var srt: String, var line: Int, val index: Int
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Token

        if (srt != other.srt) return false
        if (line != other.line) return false
        if (index != other.index) return false

        return true
    }

    override fun hashCode(): Int {
        var result = srt.hashCode()
        result = 31 * result + line
        result = 31 * result + index
        return result
    }

    override fun toString(): String {
        return "Token(srt='$srt', line=$line, index=$index)"
    }


}