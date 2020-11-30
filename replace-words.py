class Solution(object):
    # class Trie():
        def __init__(self):
            self.c={}
            self.isend=False
        def insert(self,word):
            node=self
            for w in word:
                if w not in node.c:
                    node.c[w]=Solution()
                node=node.c[w]
            node.isend=True
        def prefixsearch(self,word):
            node=self
            for w in word:
                if w not in node.c:
                    return False
            return True
        def replaceWords(self, dictionary, sentence):
            """
            :type dictionary: List[str]
            :type sentence: str
            :rtype: str
            """
            root=Solution()
            for w in dictionary:
                root.insert(w)
            # print(root)
            arr=sentence.split()
            # print(arr)
            final=[]
            for string in arr:
                # if k>0:
                curr=root
                replace=''
                for i in string:
                    # print(i)
                    if i not in curr.c or curr.isend==True:
                        break
                    replace+=i
                    # print(replace)
                    curr=curr.c[i]
                if curr.isend==True:
                    final.append(replace)
                else:
                    final.append(string)
                # print(final)
            def lsittostring(s):
                stri=' '
                return (stri.join(s))
            return lsittostring(final)
        #time-np+mp -p-length of word m-no of words in dic n-no of words in dic
        #space-mp