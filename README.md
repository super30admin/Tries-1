# Tries-1

## Problem1

Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

Insert in Trie
T.C : O(m) where m is the key length.
S.C : O(m)

SEARCH in trie

Time complexity : O(m)

Space complexity : O(1)

class TrieNode
{
boolean isEndOfWord;
TrieNode[] children;

    public TrieNode()
    {
        children = new TrieNode[26];
    }

}

public class Trie {

    private TrieNode root;

    public Trie() {

        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;
        char c;

        for(int i=0; i<word.length(); i++)
        {
            c=word.charAt(i);

            if (curr.children[c - 'a'] == null )
            {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];
        }

        curr.isEndOfWord = true;

    }

    public boolean search(String word) {

         TrieNode curr = root;
        char c;

        for(int i=0; i<word.length(); i++)
        {
            c=word.charAt(i);

            if (curr.children[c - 'a'] == null )
            {
                return false;
            }

          curr = curr.children[c - 'a'];
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
           TrieNode curr = root;
        char c;

        for(int i=0; i<prefix.length(); i++)
        {
            c=prefix.charAt(i);

            if (curr.children[c - 'a'] == null )
            {
                return false;
            }

            curr = curr.children[c - 'a'];

        }

        return true;
    }

}

/\*\*

- Your Trie object will be instantiated and called as such:
- Trie obj = new Trie();
- obj.insert(word);
- boolean param_2 = obj.search(word);
- boolean param_3 = obj.startsWith(prefix);
  \*/

## Problem2

Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

T.C : O( average of (n)) where n is the length of words[i]
S.C : O(average of (n)) space occupied by Trie
class Solution {

    class TrieNode
    {
        TrieNode children[];
        String word;

        public TrieNode()
        {
            children = new TrieNode[26];
        }

    }

    TrieNode root;

    public void insert(String word)
    {
        TrieNode curr = root;

        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null )
            {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c-'a'];
        }

        curr.word = word;
    }



    public String longestWord(String[] words) {

    root = new TrieNode();

     if ( words == null || words.length == 0) return "";

    for(String word:words)
    {
        insert(word);
    }

    Queue<TrieNode> q = new LinkedList<>();
    q.add(root);
    TrieNode curr = root;
    while (!q.isEmpty())
    {
       curr = q.poll();

           for(int i=25; i>=0; i--)
           {
               if(curr.children[i] != null && curr.children[i].word != null)
               {
               q.add(curr.children[i]);
               }
           }

    }

      if(curr.word == null) return "";
       return curr.word;
    }

}

## Problem3

Replace Words (https://leetcode.com/problems/replace-words/)

TC: O(N) where NN is the length of the sentence.

SC: O(N) the size of our trie.

class TrieNode
{
TrieNode[] children;
String word;
public TrieNode()
{
children = new TrieNode[26];
}
}

class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {

    TrieNode root = new TrieNode();

        for(String str:dictionary)
        {

            TrieNode curr=root;

            for(int i=0; i<str.length(); i++)
            {
                char c = str.charAt(i);

                if(curr.children[c - 'a'] == null)
                {
                    curr.children[c - 'a'] = new TrieNode();
                }

               curr=curr.children[c - 'a'];
            }

            curr.word = str;
        }

            StringBuilder result = new StringBuilder();

    for(String word : sentence.split("\\s+"))
    {
        if (result.length() > 0)
                result.append(" ");
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null || curr.word != null)
              break;
            curr = curr.children[c - 'a'];
        }

        result.append(curr.word != null ? curr.word : word);
    }

        return result.toString();
    }

}
