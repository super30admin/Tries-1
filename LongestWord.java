// Time Complexity : The time complexity is O(sum of lengths of all the strings)
// Space Complexity : The space complexity is O(sum of lengths of all the strings)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    String output;
    Node root;

    public String longestWord(String[] words) {

        root = new Node();
        output = "";

        if(words == null || words.length == 0){
            return output;
        }

        // Insert eah word in the trie
        for(String each:words){
            insert(each);
        }

        // Traverse through the trie to find the longest word
        find(root);
        return output;

    }

    // Insert each word
    public void insert(String word){

        Node cur = root;
        int i=0;

        // Insert each character in the trie
        while(i < word.length()){

            char c = word.charAt(i);

            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new Node();
            }

            cur = cur.children[c - 'a'];
            i++;
        }

        cur.isEnd = true;
        cur.s = word;
    }

    public void find(Node node){

        if(node.s.length() > output.length()){
            output = node.s;
        }

        for(int i=0;i<26;i++){

            // If the character exists and it is the last character, then it has the chance to be the longest word
            if(node.children[i] != null){
                if(node.children[i].isEnd){
                    find(node.children[i]);
                }
            }
        }
    }
}

class Node{

    String s;
    boolean isEnd;
    Node[] children;

    public Node(){
        s="";
        children = new Node[26];
    }
}