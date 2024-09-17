/*

Passed All Test Cases 

Complexity: 
Time -> O(N) x O(M), N is length of array words and M is length of the largest word in words array 
Space-> O(N), where N is # of words in array words 

BFS approach 
*/ 
class Solution {
    
    class TrieNode {
      String word ; 
        TrieNode [] kid ; 
        TrieNode () {
            kid = new TrieNode[26] ; 
            this.word = null ; 
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
            char add = word.charAt(i) ;   
            if(curo.kid[add - 'a'] == null)
                curo.kid[add - 'a'] = new TrieNode() ; 
            curo = curo.kid[add - 'a'] ; 
        }
        curo.word = word ; 
    }
}
    public String longestWord(String[] words) {
        Trie tr = new Trie() ; 
            //adding all the words in the trie        
        for (String word : words) {
            tr.insert(word) ; 
        }
        Queue<TrieNode> q = new LinkedList<>() ;
        q.add(tr.root) ; 
        TrieNode add = null ; 
        while (!q.isEmpty()) {
         add = q.poll() ; 
            for (int i = 25 ; i >= 0 ; --i) {
                if(add.kid[i] != null && add.kid[i].word != null)
                    q.add(add.kid[i]) ; 
            }
        } 
        return add.word ; 
    }
}




/*

DFS Approach 

Passed All Test Cases

Complextiy 
Time -> O(N) x O(M), N is length of array words and M is length of the largest word in words array 
Space-> O(N), where N is # of words in array words 

*/


class TrieNode {
    TrieNode [] kid ; 
    int end ; 
    TrieNode() {
        this.kid = new TrieNode[26] ; 
        this.end = 0 ; 
    }
}

class Trie {
    TrieNode root ; 
    Trie() {
        this.root = new TrieNode() ; 
    }
    
    public void insert(String word, int index) {
        TrieNode current = root ; 
        for (int i = 0 ; i < word.length() ; ++i) {
            char add = word.charAt(i) ; 
            if(current.kid[add - 'a'] == null)
                current.kid[add - 'a'] = new TrieNode() ; 
            current = current.kid[add - 'a'] ; 
        }
        current.end = index ; 
    }
}
class Solution {
    public String longestWord(String[] words) {
        //intitialzing the trie 
        Trie tr = new Trie() ; 
        int index = 0 ; 
        //adding all the elements to trie 
        for (String word : words) {
            tr.insert(word, ++index) ; 
        }
        //doing dfs now 
        String ans = "";
        Stack<TrieNode> s = new Stack<>() ; 
        s.push(tr.root) ; 
        while (!s.isEmpty()) {
            TrieNode check = s.pop() ; 
            
            if(check.end > 0 || check == tr.root) {                
                if(check != tr.root) {
    String word = words[check.end - 1] ;
    if (word.length() > ans.length() ||
                            word.length() == ans.length() && word.compareTo(ans) < 0)  
                    ans = word ;
            }
                
                for(int i = 25 ; i >= 0 ; --i) {
                if(check.kid[i] != null)
                    s.push(check.kid[i]) ; 
                }
            }
        }
            
        return ans ; 
    }
}