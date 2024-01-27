# Solution

# // Time Complexity : Insert: O(L), L - length of the word to be inserted
#                      search: O(L), L - length of the word to be inserted
#                      startsWith: O(L), L - lenght of the prefix
# // Space Complexity : O(n*k), where k is the average length of the words
# 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is create a class called TrieNode, which will have an array of size 26, each cell for one lower case character, since
# in this problem there will only be a lower case letter. 
# Insert: For each character of word, if a TreeNode is not already there (Eg: Car,Care) create new TreeNode and assign it to the 
# position char-"a" of the current TreeNode. since "a" is first lower case character, it gives the index of array. At end of for
# loop, make the isEnd = True, which tells the word is completed
# Search: Same as insert, only thing is we do not create new TreeNodes, if a TreeNode is missing for a character then return false,
# if TreeNode exists, continue, at the end if we find isEnd == True then entire word is available
# StartsWith: Same as search, only thing is we do not look for isEnd == True


class Trie:

    class TrieNode:
        def __init__(self):
            self.children = [None for _ in range(26)]
            self.isEnd = False

    def __init__(self):
        self.root = Trie.TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for c in word:
            if cur.children[ord(c)-ord('a')] == None:
               cur.children[ord(c)-ord('a')] = Trie.TrieNode()
            cur = cur.children[ord(c)-ord('a')]
        cur.isEnd = True


    def search(self, word: str) -> bool:
        cur = self.root
        for c in word:
            if cur.children[ord(c)-ord('a')] == None:
                return False
            
            cur = cur.children[ord(c)-ord('a')]
        
        if cur.isEnd == True:
            return True
        else:
            return False
        

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for c in prefix:
            if cur.children[ord(c)-ord('a')] == None:
                return False
            
            cur = cur.children[ord(c)-ord('a')]
        
        return True
        

if __name__ == "__main__":
# Your Trie object will be instantiated and called as such:
    input = [["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    prefix = "appl"
    obj = Trie()
    for word in input:
        obj.insert(word[0])
    for word in input:
        param_2 = obj.search(word[0])
    param_3 = obj.startsWith(prefix)
    print(param_3)