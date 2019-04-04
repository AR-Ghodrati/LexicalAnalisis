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

                    current_State = dfaTable.regularStates[current_State to char.toString()]!!

                    if (!isEndOfToken(dfaTable)) {

                    } else {

                        println(
                            "${getToken(
                                current_State,
                                tokens
                            )?.Name} Detected at { LINE = ${indexLine + 1} , INDEX = ${indexChar + 1} }"
                        )

                    }
                }
            }
    }

    private fun isEndOfToken(dfaTable: DFATable): Boolean {
        return dfaTable.finalStates.any { it == current_State }
    }

    private fun getToken(state: Int, tokens: HashSet<Token>): Token? {
        return tokens.find { it.State == state }
    }
}