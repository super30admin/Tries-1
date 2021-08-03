class TrieNode{

    boolean end;
    TrieNode[] children;

    public TrieNode()
    {
        children = new TrieNode[26];
    }
}

class Solution {

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();

        for(String word : dictionary)
        {
            insert(word);
        }

        String[] sen = sentence.split("\\s");
        StringBuilder ans = new StringBuilder();

        for(String word : sen)
        {
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;

            for(char c : word.toCharArray())
            {
                if(curr.children[c-'a'] == null || curr.end) break;
                sb.append(c);
                curr = curr.children[c-'a'];

            }

            if(curr.end)
            {
                 ans.append(sb.toString());
                 ans.append(" ");
            }
            else
            {
                ans.append(word);
                ans.append(" ");
            }
        }

        if(ans.charAt(ans.length()-1) == ' ') ans.deleteCharAt(ans.length()-1);
        return ans.toString();

    }

    public void insert(String word) {

        TrieNode curr = root;

        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();

            curr = curr.children[c-'a'];
        }

        curr.end = true;

    }
}
