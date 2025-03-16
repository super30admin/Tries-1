// Trie
// TC: O(d + s) t: total length of dictionary, s: length of sentence
// SC: O(d)
class Solution {
    class TrieNode{
        boolean isEnd;
        String word;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    private String search(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return word;
            }

            curr = curr.children[c - 'a'];
            if(curr.isEnd){
                return curr.word;
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) return sentence;
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        String[] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(String str : strArr){
            result.append(search(str));
            result.append(" ");
        }
        return result.toString().trim();
    }
}
