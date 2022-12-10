// Time Complexity : O(n * l) + O(m * k)
//n-> length of dictionary, l-> avg length of words in dic
//m-> length of sentence, k-> avg length of sentence in dic
// Space Complexity : O(n * l) + O(m * k)
class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        
        public TrieNode(){
            children=new TrieNode[26];
            
        }
        
       
    }
    
    TrieNode root;
    
     private void insert(String word){
            TrieNode curr=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr=curr.children[ch-'a'];
            }
            curr.isEnd=true;
     }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary==null || dictionary.size()==0) return sentence;
        
        root= new TrieNode();
        for(String str:dictionary){
            insert(str);
        }
        
        String[] strArray=sentence.split(" ");
        StringBuilder result= new StringBuilder();
        
        for(int i=0;i<strArray.length;i++){
            
            if(i!=0){
                result.append(" ");
            }
            
            String word= strArray[i];
            StringBuilder currWord= new StringBuilder();
            TrieNode curr=root;
            
            for(int j=0;j<word.length();j++){
                char ch=word.charAt(j);
                if(curr.children[ch-'a']==null || curr.isEnd==true){
                    break;
                }
                currWord.append(ch);
                curr= curr.children[ch-'a'];
            }
            
            if(curr.isEnd){
               result.append(currWord); 
            }else{
               result.append(word);    
            }
        }
        return result.toString();
    }
}