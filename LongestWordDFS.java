public class LongestWordDFS {

        //DFS - Trie
        public static class TrieNode {

            TrieNode[] children;
            boolean isEnd;

            public TrieNode() {

                this.children = new TrieNode[26];
            }

        }

        public void insertInTrie(TrieNode root, String word) {

            TrieNode curr = root;

            for(int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);

                if(curr.children[c - 'a'] == null) {

                    curr.children[c - 'a'] = new TrieNode();
                }

                curr = curr.children[c - 'a'];
            }

            curr.isEnd = true;
        }

        String longest;

        public String longestWord(String[] words) {

            // initiate empty longest string
            this.longest = "";

            // make trie of given words
            TrieNode rootMain = new TrieNode();

            for(String word: words) { //O(n*l)

                insertInTrie(rootMain, word);
            }

            // run dfs
            backtrackDFS(rootMain, new StringBuilder()); // O(n*l)

            // output
            return longest;
        }

        public void backtrackDFS(TrieNode currDfs, StringBuilder sb) {

            //base
            //update the longest if current StringBuilder is longer
            if(sb.length() > longest.length()) {

                //longest = new StringBuilder(sb).toString();
                longest = new String(sb);
            }

            //logic
            //dfs on all 26 array Trie Nodes of currDfs Trie Node
            for(int i = 0; i < 26; i++) {

                // if a word exists, then ARB
                if(currDfs.children[i] != null && currDfs.children[i].isEnd) {

                    //action
                    sb.append((char)('a' + i));

                    //recurse
                    backtrackDFS(currDfs.children[i], sb);

                    System.out.println(sb);

                    //backtrack
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

}

/*
TIME COMPLEXITY = O(n*l)
n - number of words
l - length of each word

build tree and search - n*l time

SPACE COMPLEXITY = O(n*l)

trie size - n*l
*/