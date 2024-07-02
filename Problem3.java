import java.util.List;
// TC: O(N+M)
// SC: O(N)
public class Problem3 {
TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public void insert(String word){
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children[c-'a']==null){
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isEnd=true;
    }

    public String searchShortestString(String word){
        TrieNode current = root;
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            if(current.children[c -'a'] == null || current.isEnd){
                break;
            }else{
                current = current.children[c-'a'];
                sb.append(c);
            }
        }
        if(current.isEnd){
            return sb.toString();
        }else{
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        StringBuilder result = new StringBuilder();
        
        for (String s: dictionary){
            insert(s);
        }

        String[] stringArr = sentence.split(" ");
        for (int i=0;i<stringArr.length;i++){
            String s = stringArr[i];
            if(i>0) result.append(" ");
            result.append(searchShortestString(s));
        }
        return result.toString();
    }   
}
