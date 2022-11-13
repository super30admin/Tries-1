class Tri{
    Tri[] c;
    boolean iw;
    Tri(){
        c = new Tri[26];
    }
}
class Solution {
            private Tri r;
        public Solution() {
        r = new Tri();
    }
    public String longestWord(String[] words) {

        for(String w : words){
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
        String a = "";
            for(String w : words){
                if((w.length()>a.length() || (w.length()==a.length() && w.compareTo(a)<0))){
                    Tri cu = r;
                    int count =0;
                    for(int i =0; i<w.length(); ++i){
                int ch = w.charAt(i)-'a';
                Tri cuu = cu.c[ch];
                if(cuu.iw==true){
                    cu = cuu;
                    count++;
                }else{
                    break;
            }
            if(count == w.length()){
                a = w;
            }
                }
            }
        
    }
    return a;
}}
//tc=nl^2
//sc=26^l
