// Time Complexity : O(nl) where n is no of word of length l
// Space Complexity: O(nl) space occupied by trie
import java.util.LinkedList;
import java.util.Queue;

public class LongestWordDictionary {
    class TrieNode {
        TrieNode [] children;
        String word; // use this as a boolean to show the word is present in dictionary

        public TrieNode()
        {
            children = new TrieNode[26];
            word = "";
        }
    }
    TrieNode root;
    private void insert(String word)
    {
        TrieNode curr = root;
        // for each char of word convert to trienodes
        for(char c: word.toCharArray())
        {
            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a']; // move curr to next char in word
        }
        // update last char with the entire word
        curr.word = word;
    }

    public String longestWord(String[] words)
    {
        if(words == null || words.length == 0)
            return "";

        root = new TrieNode();

        // make tries from all dictionary words
        for(String word : words)
        {
            insert(word);
        }

        // Use BFS to find the word
        // since we want lexically first alphabet we traverse z to a
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(root);
        TrieNode curr = root;

        while(!q.isEmpty())
        {
            curr = q.poll();
            for(int i = 25 ; i >= 0 ; i--)
            {
                if(curr.children[i] != null && curr.children[i].word != "") // if there is a word starting with char i and word is not empty means
                {
                   q.offer(curr.children[i]);
                }
            }
        }

        return curr.word; // last word in queue will be the answer if found else empty
    }
}
