class Solution {
    //TC: nk + mk
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public void insert(TrieNode root, String word){
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
        TrieNode root = new TrieNode();
        for(String str : dictionary ){
            insert(root,str);  //n*k
        }
        String [] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strArr.length; i++){  ////
            String word = strArr[i]; //k
            //if(i > 0)  result.append(" ");
            TrieNode curr = root;
            StringBuilder replacement = new StringBuilder();
            for(int k = 0; k < word.length(); k++){
                char c = word.charAt(k);
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                curr = curr.children[c-'a'];
                replacement.append(c);
            }
            
            if(curr.isEnd){
                result.append(replacement);
            }else{
                result.append(word);
            }
            result.append(" ");
        }

      

        return result.toString().trim();
    }
}