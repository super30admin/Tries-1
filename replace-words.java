// Time - O(N * p + M * p), N being the number of words in the dictionary, p being the per word length, M being the words in the sentence
// Space - O(N * p)

class Solution {
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        String word;
        
        public TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }
    
    TrieNode root;
     private void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] ==null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];    
        }
        curr.isEnd = true;
        curr.word = word;
    }  
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) {
            return sentence;
        }    
        
        root = new TrieNode();
        
        for(String word : dictionary) {
            insert(word);
        }
        
        String[] words = sentence.split("\\s+");
        
        TrieNode cur = root;
        for(int i=0;i<words.length;i++) {
            cur = root;
            for(int j=0;j<words[i].length();j++) {  
                char ch = words[i].charAt(j);

                if(cur.children[ch - 'a'] == null || cur.isEnd) {
                    break;

                }
                cur = cur.children[ch - 'a'];
            }

            if(cur.isEnd) {
                words[i] = cur.word;
            }
        }
        
        return String.join(" ", words);
    }
}
