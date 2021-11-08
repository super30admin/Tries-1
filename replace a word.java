//Timecomplexity :- O(m*k +n*l) for insertion and replacing
//Spacecomplexity :- O(m*k) 
//Did it run on leetcode:- Yes.
//What was the problem faced:- got many null pointer exceptional errors.
//at the time of inserting dictionary when we got one root word coverd marking flag as true. So at
// each word traversing in sentence when we got first true at that point replacing whole word with root or else replacing
// same word.

class Solution {
    
    class Trie{
        String str;
        Trie[] child;
        Trie(){
            str = null;
            child = new Trie[26];
        }
    }
    
    public void insert(String s, Trie curr){
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(curr.child[idx] == null) curr.child[idx] = new Trie();
            if(i == s.length()-1) curr.child[idx].str = s;
            curr = curr.child[idx];
        }
    }
    
    public String getRoot(String word, Trie curr){
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.child[idx] == null) return word;
            if(curr.child[idx].str != null) return curr.child[idx].str;
            curr = curr.child[idx];
        }
        return word; 
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        //make a trie of dictionay
        Trie root = new Trie();
        for(String rootWord : dictionary) insert(rootWord,root);
        StringBuilder ans = new StringBuilder();
        for(String word : sentence.split("\\s+")) ans.append(getRoot(word,root)).append(" ");
        return ans.toString().trim();
    }
}
