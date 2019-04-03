package Provider

import java.io.File

object AnalysisProvider {

    private val TOKENS: MutableList<Pair<String, String>>


    init {
        TOKENS = ArrayList()
    }

    fun run(strCode: String) {

        // Generate Tokens
        File("Input/tokens.txt")
            .readLines()
            .forEach {
                TOKENS.add(it.toLowerCase() to "T_${it.toLowerCase()}")
            }


    }
}

fun main() {

    AnalysisProvider.run("=")

}