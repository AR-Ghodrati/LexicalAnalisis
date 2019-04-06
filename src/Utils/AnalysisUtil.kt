package Utils

import Models.DFATable
import Models.Token
import java.io.File

object AnalysisUtil {


    private var current_State: Int = 0 // Start State
    private var start_index: Int = 0
    private var buffer: StringBuffer = StringBuffer()

    fun analysis(dfaTable: DFATable, tokens: HashSet<Token>) {

        println("Analysing inputCode...\r\n")

        // Read Code Form INPUT_CODE.txt
        File("Input/INPUT_CODE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEachIndexed { indexLine, line ->

                if (line.isNotEmpty()) {
                    // Iterate All Chars
                    line
                        .toLowerCase()
                        .forEachIndexed { indexChar, char ->

                            try {
                                //Save Start Token Index
                                if (current_State == 0)
                                    start_index = indexChar

                                current_State = generateNextState(dfaTable, char)

                                //println("current_State : $current_State  Char : $char")

                                if (isEndOfToken(dfaTable, line.getOrNull(indexChar + 1))) {
                                    getToken(current_State, tokens)
                                        .also {
                                            if (it != null)
                                                buffer.append(
                                                    "${it.Name} Detected at { LINE = ${indexLine + 1}" +
                                                            " , INDEX = ${start_index + 1} } " +
                                                            " ->  \" ${line.substring(start_index, indexChar + 1)} \""
                                                )
                                                    .append("\r\n")
                                        }
                                }

                            } catch (e: Exception) {
                                buffer.append(
                                    "Error Happened at { LINE = ${indexLine + 1} , INDEX = ${indexChar + 1} } " +
                                            " ->  \" ${line.substring(start_index, indexChar + 1)} \""
                                )
                                    .append("\r\n")
                                // Reset current_State
                                current_State = 0
                            }
                        }
                }
                current_State = 0 // Reset For newline
            }

        println(buffer)
        saveOutput()
    }

    private fun isEndOfToken(dfaTable: DFATable, nextChar: Char?): Boolean {
        if (nextChar == null) return true
        return (nextChar.isWhitespace())
                && isFinalState(dfaTable)
    }

    private fun isFinalState(dfaTable: DFATable): Boolean {
        return dfaTable.finalStates.any { it == current_State }
    }

    private fun isLastOperand(currentChar: Char, dfaTable: DFATable, nextChar: Char?, ignoreCase: Boolean): Boolean {
        return currentChar == '=' && generateNextState(dfaTable, nextChar) == 0
    }

    private fun generateNextState(dfaTable: DFATable, char: Char?): Int {
        return dfaTable.regularStates[
                current_State to char.toString()
        ]!!
    }

    private fun getToken(state: Int, tokens: HashSet<Token>): Token? {
        return tokens.find { it.State == state }
    }

    private fun saveOutput() {
        File("Output/AnalysisResult.txt").writeText(buffer.toString())
    }
}