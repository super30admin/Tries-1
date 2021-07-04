
// Time - O(Nk) + O(L)
// Space - O(Nk) + O(L)


class Solution {

    class TrieNode {
        boolean isEnd;
        TrieNode [] children; //make an array
        public TrieNode() {
            children = new TrieNode[26]; // array of 26 characters
        }


    }
    /** Initialize your data structure here. */
    TrieNode root;
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // curr // second iteration. //a
            if( curr.children[c - 'a'] == null) {
                // if it is empty insert
                curr.children[c - 'a']  = new TrieNode(); // ba
            }
            curr = curr.children[c - 'a']; // b
        }

        curr.isEnd = true;

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        //making a trie for the dictionary by inserting words
        for(String word: dictionary) {
            insert(word);
        }


        String [] splitArr = sentence.split("\\s+"); // ["the","cattle"] // removing extra spaces
        StringBuilder result = new StringBuilder(); // creating StringBuilder for result to output
        for(int k = 0; k < splitArr.length; k++) { // iterating through string array
            String word = splitArr[k]; // fetching the word from string array
            if(k > 0) result.append(" "); // if there is more then one word appending spaces
            StringBuilder replacementString = new StringBuilder(); // replcement string to store characters
            TrieNode curr = root; //
            for( int i = 0; i < word.length(); i++) { // iterating through each word
                char c = word.charAt(i); // iterating through each character starting with first if it is present or not
                if(curr.children[c - 'a'] == null || curr.isEnd) break; // if children is not present and isEnd is true break from the current for loop
                curr = curr.children[c - 'a']; // moving to another child in the tree
                replacementString.append(c); // adding characters to the replacement string
            }
            if(curr.isEnd) { // we find smallest prefix for the word
                result.append(replacementString);
            }
            else { // where we dint find prefix for the word
                result.append(word);
            }

        }

        return result.toString(); // converting stringbuilder to string

    }
}