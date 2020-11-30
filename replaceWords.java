//Time Complexity:O(N)
//Space Complexity:O(N)
//In this problem, I'll first add the words in the given dict to the trie. Then I'll be splitting the given sentence into a list of words.Then I'll be traversing through each list and add the dict word into the output string if it is not null at that position . Else I'll simply add the words in the sentence to the output.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode trie=new TrieNode();
        //adding the words in dict to the trienode
        for(String d:dict){
            TrieNode cur=trie;
            for(char letter:d.toCharArray()){
                if(cur.children[letter-'a']==null){
                    cur.children[letter-'a']=new TrieNode();
                }
                cur=cur.children[letter-'a'];
            }
            cur.word=d;
        }
        StringBuilder sb=new StringBuilder();
        //splitting the sentence into words to be added to the output if the dict word is null at that instance
        for(String word: sentence.split("\\s+")){
            if(sb.length()>0){
                sb.append(" ");
            }
            TrieNode cur=trie;
            for(char letter:word.toCharArray()){
                if(cur.children[letter-'a']==null||cur.word!=null){
                    break;
                }
                cur=cur.children[letter-'a'];
            }
            sb.append(cur.word!=null?cur.word:word);//adding the dict word if it is not null at that instance or simply adding the word in the sentence
        }
        return sb.toString();
        
    }
}
class TrieNode{
            TrieNode[] children;
            String word;
            public TrieNode(){
                children= new TrieNode[26];
            }
        }