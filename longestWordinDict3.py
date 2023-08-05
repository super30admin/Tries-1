#Time: O(sum of lengths of all words in dictionary)
#Space: same as time
#did the code run successfully? yes
#Approach:
#insert words in trie
# using BFS on valid children
# for the last word to process be the answer which is lexicogrpahically smaller
# sort the children at every node in descending order lexicographically, since queue used in BFS is LILO.

class Solution:
    def longestWord(self, words: List[str]) -> str:
        Trie = lambda: defaultdict(Trie)
        trie = Trie()

        for i, word in enumerate(words):
            reduce(dict.__getitem__, word, trie)['end'] = i

        #BFS
        keys = [key for key in trie if key!='end']
        temp = [trie[key] for key in sorted(keys, reverse=True) if 'end' in trie[key]]
        que = deque(temp)
        result = ''
        while que:
            child = que.popleft()
            result = words[child['end']]
            letters = [key for key in child if key !='end']
            for letter in sorted(letters, reverse=True):
                if letter!='end' and 'end' in child[letter]:
                    que.append(child[letter])
        return result