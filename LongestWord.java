public class LongestWord {
    

    Trie root;
    class Trie{
        String word;
        Trie [] children;

        public Trie(){
            children = new Trie[26];
        }
    
    }

    //Trie insert method
    private void add_word(String word){
        Trie cur = root;
        for( int i =0; i < word.length() ; i++){
            char c = word.charAt(i);
            
            if(cur.children[c - 'a'] == null){
                cur.children [c - 'a'] = new Trie();
            }
            cur = cur.children[c -  'a'];
        }
        
        cur.word = word;
    }
    public String longestWord(String[] words) {
        root = new Trie();
        
       //add words in Trie for processing
        for(String word :  words){
            add_word(word);
        }
        
        // add root in queue 
        Queue<Trie> q = new LinkedList();
        q.add(root);
        Trie node = null;
        // while queue is not empty popped out trie node from queue
        // and if any children of popped out node is not null and it is word add to the queue
        // when queue become empty the last word is the lonest lexographically smallest word
        // for getting longest lexographically smallest word we are processing the children in //reverse order
        while(!q.isEmpty()){
            
            node  =  q.poll();
            Trie [] children = node.children;
            for(int i=25; i >=0; i--){
                if( children[i] != null && children[i].word != null){
                    q.add(children[i]);
                }
            }
        }
        
        return node.word;
    }
}

/*

// Longest word using prefix search

// for the longest word all of its prefix should be in dictionary 
// for that we will maintain set

public String longestWord(String[] words) {
        String res = "";
        
        Set<String> s = new HashSet();
        for(String word : words){
            s.add(word);
        }
        
        for(String word: words){
            if( word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0){
                boolean found = true;
                for( int k =1;k< word.length();k++){
                    if(!s.contains(word.substring(0,k))){
                        found = false;
                        break;
                    }
                }
                if(found){
                    res =  word;
                }
            }
        }
        return res;
    }

*/

/*




/*

Longest Word using DFS


class Solution {
    Trie root;
    class Trie{
        String word;
        Trie [] children;
        
        public Trie(){
            children = new Trie[26];
        }
        
    }
    
    
    private void add_word(String word){
        Trie cur = root;
        for( int i =0; i < word.length() ; i++){
            char c = word.charAt(i);
            
            if(cur.children[c - 'a'] == null){
                cur.children [c - 'a'] = new Trie();
            }
            cur = cur.children[c -  'a'];
        }
        
        cur.word = word;
    }
    public String longestWord(String[] words) {
        root = new Trie();
        
//       add words in Trie for processing
        for(String word :  words){
            add_word(word);
        }
        String res ="";
        Stack<Trie> st = new Stack();
        st.add(root);
        Trie node = null;
        while(!st.isEmpty()){
            
            node  =  st.pop();
            
            if(node.word != null){
                if(node.word.length() > res.length()){
                    res = node.word;
                }
                if(node.word.length() == res.length() && node.word.compareTo(res) < 0){
                    res = node.word;
                }
            }
            
            Trie [] children = node.children;
            for(int i=0; i < 26; i++){
                if( children[i] != null && children[i].word != null){
                    st.add(children[i]);
                }
            }
        }
        
        return res;
    }
}

*/