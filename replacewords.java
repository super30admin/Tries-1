
time complexity: O(n)
space complexity: O(n)

class Solution {
    
    class Node {
        public boolean isLeaf = false;
        public HashMap<Character, Node> children = new HashMap<>();
    }
    class Trie {
        private Node root = new Node();
        public void add(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Node());
                }
                node = node.children.get(c);
                if (i == word.length() - 1) {
                    node.isLeaf = true;
                }
            }
        }
        private String shortestPrefix(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i ++) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    return word;
                }
                node = node.children.get(c);
                if (node.isLeaf == true) {
                    return word.substring(0, i + 1);
                }
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for (String str:dictionary) {
            t.add(str);
        }

        StringBuilder sb = new StringBuilder();
        String[] tokens = sentence.split(" ");
        for (int i = 0; i < tokens.length; i ++) {
            String token = tokens[i];
            // String res = shortestPrefix(t, token);
            String res = t.shortestPrefix(token);
            sb.append(" " + res);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
        
    }
}