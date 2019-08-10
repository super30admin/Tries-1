class LongestWordInDict {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    
        boolean isEndOfWord;
        char val;
    
        public TrieNode(char val) {
            isEndOfWord = false;
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            this.val = val;
        }
    }

    TrieNode root;

    public LongestWordInDict(){
        root = new TrieNode(' ');
    }

    public String longestWord(String[] words) {
        int maxCount=0;
        String longestWord = "";
        
        //insert
        for(int i=0;i<words.length;i++){
            TrieNode curr = root;
            String word = words[i];
            String temp = "";
            int count = 0;
            for(int j=0; j<word.length(); j++){
                char index = word.charAt(j);                
                if(curr.children[index-'a'] == null){
                    curr.children[index-'a'] = new TrieNode(index);
                    
                    if(count > maxCount){
                        maxCount = count;
                        longestWord = word.substring(0, j+1);
                    }
                    else if(count > 0 && count == maxCount){
                        // check which comes first
                        int iterator = 0;
                        String currentWord = word.substring(0, j+1);
                        while(iterator<count && longestWord.charAt(iterator) == currentWord.charAt(iterator)){
                            iterator++;
                        }

                        if(longestWord.charAt(iterator) > currentWord.charAt(iterator)){
                            longestWord = currentWord;
                        }
                        
                    }
                }
                else {
                    count++;
                    temp += index;
                }
                curr = curr.children[index-'a'];            
            }
    
            curr.isEndOfWord = true;
            
        }
        
        System.out.println("string " + longestWord + " max Count " + maxCount);
        //TrieNode curr = root;

        //
        return longestWord;
        
        
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("LongestWordInDict");
        LongestWordInDict obj = new LongestWordInDict();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        obj.longestWord(words);
    }
}