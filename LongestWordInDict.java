class Solution {
    public class Node {
        Node[] arr;
        boolean isWord;  
        Node() {
           arr = new Node[26];
           isWord = false; 
        }
    }
    
    public String longestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        
        Node root = new Node();
        for (String str : words) {
            Node trackNode = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (trackNode.arr[c - 'a'] == null) {
                    trackNode.arr[c - 'a'] = new Node();
                }
                trackNode = trackNode.arr[c - 'a'];
            }
            trackNode.isWord = true;  
        }
        
        String longest = "";
        for (String str : words) {
            if (canBeBuilt(str, root)) {
                if (str.length() > longest.length() || 
                    (str.length() == longest.length() && str.compareTo(longest) < 0)) {
                    longest = str;
                }
            }
        }
        
        return longest;
    }
    
    private boolean canBeBuilt(String word, Node root) {
        Node current = root;
        for (char c : word.toCharArray()) {
            current = current.arr[c - 'a'];
            // If any prefix is not a word, return false
            if (current == null || !current.isWord) {
                return false;
            }
        }
        return true;
    }

