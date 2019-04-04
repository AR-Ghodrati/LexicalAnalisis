package Utils

import Models.DFATable
import Models.Token
import java.io.File

object ParserUtil {


    private var current_State: Int = 0 // Start State

    fun parse(dfaTable: DFATable, tokens: HashSet<Token>) {

        // Read Code Form INPUT_CODE.txt
        File("Input/INPUT_CODE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEach { line ->
                // Iterate All Chars
                line.forEach { char ->

                    current_State = dfaTable.regularStates[current_State to char.toString()]!!

                    if (!isEndOfToken(dfaTable)) {

                    } else {

                        println("${getToken(current_State, tokens)?.Name} Detected!!")

                        //reset current_State
                        //current_State = 0
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