# TC: O(mn + kp) m-avg length of dict words, n- no. of words in the dict, k-avg length of sentence, p-avg length of words in the sentence
# SC: O(mn) Trie DS
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26
    
class Solution:
    def insert(self, word):
        curr = self.root
        for ch in word:
            if curr.children[ord(ch) - ord('a')] == None:
                curr.children[ord(w) - ord('a')] = TrieNode()
            curr = curr.children[ord(w) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # edge
        if not dictionary or len(dictionary) == 0:
            return sentence
        
        # Form Trie data structure with given words
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
        
        # extract individual words of sentence
        sentence_split = sentence.split()
        result = []
        
        # for each word in the sentenece, check for root(Shortest prefix) in the Trie
        for i in range(len(sentence_split)):
            word = sentence_split[i]
            # we need space after each word after the first word
            if i > 0:
                result.append(" ")
            
            curr = self.root
            sb = []
            for ch in word:
                # if no replacement possible, retain original word. break from this loop
                if curr.children[ord(ch) - ord('a')] == None or curr.isEnd:
                    break
                # append char to string builder(replace)
                sb.append(c) 
                curr = curr.children[ord(c) - ord('a')]
            
            # for first end of word in the path followed is your replacement string for the word of the sentence considered
            if curr.isEnd:
                result.append("".join(sb))
            # retain original word
            else:
                result.append(word)
        # result(stringbuilder of strings)
        return "".join(result)