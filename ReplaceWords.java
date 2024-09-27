//Using hashing

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>();
        
        for(String word: dict)
            set.add(word);
        
        
        StringBuilder sb = new StringBuilder();
        
        for(String word: sentence.split("\\s+")){
            String pre = ""; 
            for(int i = 1;i <= word.length(); i++){
                pre = word.substring(0,i);
                if(set.contains(pre))break;
                
                
            }
            if(sb.length() > 0) sb.append(" ");
            sb.append(pre);
        }
        return sb.toString();
    }
}
