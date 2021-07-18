class Solution(object):
    class TrieNode(object):
        children = []
        isEnd = False
        def __init__(self):
            self.children = [None for i in xrange(26)]
    def insertTrie(self,word):
        node = self.root
        for ch in word:
            if node.isEnd is True:
                break
            if node.children[ord(ch) - ord('a')] is None:
                node.children[ord(ch)-ord('a')] = self.TrieNode()
            node = node.children[ord(ch)-ord('a')]
        node.isEnd = True
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        #Time complexity: O(nk + l)
        # Space complexity: o(nk +l)
        self.root = self.TrieNode()
        for word in dictionary:
            self.insertTrie(word)
        
        sentWords = sentence.split(' ')
        for idx,word in enumerate(sentWords):
            # checking if first char is there in trie
            if self.root.children[ord(word[0])-ord('a')] is not None:
                # if yes , go through trie and check where first isEnd is
                node = self.root
                repStr = []
                flag = False
                for ch in word:
                    if node.isEnd is True:
                        flag = True
                        break
                    else:
                        if node.children[ord(ch) - ord('a')] is None:
                            break
                        else:
                            repStr.append(ch)
                            node = node.children[ord(ch) - ord('a')]
                if flag is True:
                    sentWords[idx] = ''.join(repStr)
        return ' '.join(sentWords)
