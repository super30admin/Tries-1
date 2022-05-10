// Time Complexity : O(nk)+O(ml), where n is the size of dictionary and k is the average length of the words in the dictionary. and m is the number of words in the sentence and l is the average length of the words in the sentence.
// Space Complexity : O(nk)+O(ml) for inserting the charcters in trie and the splited array. where n is the size of dictionary and k is the average length of the words in the dictionary. and m is the number of words in the sentence and l is the average length of the words in the sentence.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i =0;i<word.length();i++){
            char c= word.charAt(i);
            if(curr.isEnd==true)
                break;
            if(curr.children[c-'a']==null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary==null || dictionary.size()==0) return sentence;
        root = new TrieNode();
        for(String s:dictionary){
            insert(s);
        }
        String [] split = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i =0;i<split.length;i++){
            if(i!=0)
                result.append(" ");
            String word = split[i];
            StringBuilder newString = new StringBuilder();
            TrieNode curr = root;
            for(int j =0;j<word.length();j++){
                char c= word.charAt(j);
                if(curr.children[c-'a']==null||curr.isEnd){
                    break;
                }
                newString.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd)
                result.append(newString);
            else
                result.append(word);
        }
        return result.toString();
    }
}