
#problem 2: Longest Word in Dictionary
#time complextity : O(n), n being the sum of all letters in all words
#Space complexity: O(n)


'''
I create a trie with all the words. Then I traverse the trie with only keeping the
edges that are connecting two end_of_words (I can only visit a end_of_words each time).
We can traverse BFS or DFS. Return the maximum depth reached. We keep a memory and save
the words that are maxdepth to res. save the words that are the actual last max_depth,find min
lexciographic element by iterating through the words.
'''
class Solution:
    def longestWord(self, words: List[str]) -> str:
        my_trie=Trie()
        for word in words:
            my_trie.insert(word)

        max_depth=0
        res=[]
        memory=[]
        def dfs(root,depth):
            nonlocal max_depth
            for child in root.children:
                if child.end_word:
                    memory.append(child.val)
                    dfs(child,depth+1)
                    memory.pop()

            if depth>=max_depth:
                    max_depth=depth
                    res.append((memory[:],depth))
        dfs(my_trie,0)


        candidates=[]
        for word,depth in res:
            if depth==max_depth:
                max_word="".join(word)
                candidates.append(max_word)

        return min(candidates)
