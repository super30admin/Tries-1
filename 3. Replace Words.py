class Solution:
    # Time Complexity - O(n*m) - to build trie with a dictionary of n words and avg length of each word m +
    # and we go through k words of avg length l - O(k*l) -> Total - O(n*m) + O(k*l)
    # Space Complexity - (O(n*m) + O(k)) - k is for the words that we're searching in the trie
    def replaceWords(self, dictionary, sentence: str) -> str:
        trie = {}

        for word in dictionary:
            t = trie
            for ch in word:
                if ch not in t:
                    t[ch] = {}
                t = t[ch]
            t['#'] = "#"

        def process(string):
            t = trie
            for i, ch in enumerate(string):
                if ch not in t:
                    break
                t = t[ch]
                if '#' in t:
                    return string[:i + 1]
            return string

        return ' '.join(map(process, sentence.split()))