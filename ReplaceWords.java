/**
Time Complexity : O(height of the trie)
Space Complexity : O(N*M)
LeetCode Submitted : Yes
Approach: Store the dictionary in the Trie. Iterate over the words in the sentence. If the word is in dictionary stop searching and returnthe first word in dictionary.
**/

class Solution {

    class Trie {
        class Node{
            Node[] children = new Node[26];
            String value;
            public Node(){

            }
        }

        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node temp = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                //System.out.println(c-'a');
                if(temp.children[c - 'a'] == null)
                    temp.children[c - 'a'] =  new Node();

                //temp.children[c - 'a'].value =  1;
                temp = temp.children[c - 'a'];
            }
            temp.value = word;
        }

        /** Returns if the word is in the trie. */
        public String search(String word) {
            Node temp = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(temp.children[c - 'a'] != null)
                {
                    if(temp.children[c - 'a'].value != null)
                        return temp.children[c - 'a'].value;
                    temp = temp.children[c - 'a'];   
                }else
                    return word;
            }
            return word;
        }

        public String replaceWords(String sentence){
            Node node = root;
            StringBuffer output = new StringBuffer();

            String[] words =  sentence.split(" ");
            int l =  words.length - 1;
            for(String word : words){
                String result = search(word);
                output.append(result);
                if(l > 0)
                    {
                        output.append(" ");
                        l--;
                    }
                }

            return output.toString();
        }

    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie obj = new Trie();
        for(String word : dict)
            obj.insert(word);

        return obj.replaceWords(sentence);
    }
}