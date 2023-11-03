// Time Complexity : O(N*L + M*K) where N is length of dictionary words and L is length of dictionary word.
// and M is length of sentence words and L is length of sentence word.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ReplacementWords
{
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {

            Tries trieDs = new Tries();
            String[] words = sentence.split(" ");
            for(String key : dictionary)
                trieDs.insert(key);

            StringBuilder result = new StringBuilder();
            //TrieNode root = trieDs.root;
            for(int i = 0; i < words.length; i++)
            {
                if(i > 0)
                    result.append(" ");
                String word = words[i];
                TrieNode curr = trieDs.root;
                StringBuilder replacementStr = new StringBuilder();
                for(int j = 0; j < word.length(); j++)
                {
                    char c = word.charAt(j);
                    if(curr.children[c-'a'] == null || curr.isEnd)
                    {
                        break;
                    }
                    replacementStr.append(c);
                    curr = curr.children[c-'a'];
                }
                if(curr.isEnd)
                    result.append(replacementStr);
                else
                    result.append(word);
            }

            return result.toString();

        }

        class TrieNode
        {
            boolean isEnd;
            TrieNode[] children;

            TrieNode(){
                this.children = new TrieNode[26];
            }
        }

        class Tries
        {
            TrieNode root;
            Tries(){
                root = new TrieNode();
            }

            public void insert(String word)
            {
                TrieNode curr = root;
                for(int i = 0 ; i < word.length(); i++)
                {
                    char c = word.charAt(i);
                    if(curr.children[c-'a'] == null)
                    {
                        curr.children[c-'a'] = new TrieNode();
                    }
                    curr = curr.children[c-'a'];
                }
                curr.isEnd = true;
            }
        }
    }
}
