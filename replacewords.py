# -*- coding: utf-8 -*-
"""
TC:
SC:
"""

class Solution(object):
    def replaceWords(self, dic, sentence):
        """
        :type dic: List[str]
        :type sentence: str
        :rtype: str
        """
        trie = {}
        
        for word in dic:
            t = trie
            for ch in word:
                if ch not in t:
                    t[ch] = {}
                t = t[ch]
            t['#'] = '#'
        
        def process(string):
            t = trie
            for i,ch in enumerate(string):
                if ch not in t:
                    break
                t = t[ch]
                if '#' in t:
                    return string[:i+1]
            return string
        
        return ' '.join(map(process, sentence.split()))

S = Solution()
print(S.replaceWords(["cat","bat","rat"],"the cattle was rattled by the battery"))
        