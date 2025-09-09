

// Time Complexity: O(M * L + N * L) where M is the number of words in dictionary, N is number of words in sentence and L is the average word length

// Space Complexity: O(M * L + N * L) for tries and split array.

// We create a TrieNode class to represent each node in the Trie. 
// Each node contains an array of children nodes and a boolean flag to indicate if it marks the end of a word.  
// We insert all the words from the dictionary into the Trie.   
// We then split the sentence into words and for each word, we try to find the shortest prefix in the Trie.
// If we find a prefix that marks the end of a word in the Trie, we replace the word with that prefix.
// If no such prefix is found, we keep the original word.

class Solution {

    TrieNode root;
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        TrieNode(){
            this.children=new TrieNode[26];
        }
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root=new TrieNode();
        for(String word:dictionary)
            insert(word);
        StringBuilder result=new StringBuilder();
        String splitArr[]=sentence.split(" ");
        for(int i=0;i<splitArr.length;i++){
            String word=splitArr[i];
            if(i>0)
                result.append(" ");
            result.append(getShortWord(word));
        }
        return result.toString();
    }

    private String getShortWord(String word){
        TrieNode curr=root;
        StringBuilder sb=new StringBuilder();
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null||curr.isEnd)
                break;
            curr=curr.children[c-'a'];
            sb.append(c);
        }
        if(curr.isEnd)
            return sb.toString();
        return word;
    }
}