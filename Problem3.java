/*

Passed All Test Cases 

Complexity: 
Time -> O(N) x O(M), where N is length of dictionary, and M is avg length of word in a dictionary
Space -> O(N), where N is # of nodes in a trie 

*/


class TrieNode {
    String word ; 
    TrieNode [] kid ; 
    TrieNode() {
        this.word = null ; 
        this.kid = new TrieNode[26] ; 
    }
}

class Trie {
    TrieNode root ; 
    Trie() {
        this.root = new TrieNode() ; 
    }
    
    public void insert(String word) {
        TrieNode curo = root ; 
        for (int i = 0 ; i < word.length() ; i++) {
            char check =  word.charAt(i) ; 
            if (curo.kid[check - 'a'] == null)
                curo.kid[check - 'a'] = new TrieNode() ; 
            
            curo = curo.kid[check - 'a'] ; 
        }
        curo.word = word ; 
    }
}

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie tr = new Trie() ; 
        for (String root : dict) {
            tr.insert(root) ; 
        }
        StringBuilder sb = new StringBuilder() ; 
        for (String word : sentence.split("\\s+")) {
            TrieNode cur = tr.root ; 
            
                if(sb.length() > 0)
                sb.append(" ") ; 
            
            for (int i = 0 ; i < word.length () ; i++) {
                char check = word.charAt(i) ; 
                if(cur.kid[check - 'a'] == null ||cur.word != null)
                    break ; 
                cur = cur.kid[check - 'a'] ; 
            }
            if(cur.word == null) 
                sb.append(word) ; 
            else
                sb.append(cur.word) ; 
        }
        return sb.toString() ; 
    }
} 