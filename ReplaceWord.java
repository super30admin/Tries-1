//Time Complexity: O(ml + nk)
//Space Complexity: O(ml + nk)

class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] child;

        public TrieNode(){
            this.child = new TrieNode[26];
        }
    }

    public void insert(String word, TrieNode root) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.child[c-'a'] == null){
                curr.child[c-'a'] = new TrieNode();
            }
            curr = curr.child[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word: dictionary){
            insert(word, root);
        }
        StringBuilder result = new StringBuilder();
        String[] split = sentence.split(" ");
        for(int i = 0; i < split.length; i++){
            String currWord = split[i];
            if(i>0) result.append(" ");
            StringBuilder reps = new StringBuilder();
            TrieNode curr = root;
            for(int j = 0; j < currWord.length(); j++){
                char c = currWord.charAt(j);
                if(curr.child[c-'a'] == null || curr.isEnd) break;
                curr = curr.child[c-'a'];
                reps.append(c);
            }
            if(curr.isEnd){
                result.append(reps);
            }else{
                result.append(currWord);
            }
        }
        return result.toString();
    }
}