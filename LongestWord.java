// This solution trie to store all the words. Later we traverse or dfs to find the longest word with all the sub strings as valid. 
class Solution {
    Trie root;
    String response = new String("");
    public String longestWord(String[] words) {
        root = new Trie();
        for(String word:words) {
            addWord(word);
        }
        getLongestWord(root, new StringBuilder(""));
        return response;
    }

    private void addWord(String word) {
        Trie curr = root;
        for(char c:word.toCharArray()) {
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    private void getLongestWord(Trie root, StringBuilder s) {
        if(s.length()>response.length()) {
            response = s.toString();
        }
        for(int i=0;i<26;i++) {
            if(root.children[i]!=null && root.children[i].isEnd) {
                s.append((char)(i+'a'));
                getLongestWord(root.children[i], s);
                s.deleteCharAt(s.length()-1);
            }
        }
    }   
}

class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
    }

}
