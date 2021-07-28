# TC: O(N.k) where N is the number of words in the dictionary and k is the average length of a word in the dictionary. As we search the prefix word in trie and then insert the word in the trie.
# SC: O(N.k) where k is the length of the longest word in the dictioanry. In worst case, there can be N longest words in dict, that we will be storing into the trie.

class TrieNode: 
    def __init__(self): 
        self.hmap_children = {}
        self.isEnd = False

class Solution:
    def __init__(self): 
        self.root = TrieNode()
        self.max_word = ""
    
    def search_insert(self, prefix): 
        curr = self.root
        # print(prefix)
        for char in range(len(prefix) - 1): 
            if prefix[char] not in curr.hmap_children:
                return
            curr = curr.hmap_children[prefix[char]]
        if curr.isEnd:
            curr.hmap_children[prefix[-1]] = TrieNode()
            curr = curr.hmap_children[prefix[-1]]
            curr.isEnd = True
        
        if len(prefix) > len(self.max_word):
            self.max_word = prefix
        elif len(prefix) == len(self.max_word) and prefix < self.max_word: 
            self.max_word = prefix
    
    def insert(self, word): 
        curr = self.root
        if word not in curr.hmap_children: 
            curr.hmap_children[word] = TrieNode()
        curr = curr.hmap_children[word]
        
        curr.isEnd = True
        if len(word) > len(self.max_word):
            self.max_word = word
        elif len(word) == len(self.max_word) and word < self.max_word: 
            self.max_word = word
            
        
    def longestWord(self, words: List[str]) -> str:
        if not words or len(words) == 0: 
            return 
        
        max_length = float('-inf')
        word_lengths = {}
        for word in words: 
            if len(word) > max_length: 
                max_length = len(word)
            if len(word) in word_lengths: 
                temp_list = word_lengths.get(len(word))
                temp_list.append(word)
                word_lengths[len(word)] = temp_list
            else: 
                word_lengths[len(word)] = [word]
        
        length = 1
        while length <= max_length: 
            temp_list = word_lengths.get(length)
            if temp_list: 
                for i in temp_list: 
                    if length != 1:
                        self.search_insert(i)
                    else: 
                        self.insert(i)
            length += 1
        
        return self.max_word
                    
                    
