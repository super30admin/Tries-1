// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string[]} dict
 * @param {string} sentence
 * @return {string}
 */
var TrieNode = function() {
    this.word = null;
    this.children = new Array(26);
}
var Trie = function () {
    this.root = new TrieNode;
}
Trie.prototype.insert = function(word) {
    let curr = this.root;
    for (let i = 0; i < word.length; i++) {
        let c = word.charCodeAt(i) - 97;
        if (curr.children[c] == null) {
            curr.children[c] = new TrieNode();
        }
        curr = curr.children[c];
    }
    curr.word = word;
};

var replaceWords = function(dict, sentence) {
    if (!dict || !dict.length) return sentence;
    
    let trie = new Trie(),
        string = '';
    // Build Trie
    for (const word of dict) {
        trie.insert(word);
    }
    sentence = sentence.split(" ");
    for (const word of sentence) {
        let curr = trie.root;
        if (string.length > 0) {
            string += " ";
        }
        for (let i = 0; i < word.length; i++) {
            let c = word.charCodeAt(i) - 97;
            if (curr.children[c] == null || curr.word != null) break;
            curr = curr.children[c];
        }
        let replacement = curr.word;
        if (replacement == null) {
            string += word;
        } else {
            string += replacement;
        }
    }
    
    return string;
};
