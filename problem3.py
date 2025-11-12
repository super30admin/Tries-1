class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        res = ""
        dic = set(dictionary)
        sentence = sentence.split(" ")

        for word in sentence:
            flag = False
            i = 0
            while i < len(word):
                if word[:i] in dic:
                    res += word[:i]
                    res += " "
                    flag = True
                    break
                i += 1
            if not flag:
                res += word
                res+= " "
        #print(res)
        return res[:-1]
