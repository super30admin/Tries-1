//TC - O(nL)
//SC -O(nL+mL) where n is no of words in dictionary and L being the avegare length of each word and as well the m being
// the no of words in sentence and L being the average length of each word.
import java.util.List;

public class ReplaceWords {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] ==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }
        String[] strArray = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<strArray.length;i++){
            if(i != 0){
                ans.append(" ");
            }
            String word = strArray[i];
            TrieNode curr = root;
            StringBuilder replacement = new StringBuilder();
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];

            }
            if(curr.isEnd){
                ans.append(replacement);
            }
            else{
                ans.append(word);
            }

        }
        return ans.toString();
    }
}
