//Time: O(n*l + m*k)
// Space: O(n*l + m*k)
class Solution {
    
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }    
    }
    
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        if(dictionary == null || dictionary.size() == 0)
            return "";
        for(String word: dictionary){
            insert(word);
        }
        String[] strArray = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < strArray.length; i++){
            if(i != 0)
                result.append(" ");
            String word = strArray[i];
            StringBuilder currsb = new StringBuilder();
            TrieNode curr = root;
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                
                if(curr.children[c - 'a'] == null || curr.isEnd)
                    break;
                currsb.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd){
                result.append(currsb.toString());
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
}
