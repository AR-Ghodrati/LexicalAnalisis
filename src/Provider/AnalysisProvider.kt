package Provider

import Models.DFATable
import Models.Token
import Utils.DFATableParserUtil
import Utils.TokenParserUtil


object AnalysisProvider {

    private lateinit var tokens: HashSet<Token>
    private lateinit var dfaTable: DFATable


    fun run() {

        tokens = TokenParserUtil.parse()
        dfaTable = DFATableParserUtil.parse()


        println(tokens.size)


    }
}

fun main() {

    AnalysisProvider.run()

}