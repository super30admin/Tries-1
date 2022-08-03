//Time Complexity: O(n*l) + O(m*k), where; n is the no. of words in the dictionary,
// l is the length of the words in the dictionary, m is the no. of words in the
//sentence, k is the length of words in the sentence.
//Space Complexity : O(n*l)
//Code run successfully on LeetCode.


public class Problem3 {

    class TrieNode{
        
        TrieNode[] children;
        boolean isWord;
        
        TrieNode(){
            
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    
    private void insert(String word){
        
        TrieNode curr = root;
        
        for(int i =0; i < word.length(); i++){
            
            char c = word.charAt(i);
            
            if(curr.children[c - 'a'] == null)
                curr.children[c- 'a'] = new TrieNode();
            
            curr = curr.children[c - 'a'];
            
        }
        curr.isWord = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        for(String word: dictionary){
            
            insert(word);
        }
        
        String[] str = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i =0; i < str.length; i++){
            
            if(i != 0)
                result.append(" ");
            
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            String word = str[i];
            
            for(int j =0; j < word.length(); j++){
                
                char c = word.charAt(j);
                
                if(curr.children[c - 'a'] == null || curr.isWord == true)
                    break;
                
                sb.append(c);
                curr = curr.children[c - 'a'];
            }
            
            if(curr.isWord == true)
                result.append(sb);
            
            else
                result.append(word);
        }
        return result.toString();
    }
}
