class Trie:
    def __init__(self):
        self.child = dict()

    def insert(self, word):
        node = self.child
        for ch in word:
            if ch not in node:
                node[ch] = dict()
            node = node[ch]
        node["is_word"] = True

    def replace_str(self, word):
        cur_str = ""
        node = self.child
        for ch in word:
            if ch not in node:
                return word
            cur_str += ch
            if node[ch].get("is_word"):
                return cur_str
            node = node[ch]
        return cur_str


# TImecomplexity - O((m+n)*l)
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        result = []
        # o(n) - words in dictionary
        for each in dictionary:
            trie.insert(each)

        # O(m) = words in a sentence

        for word in sentence.split():
            res = trie.replace_str(word)
            result.append(res)
            result.append(" ")
    
        return ''.join(result).strip()
