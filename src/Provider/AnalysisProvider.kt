package Provider

import Utils.NFAUtil

object AnalysisProvider {

    val TOKENS = mutableListOf(
        "program", "print"
    )

    fun run() {

        NFAUtil.generateNFA(TOKENS)


    }


}

fun main() {

    AnalysisProvider.run()

}