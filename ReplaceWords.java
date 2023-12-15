//Time Complexity:max {O(n*L),O(m*L)} , n - number of root words, m - no of words in sentence, L - word length
//Space Complexity:max {O(n*L),O(m*L)}
//Tries approach
class Solution {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    private String searchRootWord(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null || curr.isEnd)
               break;
            curr = curr.children[c-'a'];
            sb.append(c);
        } 
        if (curr.isEnd)
            return sb.toString();
        else
            return word;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        //insert root words into dictionary
        for(String word:dictionary){
            insert(word);
        }
        //get words from sentence
        StringBuilder sb = new StringBuilder();
        String[] splitSent = sentence.split(" ");
        for(int i =0;i<splitSent.length;i++){
            if(i!=0) sb.append(' ');
            String wordSent = splitSent[i];
            sb.append(searchRootWord(wordSent));
        }
        return sb.toString();
    }
}