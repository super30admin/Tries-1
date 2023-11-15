// TC : O((r*l)+2s)  //r-no. of roots, l-length of each root, s=length of sentence
// SC : O(r*l + k)

package S30_Codes.Tries_1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ReplaceWords {
    class TrieNode{
        private boolean isWord;
        private Map<Character, TrieNode> children;
        TrieNode(){
            children = new HashMap<>();
        }

        public TrieNode createOrGetNode(char ch){
            if(!this.children.containsKey(ch))
                this.children.put(ch, new TrieNode());
            return this.children.get(ch);
        }

        public boolean getIsWord(){
            return this.isWord;
        }
        public void setIsWord(){
            this.isWord = true;
        }

        public Map<Character, TrieNode> getChildren(){
            return this.children;
        }
    }

    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;
            for(char ch: word.toCharArray()){
                node = node.createOrGetNode(ch);
            }
            node.setIsWord();
        }

        public String findShortestPrefix(String word){
            TrieNode node = root;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(!node.getChildren().containsKey(ch))
                    break;
                node = node.getChildren().get(ch);
                if(node.getIsWord())
                    return word.substring(0,i+1);
            }
            return null;
        }
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String word : dictionary){
            trie.insert(word);
        }

        String[] successor = sentence.split(" ");

        for(int i=0; i<successor.length;i++){
            String prefix = trie.findShortestPrefix(successor[i]);
            successor[i] = prefix==null ? successor[i] : prefix;
        }
        return String.join(" ", successor);
    }
}