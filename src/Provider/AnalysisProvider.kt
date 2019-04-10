package Provider

import Utils.AnalysisUtil
import Utils.DFATableParserUtil
import Utils.TokenTypeParserUtil
import Utils.TokenizerUtil


object AnalysisProvider {

    fun run() {

        val tokenTypes = TokenTypeParserUtil.parse()
        val dfaTable = DFATableParserUtil.parse()
        val tokens = TokenizerUtil.getAllTokens()

        AnalysisUtil.analysis(dfaTable, tokens, tokenTypes)
    }
}

fun main() {

    AnalysisProvider.run()


}