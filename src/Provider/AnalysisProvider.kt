package Provider

import Utils.DFATableParserUtil
import Utils.ParserUtil
import Utils.TokenParserUtil


object AnalysisProvider {

    fun run() {

        val tokens = TokenParserUtil.parse()
        val dfaTable = DFATableParserUtil.parse()

        ParserUtil.parse(dfaTable, tokens)
    }
}

fun main() {

    AnalysisProvider.run()

}