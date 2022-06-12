class Solution 
{
    TrieNode start = new TrieNode();
    int result = 0;
    
    
    public String longestWord(String[] words) 
    {
        String result = "";
        
        for(String word: words)
            insert(word);
        
        Arrays.sort(words);
        Arrays.sort(words, (a,b)-> b.length()-a.length());
         
        for(String word: words)
        {
            if(word.length() > result.length())
            {
                StringBuilder sb = new StringBuilder("");
                for(int i =0; i < word.length(); i++)
                {
                    sb.append(word.charAt(i));
                    String currentResult = search(sb.toString());
                
                    if(currentResult != null && currentResult.length() > result.length())
                        result = currentResult;
                } 
            }

        }
        
        return result;
        
        
    }
    
    private String search(String word)
    {
        TrieNode current = start;
        
        for(int i =0 ; i< word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(current.children[index].input == null)
                break;
            
            current = current.children[index];
        }
        
        return current.input;
    }
    
    private void insert(String word)
    {
        TrieNode current = start;
        
        for(int i =0 ; i< word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                current.children[index] = new TrieNode();
            
            current = current.children[index];
        }
        current.isEnd = true;
        current.input = word;
    }
    
    
}
class TrieNode
{
    public TrieNode children[] = new TrieNode[26];
    String input = null;
    public boolean isEnd = false;
    
    public TrieNode(){}
}