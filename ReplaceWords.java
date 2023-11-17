import java.util.List;

//Time Complexity:length of the sentence
//Space Complexity: length of words in the dictionary
class ReplaceWords {
    class Trie{
        Trie[] children;
        boolean isEnd;
        Trie(){
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }

    Trie root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        StringBuilder str = new StringBuilder();

        for(String current: dictionary){
            Trie curr = root;
            for(char ch: current.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new Trie();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isEnd = true;
        }
        Trie curr = root;
        boolean checkMatch = true;
        boolean matchEnd = false;
        for(int i =0; i< sentence.length(); i++){

            char ch = sentence.charAt(i);
            if(!matchEnd){
                str.append(ch);
            }
            if(ch == ' '){
                curr = root;
                if(matchEnd== true)str.append(' ');
                matchEnd = false;
                checkMatch = true;
                continue;
            }
            if(checkMatch && curr.children[ch-'a'] != null){
                curr = curr.children[ch-'a'];
                if(curr.isEnd == true){
                    matchEnd = true;
                }
            }
            else{
                checkMatch = false;
            }
        }

        return str.toString();

    }
}
