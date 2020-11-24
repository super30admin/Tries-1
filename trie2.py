# As taught in class, using trie to solve the problem
# Time Complexity: O(n)
# Space Complexity: O(n)
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}
    
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, root,word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.isEnd = True


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = Trie.root
        for w in dictionary:
            TrieNode.insert(root,w)
        result = ""
        splitArr = sentence.split("//S+")
        
        for s in sentence:
            replacement = []
            curr = Trie.root
            for i in range(len(s)):
                c = s[i]
                if (curr.children[c-'a']==None or curr.isEnd):
                    break
                replacement.append(c)
                curr = curr.children[c-'a']
            if curr.isEnd:
                result.append("".join(replacement))
            else:
                result.append(s)
        return "".join(result)
                
        
        
        
            