// ******************** DFS Approach ********************
//
// Time Complexity:  O(n*k)
// Space Complexity: O(1)

class Solution {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;
    StringBuilder result;

    private void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    private void helper(TrieNode node, StringBuilder curStr) {

        // base
        if(curStr.length() > result.length()) {
            result = new StringBuilder(curStr);
        }

        // logic
        for(int i=0; i<26; i++) {
            if(node.children[i]!=null && node.children[i].isEnd) {
                
                int le = curStr.length();

                // action
                curStr.append((char)(i + 'a'));

                // recurse
                helper(node.children[i], curStr);

                // backtrack
                curStr.setLength(le);
            }
        }

    }

    public String longestWord(String[] words) {
        
        root = new TrieNode();
        result = new StringBuilder();

        for(String word : words) {
            insert(word);
        }

        helper(root, new StringBuilder());

        return result.toString();

    }
    
}

// // ******************** BFS Approach Optimal ********************
// //
// // Time Complexity:  O(n*k)
// // Space Complexity: O(1)

// class LongestWord {

//     class TrieNode{
//         TrieNode[] children;
//         boolean isEnd;
//         TrieNode() {
//             this.children = new TrieNode[26];
//         }
//     }

//     TrieNode root;

//     private void insert(String word) {
//         TrieNode node = root;
//         for(int i=0; i<word.length(); i++) {
//             char c = word.charAt(i);
//             if(node.children[c - 'a'] == null) {
//                 node.children[c - 'a'] = new TrieNode();
//             }
//             node = node.children[c - 'a'];
//         }
//         node.isEnd = true;
//     }

//     public String longestWord(String[] words) {
        
//         root = new TrieNode();

//         for(String word : words) {
//             insert(word);
//         }

//         Queue<TrieNode> q = new LinkedList<>();
//         Queue<String> sq = new LinkedList<>();
//         TrieNode cur = root;
//         String scur = "";

//         q.add(root);
//         sq.add("");

//         while(!q.isEmpty()) {
            
//             cur = q.poll();
//             scur = sq.poll();
            
//             for(int i=25; i>=0; i--) {
//                 if(cur.children[i] != null && cur.children[i].isEnd) {
//                     q.add(cur.children[i]);
//                     sq.add(scur + (char)(i + 'a'));
//                 }
//             }
//         }

//         return scur;

//     }
    
// }

//
//
//
//
//
//
//
//
//
//
//
//

// // ******************** BFS Approach Not optimal ********************
// //
// // Time Complexity:  O(n*k)
// // Space Complexity: O(1)

// class LongestWord {

//     class TrieNode{
//         TrieNode[] children;
//         String word;
//         TrieNode() {
//             this.children = new TrieNode[26];
//             this.word = "";
//         }
//     }

//     TrieNode root;

//     private void insert(String word) {
//         TrieNode node = root;
//         for(int i=0; i<word.length(); i++) {
//             char c = word.charAt(i);
//             if(node.children[c - 'a'] == null) {
//                 node.children[c - 'a'] = new TrieNode();
//             }
//             node = node.children[c - 'a'];
//         }
//         node.word = word;
//     }

//     public String longestWord(String[] words) {
        
//         root = new TrieNode();

//         for(String word : words) {
//             insert(word);
//         }

//         Queue<TrieNode> q = new LinkedList<>();
//         TrieNode cur = root;

//         q.add(root);
//         while(!q.isEmpty()) {
//             cur = q.poll();
//             for(int i=25; i>=0; i--) {
//                 if(cur.children[i] != null && cur.children[i].word != "") {
//                     q.add(cur.children[i]);
//                 }
//             }
//         }

//         return cur.word;

//     }
    
// }
