// Time Complexity : O(n*l) where n is no of words and l is avg length of words
// Space Complexity : O(nl) where n is no of words and l is avg length of words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class LongestWord {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    StringBuilder sb;
    StringBuilder maxstr;
    public String longestWord(String[] words){
        maxstr = new StringBuilder();
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return maxstr.toString();
    }

    private void backtrack(TrieNode curr, StringBuilder str){
        //base
        if(str.length() > maxstr.length()){
            maxstr = new StringBuilder(str);
        }

        //logic
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].isEnd){
                int l = str.length();

                str.append((char)(i+'a'));

                backtrack(curr.children[i], new StringBuilder(str));

                str.setLength(l);
            }
        }

    }

    public static void main(String [] args){
        LongestWord lw = new LongestWord();
        String [] words = new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        System.out.println(lw.longestWord(words));
    }
}