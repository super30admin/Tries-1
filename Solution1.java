//Time Complexity: o(mn)
//space: o(mn) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
class Solution {
    class Trie{
        boolean end;
        Trie[] child;
        public Trie(){
            child = new Trie[26];
        }
    }
    Trie root;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        StringBuilder res = new StringBuilder();
        StringBuilder newstr;
        if (dictionary == null || sentence.length() == 0) return res.toString();
        for(String str: dictionary)
        {
            Insert(str);
        }
        String[] words = sentence.split("\\s+");
        for(int i = 0; i<words.length; i++)
        {
            if(i>0)
            {
                res.append(' ');
            }
            newstr = new StringBuilder();
            String s = words[i];
            Trie curr = root;
            for(int j =0; j<s.length(); j++)
            {
                char c = s.charAt(j);
                if(curr.child[c-'a'] == null || curr.end == true) break;
                newstr.append(c);
                curr = curr.child[c-'a'];
            }
            if(curr.end)
            {
                res.append(newstr);
            }
            else
                res.append(s);
        }
        
        return res.toString();
        
    }
    private void Insert(String word)
    {
        Trie curr = root;
        for(int i = 0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.child[c-'a'] == null)
            {
                curr.child[c-'a'] = new Trie();
            }
            curr = curr.child[c-'a'];
        }
        curr.end = true;
    }
}