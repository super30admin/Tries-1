//// Time Complexity :
//// Space Complexity :
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :

// internalizing backtracking problems

//// Your code here along with comments explaining your approach
var Trie, TrieNode, charToIndex, mt;

charToIndex = function(char) {
  return char.charCodeAt() - 'a'.charCodeAt();
};

TrieNode = function() {
  return Object.assign(Object.create(TrieNode.prototype), {
    children: Array(26),
    isWord: false
  });
};

Trie = function() {
  return Object.assign(Object.create(Trie.prototype), {
    root: TrieNode()
  });
};

Trie.prototype.insert = function(word) {
  var ch, curr, i, ref, x;
  curr = this.root;
  for (x = i = 0, ref = word.length; (0 <= ref ? i < ref : i > ref); x = 0 <= ref ? ++i : --i) {
    ch = word[x];
    if (curr.children[charToIndex(ch)] == null) {
      curr.children[charToIndex(ch)] = Trie();
    }
    curr = curr.children[charToIndex(ch)].root;
  }
  return curr.isWord = true;
};

Trie.prototype.search = function(word) {
  var ch, curr, i, ref, x;
  curr = this.root;
  for (x = i = 0, ref = word.length; (0 <= ref ? i < ref : i > ref); x = 0 <= ref ? ++i : --i) {
    ch = word[x];
    if (curr.children[charToIndex(ch)] == null) {
      return false;
    }
    curr = curr.children[charToIndex(ch)].root;
  }
  return curr.isWord;
};

Trie.prototype.startsWith = function(prefix) {
  var ch, curr, i, ref, x;
  curr = this.root;
  for (x = i = 0, ref = prefix.length; (0 <= ref ? i < ref : i > ref); x = 0 <= ref ? ++i : --i) {
    ch = prefix[x];
    if (curr.children[charToIndex(ch)] == null) {
      return false;
    }
    curr = curr.children[charToIndex(ch)].root;
  }
  return true;
};

mt = Trie();

mt.insert('apple');

mt.search('apple');

mt.search('z');

mt.startsWith('app');

mt.startsWith('apple');

//# sourceMappingURL=problem1-implement-trie.js.map
