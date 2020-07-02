// Time Complexity : O(∑ length of words)
// Space Complexity : O(∑ length of words)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Trie & BFS

class replaceWords {
    
    Node root = new Node();
        
    class Node {
        Node[] children = new Node[26];
        String word;
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();    
            }
            curr = curr.children[c - 'a'];
        }    
        curr.word = word;
    }    
    
    public String replaceWords(List<String> dict, String sentence) {
        for (String str : dict) {
            insert(str);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null || curr.word != null) {
                    break;
                }
                curr = curr.children[c - 'a'];
            }
            String replacement = curr.word;
            if (replacement == null) {
                sb.append(word);
            } else {
                sb.append(replacement);
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}