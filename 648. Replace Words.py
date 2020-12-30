class TrieNode:
    #prefix tree
    #each root node has 1)boolean value to indicate end or not 2) children map >here 26 lowercase alphas
        # Initialize your data structure here.
        def __init__(self):
            #self.c=c
            self.word=False
            self.children={}
class Solution(object):
    def __init__(self):
        self.root = TrieNode()
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        #base
        if not dictionary:
            return sentence
        
        def insert( word):
            #initilize node as root trieNode
            node=self.root
            #for every char in word> check if entry is there in children map> if not>create one and insert and proceed with that child
            for i in word:
                if i not in node.children:
                    node.children[i]=TrieNode()
                node=node.children[i]
            #mark end
            node.word=True
        #maintain trie of dictionary words
        for word in dictionary:#(O(N*length of word(p)))
            insert(word)
        #split sentence
        sp=sentence.split(" ")
        
        final=''
        internal=''
        
        for i in range(len(sp)):#O(M)
            #for every word in sentence
            cur=self.root
            internal=''
            #keep in between spaces except at the start >no leading space
            if i>0:
                final+=' '
            #for every char in word O(length of word=p)
            for j in range(len(sp[i])):
                #char
                c=sp[i][j]
                #if char not in trie or if this is the last char
                if c not in cur.children or cur.word:
                    break
                #matched chars
                internal+=c
                #proceed in trie
                cur=cur.children[c]
            #found complete word in trie>replace sentence word with trie word
            if cur.word:
                final+=internal
            #not found in trie>  continue using same word   
            else:
                final+=sp[i]
        return final
                
                
    #O(np)+O(mp)
    #build trie> O(np)
            