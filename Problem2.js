// ## Problem2
// Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)
class TrieNode {
    constructor() {
        this.children = {};
        this.word = null;  // store complete word only at valid nodes
    }
}

var longestWord = function(words) {
    // Build Trie
    const root = new TrieNode();
    for (let word of words) {
        let node = root;
        for (let ch of word) {
            if (!node.children[ch]) {
                node.children[ch] = new TrieNode();
            }
            node = node.children[ch];
        }
        node.word = word;
    }

    // BFS
    const queue = [root];
    let result = "";

    while (queue.length > 0) {
        const node = queue.shift();

        // We prioritize lexicographically smaller children first
        const keys = Object.keys(node.children).sort().reverse(); // reverse for BFS to pop smallest last
        for (let ch of keys) {
            const child = node.children[ch];
            if (child.word !== null) {
                queue.push(child);
                // Only valid if full word exists up to this point
                if (
                    child.word.length > result.length ||
                    (child.word.length === result.length && child.word < result)
                ) {
                    result = child.word;
                }
            }
        }
    }

    return result;
};
