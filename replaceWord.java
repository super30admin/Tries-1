class Solution {
    public String replaceWords(List<String> li, String sentence) {
        String ans = "";
        
        Collections.sort(li);

        String[] arr = sentence.split(" ");

        for(int i=0; i<arr.length; i++){
            String s = arr[i];

            for(int j=0; j<li.size(); j++){
                if(arr[i].startsWith(li.get(j))){
                    s = li.get(j);
                    break;
                }
            }

            ans += s;
            if(i!=arr.length-1)
            ans += ' ';
        }

        return ans;
    }
}
