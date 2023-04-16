import collections

# TC : O(L), L => length of all words
# SC : O(L)

class TrieNode:
    def __init__(self, char = ""):
        self.char = char
        self.children = {}
        self.word = None

    def insert(self, word):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode(c)
            cur = cur.children[c]
        cur.word = word


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        sentence_list = sentence.split()
        print(sentence_list)
        node = TrieNode()
        for i in dictionary:
            node.insert(i)

        for i in range(len(sentence_list)):
            temp = list(sentence_list[i])
            j = 0
            q = collections.deque([temp[0],])
            node1 = node
            while q:
                cur = q.popleft()
                if cur in node1.children and not node1.word:
                    node1 = node1.children[cur]
                elif node1.word:
                    sentence_list[i] = node1.word
                else:
                    break
                if j < len(temp) - 1:
                    j = j + 1
                    q.append(temp[j])

        return " ".join(sentence_list)