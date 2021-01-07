/*
class TrieNode:
    def __init__(self):
        self.isLast = False
        self.children = [None] * 26
        
class Solution:
    def insert(self, word):
        cur = self.root
        for c in word:
            if cur.children[ord(c) - ord('a')] is None:
                cur.children[ord(c) - ord('a')] = TrieNode()
            cur = cur.children[ord(c) - ord('a')]
        cur.isLast = True
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if dictionary is None or len(dictionary) == 0:
            return sentence
        
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
        
        sentence_list = sentence.split()
        final_str = list()
        temp_str = list()
        cur = self.root
        for i in range(len(sentence_list)):
            if i > 0:
                final_str.append(" ")
                
            cur = self.root   
            temp_str = list()  
            for c in sentence_list[i]:
                if cur.children[ord(c) - ord('a')] is None or cur.isLast:
                    break
                temp_str.append(c)
                cur = cur.children[ord(c) - ord('a')]
                
            if cur.isLast:
                final_str.append("".join(temp_str))
            else:
                final_str.append(sentence_list[i])
        
        return "".join(final_str)
*/

// Time Complexity : O(n*m) where n dictionary size and m is word size on an average
// Space Complexity : O(k) where k is sentence length
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: I maintained a trie and then splitted the sentence 
// and checked for each word

class Solution {
    
    class TrieNode{
        boolean isLast;
        TrieNode[] children;
        
        public TrieNode(){
            isLast = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isLast = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0)
            return sentence;
        
        root = new TrieNode();
        for (String word: dictionary)
            insert(word);
        
        StringBuilder finalStr = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();
        
        String[] sentence_list = sentence.split(" ");
        
        for (int i=0; i<sentence_list.length; i++){
            if (i > 0)
                finalStr.append(" ");
            
            tempStr = new StringBuilder();
            TrieNode cur = root;
            for (int j=0; j<sentence_list[i].length(); j++){
                char c = sentence_list[i].charAt(j);
                if (cur.children[c - 'a'] == null || cur.isLast)
                    break;
                tempStr.append(c);
                cur = cur.children[c - 'a'];
            }
            
            if (cur.isLast)
                finalStr.append(tempStr);
            else
                finalStr.append(sentence_list[i]);
            
        }
        return finalStr.toString();
        
    }
}
