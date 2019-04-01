package Models


class CustomTrie(private var root: CustomTrieNode) {

    private var StateCounter = 0

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    fun insert(key: String) {
        var pCrawl = root

        key.forEach {

            pCrawl.label = ++StateCounter
            if (pCrawl.children[it] == null)
                pCrawl.children[it] = CustomTrieNode()


            pCrawl = pCrawl.children[it]!!
        }

        // mark last node as leaf
        pCrawl.label = ++StateCounter
        pCrawl.isAccepted = true
    }

    // Returns true if key presents in trie, else false
    fun search(key: String): Boolean {

        var pCrawl = root

        key.forEach {

            if (pCrawl.children[it] == null)
                return false

            pCrawl = pCrawl.children[it]!!
        }

        return pCrawl.isAccepted
    }


}