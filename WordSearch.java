//Time Complexity: O(ml + nl) 
//Space Complexity: O(ml + nl)

/*
 * In this approach we iterate over the board and if can find the word we return true or else false. For finding the word we check if a particular char is equal to 
 * the same index of the word. If not we return false. If it does we mark that as visited and move on, we check all the neighbors and do same thing again. If we dont
 * find char at the word index from all the neighbors we mark it as unvisited.

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