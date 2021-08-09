// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

import java.util.*;

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word: words){
            trie.insert(word, ++ index);
        }
        trie.words = words;
        return trie.dfs();
    }
}
    
    class Node {
        char c;
        HashMap<Character, Node> children = new HashMap();
        int end;
        public Node(char c){
            this.c = c;
        }
    }
    
    class Trie{
        Node root;
        String[] words;
        public Trie(){
            root = new Node('0');
        }
    
    public void insert(String word, int index){
        Node curr = root;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new Node(c));
            curr  = curr.children.get(c);
        }
        curr.end = index;
    }
    
    public String dfs(){
        String res = "";
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.empty()){
            Node node = stack.pop();
            if(node.end > 0 || node == root){
                if(node != root){
                    String word = words[node.end - 1];
                    if(word.length() > res.length() 
                      || word.length() == res.length() && word.compareTo(res) < 0){
                        res = word;
                    }
                }
                
                for(Node nei: node.children.values()){
                    stack.push(nei);
                }
            }
        }
        
        return res;
    }
}






