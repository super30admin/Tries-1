#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#Create a Node class which will point to 26 possible nodes, each representing a charcter. Initially these nodes are null and they are created when the character is encounterd.
class Trie:
    class Node:
        def __init__(self):
            self.end=False
            self.D=[None]*26

    def __init__(self):
        self.root=self.Node()
        #root.end=True

    def insert(self, word: str) -> None:
        #print("INSERT STARTS!!")
        temp=self.root
        for i in word:
            
            if(temp.D[ord(i) - 96-1]):
                #print(i+"if bloock")
                temp=temp.D[ord(i) - 96-1]
            else:
                node=self.Node()
                #print(i+"else  bloock")
                temp.D[ord(i) - 96-1]=node
                temp=temp.D[ord(i) - 96-1]
        temp.end=True
                
        
    def search(self, word: str) -> bool:
        temp=self.root
        for i in word:
            #temp=self.root
            ch=ord(i)-96-1
            if(not temp.D[ch]):
                return False
            temp=temp.D[ch]
        #if(temp.end==True):return True
        return temp.end
        

    def startsWith(self, prefix: str) -> bool:
        temp=self.root
        for i in prefix:
            #temp=self.root
            ch=ord(i)-96-1
            print(ch)
            temp.D
            if(not temp.D[ch]):
                return False
            temp=temp.D[ch]
        #if(temp.end==True):return True
        return True

        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
