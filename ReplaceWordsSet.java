class Solution {
    //tc =o(n*k)
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        String [] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int j=0;j<strArr.length;j++)
        {
            String word = strArr[j];
            if(j>0) result.append(" ");
            int prevLen = result.length();
            
            for(int i=0;i<word.length();i++)
            {
                String sub = word.substring(0,i+1);
                
                if(set.contains(sub))
                {
                    result.append(sub);
                    break;
                }
            }
            if(prevLen == result.length())
            {
                result.append(word);
            }
            
        }
        return result.toString();
        
    }
}