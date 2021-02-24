// Time Complexity :O(n)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        //System.out.println(Arrays.toString(words));
        HashSet<String> hash=new HashSet<>();
        StringBuilder str=new StringBuilder();
       for(int i=0;i<words.length;i++){
           if(words[i].length()==1){
               hash.add(words[i]);
               if(words[i].length()>str.length()){
                       str.delete(0,str.length());
                       str.append(words[i]);
                 }
           }else{
               String st=words[i].substring(0,words[i].length()-1);
               if(hash.contains(st)){
                   hash.add(words[i]);
                   if(words[i].length()>str.length()){
                       str.delete(0,str.length());
                       str.append(words[i]);
                   }
               }
           }
       }
        return str.toString();
    }
}

//
class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        TrieNode(){
            children=new TrieNode[26];
        }
    }
    
    TrieNode root;
    public String longestWord(String[] words) {
        root=new TrieNode();
        for(String st:words){
            insert(st);
        }
        Queue<TrieNode> qu=new LinkedList<>();
        qu.add(root);
        TrieNode curr=null;
        while(!qu.isEmpty()){
            curr=qu.remove();
            for(int i=25;i>=0;i--){
                if(curr.children[i]!=null &&curr.children[i].word!=null){
                    qu.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
    
    public void insert(String str){
        TrieNode curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.word=str;
    }
}