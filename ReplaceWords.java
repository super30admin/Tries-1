// Time Complexity : O(nk + nl) 
//where n is the number of words in dictionary/sentence. 
//k and l is average number of characters in dictionary & sentence respectively
// Space Complexity : O(nk)

class Solution {
    class TreeNode{
        TreeNode[] children;
        boolean isEnd;
        
        public TreeNode(){
            children = new TreeNode[26];
        }
    }
    
    TreeNode root;
    
    public void insert(String word){
        TreeNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TreeNode();
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TreeNode();
        for(String word: dictionary){
            insert(word);
        }
        
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();       
        for(int i = 0; i < words.length; i++){
            if(i > 0)
                result.append(" ");
            String word = words[i];
            TreeNode cur = root;
            StringBuilder replacementWord = new StringBuilder();
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(cur.children[c - 'a'] == null || cur.isEnd == true)
                    break;
                cur = cur.children[c - 'a'];
                replacementWord.append(c);
            }
            if(cur.isEnd)
                result.append(replacementWord);
            else
                result.append(word);
        }
        
        return result.toString();
    }
}