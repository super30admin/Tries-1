//TC: (M+N) * l, N = number of words in dictionary,  M = number of words in sentence , l = avg length of the words
//SC: N * l, for making the trie
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No issues


// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    

    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }

        curr.isEnd = true;
    }

    private String search(TrieNode root, String word){
        TrieNode curr = root;

        StringBuilder str = new StringBuilder();

        for(char c : word.toCharArray()){
            
            if(curr.children[c-'a'] == null || curr.isEnd){ // we did not find the word or we found a a successor 
                break;
            }
            str.append(c); // form the word while traversing

            curr = curr.children[c-'a'];
        }

        return curr.isEnd ? str.toString() : word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        //TC : N * l, N = number of words in dictionary, l = avg length of the words
        //SC : N * l
        for(String word : dictionary){ 
            insert(root, word);
        }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        int i = 0;
        //TC : M * l, M = number of words in sentence, l = avg length of the words
        for(String s : strArr){
            if(i != 0){
                result.append(" ");
            }
            result.append(search(root,s));
            i++;
        }

        return result.toString();
 
    }
}

// HashSet solution
//TC: (M +N ) * (l*l), 
//SC: N * l, for making the hashset
// Approach: We will create all substrings of the word and check if it exists in Set. 

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary); // TC: N*l
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");

        for(int i = 0; i < strArr.length ; i++){ // TC: M*(l*l)
            if(i != 0){
                result.append(" ");
            }
            String word = strArr[i];
            boolean flag = false;
            for(int j = 0; j < word.length() ; j++){
                String currSub = word.substring(0,j+1);
                if(set.contains(currSub)){
                    result.append(currSub);
                    flag = true;
                    break;
                }
            }

            if(!flag){
               result.append(word); 
            }
        }

        return result.toString();

    }
}