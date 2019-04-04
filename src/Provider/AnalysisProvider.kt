package Provider

import Models.Token
import Utils.DFATableGeneratorUtil
import Utils.TokenGeneratorUtil


object AnalysisProvider {

    private var tokens: MutableList<Token> = TokenGeneratorUtil.generate()
    private var specs: SpecUtil = SpecUtil()

    init {
        specs.generateSpecs()
    }

    fun run() {


        // ParserUtil.parse()
        val table = DFATableGeneratorUtil.generate()
        println(table)






    }
}

fun main() {

    AnalysisProvider.run()

}