// TC insert nl and search number of words n  * 26 
// SC insert nl and search space for Queue O(n) no of words n * 26

class Solution {
    class TrieNode{
        boolean isEnd;
        String wordinDict;
        TrieNode [] list;
        public TrieNode(){
            list = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String inword){
        TrieNode temproot = root;
        for(int i =0; i < inword.length(); i++){
            int t = 'z' - inword.charAt(i) ;
            if(temproot.list[t] == null){
                temproot.list[t] = new TrieNode();
            } 
            temproot = temproot.list[t];
        }
        temproot.isEnd = true; 
        temproot.wordinDict = inword; 
        
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word: words){
            insert(word); 
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root); 
        TrieNode temproot = null;
        while(!q.isEmpty()){
            temproot = q.poll();
            for(int i = 0; i < 26; i++){
                if(temproot.list[i] != null && temproot.list[i].isEnd == true){
                    q.add(temproot.list[i]);
                }
            }
            
        }
        if(temproot.wordinDict != null) return temproot.wordinDict;
        return new String("");
        
        
    }
}
