/*
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. 
For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. 
If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 

Note:

The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100

*/


class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        
        Trie node = new Trie();
        
        for(int i = 0; i < dict.size(); i++){
            
            node.insert(dict.get(i));
        }
        
        return node.replace(sentence);
    }
    
    class TrieNode{
        
        public char value;
        public boolean isRoot;
        public TrieNode[] character = new TrieNode[26];
        
        public TrieNode() {}
        
        public TrieNode(char c){
            
            value = c;
        }
    }
    
    class Trie{
        
        TrieNode root;
        
        public Trie(){
            
            root = new TrieNode(' ');
        }
        
        public void insert(String word){
            
            TrieNode cur = root;
            
            for(int i = 0; i < word.length(); i++){
                
                char c = word.charAt(i);
                
                if(cur.character[c - 'a'] == null){
                    cur.character[c - 'a'] = new TrieNode(c);
                }
                
                cur = cur.character[c - 'a'];
            }
            
            cur.isRoot = true;
        }
        
        public String replace(String sentence){
            
            String result = new String();
            
            for(String str: sentence.split(" ")){
                    
                TrieNode cur = root;
                StringBuilder temp = new StringBuilder();
                
                for(char c : str.toCharArray()){
                    
                    if(cur.character[c - 'a'] != null && !cur.isRoot){
                        
                        temp.append(c);
                        cur = cur.character[c - 'a'];
                    }else break;
                }
                
                if(temp != null && cur.isRoot && result.isEmpty()){
                    
                    result += temp.toString();
                }else if(temp != null && cur.isRoot){
                    
                    result += " " + temp.toString();
                }else if(result.isEmpty()){
                    
                    result += str;
                }else   result += " " + str;
                
            }
            
            return result;
        }
    }
}