//Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        TrieNode root;

        public void insert(String word, TrieNode root){
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
        public String replaceWords(List<String> dictionary, String sentence) {

            TrieNode root = new TrieNode();
            for(String s: dictionary){
                insert(s,root);
            }

            String[] words = sentence.split(" ");
            for(int j=0;j<words.length;j++){
                String s =  words[j];
                TrieNode curr = root;
                boolean foundChar = false;
                StringBuilder sb = new StringBuilder("");
                for(int i=0;i<s.length();i++){
                    char c = s.charAt(i);
                    if(curr.children[c-'a'] != null){
                        if(curr.isEnd){
                            break;
                        }
                        sb.append(c);
                        curr = curr.children[c-'a'];
                    }else{
                        break;
                    }
                }
                System.out.println("s "+s);
                if(curr.isEnd){
                    words[j] = sb.toString();
                }
            }

            return String.join(" ", Arrays.asList(words));
        }

}
