package Models

class CustomTrieNode {

    var label: Int = Int.MIN_VALUE
    var isAccepted: Boolean = false
    var children: HashMap<Char, CustomTrieNode> = HashMap()


    override fun toString(): String {
        return "CustomTrieNode(label=$label, isAccepted=$isAccepted, children=$children)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CustomTrieNode

        if (label != other.label) return false
        if (isAccepted != other.isAccepted) return false
        if (children != other.children) return false

        return true
    }

    override fun hashCode(): Int {
        var result = label
        result = 31 * result + isAccepted.hashCode()
        result = 31 * result + children.hashCode()
        return result
    }


}