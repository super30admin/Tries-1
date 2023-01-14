//Time Complexity : Insert - O(N)
//					Search - O(N)
//					startsWith - O(N)
//Space Complexity :Insert - O(N)
//					Search - O(N)
//					startsWith - O(N)
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :


class Trie {
  
    class TrieNode{
        boolean isEnd;
        TrieNode[] childrens;
        TrieNode(){
            childrens = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public Trie() {
       root = new TrieNode(); 
    }
    
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode curr = root;
        for(char c:arr){
            int index = c-'a';
            if(curr.childrens[index]==null){
                curr.childrens[index] = new TrieNode();
                 curr = curr.childrens[index];
            }else{
                curr = curr.childrens[index];
            }
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode curr = root;
        for(char c:arr){
            int index = c-'a';
            if(curr.childrens[index]==null){
                return false;
            }else{
                curr = curr.childrens[index];
            }
        }
        return curr.isEnd==true;
    }
    
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode curr = root;
        for(char c:arr){
            int index = c-'a';
            if(curr.childrens[index]==null){
                return false;
            }else{
                curr = curr.childrens[index];
            }
        }
        return true;
    }
}
