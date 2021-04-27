//Implement a TrieNode
//tc -O(m) m - length of the word
//sc - O(m)

class Problem1{
    public static void main(String[] args){
        Problem1 p = new Problem1();

        p.insert("apple");
        System.out.println(p.search("apple"));
        System.out.println(p.search("app"));
        System.out.println(p.startWith("app"));


    }
    private class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
        
    }
    TrieNode root = new TrieNode();
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0;i< word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    public boolean search(String word){
        TrieNode curr = root;
        for(int i = 0;i< word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];

        }
        return curr.isEnd;
    }
    public boolean startWith(String prefix){
        TrieNode curr = root;
        for(int i = 0;i< prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];

        }
        return true;


    }
}