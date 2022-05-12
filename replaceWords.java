// TC  max dictionary length or sentence length 
// SC max dictionary length or sentence length 
class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode [] list;
        public TrieNode() {
            list = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode temp = root;
        for(int i=0; i < word.length();i++){
            int t = word.charAt(i) - 'a';
            if(temp.list[t] == null){
                temp.list[t] = new TrieNode();
            }
            temp = temp.list[t];
        }
        temp.isEnd = true; 
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(int j =0; j < dictionary.size(); j++){
            insert(dictionary.get(j));
        }
        String [] listSentence = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < listSentence.length; j++){
            String temp = listSentence[j];
            if(j > 0) result.append(" ");
            TrieNode temproot = root;
            StringBuilder tempresult = new StringBuilder();
            for(int i =0; i < temp.length(); i++){
                int t = temp.charAt(i) - 'a';
                if(temproot == null || temproot.isEnd == true) break;
                tempresult.append(temp.charAt(i));
                temproot = temproot.list[t];
            }
            if(temproot != null && temproot.isEnd == true) {
                result.append(tempresult);
            }
            else{
                result.append(temp);
            }
            
            
            
            
        }
        return result.toString(); 
        
        
    }
}
