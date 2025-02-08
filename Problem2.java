public class Problem2 {
    //t.c -> O(mk)+O(nl)
    //s.c -> O(mk)+O(nl)
    class Solution {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            TrieNode(){
                children = new TrieNode[26];
                isEnd = false;
            }
        }
        TrieNode root;

        public void insert(String word) {
            TrieNode curr = root;
            //for each char go check the children for root and check if its null or not
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
        public String replaceWords(List<String> dictionary, String sentence) {
            if(sentence == null || sentence.length() == 0){
                return sentence;
            }
            root = new TrieNode();
            //add each word of dict in trieNode
            for(String word : dictionary){
                insert(word);
            }
            String[] words = sentence.split(" ");//split the sentence
            StringBuilder answer = new StringBuilder();
            for(int i=0;i<words.length;i++){
                if(i!=0){
                    //exluding the first word add " " before each word
                    answer.append(" ");
                }
                String word = words[i];
                StringBuilder sb = new StringBuilder();
                TrieNode curr = root;
                //for each char in the curr word go and check in trienode if any prefix is there and while moving forward add into string builder
                for(int j=0;j<word.length();j++){
                    char c = word.charAt(j);
                    if(curr.children[c-'a'] == null ||curr.isEnd == true){
                        break;
                    }
                    sb.append(c);
                    curr= curr.children[c-'a'];
                }
                if(curr.isEnd){
                    answer.append(sb.toString());
                }
                else{
                    answer.append(word);
                }

            }
            return answer.toString();
        }
    }
}
