// Time Complexity: time to construct dict of n words and m length + search k words of l length
//                  O(nm) + O(kl) 
// Space Complexity: time to build trie of n words and m length + split array space of k
//                   O(nm) + O(k)
public class ReplaceWords {
    public class TrieNode
    {
        TrieNode [] children;
        boolean isEnd;

        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word) 
    {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c -'a'] == null)
            {
                curr.children[c -'a'] = new TrieNode();
            }
            curr = curr.children[c -'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence)
    {
        if(dictionary == null || dictionary.size() == 0)
            return "";
        
         root = new TrieNode();
        
        for(String word: dictionary)
        {
            insert(word);
        }
        
        String [] words = sentence.split(" ");
        StringBuilder replacedSentence = new StringBuilder();
        for(int i = 0 ; i < words.length; i++) // for each word search if there is a trie
        {
            if(i != 0)
            {
                replacedSentence.append(" "); // add space b/w every word
            }
            // look for a replacement of curr word
            TrieNode curr = root;
            StringBuilder replaceWord = new StringBuilder();
            for(char c: words[i].toCharArray()) // search each char of curr word
            {
                if(curr.children[c -'a'] == null || curr.isEnd)
                    break;
                curr = curr.children[c -'a'];
                replaceWord.append(c);
            }
            // if shorter word is found replace the old word
            if(curr.isEnd)
                replacedSentence.append(replaceWord);
            else // add old word
               replacedSentence.append(words[i]);
        }
        
        return replacedSentence.toString();
    }
}
