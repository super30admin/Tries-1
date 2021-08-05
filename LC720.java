class Solution {
    public String longestWord(String[] words) {
        
        HashSet<String> set = new HashSet<>();
        String result = "";
        for(int i = 0; i < words.length; i++){
            set.add(words[i]);
        }
        
        for(String word: words){
            if(word.length() > result.length() || word.length() == result.length() && word.compareTo(result) < 0){
                boolean flag = true;
                for(int i = 1; i < word.length(); i++){
                    if(!set.contains(word.substring(0,i))){
                        flag = false;
                    }
                }
                if(flag){
                    result = word;
                }
            }
        }
        return result;
    }
}