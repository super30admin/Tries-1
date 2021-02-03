// Time Complexity : O(max(mn+k)) m = average length of each word, n = number of words
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            //only lower case letter
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    private void insert(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            //check if the letter is in the trie
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            //move cur
            cur = cur.children[c-'a'];
        }
        //end of the word
        cur.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();
        //insert words in the dict
        for(String w : dictionary){
            insert(w);
        }
        //create split array
        String [] splitA = sentence.split("\\s+");
        //stringbuilder to hold the final word
        StringBuilder res = new StringBuilder();

        TrieNode cur;
        //will hold smaller word to add to the result
        StringBuilder hold;
        //iterate words in the split array
        for(int k = 0; k < splitA.length; k++){

            if(k > 0){
                res.append(' ');
            }
            //set the cur
            cur = root;
            String s = splitA[k];

            hold = new StringBuilder();
            //iterate through a single word
            for(int i = 0; i < s.length(); i++){
                //get the letter
                char c = s.charAt(i);
                //check if the word has no next letter w/respect to dictionary
                if(cur.children[c-'a'] == null || cur.isEnd) break;
                //add to replacement
                hold.append(c);
                //move cur
                cur = cur.children[c-'a'];
            }
            //check cases
            if(cur.isEnd){
                res.append(hold);
            }
            else{
                res.append(s);
            }

        }
        return res.toString();
    }
}