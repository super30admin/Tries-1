

/*

    Time complexity : O(M*N) M is the length of dictionary and N is the length of the sentence ( no of words in senstence)

    Space complexity : O(1)
    worked in leetcode : YES

*/

public class Word_Replace {
    TrieNode root;
    class TrieNode{
        String word;
        TrieNode [] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void insert(String word){
            TrieNode curr = root;
            for(int i = 0; i< word.length();i++){
                char c  = word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] =  new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for( String w :  dict){
            insert(w);
        }
        
        StringBuilder sb = new StringBuilder();
        String [] words = sentence.split("\\s+");
        for(int i=0;i < words.length;i++){
            String word = words[i];
//              search  the word in trie
            TrieNode curr = root;
            if(i > 0 ) sb.append(" ");
            for(int j =0; j< word.length();j++){
                char ch = word.charAt(j);
                if( curr.children[ch - 'a'] == null || curr.word != null) break;
                curr = curr.children[ch - 'a'];
            }
            String replace;
            if( curr.word == null){
                replace = word;
            }else{
                replace = curr.word;
            }
            sb.append(replace);
        }
        
        return sb.toString();
    }
}