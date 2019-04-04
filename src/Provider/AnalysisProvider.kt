package Provider

import Utils.AnalysisUtil
import Utils.DFATableParserUtil
import Utils.TokenParserUtil


object AnalysisProvider {

    fun run(ignoreCase: Boolean) {

        val tokens = TokenParserUtil.parse()
        val dfaTable = DFATableParserUtil.parse()

        AnalysisUtil.analysis(dfaTable, tokens, ignoreCase)
    }
}

fun main() {

    AnalysisProvider.run(true)

}