//approach - backtracking - DFS
//1. build tree with wordds given , make sure your treee is formed correct , othrwise logic will not work. 
//2. take a global variable answer to store answer
//3. make a helper method call - (curr, sb);
//inside the Helper method 
    /*logic - take a for loop running from 0 to 25
     * check if curr. child[i] not null and it's flag is true, 
     *            a.if so.. append the character to sb = sb.append((char)('a'+i)) - here 'a'+i gives integer and char converts
     *              ASCII value to its char and then append 
     *            b. Make a recursive helper call child's children ; helper(cirr.child[i], sb);
     *              //backtrack//
     *            c. after we exhaust the the recursive call and come back, check the answer's length < sb.length, 
     *                  p. if so , then only update the answer, else not. - this will take care of lexicographically
     *                      ordered word, as we move from 0 to 25. 
     *             d. regardless of condition check at step c, we will remove the last appended character from sb.
     * 
     * at last we will just return the answer.toString();
     * N = words.length, and l = avg length of each word. 
     * TC - O(insertion of words in trie - N) + O(traversing through the tree recursively for all 26 children - N*l)      
     */


class Solution {
    
    class TrieNode
    {
        TrieNode[] children;
        //String word;
        boolean isEnd;
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    
    private void insert(String wrd)
    {
        TrieNode curr = root;
        for(int i=0; i<wrd.length(); i++)
        {
            char ch = wrd.charAt(i);
            if(curr.children[ch-'a'] == null)
            {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }curr.isEnd =true;
        
    }
    
    StringBuilder answer;
    public String longestWord(String[] words) {
        
        if(words == null || words.length == 0) return "";
        
        //insert in trie
        for(int i=0; i< words.length; i++)
        {
            insert(words[i]);
        }
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        answer = new StringBuilder();
         //StringBuilder str = new StringBuilder();
        //dfs logic
        helper(curr, sb );
        
        return answer.toString();
        
    }
    private void helper(TrieNode curr, StringBuilder sb)
    {
      for(int i=0; i<26; i++)
      {
          //check if node is not null && flag is true
          if(curr.children[i] != null && curr.children[i].isEnd == true)
          {
              //append - action
              sb.append((char)('a'+i));
              //recurse
              helper(curr.children[i],sb);
              
              //backtracking
              if(answer.length() < sb.length())
              {
                  answer = new StringBuilder(sb);
              }
              sb.deleteCharAt(sb.length()-1);
          }
      }
    }
}





/*approach- 2
 * BFS
 * 1. Design a tree , such that instead of flag,maintain a string and at the time every word ends, 
 * instead of true, store the word itself there. 
 * Take a queue of TrieNode type 
 *  - Start from the root,push root to the queue. 
 * - now inf bfs, poll from the Queue and run a for loop for 26 nodes. if children found then push it to the queue, and
 * in the subsequent manner, poll the parent and push its children to queue 
 * last children to get out from the queue will be holding the answer as longest string!
 * //tc - insert to trie O(N) + BFS - O(N*l) l = average word length
 * //sc - Trie - O(N) + Queue - at a time let say all children are in Queue - O(N*l);
 */

class Solution {
    
    class TrieNode
    {
        TrieNode[] children;
        String word;
        public TrieNode()
        {
            children = new TrieNode[26];
            word ="";
        }
    }
    TrieNode root = new TrieNode();
    Queue<TrieNode> q ;
    private void insert(String wrd)
    {
        TrieNode curr = root;
        for(int i=0; i<wrd.length(); i++)
        {
            char ch = wrd.charAt(i);
            if(curr.children[ch-'a'] == null)
            {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }curr.word =wrd;
        
    }
    
    public String longestWord(String[] words) {
        
        if(words == null || words.length == 0) return "";

        //insert in trie
        for(int i=0; i< words.length; i++)
        {
            insert(words[i]);
        }

        q = new LinkedList<>();
        q.add(root);
        TrieNode curr = new TrieNode();

        while(!q.isEmpty())
        {
            curr=q.poll();
            for(int i=25; i>=0; i--)
            {
                if(curr.children[i] != null && curr.children[i].word !="" )
                {
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
        
    }
   
}