//time o(nk +lk) , n - no of words, k - avg length of word, l - length of sentence
//space o(1)
class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    
    private void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.word = word;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        for(String s: dict) {
            insert(s);
        }
        //converting sentence into words
        String[] arr = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            String word = arr[i];
            //space between words
            if(i>0)
                sb.append(" ");
            
            TrieNode curr = root;
            for(int k=0;k<word.length();k++) {
                char ch= word.charAt(k);
                if(curr.children[ch - 'a'] == null || curr.word != null)
                    break;
                curr = curr.children[ch-'a'];
            }
            
            if(curr.word == null) {
                sb.append(word);
            }
            else {
                sb.append(curr.word);
            }
        }
        return sb.toString();
    }
}