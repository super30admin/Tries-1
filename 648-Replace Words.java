//Time complexity=O(M*N)( where M=Words in string and N = words in the dictionary)
//Space complexity=O(N) (Length of sentence)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    class TrieNode{
        String word;
        TrieNode [] children;
        public TrieNode()
        {
            children =new TrieNode [26];
        }
    }
    TrieNode root;
   
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0 ; i<word.length() ;i++)
        {
            char c=word.charAt(i);
            if(curr.children[ c - 'a'] ==null)// Checks whether the character in the TrieNode
                curr.children[c - 'a']=new TrieNode(); // If not then add a new TrieNode in it. 
            curr=curr.children[c - 'a']; //Go to next node
        }
        curr.word=word; //We are storing the word that we added at its last character is added to Trie
    }

    public String replaceWords(List<String> dict, String sentence) {
        root=new TrieNode();
        for(int i=0;i<dict.size();i++)
        {
            insert(dict.get(i)); // Inserting all the elements in Trie in the dictionary
        }
        StringBuilder sb=new StringBuilder();
        String []sentenceArr=sentence.split("\\s+"); //Spliting the stirng at space and adding the elements to sentence array 
        for(int i=0;i<sentenceArr.length;i++)
        {
            String sw=sentenceArr[i];
            TrieNode curr=root;
            if(i>0) sb.append(" "); //Adding space after each element
            for(int j=0; j < sw.length();j++)
            {
                char c=sw.charAt(j);
                if(curr.children[ c-'a']==null || curr.word!=null)
                    break;
                curr=curr.children[c - 'a'];
            }
            String replace;
            if(curr.word==null)
                replace=sw;
            else
                replace=curr.word;
            sb.append(replace);
        }
        return sb.toString();
    }
}