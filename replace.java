class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet(dictionary);

        StringBuilder res = new StringBuilder();        
        String[] sent = sentence.split(" ");

        for(int i=0;i<sent.length;i++){
            if(i!=0) res.append(" ");
            for(int j=0;j<sent[i].length();j++){
                String sb = sent[i].substring(0,j+1);
                if(set.contains(sb)){
                    res.append(sb);
                    break;
                }

            }
            if(res.length()==0 || res.charAt(res.length()-1)==' '){
                res.append(sent[i]);
            }            
        }
        return res.toString();    
    }
}
