//Time Complexity:O(l) where l is the length of the words
//Space Complexity:O(l)
//In this problem, I'll be agin building a Trie data structure and use insert operation to insert all the elements in the words array into it. After that I'll be using dfs function to find the longest string lexicographically ordered. I'll be returning if I have found a longest string or I'll returning an empty string.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public String longestWord(String[] words) {
        Trie trie=new Trie();
        int index=0;
        for(String word:words){
            trie.insert(word,++index);
        }
        trie.words=words;
        return trie.dfs();
    }
}
    class Node{
        char c;
        HashMap<Character,Node> children=new HashMap();
        int end;
        public Node(char c){
            this.c=c;
        }
    }
    class Trie{
        String[] words;
        Node root;
        public Trie(){
            root=new Node('0');
        }
        public void insert(String word, int index){
            Node cur=root;
            for(char c:word.toCharArray()){
                cur.children.putIfAbsent(c,new Node(c));
                cur=cur.children.get(c);
            }
            cur.end=index;
        }
        public String dfs(){
            String ans="";
            Stack<Node> stack=new Stack();
            stack.push(root);
            while(!stack.empty()){
                Node temp=stack.pop();
                if(temp.end>0||temp==root){
                    if(temp!=root){
                        String word=words[temp.end-1];
                            if(word.length()>ans.length()||word.length()==ans.length()&&word.compareTo(ans)<0){
                            ans=word;
                        }
                    }
                    for(Node nei:temp.children.values()){
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }

