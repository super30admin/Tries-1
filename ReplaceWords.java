// Time Complexity : insertion : O(nL) (n is number of words , with longest word length = L)
// execution : O(mL) (m is size of sentence), Total : O(L(m+n))
// Space Complexity : O(nL)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    //create a class TrieNode
    class TrieNode {
        //declare array of trieNode (trieChildren)
        TrieNode[] trieChildren; 
        String word; 
        
        //constructor
        public TrieNode() {
            //initialize trieChildren array of size 26 (lower case letters)
            trieChildren = new TrieNode[26];
        }
    }

    //declare a TrieNode root globally
    TrieNode root;
    public void insert(String word) {
        //insert func has a curr TrieNode variable pointing to root
        TrieNode curr = root;
        //for each character in word
        for(int i = 0; i < word.length(); i++) {
            //get the ith char
            char c = word.charAt(i);
            //check if that char is in Trie (if trieNode exists at that array position)
            //array[1] = a ; array[2] = b ... so on 
            //array position represents ascii value of letters
            //then the letter is present
            //if null letter does not exist
            //so create a new trieNode at that array position
            if(curr.trieChildren[c - 'a'] == null) {
                curr.trieChildren[c - 'a'] = new TrieNode();
            }
            //move curr pointer to add the. other letters of the word
            curr = curr.trieChildren[c - 'a'];
        } curr.word = word;  //make the word point to entire word in thr trie
    }

    
    public String replaceWords(List<String> dict, String sentence) {
        //initialize the root
        root = new TrieNode();
        //insert each word of dictionary in the Trie (call insert method)
        for(String eachWord : dict) {
            insert(eachWord);
        }
        //use a StringBuilder to return the result
        StringBuilder replaceSentenceSB = new StringBuilder();
        //split the sentence into words (where we encounter a space)
        String [] wordsInSentence = sentence.split("\\s+");
        // for each word in sentence
        for(int i = 0; i < wordsInSentence.length; i++) {
            //get the word
            String senWord = wordsInSentence[i];
            //initialize curr pointing to root
            TrieNode curr = root;
            //to add space back to sentence (result) (we removed the space from original sentence)
            if(i > 0) replaceSentenceSB.append(" ");
            //for each selected word of sentence
            for(int j = 0; j < senWord.length(); j++) {
                //get the c and check if its present in Trie
                char c = senWord.charAt(j);
                //if char not present in trie or small word replacement found, break the for loop
                if(curr.trieChildren[c-'a'] == null || curr.word != null) break;
                //else inc curr to next trie node
                curr = curr.trieChildren[c-'a'];
            }
            //declare a string replacedWord to add to the stringbuilder
            String replacedWord;
            //if no prefix found, replacedWord will be same as the word in sentence
            if(curr.word == null) {
                replacedWord = senWord;
            }
            else {
                //else replacedWord = the short word found
                replacedWord = curr.word;
            }
            //append to stringbuilder
            replaceSentenceSB.append(replacedWord);
        }
        //return the string builder in the end
        return replaceSentenceSB.toString();        
    }
}


//////////////////


//using isEnd
class Solution {
    //create a class TrieNode
    class TrieNode {
        //declare array of trieNode (trieChildren)
        TrieNode[] trieChildren; 
        boolean isEnd; 
        
        //constructor
        public TrieNode() {
            //initialize trieChildren array of size 26 (lower case letters)
            trieChildren = new TrieNode[26];
        }
    }

    //declare a TrieNode root globally
    TrieNode root;
    public void insert(String word) {
        //insert func has a curr TrieNode variable pointing to root
        TrieNode curr = root;
        //for each character in word
        for(int i = 0; i < word.length(); i++) {
            //get the ith char
            char c = word.charAt(i);
            //check if that char is in Trie (if trieNode exists at that array position)
            //array[1] = a ; array[2] = b ... so on 
            //array position represents ascii value of letters
            //then the letter is present
            //if null letter does not exist
            //so create a new trieNode at that array position
            if(curr.trieChildren[c - 'a'] == null) {
                curr.trieChildren[c - 'a'] = new TrieNode();
            }
            //move curr pointer to add the. other letters of the word
            curr = curr.trieChildren[c - 'a'];
        } curr.isEnd = true;  //make isEnd true 
    }

    
    public String replaceWords(List<String> dict, String sentence) {
        //initialize the root
        root = new TrieNode();
        //insert each word of dictionary in the Trie (call insert method)
        for(String eachWord : dict) {
            insert(eachWord);
        }
        //use a StringBuilder to return the result
        StringBuilder replaceSentenceSB = new StringBuilder();
        //split the sentence into words (where we encounter a space)
        String [] wordsInSentence = sentence.split("\\s+");
        // for each word in sentence
        for(int i = 0; i < wordsInSentence.length; i++) {
            //get the word
            String senWord = wordsInSentence[i];
            //initialize curr pointing to root
            TrieNode curr = root;
            //to add space back to sentence (result) (we removed the space from original sentence)
            if(i > 0) replaceSentenceSB.append(" ");
            //create new stringbuilder to append the replacedWord 
            //wordReplaceSB will have the same word as sentence
            //if smaller word found, original word will be replaced in wordReplaceSB
            StringBuilder wordReplaceSB = new StringBuilder(); 
            //for each selected word of sentence
            for(int j = 0; j < senWord.length(); j++) {
                //get the c and check if its present in Trie
                char c = senWord.charAt(j);
                //if char not present in trie or isEnd encountered break the for loop
                if(curr.trieChildren[c-'a'] == null || curr.isEnd) break;
                //else add the char c to the wordReplaceSB (to get shorter word if any)
                wordReplaceSB.append(c);
                //inc curr to next trie node
                curr = curr.trieChildren[c-'a'];
            }
            //declare a string replacedWord to add to the stringbuilder
            String replacedWord;
            //if no prefix found (isEnd is false), replacedWord will be same as the word in sentence
            if(!curr.isEnd) {
                replacedWord = senWord;
            }
            else {
                //else replacedWord = the short word found (stored in wordReplaceSB)
                replacedWord = wordReplaceSB.toString();
            }
            //append to stringbuilder
            replaceSentenceSB.append(replacedWord);
        }
        //return the string builder in the end
        return replaceSentenceSB.toString();        
    }
}

