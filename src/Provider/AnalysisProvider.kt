package Provider

import Utils.NFAToDFAUtil
import java.io.File

object AnalysisProvider {

    private val TOKENS: MutableList<Pair<String, String>>
    private var DFATable: HashMap<Pair<Set<Int>, Char>, Set<Int>>

    init {
        TOKENS = ArrayList()
        DFATable = HashMap()
    }

    fun run() {

        // Generate Tokens
        File("Input/tokens.txt")
            .readLines()
            .forEach {
                TOKENS.add(it.toLowerCase() to "T_${it.toLowerCase()}")
            }

        DFATable = NFAToDFAUtil.generateDFATable(TOKENS)


    }

}

fun main() {

    AnalysisProvider.run()

}