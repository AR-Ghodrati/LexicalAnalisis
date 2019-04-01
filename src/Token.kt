class Token {

    var Type: TokenType = TokenType.NONE
    var Value: String? = null
    var Position: Pair<Int, Int>? = null


    override fun toString(): String {
        return "Token(Type=$Type, Value=$Value, Position=$Position)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Token

        if (Type != other.Type) return false
        if (Value != other.Value) return false
        if (Position != other.Position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Type.hashCode()
        result = 31 * result + (Value?.hashCode() ?: 0)
        result = 31 * result + (Position?.hashCode() ?: 0)
        return result
    }


}
