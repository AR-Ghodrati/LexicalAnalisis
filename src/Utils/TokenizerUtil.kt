package Utils

import Models.Token
import java.io.File
import java.util.*

object TokenizerUtil {

    private var delim = " \t\n\r"
    private val tokensBuff: MutableList<Token> = ArrayList()
    private val tokens: MutableList<Token> = ArrayList()
    private var opBuff = ""
    private var lastIndex = 1

    fun getAllTokens(): MutableList<Token> {

        File("Input/INPUT_CODE.txt")
            .also {
                if (!it.exists()) error("File Not Exist In Path ${it.path}")
                else {

                    it
                        .readLines()
                        .forEachIndexed { lineIndex, line ->

                            line
                                .filter { c -> isOp(c) } // Get All Ops
                                .toHashSet() // Remove Duplicate Ops
                                .forEach { c -> delim += c } // Add Ops To Delimiters


                            val tokenizer = StringTokenizer(line, delim, true)

                            var isFirst = true
                            while (tokenizer.hasMoreTokens()) {
                                val token = tokenizer.nextToken()

                                if (isFirst) {
                                    tokensBuff.add(Token(token, lineIndex + 1, 1))
                                    isFirst = false
                                } else {
                                    lastIndex += tokensBuff.last().srt.length
                                    tokensBuff.add(Token(token, lineIndex + 1, lastIndex))
                                }

                            }

                            // Reset Delimiters
                            delim = " \t\n\r"
                            // Reset lastIndex
                            lastIndex = 1
                        }
                }

                tokensBuff.removeAll { token -> token.srt.isBlank() }
                tokensBuff.forEachIndexed { index_Token, token ->
                    when {
                        isOp(token.srt) -> opBuff += token.srt

                        opBuff.isNotEmpty() -> {

                            tokens.add(
                                Token(
                                    opBuff
                                    , token.line
                                    , tokensBuff[index_Token - 1].index
                                )
                            )

                            // Reset opBuff
                            opBuff = ""

                            // Add Token After opBuff
                            tokens.add(token)
                        }

                        else -> tokens.add(token)
                    }
                }

            }

        return tokens
    }

    private fun isOp(it: Char): Boolean {
        return !it.isLetterOrDigit() && !it.isWhitespace()
    }

    private fun isOp(it: String): Boolean {
        return it.length == 1 && isOp(it[0])
    }
}