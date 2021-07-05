class ReplaceWords {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word)
    {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {   char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary)
        {
            insert(word);
        }
        String[] splitArr = sentence.split("\\s+"); //["the", "cattle"]
        StringBuilder result = new StringBuilder();
        for(int k=0;k<splitArr.length;k++)
        {
            String word = splitArr[k];
            if(k>0)
                result.append(" ");
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i=0;i<word.length();i++)
            {
                char c = word.charAt(i);
                if(curr.children[c-'a']==null || curr.isEnd)
                    break;
                curr = curr.children[c-'a'];
                replacement.append(c);
            }
            if(curr.isEnd) //found the smallest prefix
            {
                result.append(replacement);
            }
            else    //din't find
            {
                result.append(word);

            }
        }
        return result.toString();
    }
}


//time comp is O(nk)
//space comp is O(nk)