# Time: O(n)
# Space Complexity: O(n)
class Solution:

    # Trie Approach
    # Initialise a Trie
    def __init__(self):
        self.children = {}

    def insert(self, word):
        current = self.children
        for w in word:
            if w not in current:
                current[w] = {}
            current = current[w]
            if '#' in current:
                return
        current['#'] = True

    def search(self, word):
        current = self.children
        for w in word:
            if w not in current:
                return False
            current = current[w]
        return '#' in current

    def startswith(self, word):
        current = self.children
        for w in word:
            if w not in current:
                return False
            current = current[w]
        return True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Trie Approach
        result = ''
        sent = sentence.split(" ")
        for word in dictionary:
            self.insert(word)
        # print(self.children)

        for word in sent:
            temp = ''
            curr = self.children
            for ch in word:
                if ch not in curr or '#' in curr:
                    break
                temp += ch
                curr = curr[ch]
            if '#' in curr:
                result += temp
            else:
                result += word
            result += ' '

        return result.strip()


        # # Set Approach (Inefficient)
        # # Time Complexity: O()
        # # Space Complexity: O(n)

        # sent = sentence.split(" ")
        # dic_set = set(dictionary)
        # for i in sent:
        #     flag = False
        #     for j in range(1, len(i)):
        #         # print(i[:j])
        #         if i[:j] in dic_set:

        #             result += i[:j]
        #             flag = True
        #             break
        #     if not flag:
        #         result += i
        #     result += ' '
        # return result.strip()