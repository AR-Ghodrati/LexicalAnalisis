package Utils

import Models.DFATable
import java.io.File

object DFATableGeneratorUtil {


    // Read Tokens From Input/TOKENS.txt
    fun generate(): DFATable {

        // Generate Tokens
        val table = DFATable()
        var lineCount = 0




        File("Input/DFA_TABLE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEach { line ->
                // Check If Not Comment
                if (line.isNotEmpty() && !line.startsWith("#", false)) {

                    line
                        .substring(line.indexOf("("))
                        .split("|")
                        .forEach {

                            table.values[
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
        return table
    }

}