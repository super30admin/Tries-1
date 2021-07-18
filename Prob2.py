class Solution(object):
    class TrieNode(object):
        children = []
        word = None
        def __init__(self):
            self.children = [None for i in xrange(26)]
    def insertTrie(self,word):
        node = self.root
        for ch in word:
            if node.children[ord(ch)-ord('a')] is None:
                node.children[ord(ch)-ord('a')] = self.TrieNode()
            node = node.children[ord(ch)-ord('a')]
        node.word = word
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        self.root = self.TrieNode()
        for word in words:
            #time is O(nl)
            self.insertTrie(word)
        # BFS, iterate through every level of arrays and add it to queue, the last element in the queue would be the longest word as it would be popped out the last
        # we are going from right to left for lexicographically maintaining order
        queue = deque()
        queue.append(self.root)
        node = self.root
        while len(queue)>0:
            # Time complexity: O(nl)
            node = queue.popleft()
            for i in xrange(25,-1,-1):
                if node.children[i] is not None and node.children[i].word is not None:
                    queue.append(node.children[i])
        if node.word is None:
            return ''
        return node.word
                
        
        
