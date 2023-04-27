public class Problem2 {
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;
            public TrieNode(){
                this.children = new TrieNode[26];
            }
        }
        private void insert(TrieNode root, String word){
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
                if(curr.isEnd)
                    return;
        }
        curr.isEnd = true;
        }
        public String replaceWords(List<String> dictionary, String sentence) {
            TrieNode root = new TrieNode();
            for(String word: dictionary){
                insert(root, word);
            }
            StringBuilder result = new StringBuilder();
            String[] strArr = sentence.split(" ");
            for(int i = 0; i < strArr.length; i++){
                String word = strArr[i];
                StringBuilder replacement = new StringBuilder();
                TrieNode curr = root; 
                for(int j = 0; j < word.length(); j++){
                    char c = word.charAt(j);
                    if(curr.children[c - 'a'] == null || curr.isEnd == true){
                        break;
                    }
                    replacement.append(c);
                    curr = curr.children[c - 'a'];
                }
                if(curr.isEnd){
                    result.append(replacement);
                }
                else {
                    result.append(word);
                }
                result.append(" ");
            }
                return result.toString().trim();
        }
    }

