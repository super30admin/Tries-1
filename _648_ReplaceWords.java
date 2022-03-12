class Solution {

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();

        for(String word : dictionary){
            insert(word);
        }

        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");

        for(int i=0; i<arr.length; i++){
            String str = replace(arr[i]);
            if(str.length()>0)
                sb.append(str + " ");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }

    public void insert(String word){

        TrieNode curr = root;

        for(char ch : word.toCharArray()){

            TrieNode temp = curr.map[ch-'a'];

            if(temp == null){
                temp = new TrieNode();
            }

            curr.map[ch-'a'] = temp;
            curr = temp;
        }
        curr.end = true;
    }

    public String replace(String word){

        TrieNode curr = root;

        int i=0;

        while(!curr.end && i<word.length()){
            char ch = word.charAt(i);
            TrieNode temp = curr.map[ch-'a'];
            if(temp == null){
                break;
            }
            curr = temp;
            i++;
         }

        if(curr.end == false) return word;

        return word.substring(0,i);
    }
}

class TrieNode{

    TrieNode[] map;
    boolean end;

    public TrieNode(){
        map = new TrieNode[26];
        end = false;
    }

}
