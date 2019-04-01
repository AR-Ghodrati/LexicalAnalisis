package Utils

import Models.CustomTrieNode

object NFAUtil {

    private var root: CustomTrieNode
    private var NFATable: HashMap<Pair<Set<Int>, Char>, Int>

    init {
        root = CustomTrieNode()
        NFATable = HashMap()
    }

    fun generateNFA(tokens: MutableList<Pair<String, String>>) {

        root = CustomTrieUtil.generateTree(root, tokens)


        println(root.children.keys)




    }


}