'''
Solution - Trie + DFS
- Insert words in the Trie
- Do DFS starting from root node of Trie. Recurse on it's children, if children exist
  and children is completion of a word from the dictionary. 
- Maintain word path
- if length of word path is greater than previously found word, then update. 
- The flow of recursion will ensure we get smallest lexicographical order.
Time Complexity: 
    - Adding words to Trie: O(N*L), N = number of words, L = Average length of word
    - Recursion - O(N*L) Total unique characters
Space Complexity:
    - O(L) - Recursive stack Largest word. 
    - O(N*L) - Trie storage
'''
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def addWord(self,word):
        node = self.root
        for ch in word:
            if node.children is None:
                node.children = [None]*26
            if node.children[ord(ch)-ord('a')]==None:
                node.children[ord(ch)-ord('a')] = TrieNode()
            node = node.children[ord(ch)-ord('a')]
        node.isWord = True
    

class Solution:
    def longestWord(self, words: List[str]) -> str:
        word_dictionary = Trie()

        for word in words:
            word_dictionary.addWord(word)

        self.longest_word = []
        self.helper([],word_dictionary.root) # word_path, node, longest_word
        
        return "".join(self.longest_word)
    
    def helper(self,word_path,node):
        # base
        if len(word_path)>len(self.longest_word):
            self.longest_word = deepcopy(word_path)

        # logic
        for i in range(len(node.children)):
            if node.children[i]!=None and node.children[i].isWord:
                word_path.append(chr(ord('a')+ i)) # action
                self.helper(word_path,node.children[i]) # recurse
                word_path.pop() # backtrack
            

'''
Solution - Trie + BFS
- Insert words in the Trie
- Do BFS starting from root node of Trie. Recurse on it's children in reverse, 
  if children exist and children is completion of a word from the dictionary. 
- Maintain word path in different queue
- if length of word path is greater than previously found word, then update. 
- The flow of queue will ensure we get smallest lexicographical order at the end
Time Complexity: 
    - Adding words to Trie: O(N*L), N = number of words, L = Average length of word
    - BFS - O(N*L) Total unique characters
Space Complexity:
    - O(N*26) - BFS queue, total unique paths = unique words, each character in word
                can have 26 characters. 
    - O(N*L) - Trie storage
'''
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def addWord(self,word):
        node = self.root
        for ch in word:
            if node.children is None:
                node.children = [None]*26
            if node.children[ord(ch)-ord('a')]==None:
                node.children[ord(ch)-ord('a')] = TrieNode()
            node = node.children[ord(ch)-ord('a')]
        node.isWord = True
    

class Solution:
    def longestWord(self, words: List[str]) -> str:
        word_dictionary = Trie()

        for word in words:
            word_dictionary.addWord(word)

        bfs_node = deque() # for storing TrieNodes
        bfs_string = deque() # for storing Strings of this path

        bfs_node.append(word_dictionary.root)
        bfs_string.append("")

        longest_word = ""
        while bfs_node:
            size = len(bfs_node)
            for k in range(size):
                parent_node = bfs_node.popleft()
                parent_string = bfs_string.popleft()
                if len(parent_string)>=len(longest_word):
                    longest_word = parent_string
                
                for i in range(len(parent_node.children)-1,-1,-1):
                    if parent_node.children[i]!=None and parent_node.children[i].isWord:
                        bfs_node.append(parent_node.children[i])
                        bfs_string.append(parent_string+chr(i+ord('a')))
        
        return longest_word