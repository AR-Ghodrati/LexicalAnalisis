package Utils

import Models.DFATable
import Models.Token
import java.io.File

object AnalysisUtil {


    private var current_State: Int = 0 // Start State

    fun analysis(dfaTable: DFATable, tokens: HashSet<Token>, ignoreCase: Boolean) {

        println("Analysing inputCode...\r\n")

        // Read Code Form INPUT_CODE.txt
        File("Input/INPUT_CODE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEachIndexed { indexLine, line ->
                // Iterate All Chars
                line
                    .also { if (ignoreCase) it.toLowerCase() }
                    .forEachIndexed { indexChar, char ->


                        println("$current_State $char")
                        current_State = dfaTable.regularStates[current_State to char.toString()]!!

                        if (current_State == -1) {
                            println("Error Happened at { LINE = ${indexLine + 1} , INDEX = ${indexChar + 1} }")
                            current_State = 0
                        } else {

                            if (!isEndOfToken(dfaTable, line.getOrNull(indexChar + 1))) {

                            } else {

                                val token = getToken(current_State, tokens)

                                println(
                                    "${token?.Name} Detected at { LINE = ${indexLine + 1} , INDEX = ${indexChar + 1} }"
                                )
                            }
                        }
                    }
            }

    }

    private fun isEndOfToken(dfaTable: DFATable, nextChar: Char?): Boolean {
        return dfaTable.regularStates[current_State to nextChar.toString()] == 0
    }

    private fun getToken(state: Int, tokens: HashSet<Token>): Token? {
        return tokens.find { it.State == state }
    }
}