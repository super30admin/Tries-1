#All TC passed on leetcode


class TrieNode:

    def __init__(self):
        self.isEnd = False
        self.children = [None]*26
        self.word = ""


class Solution:
    def longestWord(self, words: List[str]) -> str:
        #Using BFS approach
        #Time complexity - O(2(n*l)) where n-no. of words, l- avg length of word. For inserting words into Trie and then 
        #traversing all words in BFS
        #Space complexity - O(n*l) queue size can go up till length of words
        
        root = TrieNode()

        #inserting words into Trie
        for w in words:
            cur = root
            for ch in w:
                if not cur.children[ord(ch)-ord('a')]:
                    cur.children[ord(ch)-ord('a')] = TrieNode()
                cur = cur.children[ord(ch)-ord('a')]
            cur.isEnd = True
            cur.word = w

        q = collections.deque()
        q.append(root)
        cur = root

        while q:
            cur = q.popleft()
            #iterating in reverse direction so that we get lexographically smallest word.
            for i in range(25,-1,-1):
                if cur.children[i] and cur.children[i].isEnd:
                    q.append(cur.children[i])
        
        #each TrieNode has word associated with it. Last cur pointer holds the longest word
        return cur.word
                    



#-----------------------------------------OR------------------------------------------



class TrieNode:

    def __init__(self):
        self.isEnd = False
        self.children = [None]*26


class Solution:
    def longestWord(self, words: List[str]) -> str:
        #Using DFS approach
        #Time complexity - O(2(n*l)) where n-no. of words, l- avg length of word. For inserting words into Trie and then traversing all words in DFS
        #Space complexity - O(n*l)+O(l) where n-no. of words, l- avg length of word. Here (n*l) for holding words in 
        #TrieNode and l for stack space, size of stack tree can be max length of word

        root = TrieNode()

        #inserting words into Trie
        for w in words:
            cur = root
            for ch in w:
                if not cur.children[ord(ch)-ord('a')]:
                    cur.children[ord(ch)-ord('a')] = TrieNode()
                cur = cur.children[ord(ch)-ord('a')]
            cur.isEnd = True
        
        #performing DFS on Trie
        def dfs(root, curW):
            
            #if curW string has greater length then we update res
            if len(self.res)<len(curW):
                self.res = curW
            
            for i in range(26):
                cur = root.children[i]
                #if child is not None and child is a word i.e. isEnd=True then we append it and call dfs on its children
                if cur and cur.isEnd: 
                    ch = chr(ord('a')+i)
                    curW = curW + ch    #action
                    dfs(cur, curW)      #recurse
                    curW = curW[:-1]    #backtrack

        self.res = ""
        dfs(root, "")
        return self.res

            

