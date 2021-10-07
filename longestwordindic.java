
time complexity: O(n)
space complexity: O(1)

class Solution {
    private static class Node{
		Node[] childs;
		boolean isLeaf;
		public Node(){
			this.childs = new Node[26];
		}
	}
	private void insert(Node node, String s){
		char[] arr = s.toCharArray();
		if(arr.length == 1){
			node.childs[arr[0] - 'a'] = new Node();
			if(len < 1){
				this.res = s;
				this.len = 1;
			}
			node = node.childs[arr[0] - 'a'];
			node.isLeaf = true;
		}else{
			for(int i = 0; i < arr.length - 1; i++){
				int c = arr[i] - 'a';
				if(node.childs[c] == null){
					return;
				}
				node = node.childs[c];
			}
			if(node.isLeaf){
				node.childs[arr[arr.length - 1] - 'a'] = new Node();
				node = node.childs[arr[arr.length - 1] - 'a'];
				node.isLeaf = true;
				if(arr.length > len){
					this.res = s;
					len = arr.length;
				}
			}
		}
	}
	private String res = "";
	private int len = 0;
    
    public String longestWord(String[] words) {
        Arrays.sort(words);
		Node root = new Node();
		for(String word : words){
			insert(root, word);
		}
		return res;
        
    }
}