// Time Complexity : O(M * L + N * L)
// Space Complexity : O(M * L + N * L)

class Solution {
    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for (String word: dictionary) {
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] splitStr = sentence.split(" ");

        for(int i = 0; i < splitStr.length; i++) {
            String word = splitStr[i];
            if(i > 0) result.append(" ");
            result.append(getShortVersion(word));
        }

        return result.toString();
    }

    private String getShortVersion(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null || curr.isEnd) {
                break;
            }
            curr = curr.children[ch - 'a'];
            sb.append(ch);
        }

        if(curr.isEnd) {
            return sb.toString();
        }

        return word;
    }
}