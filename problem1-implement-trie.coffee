#https://leetcode.com/problems/implement-trie-prefix-tree/
#// Time Complexity :
#// Space Complexity :
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
# internalizing backtracking problems
#
#// Your code here along with comments explaining your approach

charToIndex = (char) -> char.charCodeAt() - 'a'.charCodeAt()

Trie = () -> Object.assign(
  Object.create(Trie::),
  children: Array(26)
  isWord: false
)

Trie::insert = (word) ->
  curr = @

  for x in [0...word.length]
    ch = word[x]

    if !curr.children[charToIndex(ch)]?
      curr.children[charToIndex(ch)] = Trie()

    curr = curr.children[charToIndex(ch)]

  curr.isWord = true

Trie::search = (word) ->
  curr = @

  for x in [0...word.length]
    ch = word[x]

    if !curr.children[charToIndex(ch)]?
      return false

    curr = curr.children[charToIndex(ch)]

  curr.isWord

Trie::startsWith = (prefix) ->
  curr = @

  for x in [0...prefix.length]
    ch = prefix[x]

    if !curr.children[charToIndex(ch)]?
      return false

    curr = curr.children[charToIndex(ch)]

  true

mt = Trie()
mt.insert('apple')
mt.search('apple')
mt.search('z')
mt.startsWith('app')
mt.startsWith('apple')
