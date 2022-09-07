#Time Complexity: O(∑wi)
#Space Complexity: O(∑wi)
class Solution:
    def longestWord(self, words):
        root = {}

        for word in words:
            node = root
            for c in word:
                if c not in node:
                    node[c] = {}
                node = node[c]
            node['word'] = word

    def dfs(node):
        ans = node['word'] if 'word' in node else ''

        for child in node:
            if 'word' in node[child] and len(node[child]['word']) > 0:
                childWord = dfs(node[child])
                if len(childWord) > len(ans) or (len(childWord) == len(ans) and childWord < ans):
                    ans = childWord

            return ans

        return dfs(root)

        