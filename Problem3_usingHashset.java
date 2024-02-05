class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        StringBuilder re = new StringBuilder();
        String [] strArr = sentence.split(" ");
        for(int i = 0; i < strArr.length; i++){
            String word = strArr[i];
            boolean flag = false;
            for(int k = 0; k <  word.length(); k++){
                String sub = word.substring(0,k+1);
                if(set.contains(sub)){
                    re.append(sub);
                    flag = true;
                    break;
                }
            }
            if(!flag) re.append(word);
            re.append(" ");
        }
        return re.toString().trim();
    }
}