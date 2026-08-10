//problem1
class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {   
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEnd;
    }
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//problem 2
class Solution {
    class trienode{
        trienode[] child=new trienode[26];
        boolean isend;
    }
    trienode root=new trienode();
    public void insert(String word){
        trienode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null)
                curr.child[idx]=new trienode();
            curr=curr.child[idx];
        }
        curr.isend=true;
    }
    public boolean check(String word){
        trienode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null) return false;
            curr=curr.child[idx];
            if(!curr.isend) return false;
        }
        return true;
    }
    public String longestWord(String[] words) {
        for(String word:words){
            insert(word);
        }
        String ans="";
        for(String word:words){
            if(check(word)){
                if(word.length()>ans.length()){
                    ans=word;
                }
                if(word.length()==ans.length() && word.compareTo(ans)<0){
                    ans=word;
                }
            }
        }
        return ans;
    }
}
//problem 3
class Solution {
    class trienode{
        trienode[] child=new trienode[26];
        boolean end;
    }
    trienode root=new trienode();
    public void insert(String word){
        trienode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null)
                curr.child[idx]=new trienode();
            curr=curr.child[idx];
        }
        curr.end=true; 
    }
    public String search(String word){
        trienode curr=root;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null) return word;
            sb.append(word.charAt(i));
            curr=curr.child[idx];
            if(curr.end) return sb.toString();
        }
            return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String rootword:dictionary){
            insert(rootword);
        }
        StringBuilder ans=new StringBuilder();
        String words[]=sentence.split(" ");
        for(String word:words){
            ans.append(search(word)).append(" ");
        }
        return ans.toString().trim();
    }
}
