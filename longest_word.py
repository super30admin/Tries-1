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

    # def prefix(self, word):
    #     node = self.child
    #     for ch in word:
    #         if ch not in node:
    #            return False
    #         if not node[ch].get("is_word"):
    #             return False
    #         node = node[ch]
    #     return node.get("is_word")

# Time/Space complexity - O(ns)

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        ans = ''

        # O(ns)
        for word in words:
            trie.insert(word)

        #O(n)
        for word in words:
            node = trie.child
            if len(word) < len(ans):
                continue
            
            
            #(O(s))
            # check if each letter is a complete word/ there is prefix for each letter
            flag = True
            for ch in word[:-1]:
                cur = node.get(ch)
                if not cur.get("is_word"): 
                    flag = False
                    break
                node = node[ch]

            # condition for lexicographical ordering
            if flag and ((len(ans) < len(word)) or (len(ans) == len(word) and word < ans)):
                ans = word
                
        return ans


# class Solution:
#     def longestWord(self, words: List[str]) -> str:
#         words.sort() # O(nlogn)
#         word_set, ans = set(['']), ''

#         for word in words: # n*s^2
#             # check if prefix exists in word
#             if word[:-1] in word_set:
#                 if len(word) > len(ans):
#                     ans = word
#                 word_set.add(word)
#         return ans

    
