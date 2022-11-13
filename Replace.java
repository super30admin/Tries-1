// Time Complexity:O(n*L * m*l)
// Space Complexity: TrieSpace used - N*L
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No

// Your code here along with comments explaining your approach
/*
 * We insert the words in dictionary inside the Trie DS. After that, we split the sentence into a words array, 
 * iterate over each word,iterate over each letter in the word and check if the letter is present in the Trie.
 * Remember, we initialize the curr node each time we get a new word and we also we initialize a new 
 * replacement string for every word. Two important break conditions are when isEnd flag is true or when
 * curr is null because that letter does not exist. In the end of letter iteration in every word - we check 
 * that if isEnd is true, means prefix is found so we append the replacement string else we append the original 
 * word.
 */
public class Replace {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
TrieNode root;
    
public void insert(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i < word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
public String replaceWords(List<String> dictionary, String sentence) {
    root = new TrieNode();
    for(String str: dictionary)
    {
        insert(str);
    }
    
    String[] words = sentence.split(" ");
    StringBuilder result = new StringBuilder();
    
    for(int k = 0; k < words.length;k++)
    {
        if(k != 0)
        {
            result.append(" ");
        }
        StringBuilder replacement = new StringBuilder();
        String word = words[k];
        TrieNode curr = root;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null || curr.isEnd)
            {
                break;
            }
            replacement.append(c);
            curr = curr.children[c - 'a'];
            
        }
        if(curr.isEnd)
        {
            result.append(replacement);
        }
        else
        {
            result.append(word);
        }
    }
    return result.toString();
}
}
