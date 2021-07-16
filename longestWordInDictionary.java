// n is the number of words and k is the average length of each word
// Time Complexity: O(nk)  
//Space Complexity: O(nk)

class Solution {
    class TrieNode{
        String str;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.str = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        for(String word: words){
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i=25; i>=0; i--){
                if(curr.children[i] != null && curr.children[i].str != null){
                    q.add(curr.children[i]);
                }
            }
        }
        if(curr.str == null) return "";
        return curr.str;
    }
}

// n is the number of words and k is the average length of each word
// Time Complexity: O(nlogk)  
//Space Complexity: O(nk) 

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> builtWords = new HashSet<>();
        String result = "";
        for(String word: words){
            if(word.length() == 1 || builtWords.contains(word.substring(0,word.length() - 1))){
                if(word.length() > result.length()){
                    result = word;
                }
                builtWords.add(word);
            }
        }
        return result;
    }
}