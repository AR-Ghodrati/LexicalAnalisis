enum class TokenType {

    //Ops
    Op_not,
    Op_less, Op_lesster_equal, Op_lessequal, Op_greater, Op_greaterequal,
    Op_equal, Op_notequal, Op_assign

    //Keywords
    ,
    Keyword_if, Keyword_else, Keyword_start, Keyword_finish
    ,
    Keyword_print, Keyword_then, Keyword_repeat, Keyword_var
    ,
    Keyword_do, Keyword_read, Keyword_void, Keyword_return
    ,
    Keyword_dummy, Keyword_program, Keyword_int, Keyword_float


    //Extra
    ,
    Plus, WhiteSpace, Semicolon, Comma
    ,
    Identifier


    ,
    NONE
    ,
    ERROR
}