import java.util.List;

class ReplaceWords {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public void insert(TrieNode root,String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) {
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dictionary) {
            insert(root, word);
        }
        String[] arr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<arr.length;i++) {
            StringBuilder replacement = new StringBuilder();
            String currWord = arr[i];
            TrieNode current = root;
            for(int j=0;j<currWord.length();j++) {
                char c = currWord.charAt(j);
                if(current.children[c-'a'] == null || current.isEnd) {
                    break;
                }
                current = current.children[c-'a'];
                replacement.append(c);
            }
            if(current.isEnd) result.append(replacement); // we found the replacement
            else result.append(currWord);
            result.append(" ");
        }
        return result.toString().trim();
    }
}