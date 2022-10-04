class Solution {
    //tc - nk+ml where n no of word in the dict with avg length k. With m words in sentence with avg l
  class TrieNode
    {
        TrieNode[] children;
        boolean isEnd;
        
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
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            
                curr = curr.children[c-'a'];
            
        }
        curr.isEnd = true;
        
    }
      
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String s : dictionary)
        {
            insert(s);
        }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
       
        for(int k=0;k<strArr.length;k++)
        {
            StringBuilder replacement = new StringBuilder();
            String word = strArr[k];
             TrieNode curr = root;
            for(int i=0;i<word.length();i++)
            {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd == true)
                {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd)
            {
                //replacement string found
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