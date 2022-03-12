// Time Complexity : o(n *l + W) where l is the length of word being inserted and W is the length of string
// Space Complexity : o(n *l) whre is n is number of words i dictionary and l is average length of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach, create TrieNode and perform operations in iterative fashion, at each step we need to check for root, if root found retrun root else whole word 

class Solution {

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();

        for(String word : dictionary){
            insert(word);
        }

        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");

        for(int i=0; i<arr.length; i++){
            String str = replace(arr[i]);
            if(str.length()>0)
                sb.append(str + " ");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }

    public void insert(String word){

        TrieNode curr = root;

        for(char ch : word.toCharArray()){

            TrieNode temp = curr.map[ch-'a'];

            if(temp == null){
                temp = new TrieNode();
            }

            curr.map[ch-'a'] = temp;
            curr = temp;
        }
        curr.end = true;
    }

    public String replace(String word){

        TrieNode curr = root;

        int i=0;

        while(!curr.end && i<word.length()){
            char ch = word.charAt(i);
            TrieNode temp = curr.map[ch-'a'];
            if(temp == null){
                break;
            }
            curr = temp;
            i++;
         }

        if(curr.end == false) return word;

        return word.substring(0,i);
    }
}

class TrieNode{

    TrieNode[] map;
    boolean end;

    public TrieNode(){
        map = new TrieNode[26];
        end = false;
    }

}
