class Solution {
    public class Node {

       Node[] arr;
       boolean isEnd;
       Node(){
        arr = new Node[26];
        isEnd = false;
       } 
    }
    public String replaceWords(List<String> dictionary, String sentence) {
    
    Node root = getDict (dictionary);
    String[] words = sentence.split(" ");        
    
   
    StringBuilder sb = new StringBuilder();
        for ( String word : words){
            sb.append (getPartialMatch(root, word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String getPartialMatch(Node root, String str){
        String match ="";
        int len = str.length();

        for (int i = 0; i< str.length();i++){
            char c= str.charAt(i);
            if (root.arr[c-'a'] == null){
                return str;
            }
            if (root.arr[c-'a'].isEnd)
            return str.substring(0,i+1);
            root = root.arr[c-'a'];
        }
        return str.trim();
    }
    private Node getDict(List<String> dictionary){
        if (dictionary == null)
        return null;

        Node root = new Node();
        for (String str : dictionary){
            int pointer = 0;
            Node track = root;
            while (pointer < str.length()){
               char c = str.charAt (pointer); 
               if (track.arr[c-'a'] == null){
                track.arr[c-'a'] = new Node();
               }
               track = track.arr[c-'a'];
               pointer++;
            }
            track.isEnd = true;
        }

        return root;
    }
}
