// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


var Trie = function() {
    this.children = new Map();
    this.isEnd = false;
};


var longestWord = function(words){
    let root = new Trie();
    words.sort((a,b) => a.localeCompare(b))

    for(let word of words){
        let curr = root
        for(let w of word){
            let map = curr.children
            if(!map.has(w)) map.set(w, new Trie())
            curr = map.get(w)
        }
        curr.isEnd = true
    }
    function dfs(root, str, res){
        for(let [char, node] of root.children){
            if(!node.isEnd) continue
            res = dfs(node, str+char, res)
        }
        res = res.length<str.length ? str : res
        return res;
    }

    return dfs(root, '', '')

}