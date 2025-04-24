package week6;

public class TrieReplaceWords {

    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        String[] words = sentence.split(" ");

        //add dictionary
        for(String w : dictionary) {
            insert(w);
        }

        StringBuilder result = new StringBuilder();
        int i = words.length-1;
        for(String word: words) {
            result.append(findR(word));
            if(i > 0){
                result.append(" ");
            }
            i--;
        }
        return result.toString();
    }

    private void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    private String findR(String word) {
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                return word;
            } else {
                sb.append(c);
                if(curr.children[c-'a'].isEnd) {
                    return sb.toString();
                }
            }
            curr = curr.children[c-'a'];
        }
        return word;
    }
}
