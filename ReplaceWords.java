class Solution {

    class Node {
        Node[] children;
        String word;
        Node() {
            children = new Node[26];
            word = null;
        }
    }

    Node root = new Node();

    private void insertInTrie(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    private String containsRoot(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null || curr.word != null) {
                break;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.word == null ? "" : curr.word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder result = new StringBuilder();

        for(String word : dict) {
            insertInTrie(word);
        }

        String[] words = sentence.split("\\s+");
        for(String word : words) {
            String wordRoot = containsRoot(word);
            if(wordRoot.equals("")) {
                result.append(word);
            } else {
                result.append(wordRoot);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}