//implement trie data structure
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {
    
    class TrieNode {
        
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

// longest word in a dictionary
//tc sigma(O(length of words[i]))
//sc same as above
  
// brute force

// class Solution {
//     public String longestWord(String[] words) {
//         String ans = "";
//         Set<String> wordset = new HashSet();
//         for (String word: words) wordset.add(word);
//         for (String word: words) {
//             if (word.length() > ans.length() ||
//                     word.length() == ans.length() && word.compareTo(ans) < 0) {
//                 boolean good = true;
//                 for (int k = 1; k < word.length(); ++k) {
//                     if (!wordset.contains(word.substring(0, k))) {
//                         good = false;
//                         break;
//                     }
//                 }
//                 if (good) ans = word;
//             }    
//         }
//         return ans;
//     }
// }

class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;

        TrieNode(){
            this.children=new TrieNode[26];
            this.word="";
        }
    }

    TrieNode root;
    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.word=word;
    }

    public String longestWord(String[] words) {
        root=new TrieNode();
        for(String word:words){
            insert(word);
        }

        Queue<TrieNode> queue=new LinkedList<>();
        queue.add(root);
        TrieNode curr=root;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                 curr=queue.poll();
                for(int k=25;k>=0 ;k--){
                    if(curr.children[k]!=null && curr.children[k].word.length()>0){
                        queue.add(curr.children[k]);
                    }
                }    
            }
        }
        return curr.word;
    }
} 

