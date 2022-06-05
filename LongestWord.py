class Node():
    def __init__(self):
        self._trie = 26 * [None]
        self._isEnd = None

# TC - O(n*k) => n is the length of words and k is length of each word in words array - doubtful
# SC - O(n*k) => n is the length of words and k is length of each word in words array - doubtful


class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        root = Node()

        def constructTrie(word):
            curr = root
            for char in word:
                index = ord(char) - ord('a')
                if curr._trie[index] is None:
                    curr._trie[index] = Node()
                curr = curr._trie[index]
            curr._isEnd = word

        for word in words:
            constructTrie(word)

        queue = deque([root])
        curr = None

        while(queue):
            curr = queue.popleft()

            for i in range(25, -1, -1):
                if(curr._trie[i] is not None and curr._trie[i]._isEnd is not None):
                    queue.append(curr._trie[i])

        if curr._isEnd is not None:
            return curr._isEnd
        else:
            return ""
