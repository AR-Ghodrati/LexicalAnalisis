package Provider

import Utils.AnalysisUtil
import Utils.DFATableParserUtil
import Utils.TokenParserUtil


object AnalysisProvider {

    fun run() {

        val tokens = TokenParserUtil.parse()
        val dfaTable = DFATableParserUtil.parse()

        AnalysisUtil.analysis(dfaTable, tokens)
    }
}

fun main() {

    AnalysisProvider.run()

}