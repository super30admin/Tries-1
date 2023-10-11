class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        Trie = lambda: collections.defaultdict(Trie)
        trie = Trie()
        END = True

        for root in dictionary:
            reduce(dict.__getitem__, root, trie)[END] = root

        
        def replace(arr):
            cur = trie
            for letter in arr:
                if letter not in cur or END in cur: break
                cur = cur[letter]
            return cur.get(END, arr)

        return " ".join(map(replace, sentence.split()))