# Time Complexity: O(m + n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        trie = {}
        for root in dictionary:
            current = trie
            for letter in root:
                current = current.setdefault(letter, {})
            current['_end_'] = root
        def replace(word):
            current = trie
            for letter in word:
                if (letter not in current) or ('_end_' in current): break
                current = current[letter]
            return current.get('_end_', word)
        return ' '.join(map(replace, sentence.split()))