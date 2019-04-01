package Provider

import Utils.NFAUtil
import java.io.File

object AnalysisProvider {

    val TOKENS: MutableList<Pair<String, String>>

    init {
        TOKENS = ArrayList()
    }

    fun run() {

        // Generate Tokens
        File("Input/tokens.txt")
            .readLines()
            .forEach {
                TOKENS.add(it.toLowerCase() to "T_${it.toLowerCase()}")
            }

        NFAUtil.generateNFA(TOKENS)


    }

}

fun main() {

    AnalysisProvider.run()

}