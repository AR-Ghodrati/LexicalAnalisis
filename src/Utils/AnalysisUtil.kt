package Utils

import Models.DFATable
import Models.Token
import Models.TokenType
import java.io.File

object AnalysisUtil {


    private var current_State: Int = 0 // Start State
    private var buffer: StringBuffer = StringBuffer()

    fun analysis(dfaTable: DFATable, tokens: MutableList<Token>, tokenTypes: HashSet<TokenType>) {

        println("Analysing inputCode...\r\n")

        tokens.forEach {
            println(it)
        }


        /*// Read Code Form INPUT_CODE.txt
        File("Input/INPUT_CODE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEachIndexed { indexLine, line ->

                if (line.isNotEmpty()) {
                    // Iterate All Chars
                    val _line = line.toLowerCase()
                    var i = 0

                    while (i != _line.length){

                        try {

                            val currentChar = _line[i]

                            //Save Start TokenType Index
                            if (current_State == 0)
                                start_index = i

                            current_State = generateNextState(dfaTable, currentChar)


                            if(isOp(line.getOrNull(i+1))){

                                getToken(current_State, tokenTypeSet)
                                    .also {
                                        if (it != null)
                                            buffer.append(
                                                "${it.Name} Detected at { LINE = ${indexLine + 1}" +
                                                        " , INDEX = ${start_index + 1} } " +
                                                        " ->  \" ${line.substring(start_index, i + 1)} \""
                                            )
                                                .append("\r\n")
                                    }

                                current_State = 0
                            }
                            else if (isEndOfToken(dfaTable,line.getOrNull(i+1))) {

                                getToken(current_State, tokenTypeSet)
                                    .also {
                                        if (it != null)
                                            buffer.append(
                                                "${it.Name} Detected at { LINE = ${indexLine + 1}" +
                                                        " , INDEX = ${start_index + 1} } " +
                                                        " ->  \" ${line.substring(start_index, i + 1)} \""
                                            )
                                                .append("\r\n")
                                    }
                            }

                        } catch (e: Exception) {
                            buffer.append(
                                "Error Happened at { LINE = ${indexLine + 1} , INDEX = ${i + 1} } " +
                                        " ->  \" ${line.substring(start_index, i + 1)} \""
                            )
                                .append("\r\n")
                            // Reset current_State
                            current_State = 0
                        }

                        i++
                    }

                }
                current_State = 0 // Reset For newline
            }

            */

        println(buffer)
        saveOutput()
    }

    private fun isEndOfToken(dfaTable: DFATable, nextChar: Char?): Boolean {

        if (nextChar == null) return false

        return nextChar.isWhitespace() && (isFinalState(dfaTable, current_State))

    }

    private fun isOp(nextChar: Char?): Boolean {
        if (nextChar == null) return false
        return !nextChar.isLetterOrDigit() && !nextChar.isWhitespace()
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