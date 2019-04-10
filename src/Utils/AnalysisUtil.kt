package Utils

import Models.DFATable
import Models.Token
import Models.TokenType
import java.io.File

object AnalysisUtil {


    private var current_State = 0 // Start State
    private var buffer: StringBuffer = StringBuffer()

    fun analysis(dfaTable: DFATable, tokens: MutableList<Token>, tokenTypes: HashSet<TokenType>) {

        println("Analysing inputCode...\r\n")

        tokens
            .forEach { token ->

                token
                    .srt
                    .toLowerCase()
                    .forEachIndexed { str_Index, token_char ->

                        current_State = generateNextState(dfaTable, token_char)
                        // println(current_State)

                        if (isEndOfToken(dfaTable, str_Index, token)) {

                            getToken(current_State, tokenTypes)
                                .also { type ->
                                    if (type != null)
                                        buffer.append(
                                            "${type.Name} Detected at { LINE = ${token.line}" +
                                                    " , INDEX = ${token.index} } " +
                                                    " ->  \" ${token.srt} \""
                                        )
                                            .append("\r\n")
                                }

                            current_State = 0
                        }
                    }
            }

        println(buffer)
        saveOutput()
    }

    private fun isEndOfToken(dfaTable: DFATable, currentIndex: Int, token: Token): Boolean {
        return isFinalState(dfaTable, current_State)
                && currentIndex == token.srt.length - 1 // Detect When Token End

    }

    private fun isFinalState(dfaTable: DFATable, state: Int): Boolean {
        return dfaTable.finalStates.any { it == state }
    }


    private fun generateNextState(dfaTable: DFATable, char: Char?): Int {
        dfaTable.regularStates[
                current_State to char.toString()
        ].let {
            return it ?: -1
        }
    }

    private fun getToken(state: Int, tokenTypes: HashSet<TokenType>): TokenType? {
        return tokenTypes.find { it.State == state }
    }

    private fun saveOutput() {
        File("Output/AnalysisResult.txt").writeText(buffer.toString())
    }
}