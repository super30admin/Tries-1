/*
    - toss the entire dictonary in a trie
    - then split sentence into a list
    - Loop over each word in split array
    - Search for each character and form the replacement word
    - If we successfully found a replacement, then replace append the replacement to a our resulting string builder
    - Finally return the string from string builder
    

*/

// dictionary size = m, avg word len = k
// total words in sentence = n, avg word len = l
func replaceWords(dictionary []string, sentence string) string {
    root := &TrieNode{}
    // time : o(m) * o(k) = o(mk)
    for _, dict := range dictionary {
        root.Insert(dict)
    }
    
    splitWords := strings.Split(sentence, " ")
    outBldr := new(strings.Builder)
    // time : o(n) * o(l) = o(nl)
    // o(l) where l is the avg len of each word in sentence and searching for a word in trie takes o(l) time
    // time = o(nl)
    for idx, word := range splitWords {
        if idx != 0 {
            outBldr.WriteString(" ")
        }
        foundValidWord, replace := root.Search(word)
        if foundValidWord {
            splitWords[idx] = replace
            outBldr.WriteString(replace)
        } else {
            outBldr.WriteString(word)
        }
    }
    
    // total time = o(mk) + o(nl)
    // space: o(mk) + o(nl)
    
    return outBldr.String()
}



type TrieNode struct {
    isEnd bool
    childrens [26]*TrieNode
}

// time: o(k) where k is len of input str
// space: o(k)
func (t *TrieNode) Insert(word string)  {
    cur := t
    for i := 0; i < len(word); i++ {
        char := word[i]
        if cur.childrens[char-'a'] == nil {
            cur.childrens[char-'a'] = &TrieNode{
                isEnd: false, childrens: [26]*TrieNode{}}
        }
        cur = cur.childrens[char-'a']
    }
    cur.isEnd = true
}

// time: o(k) where k is len of input str
// space: o(k) for string builder - worse case we do not find any smaller valid word
func (t *TrieNode) Search(word string) (bool, string) {
    cur := t
    wordBldr := new(strings.Builder)
    for i := 0; i < len(word); i++ {
        char := word[i]
        if cur.childrens[char-'a'] == nil {return false, ""}
        cur = cur.childrens[char-'a']
        wordBldr.WriteByte(char)
        if cur.isEnd {return true, wordBldr.String()}
    }
    // did not find a smaller word than the word itself 
    return false, word

}






