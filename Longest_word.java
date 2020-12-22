class Solution {
    public String longestWord(String[] words) {
        Trie trie=new Trie();
        int index=0;
        
        for(String word : words){
            trie.insert(word);
            // index++;
        }
        
        return trie.dfs();
        
        
    }
    
    
    
}

class Node {
    
    boolean end;
    Node [] children;
    String word;
    public Node(){
        children= new Node[26];
    }
}


class Trie{
    Node root;

    public Trie(){
        root= new Node();
    }
    
    
    public void insert(String word){
        Node curr=root;
        
        for(int i=0;i<word.length();i++){
            char c =word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new Node();
            }
            curr=curr.children[c-'a'];
        }
        curr.end=true;
        curr.word=word;
        
    }
    
    
    public String dfs(){
        String ans="";
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node node =stack.pop();
            if(node.end==true|| node==root){
                if (node!=root){
                String word=node.word;
                if (word.length()>ans.length()||word.length()==ans.length() &&word.compareTo(ans)<0){
                    ans=word;
                }
                }
                
                for(Node child:node.children){
                    if (child!=null){
                        stack.push(child);
                    }
                }
                
                }

            
        }
                    return ans;
        
    }
    
}

