// Time Complexity: O(nl) where n is the number of words and l is the average length of all words
// Space Complexity: O(nl)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No.

class TriNode {
  constructor(char) {
    this.char = char;
    this.isEndWord = false;
    this.children = []; // arrays in js are dynamic so we don't need to create a fixed length array
  }
}

class Trie {
  constructor() {
    this.root = new TriNode(""); // root node
  }

  getIndex(char) {
    return char.charCodeAt(0) - "a".charCodeAt(0);
  }

  insert(word) {
    let currentNode = this.root;
    for (let i = 0; i < word.length; i++) {
      let char = word[i];
      if (currentNode.children[this.getIndex(char)] === undefined) {
        currentNode.children[this.getIndex(char)] = new TriNode(char);
      }
      currentNode = currentNode.children[this.getIndex(char)];
    }
    currentNode.isEndWord = true;
  }

  search(word) {
    let currentNode = this.root;
    for (let i = 0; i < word.length; i++) {
      let char = word[i];
      if (
        currentNode.children[this.getIndex(char)] === undefined ||
        (i === word.length - 1 &&
          !currentNode.children[this.getIndex(char)].isEndWord)
      ) {
        return false;
      }
      currentNode = currentNode.children[this.getIndex(char)];
    }
    return true;
  }

  startsWith(word) {
    let currentNode = this.root;
    for (let i = 0; i < word.length; i++) {
      let char = word[i];
      if (currentNode.children[this.getIndex(char)] === undefined) {
        return false;
      }
      currentNode = currentNode.children[this.getIndex(char)];
    }
    return true;
  }
}

const trieDS = new Trie();
let keys = ["the", "a", "there", "answer", "any", "by", "bye", "their", "abc"];
for (let i = 0; i < keys.length; i++) {
  trieDS.insert(keys[i]);
}
console.dir(trieDS, { depth: null });
console.log(trieDS.search("answers"));
console.log(trieDS.startsWith("byes"));
