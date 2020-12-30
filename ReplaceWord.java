/*Time Complexity : O(N*avg length of the word)
Space complexity : O(N*avg length of the word)
Idea : store all root words into the trie and split the words of the given sentence if the word prefic matches with
the root replace withe root else keep the same word.
*/
class Solution {
    class TrieNode{
        TrieNode[] childrens;
        String word;
        public TrieNode(){
            this.childrens = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.childrens[ch-'a'] == null){
                node.childrens[ch-'a'] = new TrieNode();
            }
            node = node.childrens[ch-'a'];
        }
        node.word = word;
    }
    public String searchRoot(String word)
    {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.childrens[ch-'a'] == null){
                return null;
            }
            if(node.childrens[ch-'a'].word != null){
                return node.childrens[ch-'a'].word;
            }
            node = node.childrens[ch-'a'];
        }
        return node.word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size()==0){
            return "";
        }
        for(String word : dictionary){
            insert(word);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            String rootW = searchRoot(word);
            if(rootW != null){
                sb.append(rootW);
                sb.append(" ");
            }else{
                sb.append(word);
                sb.append(" ");
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}