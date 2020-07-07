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