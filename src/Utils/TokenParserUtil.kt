package Utils

import Models.Token
import java.io.File

object TokenParserUtil {

    // Read Tokens From Input/TOKENS.txt
    fun parse(): HashSet<Token> {

        val token = hashSetOf<Token>()

        // Generate Tokens
        File("Input/TOKENS.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEach {
                // Check If Not Comment
                if (it.isNotEmpty() && !it.startsWith("#", false)) {
                    token.add(
                        Token(
                            "T_${it.split("->").first().trim().toUpperCase()}"
                            , it.split("->").last().trim().toInt()
                        )
                    )
                }
            }

        return token
    }


}