//TC : O((no of words in dictionary * max length of a word) + (number of words in sentence + max length of the words))
// or O(nk+ml)
//SC : O(no of words in dictionary +  (number of words in sentence + max length of the words)) or O(n+ml)
class Solution {
    TrieNode root = new TrieNode();
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    public void insert(List<String> dictionary){
        TrieNode curr = root;
        for(String s : dictionary)
        {
            for(int i=0;i<s.length();i++)
            {
                char c = s.charAt(i);
                if(curr.children[c-'a']==null)
                {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
            curr = root;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        //creating a Trie
        insert(dictionary);
        StringBuilder sb = new StringBuilder();
        String[] sen = sentence.split(" ");
        for(String s : sen)
        {
            TrieNode curr = root;
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                char c = s.charAt(i);
                if(curr.children[c-'a']!=null)
                {
                    temp.append(c);
                    curr = curr.children[c-'a'];
                    if(curr.isEnd)
                        break;
                }
                else
                    break;
            }
            if(curr.isEnd)
                sb.append(temp);
            else
                sb.append(s);

            sb.append(" ");
        }

        return sb.toString().trim();
    }
}