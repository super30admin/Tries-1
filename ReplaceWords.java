// Time Complexity : O(L)  l is length of the word
// Space Complexity : O(no of words * length of each word)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    TrieNode root;
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode curr = root;

        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();

        for(String word : dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();

        String[] senArr = sentence.split(" ");

        for(int i=0;i< senArr.length;i++) {
            String word = senArr[i];
            result.append(search(word)).append(" ");
        }

        return result.toString().trim();
    }

    private String search(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for(char c : word.toCharArray()){

            if(curr.children[c-'a'] == null || curr.isEnd) {
                break;
            }

            curr = curr.children[c-'a'];
            sb.append(c);
        }

        if(curr.isEnd) {
            return  sb.toString();
        }
        return word;
    }
}

// using hashset approach
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        String[] str = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=0;i< str.length;i++){

            String word = str[i];
            boolean flag = false;
            if(i > 0){
                sb.append(" ");
            }
            for(int j=0;j<word.length();j++) {
                String substr = word.substring(0,j+1);
                if(set.contains(substr)) {
                    sb.append(substr);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                sb.append(word);
            }
        }

        return sb.toString();
    }
}