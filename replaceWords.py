
class TrieNode:
    def __init__(self):
        self.children={}
        self.is_end=False
    
class Solution:
    def replaceWords(self,dictionary,sentence):
        root_node=TrieNode()
        for root in dictionary:
            node=root_node
            for char in root:
                if char not in node.children:
                    node.children[char]=TrieNode()
                node=node.children[char]
            node.is_end=True
            
        def find_root(word):
            node=root_node
            prefix=""
            for char in word:
                if char not in node.children:
                    return word
                node=node.children[char]
                prefix+=char
                if node.is_end:
                    return prefix
            return word
            
        words=sentence.split()
        replaced=[find_root(word)for word in words]
        return " ".join(replaced)

dictionary=["cat","bat","rat"]
sentence="the cattle was rattled by the battery"
solution=Solution()
print(solution.replaceWords(dictionary,sentence))
