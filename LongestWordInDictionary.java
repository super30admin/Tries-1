/**Leetcode Question 720 - Longest word in a Dictionary */
/**Algorithm - Trie + BFS
 * Insert the words in a trie, maintain a string word at every point in the trie when a word ends
 * For a backward BFS traversal of the array so that the smalllest lexographical is popped.
 */
/**TC - O(MN) - M = length of string of words, N = avg length of the words
 * SC - O(MN)
 */
public class LongestWordInDictionary {
    class Solution {
        class TrieNode{
            String word;
            TrieNode children[];
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        
        TrieNode root;
        
        public void insert(String word){
            TrieNode curr = root;
            for(int i =0; i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
        
        public String longestWord(String[] words) {
            root = new TrieNode();
            if(words == null || words.length == 0){
                return "";
            }
            for(String word: words){
                insert(word);
            }
            TrieNode curr = root;
            Queue<TrieNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                curr = q.poll();
                for(int i =25; i>= 0; i--){
                    if(curr.children[i]!= null && curr.children[i].word!= null){
                        q.add(curr.children[i]);
                    }
                }
            }
            return curr.word;
        }
    }
    
}
