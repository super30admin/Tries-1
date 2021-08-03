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

    public String longestWord(String[] words)
    {

        root = new TrieNode();

        Arrays.sort(words);

        for(String word : words) insert(word);

        int max = Integer.MIN_VALUE;
        int sbmax = Integer.MIN_VALUE;
        String ans = "";

        for(String word : words)
        {
            int index = 1;

            while(index <= word.length())
            {
                if(search(word.substring(0,index)))
                {
                    if(word.substring(0,index).length() > max)
                    {
                        max = word.length();
                        ans = word;
                    }

                    index++;
                }
                else break;
            }
        }

        return ans;

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

    public boolean search(String word) {

        TrieNode curr = root;

        for(char c : word.toCharArray())
        {
            if(curr.children[c-'a'] == null) return false;

            curr = curr.children[c-'a'];
        }

        return curr.end;
    }


}
