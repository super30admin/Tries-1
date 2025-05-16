//Time Complexity: O(n)
// Space Complexity: O(1)

public class LongestWordDict {

        String lword = "";
        class TrieNode{
            char character;
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(char character){
                this.character = character;
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        TrieNode root;
        public void insert(String word, TrieNode root){

            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                // System.out.println("c"+ c);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode(c);
                    //  System.out.println("add"+ curr.children[c-'a'].character);
                }
                curr = curr.children[c-'a'];
            }
            // System.out.println("check "+ curr.character);
            curr.isEnd = true;
            // System.out.println("adde "+ curr.isEnd);
        }

        public String longestWord(String[] words) {
            root = new TrieNode('\u0000');
            for(String w : words){
                insert(w, root);
            }
            StringBuilder sb = new StringBuilder("");

            return search(root, sb);
        }

        public String search(TrieNode root, StringBuilder sb){

            if(root == null){
                return sb.toString();
            }
            for(int i=0;i<26;i++){
                if(root.children[i] != null){
                    // System.out.println("node val"+root.children[i].character);
                    // System.out.println("node val"+root.children[i].isEnd);

                    if(root.children[i].isEnd){

                        sb.append(root.children[i].character);
                        lword = sb.length() > lword.length() ? sb.toString() : lword;
                        //System.out.println(sb);
                        search(root.children[i], sb);
                        sb.delete(sb.length()-1, sb.length());
                    }
                }
            }

            return lword;
        }

}
