// Replaces words in a sentence with their shortest root forms from a given dictionary using a Trie data structure. We first build the Trie from the dictionary,
// then for each word in the sentence, we find the shortest root in the Trie and replace it if found.
// Time Complexity: O(M * L + N * L) where M is the total number of characters in the dictionary, N is the number of words in the sentence, and L is the average length of the words.
// Space Complexity: O(M * L + N * L) for tries and split array. 
class Solution {

    class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var isEnd = false
    }

    var root = TrieNode()


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

    fun replaceWords(dictionary: List<String>, sentence: String): String {
        this.root = TrieNode()
        for(word in dictionary) {
            insert(word)
        }

        val splitArr = sentence.split(" ")
        var result = StringBuilder()

        for(i in splitArr.indices) {
            val word = splitArr[i]
            if(i > 0) result.append(" ")
            result.append(getShortestVersion(word))
        }

        return result.toString()

    }

    fun getShortestVersion(word: String) : String {
        var curr = root
        val sb = StringBuilder()

        for (c in word) {
            val idx = c - 'a'
            if(curr.children[idx] == null || curr.isEnd == true) {
                break
            }

            curr = curr.children[idx]!!
            sb.append(c)
        }

        return if(curr.isEnd) sb.toString() else word
    }
}