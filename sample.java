// Time Complexity : O(L) as we traverse the length of the word to be inserted or searched
// Space Complexity : O(nL) as distinct words n of length l can be inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Trie {
    
    class TrieNode //data structure
    {
        boolean isEnd; // to track we have reached end of a string
        TrieNode children[]; //to track the word by initializing a new trinode type array at the index of teh word
        
     public TrieNode()
    {
        isEnd = false; // set to false initially ( boolean is false by default)
        children = new TrieNode[26]; // initialized to a trieNode array of 26 since 26 alphabet 
    }
    }
    
   
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode(); //object
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root; // pointing curr to root
        for(int i=0;i<word.length();i++) // traversing the word to be inserted
        { 
            char c = word.charAt(i); // getting character at index in the word
            if(curr.children[c-'a'] == null) // if null found i.e no new trienode array has been initilaize further means the character not found
                curr.children[c-'a'] = new TrieNode(); // put a new trienode array
         curr = curr.children[c-'a']; //move curr to the children
        }
        
        curr.isEnd = true; // at the end of word set isend flag to true
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root; // pointing curr to root
        for(int i=0;i<word.length();i++) // traversing the word to be searched
        {
            char c = word.charAt(i);  // getting character at index in the word
            if(curr.children[c-'a'] == null)  // if null found i.e no new trienode array has been initilaize further means the character not found
                return false;  // word not found
            curr = curr.children[c-'a'];  //move curr to the children
        }    
      return curr.isEnd;   // if nothing returned return the value of flag at the word's last character 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root; // pointing curr to root
        
        for(int i=0;i<prefix.length();i++) // traversing the word to be searched
        {
            char c = prefix.charAt(i); // getting character at index in the word
            if(curr.children[c-'a'] == null) // if null found i.e no new trienode array has been initilaize further means the character not found
                return false; // word not found
           curr = curr.children[c-'a']; //move curr to the children
        }
        
        return true; // word doesnt have to be inserted so if we have traversed the whole prefix, return true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// Time Complexity : O(nL) since we traverse the n words of sentence with average length equal to that corresponding to the word in dictionary
// Space Complexity : O(nL) as distinct words n of length l can be inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    TrieNode root; //global root
    class TrieNode // Trienode class
    {
        boolean isEnd; // to mark end of word
        TrieNode children[]; // to mark if we have a character at the position, initialize a TrieNode
        
     public TrieNode()
        {
             children = new TrieNode[26]; // initialize it to a 26 length array of trienodes
        }
    
    }
   
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root; // pointing curr to root
        for(int i=0;i<word.length();i++) // traversing the word to be inserted
        { 
            char c = word.charAt(i); // getting character at index in the word
            if(curr.children[c-'a'] == null) // if null found i.e no new trienode array has been initilaize further means the character not found
                curr.children[c-'a'] = new TrieNode(); // put a new trienode array
         curr = curr.children[c-'a']; //move curr to the children
        }
        
        curr.isEnd = true; // at the end of word set isend flag to true
    }

    public String replaceWords(List<String> dict, String sentence) {
      root = new TrieNode(); // initalize root a new trienode
        
        for(String s : dict) // insert all words of dictionary in the trie
        {
            insert(s);
        }
        
        String senArr[] = sentence.split("\\s+"); // split sentence based on spaces in senarr
        StringBuilder result = new StringBuilder(); // result string
        
        for(int k=0;k<senArr.length;k++) // iterate through the senArr
        {
            String word = senArr[k]; // get the word
            if(k>0)
                result.append(" "); // append space to result string
            
            TrieNode curr = root; // curr pointer
             StringBuilder repStr = new StringBuilder(); // replacement string
            for(int i=0;i<word.length();i++) // iterate through the word of the senarr
            {
                char c = word.charAt(i); //get the char
                  
                    if(curr.children[c-'a'] == null || curr.isEnd) // if word not found or we reached end
                        break;
                
                repStr.append(c); // append to replace string, (one extra trienode initialized at end where isend is true and so we are appending later)
                curr = curr.children[c-'a'];  // move the curr pointer
            }
             if(curr.isEnd) // if we reached end i.e we found a replacement
                   result.append(repStr); // append to result
             else
                 result.append(word); // else append to word itself
            }
          return result.toString();  //return result by converting to string
        }
        
}


// Time Complexity : O(nL + n*26) = O(nL)
// Space Complexity : O(nL) as distinct words n of length l can be inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {  
    TrieNode root;
    class TrieNode
    {
        String word;
        TrieNode children[];
        
     public TrieNode()
        {
             children = new TrieNode[26];
        }
    
    }
   
   /** Inserts a word into the trie. */
   public void insert(String word) {
    TrieNode curr = root; // pointing curr to root
    for(int i=0;i<word.length();i++) // traversing the word to be inserted
    { 
        char c = word.charAt(i); // getting character at index in the word
        if(curr.children[c-'a'] == null) // if null found i.e no new trienode array has been initilaize further means the character not found
            curr.children[c-'a'] = new TrieNode(); // put a new trienode array
     curr = curr.children[c-'a']; //move curr to the children
    }
    
    curr.word = word; // at the end store the word when we reach the end
}
    
    public String longestWord(String[] words) {
         root = new TrieNode(); // initialize the root
        
        for(String word: words) //insert all words in trie
        {
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>(); // queue to process the trienodes
        q.add(root); // add root to queue
        TrieNode curr = null;
        while(!q.isEmpty()) // till queue is not empty
        {
            curr = q.poll(); // get the curr trinode
            
            for(int i=25; i>=0; i--) //check all index, adding reverse lexicographically to queue
            {
                if(curr.children[i] !=null && curr.children[i].word != null) // if there is a character and we found the end of the wor
                {
                 q.add(curr.children[i]);   //add the child node to queue
                }
            }
        }
        
        return curr.word; //return word corresponding to the last character left in queue
    }
}