class Solution {
    private class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean terminate = false;

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("terminate: ");
            sb.append(this.terminate);
            sb.append("\n");
            this.map.forEach((key, value) -> sb.append(key + "\n"));
            return sb.toString();
        }
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;

        for(char c : w){
            if(!node.map.containsKey(c)){
                node.map.put(c, new TrieNode());
            }
            //System.out.println(node);
            node = node.map.get(c);
        }

        node.terminate = true;
        //System.out.println(node);
        
    }

    private String findPrefix(String word){

        TrieNode node = root;

        StringBuilder ssf = new StringBuilder();

        for(char c : word.toCharArray()){
            if(node.terminate) return ssf.toString();

            if(!node.map.containsKey(c)){
                return word;
            }

            ssf.append(c);
            node = node.map.get(c);
        }

        return node.terminate ? ssf.toString() : word;

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for(String word : dictionary) insert(word);

        StringBuilder sb = new StringBuilder();

        for(String word: sentence.split(" ")){
            String prefix = findPrefix(word);
            //System.out.println(prefix);
            sb.append(prefix);
            sb.append(" ");
        }

        return sb.toString().trim();
        
    }
}
