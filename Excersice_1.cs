public class Node {
    public Node[] children = new Node[26];
    public bool IsEnd;

  
}

public class Trie {
    public Node root;
    public Trie() {
        root = new Node();
    }
    
    public void Insert(string word) {
        Node curr = root;
        for(int i = 0; i<word.Length ; i++){
            int idx = word[i] - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
            curr.IsEnd = true;
    }
    
    public bool Search(string word) {
        Node curr = root;
        for(int i = 0;i<word.Length; i++){
            int idx = word[i] - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.IsEnd;
    }
    
    public bool StartsWith(string prefix) {
        Node curr = root;
        for(int i = 0 ;i<prefix.Length ; i++){
            int idx = prefix[i] - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return  true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */