#Time: O(sum of lengths of all roots + number of words in the sentence)
#Space: same as time
#did the code run successfully on LC? yes
#issues faced? when word in a sentence is smaller than a root
#approach:
#build a prefix tree for roots in dictionary
#get the smallest root if a root is possible for each word in the sentence

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        Trie = lambda: defaultdict(Trie)
        trie = Trie()
        for root in dictionary:
            reduce(dict.__getitem__, root, trie)['end'] = root
        
        def replace(word):
            curr = trie
            for letter in word:
                if 'end' in curr:
                    return curr['end']
                if letter not in curr:
                    return word
                curr = curr[letter]
            return word
        
        return ' '.join(map(replace, sentence.split()))