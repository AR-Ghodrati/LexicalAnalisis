class Analysis {


    val _KeywordToken = mapOf(
        "if" to TokenType.Keyword_if,
        "else" to TokenType.Keyword_else,
        "start" to TokenType.Keyword_start,
        "finish" to TokenType.Keyword_finish,
        "print" to TokenType.Keyword_print,
        "then" to TokenType.Keyword_then,
        "repeat" to TokenType.Keyword_repeat,
        "var" to TokenType.Keyword_var,
        "do" to TokenType.Keyword_do,
        "read" to TokenType.Keyword_read,
        "void" to TokenType.Keyword_void,
        "return" to TokenType.Keyword_return,
        "dummy" to TokenType.Keyword_dummy,
        "program" to TokenType.Keyword_program,
        "int" to TokenType.Keyword_int,
        "float" to TokenType.Keyword_float

    )

    val _OperatorToken = mapOf(
        "!" to TokenType.Op_not,
        "<" to TokenType.Op_less,
        ">" to TokenType.Op_greater,
        ">=" to TokenType.Op_greaterequal,
        "<=" to TokenType.Op_lesster_equal,
        "==" to TokenType.Op_equal,
        "!=" to TokenType.Op_notequal,
        "=" to TokenType.Op_assign
    )

    val _ExtraChars = mapOf(
        "+" to TokenType.Plus,
        " " to TokenType.WhiteSpace,
        ";" to TokenType.Semicolon,
        "," to TokenType.Comma
    )


    fun Scan(txt: String) {

    }


    /* private fun ScanWithDFA(txt : String) : Boolean{
         var state = 0
         for (ch in txt)
             state = kTransitionTable[state][ch] return kAcceptTable[state]
     }
     */
}