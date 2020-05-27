#Problem 1: Implement Trie (Prefix Tree)
'''
Own implementation of tries, I'm aware that
it could be implemented more aesthetically pleasing.
There are a few technicalities too look out for.
First you need to mark that it's a word ending, and make
sure that you do even if the word is aleady there (start
of another word). Keep a variable to know what is the
next letter we have to either find or process. increment
it by one every time you found one of the letter.
What the variable is will mark where to start the building
phase of insert (traverse until there's no next letter,than
expand the branch).
'''
class Trie:

    def __init__(self):

        self.val=None
        self.children=[]
        self.end_word=False


    def insert(self, word: str) -> None:
        root=self
        found=False
        finished=False
        where=0
        for i,c in enumerate(word):
            for child in root.children:
                if child.val==c:
                    where=i+1
                    root=child
                    found=True
                    break
            if not root.children or not found:
                break
            found=False

        for i in range(where,len(word)):
            child=Trie()
            child.val=word[i]
            root.children.append(child)
            root=child
        root.end_word=True



    def search(self, word: str) -> bool:
        found=False
        root=self
        for i,c in enumerate(word):
            for child in root.children:
                if child.val==c:
                    found=True
                    root=child
                    break
            if not found:
                return False
            found=False
        return root.end_word





    def startsWith(self, prefix: str) -> bool:
        found=False
        root=self
        for i,c in enumerate(prefix):
            for child in root.children:
                if child.val==c:
                    found=True
                    root=child
                    break
            if not found:
                return False
            found=False
        return True
