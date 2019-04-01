package Utils

import Models.CustomTrie
import Models.CustomTrieNode

object NFAUtil {

    private var root: CustomTrieNode = CustomTrieNode()
    private lateinit var customTrie: CustomTrie

    fun generateNFA(tokens: MutableList<String>) {

        customTrie = CustomTrie(root)

        tokens.forEach { customTrie.insert(it) }

        println(root)




    }


}