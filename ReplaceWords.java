class ReplaceWords {
    
    // Time Complexity: O(sum of length of each string in the arr) --> O(sum(len(s)))   (where s -> string in dictionary)
    // Space Complexity: O(sum(len(s)))
    
    class TrieNode{
        Map<Character, TrieNode> map;
        boolean isWord;
        char c;
        
        public TrieNode(char c){
            this.c = c;
            map = new HashMap<>();
            isWord = false;
        }
    }
    
    TrieNode root = new TrieNode('-');;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        // insert
        for(String word : dictionary){
            insert(word);            
        }
        
        // get words from sentence
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(String word : words){
            sb.append(getRoot(word));
            sb.append(" ");
        }
        
        // remove extra space
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
    
    private void insert(String word){
        TrieNode curr = root;
        
        for(char c : word.toCharArray()){
            if(!curr.map.containsKey(c)){
                curr.map.put(c, new TrieNode(c));
            }
            curr = curr.map.get(c);
        }
        curr.isWord = true;
    }
    
    private String getRoot(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            if(curr.map.containsKey(c)){
                curr = curr.map.get(c);
                sb.append(c);
                if(curr.isWord)
                    return sb.toString();
            }else
                break;
        }
        return word;
    }
}