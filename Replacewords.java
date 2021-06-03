// Time Comlexity: O(n) n -> length of sentence
// Space Complexity: O(n)


class Solution {
    class TrieNode{
        HashMap<Character, TrieNode> map;
        boolean isWord;
        char c;

        public TrieNode(char c){
            this.c = c;
            map = new HashMap<>();
            isWord = false;
        }
    } 

    TrieNode root = new TrieNode('-');

    public String replaceWords(List<String> dictionary, String sentence) {

        //Insert
        for(String word: dictionary){
            insert(word);
        }

        //get words from sent
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String word: words){
            sb.append(getRoot(word));
            sb.append(" ");
        }

        sb.setLength(sb.length() - 1);

        return new String(sb);

    }

    private void insert(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.map.containsKey(ch)){
                curr = curr.map.get(ch);
            }else{
                curr.map.put(ch, new TrieNode(ch));
                 curr = curr.map.get(ch);
            }
        }
        curr.isWord = true;
    }

    private String getRoot(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();

        for(char ch : word.toCharArray()){
            if(curr.map.containsKey(ch)){
               curr = curr.map.get(ch);
                sb.append(ch);
                if(curr.isWord){
                    return new String(sb);
                } 
            }
            else{
                break;
            }
        }

        return word;
    }
}


