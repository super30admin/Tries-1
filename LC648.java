//Time Complexity :O(nk + ml)
//Space Complexity :O(ml)

class Solution {
    
    class TrieNode
    {
        boolean isEnd;
        TrieNode children[];
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.isEnd = true;
        
        return;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        
        for(String ele: dictionary)
        {
            insert(ele);
        }
        
        String split_str[] = sentence.split(" ");
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<split_str.length;i++)
        {
            String word = split_str[i];
            TrieNode curr = root;
            StringBuilder replacement = new StringBuilder();
            
            for(int j=0;j<word.length();j++)
            {
                char c = word.charAt(j);
                
                if(curr.isEnd || curr.children[c - 'a'] == null)
                {
                    break;
                }
                
                curr = curr.children[c - 'a'];
                
                replacement.append(c); 
            }
            
            if(curr.isEnd)
            {
                result.append(replacement);
            }
            else
            {
                result.append(word);
            }
            
            result.append(" ");
        }
        
        return result.toString().trim();
    }
}