// Time Complexity : o(l) where l is the length of word being inserted, serached or length of prefix
// Space Complexity : o(n *l) whre is n is number of words and l is average length of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach, create TrieNode and perform operations in iterative fashion

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            if(curr.map.get(ch) != null){
                curr = curr.map.get(ch);
            }
            else{
                TrieNode temp = new TrieNode();
                curr.map.put(ch,temp);
                curr = temp;
            }
        }

        curr.end = true;

    }

    public boolean search(String word) {

        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            if(curr.map.get(ch) != null){
                curr = curr.map.get(ch);
            }
            else{
                return false;
            }
        }

       return curr.end;

    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        for(char ch : prefix.toCharArray()){
            if(curr.map.get(ch) != null){
                curr = curr.map.get(ch);
            }
            else{
                return false;
            }
        }
        return true;
    }
}

class TrieNode{

   public Map<Character, TrieNode> map;
   public boolean end;

    public TrieNode(){
        map = new HashMap<>();
        end = false;
    }
}
