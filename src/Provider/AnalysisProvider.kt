package Provider

import Utils.NFAUtil

class AnalysisProvider {

    val TOKENS = mutableListOf(
        "if", "int", "else"
    )

    fun run() {

        NFAUtil.generateNFA(TOKENS)


    }


}