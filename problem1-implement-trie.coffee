#// Time Complexity :
#// Space Complexity :
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
# internalizing backtracking problems
#
#// Your code here along with comments explaining your approach

charToIndex = (char) -> char.charCodeAt() - 'a'.charCodeAt()

TrieNode = () -> Object.assign(
  Object.create(TrieNode::),
  children: Array(26)
  isWord: false
)

Trie = () -> Object.assign(
  Object.create(Trie::),
    root: TrieNode()
)

Trie::insert = (word) ->
  curr = @root

  for x in [0...word.length]
    ch = word[x]

    if !curr.children[charToIndex(ch)]?
      curr.children[charToIndex(ch)] = Trie()

    curr = curr.children[charToIndex(ch)].root

  curr.isWord = true

Trie::search = (word) ->
  curr = @root

  for x in [0...word.length]
    ch = word[x]

    if !curr.children[charToIndex(ch)]?
      return false

    curr = curr.children[charToIndex(ch)].root

  curr.isWord

Trie::startsWith = (prefix) ->
  curr = @root

  for x in [0...prefix.length]
    ch = prefix[x]

    if !curr.children[charToIndex(ch)]?
      return false

    curr = curr.children[charToIndex(ch)].root

  true

mt = Trie()
mt.insert('apple')
mt.search('apple')
mt.search('z')
mt.startsWith('app')
mt.startsWith('apple')
