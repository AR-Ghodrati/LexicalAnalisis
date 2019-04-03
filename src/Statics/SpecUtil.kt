package Statics

import Models.DFATable
import Utils.DFATableGeneratorUtil

class SpecUtil {

    private var LANG_SPEC: HashSet<Pair<Char, Int>> = HashSet()
    private lateinit var DFATable: DFATable

    fun generateSpecs() {
        generate_LANG_SPEC()
        DFATable = DFATableGeneratorUtil.generate()
        println(DFATable)
    }

    private fun generate_LANG_SPEC() {

        // Add All alphabet
        for (char in 'a'..'z')
            LANG_SPEC.add(char to LANG_SPEC.size + 1)

        // Add All Numbers
        for (char in '0'..'9')
            LANG_SPEC.add(char to LANG_SPEC.size + 1)

        // Add Special Chars
        LANG_SPEC.add('<' to LANG_SPEC.size + 1)
        LANG_SPEC.add('>' to LANG_SPEC.size + 1)
        LANG_SPEC.add('=' to LANG_SPEC.size + 1)
        LANG_SPEC.add('!' to LANG_SPEC.size + 1)
        LANG_SPEC.add('.' to LANG_SPEC.size + 1)
        LANG_SPEC.add(' ' to LANG_SPEC.size + 1)

    }

    fun getLANG_SPEC(index: Int): Char? {

        return LANG_SPEC.find { it.second == index }?.first

    }
}