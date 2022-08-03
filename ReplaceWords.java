class ReplaceWords {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
     // TC is O(l) where l is the length of word
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0; i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    // TC is O(n), length of sentence
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String str: dictionary){
            insert(str);
        }
        String[] list = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        int k = 0;
        for(String str: list){
            if(k!=0) result.append(" ");
            k++;
            TrieNode curr = root;
            boolean found = true;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< str.length();i++){
                char c = str.charAt(i);
                
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                sb.append(c);
                curr = curr.children[c-'a'];
            }
           if(curr.isEnd){
               result.append(sb);
           }else{
               result.append(str);
           }
                
        }
        return result.toString();
    }
}