package Provider

import Models.Token
import Statics.SpecUtil
import Utils.TokenGeneratorUtil


object AnalysisProvider {

    private lateinit var tokens: MutableList<Token>
    private var Specs: SpecUtil = SpecUtil()

    fun run() {

        // Generate Data
        tokens = TokenGeneratorUtil.generate()
        Specs.generateSpecs()


    }
}

fun main() {

    AnalysisProvider.run()

}