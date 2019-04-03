package Utils

import Models.TokenType
import java.io.File

object TokenGeneratorUtil {

    // Read Tokens From Input/tokens.txt
    fun generate(): MutableList<TokenType> {

        val token = mutableListOf<TokenType>()

        // Generate Tokens
        File("Input/tokens.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEach {
                // Check If Not Comment
                if (it.isNotEmpty() && !it.startsWith("#", false)) {
                    token.add(
                        TokenType(
                            "T_${it.split("->").first().trim().toUpperCase()}"
                            , it.split("->").last().trim().toInt()
                        )
                    )
                }
            }

        return token
    }


}