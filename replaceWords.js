// Time Complexity : O(max(M, N))
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


var Trie = function() {
    this.children = new Map();
    this.isEnd = false;
};

Trie.prototype.insert = function(word) {
    let curr = this
    for(let i = 0; i < word.length; i++){
        let node = curr.children.get(word[i])
        if(!node){
            node = new Trie();
            curr.children.set(word[i], node);
        }
        curr = node
    }
    curr.isEnd = true;
};

Trie.prototype.hasRoot = function(word){
    let curr = this;
    for(i = 0; i < word.length; i++){
        if(curr.isEnd){
            return {word:word.substring(0,i),
                    found: true};
        }
        if(curr.children.has(word[i])){
            curr = curr.children.get(word[i])
        }
        else {
            return {found: false}
        }
    }
    return {found: false};
}

var replaceWords = function(dict, sentence) {
    let senten = sentence.split(' ');
    let curr = new Trie();
    for(let root of dict){
        curr.insert(root)
    }

    for(let i = 0; i < senten.length; i++){
        let res = curr.hasRoot(senten[i]);
        if(res.found){
            senten[i] = res.word
        }
    }
    return senten.join(' ');
}