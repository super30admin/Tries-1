class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i) - 'a'] == null){
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
    public boolean search(String word){
        TrieNode curr = root;
        for(int i =0;i<word.length();i++){
            if(curr.children[word.charAt(i) - 'a'] ==null) return false;
            curr = curr.children[word.charAt(i) - 'a'];
        }
        return curr.isEnd;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        StringBuilder replacement;
        TrieNode curr;
        String[] wordArray = sentence.split("\\s+");
        for(String word: wordArray){
            replacement = new StringBuilder();
            curr = root;
            for(int i=0;i<word.length();i++){
                if(curr.children[word.charAt(i) - 'a'] == null || curr.isEnd == true)
                    break;
                replacement.append(word.charAt(i));
                curr = curr.children[word.charAt(i) - 'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
                result.append(" ");
            }
            else{
                result.append(word);
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}
//Space complexity: O(M) size of the trie
//Time Complexity: O(N) N is the length of the sentence
