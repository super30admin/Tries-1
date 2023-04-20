/*
    Time Complexity - O(n) n steps to insert all words in dictionary to trie. n is the sum of length of words in dictionary. 
    Space complexity - O(n)
*/
class Solution {
    TrieNode trieNode = null;
    static class TrieNode{

        int size = 26;
        TrieNode[] child = null;
        boolean isEnd;

        protected TrieNode(){
            this.child = new TrieNode[size];
            this.isEnd = false;
        }

        protected boolean getEnd(){
            return this.isEnd;
        }

        protected void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }

        protected boolean containsKey(char ch){
            return this.child[ch - 'a'] != null;
        }

        protected TrieNode getKey(char ch){
            return this.child[ch - 'a'];
        }

        protected void setKey(char ch, TrieNode link){
            this.child[ch - 'a'] = link;
        }
    }
    public void insert(String word) {
        if(word == null || word.length() == 0)
            return;
        int len = word.length();
        TrieNode ptr = trieNode;
        for(int i = 0; i < len; i++){
            char ch = word.charAt(i);
            if(!ptr.containsKey(ch))
                ptr.setKey(ch, new TrieNode());
            ptr = ptr.getKey(ch);            
        }
        ptr.setEnd(true);
    }
    public Solution() {
        trieNode = new TrieNode();
    }

    public String find(String word) {
        if(word == null || word.length() == 0)
            return word;
            
        int len = word.length();
        TrieNode ptr = trieNode;
        for(int i = 0; i < len; i++){
            char ch = word.charAt(i);
            if(ptr.getEnd())
                return word.substring(0, i);
            if(!ptr.containsKey(ch))
                return word;
            ptr = ptr.getKey(ch);            
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0)
            return sentence;
        
        for(String s : dictionary)
            insert(s);

        StringBuilder result = new StringBuilder();

        for(String word : sentence.split("\\s+")) 
            result.append(find(word) + " ");

        return result.toString().trim();
    }
}
