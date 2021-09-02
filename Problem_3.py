# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None for i in range(26)]
            self.isEnd = False

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for i in range(len(word)):
            c = word[i]
            if cur.children[ord(c) - 97] == None:
                cur.children[ord(c) - 97] = self.TrieNode()
            cur = cur.children[ord(c) - 97]
        cur.isEnd = True

    """
    add the words to trie then compare with the sentences
    TC - O(nk) + O(n)
    SC - O(nk) + O(n)
    """

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if not sentence:
            return sentence
        root = self.TrieNode
        for word in dictionary:
            self.insert(word)
        sarr = sentence.split(" ")
        sb = []
        for i in range(len(sarr)):
            word = sarr[i]
            rp = []
            curr = self.root
            for j in range(len(word)):
                c = word[j]
                if curr.children[ord(c) - 97] == None or curr.isEnd:
                    break
                rp.append(c)
                curr = curr.children[ord(c) - 97]
            if curr.isEnd:
                sb.append("".join(rp))
            else:
                sb.append(word)
        return " ".join(sb)
