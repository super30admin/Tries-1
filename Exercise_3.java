class Solution {
    private Tri r;
        public Solution() {
        r = new Tri();}
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");

        for(String w : dictionary){
            Tri cu = r;
            for(int i =0; i<w.length(); ++i){
                int ch = w.charAt(i)-'a';
                if(cu.c[ch]==null){
                    cu.c[ch] = new Tri();
                }
                    cu = cu.c[ch];
            }
            cu.iw = true;
        }
        //String a = "";
            for(int j = 0; j<words.length; ++j){
                //if((w.length()>a.length() || (w.length()==a.length() && w.compareTo(a)<0))){
                    String w = words[j];
                    Tri cu = r;
                    StringBuilder a = new StringBuilder();
                    //int count =0;
                    for(int i =0; i<w.length(); ++i){
                int ch = w.charAt(i)-'a';
                Tri cuu = cu.c[ch];
                if(cuu!= null && cuu.iw==true){
                    a.append(cu);
                    //String b = a.toString();
                    words[j] = w.substring(0,i+1);
                    break;
                    //count++;
                }else if(cuu== null){
                    // a.append(cu);
                    // cu = cuu;
                    break;
            }
            a.append(cu);
            cu = cuu;
            // if(count == w.length()){
            //     a = w;
            // }
                }
            //}

    }
    return String.join(" ", words);
}
    }
class Tri{
    Tri[] c;
    boolean iw;
    Tri(){
        c = new Tri[26];
    }
}
//tc=O(wl)
//sc=O(26^l)
