// Time Complexity : The time complexity is O(sum of lengths of all the strings in dictionary + number of letters in sentence)
// Space Complexity : The space complexity is O(sum of lengths of all the strings in dictionary + number of letters in sentence)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    TrieNode root;

    public String replaceWords(List<String> class Solution {

        TrieNode root;

        public String replaceWords(List<String> dictionary, String sentence) {

            root = new TrieNode();

            // Iterate through the distionary and add them to the trie
            for(String each:dictionary){
                insert(each);
            }

            String[] words = sentence.split("\\s+");
            StringBuilder output = new StringBuilder();

            // Now iterate through the sentence and replace the work if it is present in the dictionary
            for(String each:words){

                String actualWord = each;
                TrieNode cur = root;

                for(int i=0;i<actualWord.length();i++){

                    char c = actualWord.charAt(i);

                    if(cur.children[c-'a'] == null || cur.isEnd){
                        break;
                    }
                    cur = cur.children[c-'a'];
                }

                if(cur.isEnd){
                    output.append(cur.word);
                }
                else{
                    output.append(actualWord);
                }

                output.append(" ");

            }

            return output.deleteCharAt(output.length()-1).toString();

        }

        // To add in the trie
        public void insert(String word){

            TrieNode cur = root;

            for(int i=0;i<word.length();i++){

                char c = word.charAt(i);

                if(cur.children[c-'a'] == null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }

            cur.isEnd = true;
            cur.word = word;
        }
    }

    class TrieNode{

        TrieNode[] children;
        boolean isEnd;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }, String sentence) {

        root = new TrieNode();

        for(String each:dictionary){
            insert(each);
        }

        String[] words = sentence.split("\\s+");
        StringBuilder output = new StringBuilder();

        for(String each:words){

            String actualWord = each;
            TrieNode cur = root;

            for(int i=0;i<actualWord.length();i++){

                char c = actualWord.charAt(i);

                if(cur.children[c-'a'] == null || cur.isEnd){
                    break;
                }
                cur = cur.children[c-'a'];
            }

            if(cur.isEnd){
                output.append(cur.word);
            }
            else{
                output.append(actualWord);
            }

            output.append(" ");

        }

        return output.deleteCharAt(output.length()-1).toString();

    }

    public void insert(String word){

        TrieNode cur = root;

        for(int i=0;i<word.length();i++){

            char c = word.charAt(i);

            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }

        cur.isEnd = true;
        cur.word = word;
    }
}

class TrieNode{

    TrieNode[] children;
    boolean isEnd;
    String word;

    public TrieNode(){
        children = new TrieNode[26];
    }
}