class Solution 
{
    TrieNode start = new TrieNode();
    
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        for(String word: dictionary)
            insert(word);
        
        String inputs [] = sentence.split(" ");
        
        for(int i = 0; i< inputs.length; i++)
        {
            char inputArray[] = inputs[i].toCharArray();
            
            int inputLength = inputArray.length;
            String input = "";
            
            for(int j = 0; j < inputLength; j++)
            {
                input = input + inputArray[j];
                boolean isPresent = contains(input);
                
                if(isPresent)
                {
                    inputs[i] = input;
                    break;
                }
            }
        }
        
        return String.join(" ", inputs);
        
    }
    
    private boolean contains(String word)
    {
        int length = word.length();
        TrieNode current = start;
        
        for(int i =0; i< length; i++)
        {
            int index = word.charAt(i) - 'a';
            
            if(current.children[index] == null)
                return false;
            
            current = current.children[index];
        }
        
        return current.isEnd;
    }
    
    private void insert(String word)
    {
        int length = word.length();
        TrieNode current = start;
        
        for(int i =0; i< length; i++)
        {
            int index = word.charAt(i) - 'a';
            
            if(current.children[index] == null)
                current.children[index] = new TrieNode();
            
            current = current.children[index];
        }
        
        current.isEnd = true;
    }
}
class TrieNode
{
    public TrieNode children[] = new TrieNode[26];
    public boolean isEnd;
    
    public TrieNode(){};
}