# put the dictionary into a set and break the sentences into a list
# create a helper function for each word in sentence List
# check if a substring of the word in sentence exists in set of dict
# keep incrementing the substring till it matches
# time complexity 0(w[i]^2) where w[i] is the length of ith element in sentence
# space complexity 0(n) where n is the length of sentence without spacing


class Solution:

    def findRoot(self,word,dictSet):
        for head in range(1,len(word)):
            if word[:head] in dictSet :
                return word[: head]
        return word
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        setDict = set(dictionary)
        #print(setDict)
        sentenceInList = sentence.split(" ")
        #print(sentenceInList)

        returnList = [ self.findRoot(w,setDict) for w in sentenceInList]

        return " ".join(returnList)
        