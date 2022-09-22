// Time Complexity : O(Nk)
// Space Complexity : O(Nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Form the trie. Loop through each word in sentence, if the words root is present in trie replace it
*/
public class ReplaceWords {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children= new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary==null || dictionary.size()==0 || sentence.length()==0) return sentence;

        //construct the trie node
        TrieNode root= new TrieNode();
        for(String entry: dictionary){
            TrieNode curr=root;
            for(char ch: entry.toCharArray()){
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']= new TrieNode();
                }
                curr=curr.children[ch-'a'];
            }
            curr.isEnd=true;
        }

        String[] words= sentence.split(" ");
        StringBuilder result= new StringBuilder();
        for(int i=0;i<words.length;i++){
            if(i!=0) result.append(" ");
            TrieNode curr=root;
            StringBuilder newString= new StringBuilder();

            for(char ch: words[i].toCharArray()){
                if(curr.children[ch-'a']==null || curr.isEnd){
                    break;
                }
                newString.append(ch);
                curr=curr.children[ch-'a'];
            }

            if(curr.isEnd){
                result.append(newString);
            }else{
                result.append(words[i]);
            }
        }

        return result.toString();
    }
}
