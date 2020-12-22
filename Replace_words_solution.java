class Solution {
        class Node{
            boolean end;
            Node [] children;
            
            public Node(){
                children=new Node[26];
            }
            
        }
        
        Node root;
        
        
        public void addTree(String word){
            Node curr=root;
            for(int i =0;i<word.length(); i++){
                char c=word.charAt(i);
                if (curr.children[c-'a']==null){
                    curr.children[c-'a']=new Node();
                    
                }
                curr=curr.children[c-'a'];
            }
            curr.end=true;
        }
        

        
        
        
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
         root=new Node();
        
        for(String word:dictionary){
            addTree(word);
        }
        StringBuilder result=new StringBuilder();
        String [] split=sentence.split("\\s+");
        
        Node cur;
        for (int i =0;i<split.length;i++){
            if (i>0){
                result.append(" ");
            }
            String temp=split[i];
            cur=root;
            
            StringBuilder replace=new StringBuilder();
            
            for(int k=0;k<temp.length();k++){
                char c= temp.charAt(k);
                if (cur.children[c-'a']==null || cur.end){
                    break;   // we do not have a complete word
                }else{
                    replace.append(c);
                    cur=cur.children[c-'a'];
                }
            }
            if (cur.end){
                result.append(replace.toString());
            }else{
                result.append(temp);
            }
        }
        
        return result.toString();
}
    
}
