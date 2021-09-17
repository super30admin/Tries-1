//Time Complexity: O(N)
//Space Complexity: O(N)


class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if(sentence == null || sentence.length() == 0){
            return sentence;
        }
        root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }
        String[] strArray = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< strArray.length; i++){
            if(i  > 0){
                sb.append(" ");
            }
            String word = strArray[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr  = curr.children[c - 'a'];
            }
            if(curr.isEnd){
                sb.append(replacement);
            }
            else{
                sb.append(word);
            }
        }
        return sb.toString();
    }
}