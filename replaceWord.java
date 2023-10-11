class Solution {
    class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
    }
    TrieNode root;
    private void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) {
            return sentence;
        }
        root = new TrieNode();
        for(String word : dictionary) {
            insert(word);

        }
        String[] strArray = sentence.split(" ");
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < strArray.length; i++){
            
        }

        for(int i = 0; i < strArray.length; i++) {
            if(i !=0) {
                answer.append(" ");
            }
            String word = strArray[i];
            StringBuilder replacementWord = new StringBuilder();
            TrieNode curr = root;
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                
                if(curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                replacementWord.append(c);
                curr = curr.children[c - 'a'];
            }
                if(curr.isEnd) {
                    answer.append(replacementWord);
                }
                else {
                answer.append(word);
                }

            }
            
        return answer.toString();

    
    }
}