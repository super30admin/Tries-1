
#Problem 3: Replace Words
#Time Complexity: O(m+n), m number of characters in the dict, num of characters in sentence
#Space Complexity: O(m+n), the trie and the split sentence
'''
We create a Trie with all the words in the dictionary.
We iterate the words through in sentence and go along
the trie and update the word by the word in the trie if it's
end_of_word ,until we reach  end of the trie. If it's not
end_of_word we just ignore it. We split sentence as a list
of words so that it's easier to work with
'''
class Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        #edge case
        if not dict or not sentence:
            return sentence
        sentence_l=sentence.split(" ")
        my_trie=Trie()
        for word in dict:
            my_trie.insert(word)
        found=False
        for i,word in enumerate(sentence_l):
            root=my_trie
            memory=[]
            for c in word:
                if root.end_word:
                    sentence_l[i]="".join(memory)
                    break

                for child in root.children:
                    if child.val==c:

                        memory.append(c)
                        root=child
                        found=True
                if not found:
                    break
                found=False
        return " ".join(sentence_l)
