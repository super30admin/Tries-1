class Solution {
    
    HashMap<String,Integer> map;
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb=new StringBuilder();
        map=new HashMap<>();
        for(String x: dictionary){
            map.put(x,1);
        }
        
        String[] words=sentence.split(" "); //{"the" "cattle" "was" rattled by the battery"}
        
            for(String s:words){
                
             String tempKey="";
                for(int i=1;i<=s.length();i++){
                    tempKey=s.substring(0,i);
                    if(map.containsKey(tempKey))break;
                 }
            
                      if(sb.length()>0) sb.append(" ");
                       sb.append(tempKey);
                 
            }
    
    return sb.toString().trim();   
        
    }
                 
        }

