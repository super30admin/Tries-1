  //Time - O(m*l) + O(n*k)
    //space - O(n*k)
class Solution {
    
   class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    
    public void insert(String s){
        TrieNode curr = root;
        for(int i=0; i<s.length(); i++){
            if(curr.children[s.charAt(i) - 'a'] ==null){
                curr.children[s.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[s.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        for(String s : dictionary){
            insert(s);
        }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        for(int j =0 ; j< strArr.length; j++){
            StringBuilder replace = new StringBuilder();
            TrieNode curr = root;
            if(j>0) result.append(" ");
            for(int i=0 ; i< strArr[j].length(); i++)
            {
                char c = strArr[j].charAt(i);
                if(curr.children[c -'a'] == null || curr.isEnd) break;
                replace.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd) result.append(replace);
            else result.append(strArr[j]);
        }
        return result.toString();
    }
}