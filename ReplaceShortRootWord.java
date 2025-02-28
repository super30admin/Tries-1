class ReplaceShortRootWord {
    class TrieNode
   {
       TrieNode[] children;
       boolean isEnd;
       TrieNode() {
           children = new TrieNode[26]; 
           isEnd = false; 
       }
   }
   public void insert(String word) {
       TrieNode curr = root;
       for(int i=0;i<word.length();i++)
       {
           char ch =word.charAt(i);
           if(curr.children[ch-'a'] == null)
           {
               curr.children[ch-'a'] = new TrieNode();
           }
           curr = curr.children[ch-'a'];

       }
       curr.isEnd = true;
   }
   private TrieNode root;
   public String replaceWords(List<String> dictionary, String sentence) {
       this.root = new TrieNode();
       for(String word: dictionary)// n*l
       {
           insert(word);
       }
       String [] strarr = sentence.split(" ");
       StringBuilder result = new StringBuilder();
       for(int i=0;i<strarr.length;i++)
       {
           String curword = strarr[i];

           //search for the smaller prefix
           TrieNode cur = root;
            StringBuilder replacementString = new StringBuilder();
           for(int j=0;j<curword.length();j++)
           {
               char ch = curword.charAt(j);
               if( cur.children[ch-'a'] == null || cur.isEnd)
               break;
               replacementString.append(ch);
               cur = cur.children[ch-'a'];
           }
           if(cur.isEnd){
               //we found the smaller prefix
               result.append(replacementString.toString()).append(" ");
           }
           else{
               result.append(curword).append(" ");
           }
       }
        return result.toString().trim();
   }
  
}

//Time Complexity: O((n+m)×l)

//Space Complexity: O(n×l)
//Where:
//n is the number of words in the dictionary.
//m is the number of words in the sentence.
//l is the average length of the words in both the dictionary and the sentence.