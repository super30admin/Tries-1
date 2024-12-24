// Total time complexity is O((N+M)*l)
// Total space complexity is O((N+M)*l)

class Solution {
    class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
    }        
}


public void insert(TrieNode root, String word) { // O(l)
    TrieNode current = root;
    for(int i=0;i< word.length();i++) {
        int idx = word.charAt(i)- 'a';
        if(current.children[idx] == null) {
            current.children[idx] = new TrieNode();
        }
        current = current.children[idx];
    }
    current.isEnd = true;
}

public String replaceWords(List<String> dictionary, String sentence) {
    // N is the no. of words in the dictionary 
    // M is the no. of words in the sentence.
    // Total time complexity is O((N+M)*l)
    // Total space complexity is O((N+M)*l)
    TrieNode root = new TrieNode();
    StringBuilder result = new StringBuilder();
    for(String word: dictionary) {  // space complexity = N *l
        insert(root, word);
    }
    
    String[] words = sentence.split(" "); // space complexity = M *l
    for(String word: words) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(int j=0;j< word.length();j++) {
            int idx = word.charAt(j) - 'a';
            if(curr.children[idx] == null  || curr.isEnd) {
                break;
            }
            curr = curr.children[idx];
            sb.append(word.charAt(j));
        }
        if(curr.isEnd) {
            result.append(sb);
        } else {
            result.append(word);
        }
        result.append(" ");
    }
    return result.toString().trim();
}
}