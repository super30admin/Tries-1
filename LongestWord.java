//TC = nlogn
//SC = O(n)
// Here we are sorting the giver array of string. coz we need to form the word from its previous.
// then will check the its previous string is preset set using substring.
class LongestWord{
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> build = new HashSet<>();
        Strinf res = "";
        for(String w: words){
            if(w.length() == 1 || build.contains(w.substring(0,w.length()-1))){
                if(w.length()>result.length())result = w;
                build.add(w);
            }
        }
        return result; 
    }
}
