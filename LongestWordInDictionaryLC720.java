class Solution {

    class TrieNode{

        TrieNode[] children;
        boolean isEnd;
        //String word;        //BFS Approach 1

        TrieNode(){
            this.children = new TrieNode[26];
            //word = "";        //BFS Approach 1
        }
    }

    private void insert(String word){

        TrieNode current = root;

        for(int i=0; i<word.length(); i++){

            char ch = word.charAt(i);

            if(current.children[ch-'a'] == null){
                current.children[ch-'a'] = new TrieNode();
            }
            current = current.children[ch-'a'];
        }
        current.isEnd = true;
        //current.word = word;        //BFS Approach 1
    }

    TrieNode root;
    StringBuilder maxString;


    //DFS + backtraing Approach
    //Time Complexity: O(n*k)
    //Space Complexity: O(n*k), n = length of words, k = average length of individual word

    public String longestWord(String[] words) {

        root = new TrieNode();
        maxString = new StringBuilder();

        for(String word: words){
            insert(word);
        }

        backtracking(root, new StringBuilder());

        return maxString.toString();

    }

    private void backtracking(TrieNode current, StringBuilder currentString){

        //base
        if(currentString.length() > maxString.length()){
            maxString = new StringBuilder(currentString);
        }

        //we don't have to worry about the lexicographical order, because we are iterating from 0 to 25, so we are setting the maxString to smallest lexicographical order, hence we don't need to change anything if currentString and maxString length is same


        //logic
        for(int i=0; i<26; i++){

            if(current.children[i] != null && current.children[i].isEnd){

                int len = currentString.length();
                //action
                currentString.append((char)(i+'a'));
                //recurse
                backtracking(current.children[i], currentString);
                //backtrack
                currentString.setLength(len);
            }
        }
    }






    //BFS Approach 2
    //Time Complexity: O(n*k)
    //Space Complexity: O(n*k), n = length of words, k = average length of individual word

//     public String longestWord(String[] words) {

//         root = new TrieNode();

//         for(String word: words){
//             insert(word);
//         }

//         Queue<TrieNode> tq = new LinkedList<>();
//         Queue<String> sq = new LinkedList<>();

//         tq.add(root);
//         sq.add("");

//         TrieNode current = new TrieNode();
//         String currentString = "";
//         while(!tq.isEmpty()){

//             current = tq.poll();
//             currentString = sq.poll();

//             // we are iterating from 25 to 1 just because we wanted to stay the longest word in queue till last and if there are two longest word, then we need to handle the lexicographical order, So to handle the lexicographical order, we iterating in reverse

//             for(int i=25; i>=0; i--){

//                 if(current.children[i] != null && current.children[i].isEnd){

//                     tq.add(current.children[i]);
//                     sq.add(currentString + (char)(i+'a'));
//                 }
//             }
//         }
//         return currentString;
//     }






    //BFS Approach 1
    //Time Complexity: O(n*k)
    //Space Complexity: O(n*k), n = length of words, k = average length of individual word

//      public String longestWord(String[] words) {

//          root = new TrieNode();

//          for(String word: words){
//              insert(word);
//          }

//          Queue<TrieNode> q = new LinkedList<>();
//          q.add(root);

//          TrieNode current = new TrieNode();

//          while(!q.isEmpty()){

//              current = q.poll();

//             // we are iterating from 25 to 1 just because we wanted to stay the longest word in queue till last and if there are two longest word, then we need to handle the lexicographical order, So to handle the lexicographical order, we iterating in reverse

//              for(int i=25; i>=0; i--){

//                  if(current.children[i] != null && current.children[i].isEnd){

//                      q.add(current.children[i]);
//                  }
//              }
//          }
//          return current.word;
//      }
}


public class LongestWordInDictionaryLC720 {
}


