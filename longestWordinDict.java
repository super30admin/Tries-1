// Time Complexity : O(N sub(l)), l is the length of each word in the trie
// Space Complexity : O(N sub(l)), l is the length of each word in the trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class longestWordinDict {
    class Trie {
        class Node {
            char ch;
            Node[] children = new Node[26];
            boolean isWord = false;
            
            public Node (char c) {
                ch = c;
                isWord = false;
            }
        }
        
        Node root;
        int len;
        String maxWord;
        
        public Trie() {
            root = new Node('\0');
            len = 0;
            maxWord = "";
        }
        
        public void insert(String s) {
            Node curr = root; 
            boolean flag = true;
            
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if (curr.children[c-'a']!=null) {
                    if(!curr.children[c-'a'].isWord) {
                        flag = false;
                    }
                    curr = curr.children[c-'a'];
                } else {
                    if(i!=s.length()-1) {
                        flag = false;
                    }
                    curr.children[c-'a'] = new Node(c);
                    curr = curr.children[c-'a'];
                }
            }
            curr.isWord = true;
            
            if (flag) {
                if (s.length()>len) {
                    len = s.length();
                    maxWord = s;
                } else if (s.length()==len) {
                    if(s.compareTo(maxWord) < 0)
                        maxWord = s;
                }
            }
        }
    }
    
    public String longestWord(String[] words) {

        Trie trie = new Trie();
        Arrays.sort(words);
        for(String s: words){
            trie.insert(s);
        }
        return trie.maxWord;
    }
}
