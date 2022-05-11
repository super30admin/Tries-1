class replaceWords1 {
    
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word) {
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
        if(dictionary == null || dictionary.size() == 0) return sentence;
        root = new TrieNode();
        StringBuilder result = new StringBuilder();
        
        for(String str : dictionary){
            insert(str);
        }
        
        String[] splitStr = sentence.split(" ");
        for(int i = 0; i < splitStr.length; i++){
            if(i != 0){
                result.append(" ");
            }
            StringBuilder newStr = new StringBuilder();
            String str = splitStr[i];
            TrieNode curr = root;
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                newStr.append(c);
                curr = curr.children[c - 'a'];
            }
            
            if(curr.isEnd){
                result.append(newStr);
            }
            else{
                result.append(str);
            }
        }
        return result.toString();
    }
}

//time complexity O(nk) + O(ml) n is number of words in dictionary with average length of K
// m is the length of split string array and l is average length of the string of split array 

//space complexity O(nk) + O(ml) nk is creating trie data structure of n number of words in dictionary with average
// length of K and ml is creating split Array, m is the length of split array and l is average length of the string in split array.

