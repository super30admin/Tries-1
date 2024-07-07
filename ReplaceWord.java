import java.util.List;

public class ReplaceWord {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert( String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary.isEmpty() || sentence == null) return null;
        root = new TrieNode();

        // insert all elements of dictionary into the trie.
        for(String word: dictionary){
            insert(word);
        }
        // iterate over the string. and build new string.
        String[] strArray = sentence.split(" ");
        StringBuilder answer = new StringBuilder();



        for(int i=0; i<strArray.length; i++){
            if(i !=0){
                answer.append(" ");
            }
            String word = strArray[i];
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a']==null ||curr.isEnd == true ){
                    break;
                }
                sb.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                answer.append(sb);
            }else{
                answer.append(word);
            }
        }
        return answer.toString();
    }
}
