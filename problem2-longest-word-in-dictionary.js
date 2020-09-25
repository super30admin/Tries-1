//// Time Complexity :
//// Space Complexity :
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :

//// Your code here along with comments explaining your approach
var Trie, TrieNode, charToIndex, dfs, longestWord, result;

charToIndex = function(char) {
  return char.charCodeAt() - 'a'.charCodeAt();
};

TrieNode = function() {
  return Object.assign(Object.create(TrieNode.prototype), {
    children: Array(26),
    word: ''
  });
};

Trie = function() {
  return Object.assign(Object.create(Trie.prototype), {
    root: TrieNode()
  });
};

Trie.prototype.insert = function(words) {
  var curr, j, ref, results, word, x;
  results = [];
  for (word in words) {
    curr = this.root;
    for (x = j = 0, ref = word.length; (0 <= ref ? j < ref : j > ref); x = 0 <= ref ? ++j : --j) {
      if (curr.children[charToIndex(words[x])] == null) {
        curr.children[charToIndex(words[x])] = Trie();
      }
      curr = curr.children[charToIndex(words[x])].root;
    }
    results.push(curr.word = word);
  }
  return results;
};

result = '';

dfs = function(root) {
  var i, j, results;
  if (root.word.length > result.length) {
    result = root.word;
  }
  results = [];
  for (i = j = 0; j < 26; i = ++j) {
    if (!root.children[i] && root.children[i].word !== '') {
      results.push(dfs(root.children[i]));
    } else {
      results.push(void 0);
    }
  }
  return results;
};

longestWord = function(words) {
  var root;
  if ((words == null) || words.length === 0) {
    return '';
  }
  root = Trie().root;
  root.insert(words);
  dfs(root);
  return result;
};

//# sourceMappingURL=problem2-longest-word-in-dictionary.js.map
