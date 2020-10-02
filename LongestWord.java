class LongestWord{
    
    /* Approach -1 : Using a Hashset 
    Code executed in Leetcode? Yes
    * 1. Initialize a set that stores list of acceptable strings.
    * 2. Initialize a global variable, finalResult to empty string. This variable stores the string containing maximum length.
    * 3. Sort the given array of words and Iterate through the array.
    * 4. If the current word has only one character, or if its substring is already present in the set, add the current word to the set.
    * 5. At each iteration, update the variable, finalResult if the length of current word is greater than the finalResult
    * 6. At the end, return the value in finalResult.
    
    * Time complexity: O(KNLogN) for sorting the list where K- is average length of word. N- number of words in the given list
    O(N) -- for iterating through the list of words.
    O(1) -- for the contains method of hashset.
    Total --> O(KNlogN)
    * Space Complexity: O(N) --> additional space for hashset, that stores the complete list of words, maximum space it could take is the given list of words.
    */
    
    public String longestWord_Approach1(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
        Arrays.sort(words);
        Set<String> wordSet = new HashSet<String>();
        String finalRes = "";
        
        for(String w: words){
            if(w.length() == 1 || wordSet.contains(w.substring(0,w.length()-1))){
                wordSet.add(w);
                finalRes = w.length() > finalRes.length() ? w: finalRes;
            }
        }
        return finalRes;
    }
    
    /*Approach 2- Using a Trie
    Code executed in Leetcode? Yes
    1. Build a Trie using the given words.
    2. Initialize a variable longestStr that stores the maximum length of the word.
    3. Start traversing the Trie from the root node.
    4. Iterate through the children of current node and perform Depth First Search at each child if the wordEnd value is true. Build the traversed string at each path. Update the variable, longestStr if the length of the traversed string is greater than the longestStr.
    5. At the end, return the variable "longestStr".
    
    * Time complexity - O(NK) - N- number of words in the array. K- average length of each word
    * Space complexity:
    * 1. Trie data structure: O(NK) in the worst case where N- number of words in the array and K- average length of each word.
    * 2. maximum size of recursion call stack: Length of longest word
    * Overall space complexity : O(NK)
    */
    class TrieNode {
        TrieNode[] children;
        boolean wordEnd;
        TrieNode(){
            children = new TrieNode[26];
            wordEnd = false;
        }
    }
    
    TrieNode root;
    String longestStr = "";
    public String longestWord(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
        
        initializeTrie(words);
        findLongestString(root, new StringBuffer());
        return longestStr;
    }
    
    private void findLongestString(TrieNode curr, StringBuffer path){
        if(path.length() > longestStr.length()){
            longestStr = path.toString();
        }
        for(int i=0; i<curr.children.length; i++){
            TrieNode child = curr.children[i];
            if(child != null && child.wordEnd){
                path.append((char)('a'+i));
                findLongestString(child, path);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
    
    /*Builds a trie with the given list of words */
    private void initializeTrie(String[] words){
        root = new TrieNode();
        for(String s: words){
            insert(s);
        }
    }
    
    /* Inserts given word in to the Trie */
    private void insert(String word){
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.wordEnd = true;
    }
    
}