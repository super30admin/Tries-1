class Solution {
    
    class TrieNode {
        
        boolean isEnd;
        TrieNode children[];
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
        
    }
    private void insert(String s, TrieNode root)
    {
        TrieNode curr= root;
        
        for(int i=0;i<s.length();i++)
        {
            if(curr.children[s.charAt(i)-'a']==null)
            {
                curr.children[s.charAt(i)-'a']= new TrieNode();
            }
            curr= curr.children[s.charAt(i)-'a'];
        }
        curr.isEnd = true;
        
    }
    
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        
        for(String s:dictionary)
        {
            insert(s,root);
        }
        
        String[] words= sentence.split(" ");
        StringBuilder res =new StringBuilder();
        int count=0;
        for(String s :words)
        {  
            StringBuilder replacement = new StringBuilder();
            TrieNode curr =root;
            for( int i =0 ; i<s.length();i++)
            {    
                if(curr.children[s.charAt(i)-'a']==null)
                    break;
                
                 if(curr.isEnd)
                {
                break;
                }
                replacement.append(s.charAt(i));
               
                curr = curr.children[s.charAt(i)-'a'];   
                
            }
            if(curr.isEnd)
            {
                if(count>0)
                {res.append(" "+replacement.toString());}
                else
                    res.append(replacement.toString());
                
                
            }
            else
            {
                if(count>0)
                {res.append(" "+s);}
                else
                    res.append(s);
            }

            count++;
            
        }
        
        return res.toString();
        
        
    }
}