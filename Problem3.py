#Time Complexity - O(nl)
#Space Complexity - O(nl)
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = {}
        result = ""
        for word in dictionary:
            t = trie
            for ch in word:
                if ch not in t:
                    t[ch] = {}
                t = t[ch]
            t["-"] = True
        
        def explore(word):
            t = trie
            string = ""
            for ch in word:
                if ch in t:
                    string += ch
                    t = t[ch]
                    if '-' in t:
                        return string
                else:
                    return word
            return word
            

        sentence = sentence.split(" ")
        for word in sentence:
            result += explore(word) + " "
        
        return result[:len(result) - 1]
            

        