//TC, SC = O(ml) + O(nk)  // first term for inserting, second for fiding & placing.

class ReplaceWord {

    class TriNode{
        boolean isEnd;
        TriNode[] children;
        public TriNode(){
            this.children = new TriNode[26];
        }
    }

    public void insert(String word, TriNode root){
        TriNode curr = root;
        for(int i = 0 ; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TriNode();
            }
            curr = curr.children[c -'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TriNode root = new TriNode();
        for(String word: dictionary){ //m
            insert(word,root); //l
        }
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for(int i = 0; i<splitArr.length; i++){  //n
            if(i>0) result.append(" ");
            String word = splitArr[i];
            StringBuilder replace = new StringBuilder();
            TriNode curr = root;
            for(int k = 0; k<word.length(); k++){ // Here we are making replacement string. // k
                char c = word.charAt(k);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                curr = curr.children[c-'a'];
                replace.append(c);
            }
        if(curr.isEnd){
            result.append(replace);
        }else{
            result.append(word);
        }    
        }
        return result.toString();
    }
}