package Utils

import java.io.File

object ParserUtil {


    fun parse() {

        // Read Code Form INPUT_CODE.txt
        val linesOfCodes: MutableList<String> = ArrayList()
        File("Input/INPUT_CODE.txt")
            .takeIf { it.exists() }
            ?.readLines()
            ?.forEach {
                linesOfCodes.add(it)
            }


    }


}