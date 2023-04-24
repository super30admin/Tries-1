import java.util.List;
//Leetcode - 648
//Time Complexity - O(NL + m*k) m -total no of words in sentence, n words in dictionary
//Space complexity for trie approach is better than HashSet
public class ReplaceWords {
    static class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            if(curr.isEnd) return;
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary) { //O(NL + m*k) m -total no of words in sentence, n words in dictionary
            insert(root, word);
        }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        for (String word : strArr) {
            StringBuilder replacementStr = new StringBuilder();
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) { //O(k), k length of word
                char c = word.charAt(j);
                if (curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                replacementStr.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd)
                result.append(replacementStr);
            else
                result.append(word);
            result.append(" ");
        }
        return result.toString().trim();
    }


    //HashSet solution
    /*
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        String [] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0; i<strArr.length; i++) {
            if(i>0) result.append(" ");
            String word = strArr[i];
            boolean flag = false;
            for(int j=0; j<word.length(); j++){
                String sub = word.substring(0, j+1);
                if(set.contains(sub)) {
                    result.append(sub);
                    flag = true;
                    break;
                }
            }
            if(!flag) result.append(word);
        }
        return result.toString();
    }
     */
}
