# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root_trie = {}
        for root in dictionary:
            node = root_trie
            for char in root:
                node = node.setdefault(char, {})
            node['#'] = True

        words = sentence.split(' ')
        replaced_words = []
        for word in words:
            node = root_trie
            prefix = ""
            found_replacement = False
            for char in word:
                if char not in node:
                    break
                prefix += char
                node = node[char]
                if node.get('#'):
                    replaced_words.append(prefix)
                    found_replacement = True
                    break
            
            if not found_replacement:
                replaced_words.append(word)
                
        return " ".join(replaced_words)
        