package Utils

import Models.TokenType
import java.io.File

object TokenTypeParserUtil {

    // Read Tokens From Input/TOKENS.txt
    fun parse(): HashSet<TokenType> {

        val token = hashSetOf<TokenType>()
        println("Parsing TokensList...")

        // Generate Tokens
        File("Input/TOKENS.txt")
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