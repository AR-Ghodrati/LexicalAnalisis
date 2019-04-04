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

                    if (!dfaTable.finalStates.contains(current_State)) {
                        println(current_State)
                    } else
                        println("Token Detected!!")
                }
            }
    }
}