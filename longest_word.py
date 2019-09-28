"""
Given a list of strings . Find the string that

Time complexity O(num_words * word_length)
Space complexity O(num_words * word_length)

Runs on leet code : yes


"""


class Trei:
    is_word = False
    child = {}
    depth = 0
    
    def __init__(self, depth):
        self.depth = depth
        self.is_word = False
        self.child = {}
    
    def add(self, string, depth=0):
        
        if string == '':
            self.is_word = True
            return self.depth
        
        if not self.child.get(string[0]):
            self.child[string[0]] = Trei(self.depth + 1)
        
        return self.child[string[0]].add(string[1:])
    
    def is_valid(self, s):
        if s == '':
            return True
        
        if not self.child[s[0]].is_word:
            return False
        
        return self.child[s[0]].is_valid(s[1:])


class Solution(object):
    
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        
        root = Trei(0)
        
        iterable_results = [(w, root.add(w)) for w in words]
        
        filtered_results = [i for i in iterable_results if root.is_valid(i[0])]
        
        max_str = None
        
        if filtered_results:
            max_str = filtered_results[0]
            for i in filtered_results[1:]:
                max_str = i if self.is_bigger(i, max_str) == 1 else max_str
        
        return max_str[0]
    
    def is_bigger(self, x, y):
        if x[1] == y[1]:
            return False if x[0] > y[0] else True
        return True if x[1] > y[1] else False
