package Provider

import Models.TokenType
import Utils.TokenGeneratorUtil


object AnalysisProvider {

    private lateinit var Tokens: MutableList<TokenType>


    fun run() {
        Tokens = TokenGeneratorUtil.generate()
        println(Tokens)
    }
}

fun main() {

    AnalysisProvider.run()

}