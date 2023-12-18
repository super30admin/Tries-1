// Time Complexity: O(mL) m is the number of words and L is the length of the word.
// Space Complexity: O(mL)
class Solution {

    class TrieNode{
        boolean isEnd;
        TrieNode children[];

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    String longestWord = "";
    public String longestWord(String[] words) {
        this.root = new TrieNode();


        // O(ml)
        for(String word: words){
            insert(word);
        }

        // O(mL)
        for(String word: words){
            // System.out.println(canForm(word));
            if(word.length() >= longestWord.length() && canForm(word)){
                if(word.length() == longestWord.length()){
                    longestWord = longestWord.compareTo(word) < 0 ? longestWord : word;
                }else
                    longestWord = word;
            }
        }
        return longestWord;        
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    private boolean canForm(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr = curr.children[c - 'a'];
            if(!curr.isEnd){
                return false;
            }
        }
        return true;
    }
}