class Solution {

    private class TrieNode {
        Map<Character, TrieNode> map = new TreeMap<>();
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

    public String longestWord(String[] words) {

        for(String word : words){
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

        // bfs to find longest
        TrieNode prev = root;
        String longestWord = new String();

        Queue<Pair<TrieNode, String>> q = new LinkedList<>();
        q.offer(new Pair(root, longestWord));

        while(!q.isEmpty()){
            int len = q.size();
            while(len-- > 0){
                Pair<TrieNode, String> mPair = q.poll();
                TrieNode node = mPair.getKey();
                String ssf = mPair.getValue();
                if(ssf.length() > longestWord.length()){
                    longestWord = ssf;
                }
                Set<Character> children = node.map.keySet();
                for(Character child: children){
                    if(node.map.get(child).terminate){
                        q.offer(new Pair(node.map.get(child), ssf + child));
                    }
                }

            }
        }

        return longestWord;

        
    }
}
