#https://leetcode.com/problems/longest-word-in-dictionary
#// Time Complexity :
#// Space Complexity :
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
#// Your code here along with comments explaining your approach
charToIndex = (char) -> char.charCodeAt() - 'a'.charCodeAt()

Trie = () -> Object.assign(
  Object.create(Trie::),
  children: Array(26)
  word: ''
)

Trie::insert = (word) ->
  curr = @

  for x in [0...word.length]
    ch = word[x]

    if !curr.children[charToIndex(ch)]?
      curr.children[charToIndex(ch)] = Trie()

    curr = curr.children[charToIndex(ch)]

  curr.word = word

dfs = (root, result) ->
  if root.word.length > result.length
    result.push(root.word)

  for i in [0...26]
    dfs(root.children[i], result) if root.children[i] && root.children.word isnt ''

longestWord = (words) ->
  return '' if !words? or words.length is 0

  root = Trie()

  words.forEach (word) ->
    root.insert(word)

  result = []
  dfs(root, result)
  result[result.length-1]

longestWord(["w"])
#longestWord(["w","wo","wor","worl", "world"])
