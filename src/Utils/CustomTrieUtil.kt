package Utils

import Models.CustomTrie
import Models.CustomTrieNode

object CustomTrieUtil {

    private lateinit var customTrie: CustomTrie

    fun generateTree(root: CustomTrieNode, tokens: MutableList<Pair<String, String>>): CustomTrieNode {

        customTrie = CustomTrie(root)
        tokens.forEach { customTrie.insert(it.first) }
        return root

    }

}