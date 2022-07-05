import java.util.List;
//Time Complexity: O(N)where N is the length of the sentence
//Space Complexity: O(n), the size of trie
public class ReplaceWords {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String str: dictionary){
            insert(str);
        }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        for(int k=0; k < strArr.length; k++){
            String word = strArr[k];
            if(k !=0)result.append(" ");
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
}
