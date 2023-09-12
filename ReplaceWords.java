// Time Complexity = O(m*n), n is the number of words and m is the length of the word
// Space Complexity = O(m*n), n is the number of words and m is the length of the word
class Solution {
    class TrieNode {
        boolean isEndOfWord; // shows end of string
        TrieNode[] children; // references to child nodes
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    // method inserts word into Trie, takes word as parameter
    public void insert(String word, TrieNode root) {
       TrieNode position = root;
       char c;
       for (int i = 0; i < word.length(); i++) { 
           c = word.charAt(i);
           if (position.children[c - 'a'] == null) {
               position.children[c - 'a'] = new TrieNode();
           }
           position = position.children[c - 'a']; 
       }
       position.isEndOfWord = true; 
   }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary){
            insert(word, root);
        }
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for ( int i=0 ; i<splitArr.length;i++){

            String word = splitArr[i];
            if(i>0) result.append(" ");
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for( int k =0; k<word.length();k++){
                char c= word.charAt(k);
                if(curr.children[c - 'a'] == null || curr.isEndOfWord) break;
                curr = curr.children[c- 'a'];
                replacement.append(c);

            }
            if(curr.isEndOfWord){
                result.append(replacement);
            }else{
                result.append(word);
            }
        }
        return result.toString();
    }

}



//Using HashSet
// Time Complexity = O(m*n), n is the number of words and m is the length of the word
// Space Complexity = O(m*n), n is the number of words and m is the length of the word
class Solution {
    
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for ( int i=0 ; i<splitArr.length;i++){

            String word = splitArr[i];
            if(i>0) result.append(" ");
            boolean flag = false;
            for( int k =0; k<word.length();k++){
                String sub = word.substring(0,k+1);
                if(flag) break;
                if(set.contains(sub)){
                    flag=true;
                    result.append(sub);
                }
            }
            if(!flag){
                result.append(word);
            }
        }
        return result.toString();
    }
}
