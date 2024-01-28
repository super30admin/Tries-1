
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode []children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    public void insert(TrieNode root,String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String str : dictionary){
            insert(root,str);
        }
        String [] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< strArr.length;i++)
        {
            String word = strArr[i];
            if(i > 0){
                result.append(" ");

            }
            TrieNode curr = root;
            StringBuilder replacementStr = new StringBuilder();

            for(int k = 0; k < word.length();k++){
                char c = word.charAt(k);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                curr = curr.children[c-'a'];
                replacementStr.append(c);
            }

            if(curr.isEnd){
                result.append(replacementStr);
            }
            else{
                result.append(word);
            }
           
        }


        return result.toString().trim();


    }


}