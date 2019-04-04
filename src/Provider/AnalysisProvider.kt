package Provider

import Models.Token
import Utils.DFATableParserUtil
import Utils.TokenGeneratorUtil


object AnalysisProvider {

    private var tokens: MutableList<Token> = TokenGeneratorUtil.generate()


    fun run() {

        val table = DFATableParserUtil.parse()
        println(table.finalStates)


    }
}

fun main() {

    AnalysisProvider.run()

}