//Time Complexity: O(ml + nl) 
//Space Complexity: O(ml + nl)

/*
 * In this approach we start from the root, we first insert all the words in the dictionary ad trie nodes. We then split our sentence with the space.
   For all the words of the sentence we iterate over all the characters and if there are no children or is end is true we break, other wise we append those characters
   to the intermediate string and move to the next children. If we find the shortest prefix we append it to result.

*/
class Solution {
    private TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private void insert(String words){
        TrieNode curr = root;
        for(int i=0;i<words.length();i++){
                char c = words.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode(); 
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String words : dictionary){ //nl l-to insert a word of l length and n number of words
            insert(words);
        }
        String[] word = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(String words: word){  // m words of a sentence
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< words.length();i++){  //l time to find a replacement of the word
                char c = words.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                sb.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(sb);
            }else{
                result.append(words);
            }
            result.append(" ");

        }
    return result.toString().trim();
    }
}