import java.util.List;

// Time Complexity : Max of O(Number of dictionary words * maxLengthOfAWord) and O(Number of words in sentence * MaxLengthOfAWord)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie(); 
        
        TrieNode root = trie.root;
        for(String word: dictionary)
        {
            //time: O(Number of dictionary words * maxLengthOfAWord)
            trie.insert(word);
        }
        StringBuilder result = new StringBuilder();
        StringBuilder replacement = new StringBuilder();
        
        //Space: O(Number of words in sentence)
        //Time: 
        String[] words = sentence.split(" ");
        for(String word: words)
        {
            // Time: O(Number of words in sentence * MaxLengthOfAWord)
            TrieNode curr = root;
            for(int i=0;i<word.length(); i++)
            { 
                char ch = word.charAt(i);
                if(curr.children[ch - 'a']== null || curr.isEnd)
                    break;
                replacement.append(ch);
                curr = curr.children[ch - 'a'];
                
            }
            if(curr.isEnd)
            result.append(replacement+" ");
            else result.append(word+" ");
          replacement.setLength(0);
            
        }
        
        return result.toString().trim();
         
    }
}
