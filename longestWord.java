/*
    Time Complexity - O(n) where n is the sum of length of words in dictionary.
    Space complexity - O(n)  
*/
class Solution {
    
    TrieNode trieNode = null;
    static class TrieNode {
        TrieNode[] child = null;
        boolean isEnd;
        String word;
        
        public TrieNode() {
            this.child = new TrieNode[26];
            this.isEnd = false;
        }
        
        public boolean getEnd() {
            return this.isEnd;
        }
        
        public void setEnd() {
            this.isEnd = true;
        }
        
        public void setWord(String word) {
            this.word = word;    
        }
        
        public String getWord() {
            return this.word;
        }
        
        public boolean containsKey(char ch){
            return this.child[ch - 'a'] != null;
        }
        
        public TrieNode get(char ch){
            return this.child[ch - 'a'];
        }
        
        public void put(char ch, TrieNode link){
            this.child[ch - 'a'] = link;
        }
    }
        
    public void insert(String word) {        
        TrieNode ptr = trieNode;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!ptr.containsKey(c))
                ptr.put(c, new TrieNode());
            ptr = ptr.get(c);
        }
        ptr.setEnd();
        ptr.setWord(word);
    }
    
    public String findLongestWord() {
        String result = "";
        Queue<TrieNode> wordStack = new LinkedList<>();
        wordStack.offer(trieNode);
        
        while(!wordStack.isEmpty()){
            int size = wordStack.size();
            for(int stackInd = 0; stackInd < size; stackInd++) {
                TrieNode ptr = wordStack.poll();
                //to get lexicograpcially smallest word.
                for(int childInd = 25; childInd >= 0; childInd--){
                    if(ptr.child[childInd] != null && ptr.child[childInd].getEnd()){
                        result = ptr.child[childInd].word;
                        wordStack.offer(ptr.child[childInd]);
                    }
                }
            }
        }
        return result;
    }
    
    public String longestWord(String[] words) {
        trieNode = new TrieNode();
        for(String word : words)
            insert(word);      
        return findLongestWord();
    }
}
