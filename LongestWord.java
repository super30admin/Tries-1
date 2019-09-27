/*
The time complexity is O(sum of len of all words) and the space complexity in the worst case is also O(sum of len of all words)

The intuition here is to sort the array to get all the words that form the present word should be before it in the array. While inserting
check if all the characters of the word are present except the last character. This we are checking in the new count. We should even check
the case where even if newcount = 1 the previous word should also be formed with adding only one character. For this we are using isValid
field

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public String longestWord(String[] words) {

        Arrays.sort(words); String retWord = "";
        TrieNode root = new TrieNode('-'); root.isValid = true;
        for(String word:words){
            if(insert(root,word)){
                if(word.length()>retWord.length()){
                    retWord = word;
                }
            }
        }

        return retWord;

    }

    public boolean insert(TrieNode root,String word) {
        TrieNode temp = root; TrieNode prev = root; int newCount = 0;

        for(int i=0;i<word.length();i++){
            if(temp.arr[word.charAt(i)-'a']!=null){
                prev = temp;
                temp = temp.arr[word.charAt(i)-'a'];
            }
            else{
                newCount++;
                prev = temp;
                temp.arr[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));
                temp = temp.arr[word.charAt(i)-'a'];
            }
        }

        temp.isWord = true;

        if(newCount==1){
            if(prev.isValid){
                temp.isValid = true;
                return true;
            }
            return false;
        }

        return false;
    }
}

class TrieNode {
    char c;
    TrieNode[] arr;
    boolean isWord;
    boolean isValid;

    TrieNode(char c){
        this.c = c;
        arr = new TrieNode[26];
        isWord = false;
        isValid = false;
    }
}