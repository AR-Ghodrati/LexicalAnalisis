package Utils

import Models.DFATable
import java.io.File

object DFATableGeneratorUtil {


    // Read Tokens From Input/TOKENS.txt
    fun generate(): DFATable {

        // Generate Tokens
        val table = DFATable()

        File("Input/DFA_TABLE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEach {
                // Check If Not Comment
                val states: MutableList<Int> = ArrayList()

                if (it.isNotEmpty() && !it.startsWith("#", false)) {

                    it.split(',').forEach { state ->
                        states.add(state.toInt())
                    }
                    table.values.add(states)
                }
            }

        return table
    }

}