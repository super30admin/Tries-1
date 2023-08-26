import java.util.List;

class ReplaceWords {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word : dictionary) {
            insert(word);
        }
        StringBuilder replaceSentence=new StringBuilder();
        String[] words=sentence.split(" ");
        for(String word: words){
            TrieNode curr=root;
            StringBuilder replacementWord=new StringBuilder();
            for(int i=0; i<word.length();i++){
                char c=word.charAt(i);
                if(curr.isEnd ||curr.children[c - 'a']==null){
                    break;
                }
                curr=curr.children[c - 'a'];
                replacementWord.append(c);
            }
            if(!curr.isEnd){
                replaceSentence.append(word);
            }else{
                replaceSentence.append(replacementWord.toString());

            }
            replaceSentence.append(" ");
        }
        return replaceSentence.toString().trim();
    }
}
