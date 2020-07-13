#LC 648 - Replace Words
#Time Complexity - O(n.k) k being the average length of the word
#Space Complexity - O(n)
class TrieNode(object):
    
    def __init__(self):
        self.children = dict()
        self.endOfWord = False
        
class Solution(object):
    def replaceWords(self, dic, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        self.root = TrieNode()
        
        def insert(word):
            """
            Inserts a word into the trie.
            :type word: str
            :rtype: None
            """
            currNode = self.root
            for i in range(len(word)):
                char = word[i]
                if char not in currNode.children:
                    currNode.children[char] = TrieNode()
                currNode = currNode.children[char]
            currNode.endOfWord = True
            
        for i in dic:
            insert(i)
        
        ans = []
        sent = sentence.split(' ')
        for word in sent:
            currNode = self.root
            temp = ""
            for i in range(len(word)):
                if word[i] in currNode.children:
                    temp = temp + word[i]
                    currNode = currNode.children[word[i]]
                    if currNode.endOfWord:
                        break
                else:
                    ans.append(word)
                    break
            if currNode.endOfWord:
                ans.append(temp)  
        return(" ".join(ans))