// Time complexity O(N) and space complexity O(1)
 class TrieNode {

        boolean isEnd;
        TrieNode[] alpha;
        public TrieNode(){
            this.alpha = new TrieNode[26];
        }
    }
class Trie {

    private TrieNode root;


    public Trie() {

        this.root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Character letter = word.charAt(i);

            if(curr.alpha[letter-'a']==null){
                curr.alpha[letter-'a'] = new TrieNode();
            }
            curr = curr.alpha[letter-'a'];
        }
        curr.isEnd = true;
        
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Character letter = word.charAt(i);
            if(curr.alpha[letter-'a']==null){
                return false;
            }
            curr = curr.alpha[letter-'a'];
        }

        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            Character letter = prefix.charAt(i);
            if(curr.alpha[letter-'a']==null){
                return false;
            }
            curr = curr.alpha[letter-'a'];
        }
        return true;
        
    }
}

//time complexity O(N) and space complexity O(1)
 class TrieNode {
        boolean isEnd;
        TrieNode[] characters;
        public TrieNode(){
            this.characters = new TrieNode[26];
        }
}

class Solution {
   
    private TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            if(curr.characters[c-'a']==null){
                curr.characters[c-'a'] = new TrieNode();
            }
            curr = curr.characters[c-'a'];
        }

        curr.isEnd = true;

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        //insert all the words in the TrieNode
        for(int i=0;i<dictionary.size();i++){
            String word = dictionary.get(i);
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for(int i=0;i<words.length;i++){
            String word = words[i];
            StringBuilder str = new StringBuilder();
            TrieNode curr = root;
            for(int j=0;j<word.length();j++){
                Character c = word.charAt(j);
                
                if(curr.characters[c-'a']==null || curr.isEnd){
                    break;
                }
                curr= curr.characters[c-'a'];    
                str.append(c);
            }
            if(curr.isEnd){
                res.append(str);
            }else{
                res.append(word);
            }
            if(i==words.length-1){
                
            }else{
                res.append(" ");
            }
        }

        return res.toString();
        
    }
}
