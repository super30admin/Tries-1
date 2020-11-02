/**
 *  Time Complexity: O(k) where k is the  sum of length of words[i]
 *  Space Complexity: O(k)  where k is the  sum of length of words[i]
 */

class TrieNode {
    
    public char ltr;
    public Boolean isWord = false;
    public TrieNode[] children;
    
    public TrieNode() {
    }
    
    TrieNode(char c) {
        children = new TrieNode[26];
        ltr = c;
    }
}

class Solution {
    
    public TrieNode root;
    public String match;
    
    public String longestWord(String[] words) {
        // let's find the length of the longest character, then let's insert words progressively starting at length 1
        if (words.length == 0) return "";
        
        root = new TrieNode(' ');
        
        int longest = 0;
        // let's also insert the smallest words
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                insert(words[i]);
                
                // if first match - insert, otherwise check lexi order
                if (match == null) {
                    match = words[i];
                } else if (lexi(words[i], match) == true) {
                    match = words[i];
                }
            }
            
            longest = Math.max(words[i].length(), longest);
        }
        
        // let's insert the rest in order, if they have a prefix
        for (int i = 2; i <= longest; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() == i && isPrefix(words[j])) {
                    // insert(words[j]); -- insert directly from the prefix check for speed optimization
                    
                    // compare match by going letter by letter -- check size first
                    if (match.length() < words[j].length()) {
                        match = words[j];
                    } else if (lexi(words[j], match) == true) {
                        match = words[j];
                    }
                }
            }
        }
        
            
        return match;
    }
    
    public void insert(String word) {
        
        TrieNode ws = root;
        
        for (int i = 0; i < word.length(); i++) {
            char currLtr = word.charAt(i);
            if (currLtr != ws.ltr) {
                TrieNode tmp = new TrieNode(currLtr);
                ws.children[currLtr - 'a'] = tmp; // add the next node
            }
            ws = ws.children[currLtr - 'a']; // advance the root to the next character
        }
        
        ws.isWord = true; // mark as a complete word
    }
    
    public Boolean isPrefix(String word) {
        
        TrieNode ws = root;
        
        // go one less characters!
        for (int i = 0; i < word.length() - 1; i++) {
            char currLtr = word.charAt(i);
            if (ws.children[currLtr - 'a'] == null) {
                return false;
            }
            
            ws = ws.children[currLtr - 'a']; // advance the root to the next character
        }
        
        quickInsert(ws, word);
        
        return true;
    }
    
    public void quickInsert(TrieNode ws, String word) {
        // let's insert directly from here!
        char lastLtr = word.charAt(word.length() - 1);
        ws.children[lastLtr - 'a'] = new TrieNode(lastLtr);
    }
    
    // true indicates it's in better order
    public Boolean lexi(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        
        // same word!
        return true;
    }
}