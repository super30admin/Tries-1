//Time complexity : mk + nl where m is total number of words in sentence and k is length of words 
// n is total number of words in dictionary and l is length of the words
// space complexity is nl
import java.io.*;

class Solution {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root; // created a container for the object 
    private void insert(String word){
        TrieNode curr = root; // created a pointer to the node/container root
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){ //checks everytime if there is a children present at defined index for that char
               curr.children[c-'a']= new TrieNode(); // if not then creates a node at index 2 (for b)
            }
            System.out.println(c-'a');
            curr=curr.children[c-'a']; // pointer current is moved to where newly added nod resides
            //System.out.println(curr.children[c-'a']);
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
      root = new TrieNode();
      for(String word:dictionary){
          insert(word);
      }
        
        StringBuilder result = new StringBuilder();
        String [] splitArr = sentence.split(" ");
        for(int i=0; i<splitArr.length; i++){
            if(i != 0 ) result.append(" ");
            String word = splitArr[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int j = 0; j < word.length(); j++){
                char c= word.charAt(j);
                if(curr.children[c-'a']==null || curr.isEnd) break; //if the character does not exist at that index or last char is reached to the end
                curr = curr.children[c-'a']; //if valid then move pointer to children node
                replacement.append(c); // if trie has TINY snd word is THE then replacement will have T stored in it
            }
            if(curr.isEnd){
                result.append(replacement); // if all chars in trie word then only add it to result
                
            }else {
                result.append(word); // orelse add word as it is
            }
          // result.append(" "); 
        }
        return result.toString().trim();
    }
}
