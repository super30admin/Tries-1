class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        set_ = set(dictionary)

        splitArr = sentence.split(" ")
        result = []

        for i in range(len(splitArr)):
            word = splitArr[i]
            flag = True

            for j in range(len(word)):
                subStr = word[:j+1]
                if subStr in set_:
                    result.append(subStr)
                    flag = False
                    break

            if flag:
                result.append(word)

        return " ".join(result)

#Time: O(M * L + N * L^2), where M is the number of words in dictionary, N is number of words in sentence, and L is the average word length.
#Space: O(M * L + N * L) for hashset and split array.
