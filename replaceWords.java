//TC - O(nl + mk)
//SC - O(nl)
//where 
// n - is number of words in the dictionary
// l - average length of word in dictionary
// m - number of words in sentence
// k - average length of words in sentence
class Solution {
    
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
       StringBuilder res= new StringBuilder();
        
        String [] arr = sentence.split(" ");
        
        for( String each : dictionary){
            insert(each);
        }
        
        for(int j=0;j<arr.length;j++){
            if(j!=0){
                res.append(" ");
            }
            TrieNode curr = root;
            String str = arr[j];
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                //temp = temp + ch;
                if(curr.children[ch-'a']==null || curr.isEnd){
                    break;
                }
                sb.append(ch);
                
                curr = curr.children[ch-'a'];
            }
            if(curr.isEnd){
                res.append(sb.toString());
            }
            else{
                res.append(str);
            }
        }
        
        return res.toString();
    }
}