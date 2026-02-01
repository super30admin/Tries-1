// Implemented Trie (Prefix Tree) data structure in Kotlin. We have insert, search, and startsWith methods. For insert method, we traverse each character of the word, creating a new TrieNode if it doesn't exist. 
// For search method, we traverse the Trie as per the characters in the word and check if we reach an end node. For startsWith method, we just need to ensure that the prefix exists in the Trie.
// Time Complexity: O(L) for each operation, where L is the length of the word or prefix.
// Space Complexity: O(N * L) where N is number of words and L is average word length

class Trie {

    class TrieNode() {
        val children = arrayOfNulls<TrieNode>(26)
        var isEnd = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var curr = root
        for(c in word) {
            val idx = c - 'a'
            if(curr.children[idx] == null) {
                curr.children[idx] = TrieNode()
            }
            curr = curr.children[idx]!!
        }
        curr.isEnd = true
    }

    fun search(word: String): Boolean {
        var curr = root
        for (c in word) {
            val idx = c - 'a'
            curr = curr.children[idx] ?: return false
        }
        return curr.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root
        for (c in prefix) {
            val idx = c - 'a'
            curr = curr.children[idx] ?: return false
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */