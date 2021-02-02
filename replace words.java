// Time Complexity : O(Max(mn+k)) m = average length of each word in the dictionary and n being number of words
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
    //creat the insert function
    private void insert(String word){
        //set cur to root
        TrieNode cur = root;
        //start looping through the word
        for(int i = 0; i < word.length(); i++){
            //get the character
            char c = word.charAt(i);
            //check if the letter is in the trie or not
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            //move the cur pointer
            cur = cur.children[c-'a'];
        }
        //end of the word change isEnd to true
        cur.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        //creat the root
        root = new TrieNode();
        //insert the words in the dictionary they have gave us into the trie
        for(String w : dictionary){
            insert(w);
        }
        //now create the split array which has each of the words excluding spaces and multiple spaces
        String [] splitA = sentence.split("\\s+");
        //create a stringbuilder to hold the final word
        StringBuilder res = new StringBuilder();
        //set the cur
        TrieNode cur;
        //set the replacement stringbuilder which will hold the smaller word and be added to the restul stringbuilder
        StringBuilder hold;
        //start iterating through the words in the split array
        for(int k = 0; k < splitA.length; k++){
            //check add spaces back into result string
            if(k > 0){
                res.append(' ');
            }
            //set the cur 
            cur = root;
            String s = splitA[k];
            //intialize hold each time
            hold = new StringBuilder();
            //iterate through a single word
            for(int i = 0; i < s.length(); i++){
                //get the letter
                char c = s.charAt(i);
                //check if the word has an end or no next letter corresponding to word in dictionary
                if(cur.children[c-'a'] == null || cur.isEnd) break;
                //if not then add to the replacement
                hold.append(c);
                //move the cur pointer
                cur = cur.children[c-'a'];
            }
            //check the two cases
            if(cur.isEnd){
                //add to the result string
                res.append(hold);
            }
            else{
                //add the letter to final string
                res.append(s);
            }
            
        }
        return res.toString();
    }
}


