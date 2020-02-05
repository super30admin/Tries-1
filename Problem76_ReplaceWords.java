//Space Complexity: Space occupied by the Trie of dict
//Time Complexity: (m1*n1) + (m*n) ~ O(n) ~ Linear
/*dictionary has n-> words
               m -> size of words
               to build Trie : m*n (from dict)
sentence has words -> m1
avg length of words -> n1
                replacing time complexity: m1*n1
 */

class Solution {
    //create TrieNode class
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children =  new TrieNode[26];
        };
    
    }
    TrieNode root = new TrieNode();
    //inserting word in the Trie
    public void insert(String word){
        //initially curr is root
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            //if char doesnot exist, add new trienode
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            //curr++
            curr = curr.children[c-'a'];
        }
        //set curr.word to the word
        curr.word = word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        //building a trie of the dict
        //with insert function
        for(String s : dict){
            insert(s);
        }
        //builder to append strings
        StringBuilder sb = new StringBuilder();
        //to get word of the sentence, split it into words
        //and to distinguish, add spaces
        for(String word : sentence.split("\\s+")){
            if(sb.length() > 0)
                sb.append(" ");
            
            TrieNode curr = root;
            //now for each word till its length
            for(int i=0; i<word.length(); i++){
                //get character, compare character with children
                char c = word.charAt(i);
                //if no children found or curr.word is null
                if(curr.children[c-'a'] == null || curr.word != null){
                    break;
                }
                //curr++
                curr = curr.children[c-'a'];
            }
            //replacement found or not?
            String replacement = curr.word;
            if(replacement == null){
                sb.append(word);
            }else{
                sb.append(replacement);
            }
        }
        return sb.toString();
    }
}
