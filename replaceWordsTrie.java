// Time Complexity: O(L) for both insert and search where L is on average number of characters in word, if we add many words => O(W*L)
// Space Complexity: This is an optimization of space Worst case is Length of key or O(num of words * Length of word * 26)
// Write your approach here
// Idea here is to use TrieNodes which have array of 26 as child characters
// Basic insersion code is bootstrapped
// Now we can split whole sentence into array of words and on each word
// we check if the characters are present in Trie we have constructed
// If at any point end is hit or Trie does not contain the character hierarchy
// loop is broken and based on end or absence of character either replacement is added
// to resultant string builder or the word itself
// otherwise replacement string is kept appended with characters until null is encountered.
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
             children = new TrieNode[26];
        }
    }

    TrieNode root;
    private void insert(String prefix) {
        TrieNode curr = root;
        for(int i=0; i< prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String st: dictionary) {
            insert(st);
        }
        StringBuilder sb = new StringBuilder();
        String[] spl = sentence.split(" ");
        
        for(int i=0; i<spl.length; i++) {
            if(i!=0) {
                sb.append(" ");
            }
            String word = spl[i];
            StringBuilder rep = new StringBuilder();
            TrieNode curr = root;
            for(int j=0; j<word.length(); j++) {
                char c = word.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd) break;
                rep.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                sb.append(rep);
            } else {
                sb.append(word);
            }
        }
        return sb.toString();
    }
}