package Utils

import Models.DFATable
import java.io.File

object DFATableParserUtil {


    // Read Tokens From Input/TOKENS.txt
    fun parse(): DFATable {

        // Generate Tokens
        val table = DFATable()
        var lineCount = 0

        println("Paring DFA Table...")



        File("Input/DFA_TABLE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEach { line ->
                // Check If Not Comment
                if (line.isNotEmpty() && !line.startsWith("#", false)) {
                    // Read Final States
                    if (line.startsWith("%")) {

                        line
                            .removePrefix("%")
                            .removeSuffix("%")
                            .trim()
                            .split(',')
                            .forEach {
                                table.finalStates.add(it.trim().toInt())
                            }

                    } else {

                        line
                            .substring(line.indexOf("("))
                            .split("|")
                            .forEach {

                                table.regularStates[
                                        lineCount to it.split(',')[0]
                                            .removePrefix("(")
                                ] = it
                                    .split(',')[1]
                                    .removeSuffix(")")
                                    .toInt()
                            }

                        lineCount++
                    }
                }
            }


        return table
    }

}