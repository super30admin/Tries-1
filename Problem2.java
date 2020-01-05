/**
LeetCode Submitted : YES
Time Complexity : O(Num of words * Max Height of Tree)
Space Complexity : O(Num of words)

The idea is to use Trie data structure to store all the possible words in dictionary. Along with each word we are also storing value of the string as word of the Trie. For lexicographical ordering we are reading last to first.
**/

class Solution {
    
    class Trie {

        class Node{
            Node[] children = new Node[26]; //char Array
            String value;
            public Node(){
            
            }
        }
    
    Node root;
    
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }
    
        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node temp = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                //System.out.println(c-'a');
                if(temp.children[c - 'a'] == null)
                    temp.children[c - 'a'] =  new Node();
            
                //temp.children[c - 'a'].value =  1;
                temp = temp.children[c - 'a'];
            }
            temp.value = word;
        }
    
        /** Returns if the word is in the trie. */
        public String search(String word) {
            Node temp = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(temp.children[c - 'a'] != null && temp.children[c - 'a'].value !=  null)
                    temp = temp.children[c - 'a'];
            }
            return temp.value;
        }
        
        public String findLongestWord(){
            Node node = root;
            String output = "-1";
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            
            while(!q.isEmpty()){
                int size = q.size();
                
                for(int i = size-1; i >= 0; i--){ //Lexicolgraphical Ordering
                    Node temp = q.poll();
                    for(int j = 25; j>=0;j--){  //Lexicolgraphical Ordering
                        if(temp.children[j] != null && temp.children[j].value != null){
                            q.add(temp.children[j]);
                            output = temp.children[j].value;
                        }
                            
                    }
                }
            }
            
            return output;
        }
        
    }
    public String longestWord(String[] words) {
        Trie obj = new Trie();
        for(String word : words)
            obj.insert(word);
        
        //helper function to find maximum word 
        return obj.findLongestWord();
        
    }
}
