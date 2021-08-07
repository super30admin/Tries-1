// Time Complexity : O(Nk) [N-> words, k-> characters]
// Space Complexity : O(Nk)

class TrieNode {
    char c;
    boolean isWord;
    HashMap<Character,TrieNode> map;


    TrieNode(char c){
        this.c = c;
        isWord = false;
        map = new HashMap<>();
    }
}

class Solution {

    public String replaceWords(List<String> dict, String sentence) {

        TrieNode root = new TrieNode('-');

        for(String word:dict)

            insert(root,word);

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String word:words) {
            sb.append(getRoot(root,word));
            sb.append(" ");
        }


        int length = sb.length();
        sb.setLength(length-1);

        return new String(sb);
    }

    public void insert(TrieNode node,String word) {

        TrieNode temp = node;

        for(int i=0;i<word.length();i++) {
            if(temp.map.containsKey(word.charAt(i))) {
                temp = temp.map.get(word.charAt(i));
            } else {
                temp.map.put(word.charAt(i),new TrieNode(word.charAt(i)));
                temp = temp.map.get(word.charAt(i));
            }
        }
        temp.isWord = true;
    }

    public String getRoot(TrieNode root,String word) {

        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<word.length();i++) {

            if(temp.map.containsKey(word.charAt(i))) {
                temp = temp.map.get(word.charAt(i));
                sb.append(word.charAt(i));

                if(temp.isWord)
                    return new String(sb);
            } else {
                break;
            }
        }
        return word;

    }

}









