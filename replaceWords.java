// Time Complexity : O(M * L + N * L²)
// Space Complexity : O(M * L + N * L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        HashSet<String> set = new HashSet<>(dictionary);

        String[] splitArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < splitArr.length; i++){
            String word = splitArr[i];
            if(i > 0) result.append(" ");
            boolean flag = true;

            for(int j = 0; j < word.length(); j++){
                String subStr = word.substring(0, j+1);
                if(set.contains(subStr)){
                    result.append(subStr);
                    flag = false;
                    break;
                }
            }

            if(flag){
                result.append(word);
            }
        }
        return result.toString();
    }
}
