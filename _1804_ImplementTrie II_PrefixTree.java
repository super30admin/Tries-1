// Time Complexity : o(l) where l is the length of word being inserted, serached or length of prefix
// Space Complexity : o(n *l) whre is n is number of words and l is average length of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach, create TrieNode and perform operations in recursive fashion

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        dfsInsert(root, word, 0);
    }

    public void dfsInsert(TrieNode root, String word, int index){

        if(index == word.length()){
            root.endWith +=1;
            return;
        }

        TrieNode curr = root.map.get(word.charAt(index));

        if(curr == null){
            curr = new TrieNode();
        }

        curr.end += 1;
        root.map.put(word.charAt(index), curr);

        dfsInsert(curr, word, index+1);
    }

    public int countWordsEqualTo(String word) {
        return dfsCountWordsEqualTo(root, word, 0);
    }

    public int dfsCountWordsEqualTo(TrieNode root, String word, int index){
        if(index == word.length()){
            return root.endWith;
        }

        TrieNode curr = root.map.get(word.charAt(index));

        if(curr == null){
            return 0;
        }
        else{
            return dfsCountWordsEqualTo(curr, word, index+1);
        }
    }

    public int countWordsStartingWith(String prefix) {
        return dfsCountWordsStartingWith(root, prefix, 0);
    }

    public int dfsCountWordsStartingWith(TrieNode root, String word, int index){
        if(index == word.length()){
            return root.end;
        }

        TrieNode curr = root.map.get(word.charAt(index));

        if(curr == null){
            return 0;
        }
        else{
            return dfsCountWordsStartingWith(curr, word, index+1);
        }
    }

    public void erase(String word) {
        if(countWordsEqualTo(word) == 0) return;
        dfsErase(root, word, 0);

    }
    public void dfsErase(TrieNode root, String word, int index ) {

        if(index == word.length()){
            root.endWith -= 1;
             return;
        }

        TrieNode curr = root.map.get(word.charAt(index));
        int count = curr.end;
        if(count == 1){
            root.map.remove(word.charAt(index));
        }
        else{
            curr.end -= 1;
        }
        dfsErase(curr, word, index+1);
    }
}

class TrieNode{

    public Map<Character, TrieNode> map;
    public int end;
    public int endWith;

    public TrieNode(){
        map = new HashMap<>();
        end = 0;
        endWith = 0;
    }
}
