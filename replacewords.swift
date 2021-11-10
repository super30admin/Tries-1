// Time Complexity : O(m*n) + 0(l*p)
// Space Complexity : O(l)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    class TrieNode {
    var isWord: Bool
    var children: [Character:TrieNode]
    init() {
        isWord = false
        children = [Character:TrieNode]()
    }
}
class Solution {
    var root = TrieNode()
    func replaceWords(_ dictionary: [String], _ sentence: String) -> String {
        var words = sentence.components(separatedBy: " ")
        var result = ""
        for word in dictionary {
            insertWords(word)
        }
        for i in 0..<words.count {
            var word = words[i]
            var replacement = ""
            var curr = root
            if i != 0 {
                result.append(" ")
            }
            for char in word {
                if curr.children[char] == nil || curr.isWord {
                    break
                } else {
                    replacement.append(char)
                    curr = curr.children[char]!
                }
                
            }
            if curr.isWord {
                result.append(replacement)
            } else {
                result.append(word)
            }
            
        }
        return result
    }
    func insertWords(_ word: String) {
        var curr = root
        for char in word {
            if curr.children[char] == nil {
               curr.children[char] = TrieNode()
            } 
            curr = curr.children[char]!
        }
        curr.isWord = true
    }
}