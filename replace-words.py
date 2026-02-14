''' Time Complexity : O(M * L + N * L) where M is the number of words in dictionary, 
                                       N is number of words in sentence and L is the average word length
    Space Complexity : O(M * L + N * L) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = TrieNode()
        for word in dictionary:
            curr = root
            for w in word:
                idx = ord(w) - ord('a')
                if curr.children[idx] is None:
                    curr.children[idx] = TrieNode()
                curr = curr.children[idx]
            curr.isEnd = True

        result = []        
        sen = list(sentence.split())
        for word in sen:
            curr = root
            baby_str = ""
            for w in word:
                idx = ord(w) - ord('a')
                if curr.children[idx] is  None or curr.isEnd:
                    break
                curr = curr.children[idx]
                baby_str += w
            if curr.isEnd:
                result.append(baby_str)                
            else:
                result.append(word)
        return " ".join(result)