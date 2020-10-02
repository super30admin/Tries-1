/*
Approach - Create a Trie with the given dictionary.
1. For each word of the given sentence, traverse through the Trie from the root node. 
2. At each level, move to the next character. 
3. If the current character is not present in the dictionary, stop iterating further and append the same word.
4. If the current character is present in the Trie, move further to the next child node. 
5. Repeat the process till we reach the node with boolean flag isWord as true. If there is no flag with isWord as true, put the same word in the final sentence.

Time complexity - O(NK) -- number of words in the dictionary, K- length of each word.In the worst case, if the sentence is same as the dictionary, we endup traversing through the whole sentence.
Space complexity- space needed to construct dictionary - O(N), N is the total number of characters present in the dictionary.

*/
class ReplaceWords {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root = null;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        initializeTrie(dictionary);
        return replaceWords(sentence);
    }
    
    private void initializeTrie(List<String> dictionary){
        TrieNode curr = root;
        for(String s: dictionary){
            curr = root;
            for(char ch: s.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isWord = true;
        }
    }
    
    
    private String replaceWords(String sentence){
        TrieNode curr = root;
        String[] sentenceArr = sentence.split(" ");
        
        for(int i=0; i<sentenceArr.length; i++){
            String s = sentenceArr[i];
            curr = root;
            StringBuilder replacement = new StringBuilder();
            for(char ch: s.toCharArray()){
                if(curr.isWord){
                    sentenceArr[i] = replacement.toString();
                    break;
                }
                if(curr.children[ch-'a'] != null){
                    curr = curr.children[ch-'a'];
                    replacement.append(ch);
                } else {
                   break;
                }
            }
        }
        
        StringBuilder newSentence = new StringBuilder();
        for(String s: sentenceArr){
            newSentence.append(s).append(" ");
        }
        return newSentence.toString().trim();
    }
    
}