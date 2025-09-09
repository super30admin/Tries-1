// Time Complexity: O(N * L) where N is the number of words and L is the average length of the words.
// Space Complexity: O(N * L) for storing the Trie. 

// We create a TrieNode class to represent each node in the Trie. 
// Each node contains an array of children nodes and a boolean flag to indicate if it marks the end of a word.  
// We insert all the words into the Trie.
// We then perform a depth-first search (DFS) on the Trie to find the longest word such that all its prefixes are also present in the Trie.     
// We maintain a StringBuilder to keep track of the current path and update the result whenever we find a longer valid word.
// If there are multiple longest words, we choose the lexicographically smallest one by exploring the children in alphabetical order.


class Solution {
    TrieNode root;
    String result;
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

    public String longestWord(String[] words) {
        this.root=new TrieNode();
        this.result="";
        for(String word:words)
            insert(word);
        dfs(root,new StringBuilder());
        return result;
    }
    private void dfs(TrieNode root,StringBuilder path){
        if(result.length()<path.length())
            result=path.toString();
        
        for(int i=0;i<26;i++){
            if(root.children[i]!=null&&root.children[i].isEnd){
                int l=path.length();

                path.append((char)(i+'a'));

                dfs(root.children[i],path);

                path.setLength(l);
            }
        }
    }
}

