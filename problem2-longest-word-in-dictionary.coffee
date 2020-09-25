#// Time Complexity :
#// Space Complexity :
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
#// Your code here along with comments explaining your approach
charToIndex = (char) -> char.charCodeAt() - 'a'.charCodeAt()

TrieNode = () -> Object.assign(
  Object.create(TrieNode::),
  children: Array(26)
  word: ''
)

Trie = () -> Object.assign(
  Object.create(Trie::),
  root: TrieNode()
)

Trie::insert = (words) ->
  for word of words
    curr = @root
    for x in [0...word.length]
      if !curr.children[charToIndex(words[x])]?
        curr.children[charToIndex(words[x])] = Trie()

      curr = curr.children[charToIndex(words[x])].root

    curr.word = word

result = ''

dfs = (root) ->
  if root.word.length > result.length
    result = root.word

  for i in [0...26]
    dfs(root.children[i]) if !root.children[i] and root.children[i].word isnt ''

longestWord = (words) ->
  return '' if !words? or words.length is 0

  root = Trie().root

  root.insert(words)

  dfs(root)

  result
