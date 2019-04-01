package Utils

import Models.CustomTrieNode

object NFAToDFAUtil {

    private const val START_VALUE = Int.MAX_VALUE
    private const val KleenClouser = 'E'
    private var root: CustomTrieNode
    private var DFATable: HashMap<Pair<Set<Int>, Char>, Set<Int>>

    init {
        root = CustomTrieNode()
        DFATable = HashMap()
    }

    fun generateDFATable(tokens: MutableList<Pair<String, String>>): HashMap<Pair<Set<Int>, Char>, Set<Int>> {

        root = CustomTrieUtil.generateTree(root, tokens)


        // Add Start States
        val startStates: HashSet<Int> = HashSet()
        root.children.values.forEach {
            startStates.add(it.label)
        }

        DFATable[setOf(START_VALUE) to KleenClouser] = startStates

        traceTree(root)

        return DFATable
    }

    private fun traceTree(state: CustomTrieNode) {

        if (!state.isAccepted) {

            state.children.forEach {

                val states: HashSet<Int> = HashSet()
                it.value.children.values.forEach { it1 ->
                    states.add(it1.label)
                }
                DFATable[setOf(it.value.label) to it.key] = states
                // Go To children
                traceTree(it.value)
            }
        }
    }

}