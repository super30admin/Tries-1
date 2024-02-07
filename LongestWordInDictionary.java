class Solution {

    class Node{
        Node links[]= new Node[26];
        boolean flag= false;
    }

    Node root= new Node();

    public void insert(String words){
        Node node =root;
        for(char c : words.toCharArray()){
            int idx=c-'a';
            if(node.links[idx]==null){
                node.links[idx]= new Node();
            }
            node=node.links[idx];
        }
        node.flag=true;
    }
    

    public String longestWord(String[] words) {
        for(String word: words){
            insert(word);
        }
        String longestString="";
        for(String word: words){
            if(constructFromPrefix(word)){
                if(word.length() > longestString.length() || 
                   (word.length() == longestString.length() && word.compareTo(longestString) < 0)){
                    longestString=word;
                }
            }
        }
        return longestString;
    }

    public boolean constructFromPrefix(String word){
        Node node=root;
        for(char c : word.toCharArray()){
            int idx=c-'a';
            if(!node.links[idx].flag){
                return false;
            }
            node=node.links[idx];
        }
        return node.flag;
    }
}