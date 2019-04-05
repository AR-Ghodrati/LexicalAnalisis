package Utils

import Models.DFATable
import java.io.File

object DFATableParserUtil {


    // Read Tokens From Input/TOKENS.txt
    fun parse(): DFATable {

        // Generate Tokens
        val table = DFATable()

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

                        val state = line
                            .substring(3, line.indexOf('~', 3))
                            .toInt()

                        line
                            .substring(line.indexOf('('))
                            .split('|')
                            .forEach {

                                table.regularStates[
                                        state to it.split(',')[0]
                                            .removePrefix("(")
                                ] = it
                                    .split(',')[1]
                                    .removeSuffix(")")
                                    .toInt()
                            }
                    }
                }
            }


        return table
    }

}