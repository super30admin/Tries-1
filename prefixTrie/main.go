

type TrieNode struct {
    isEnd bool
    childrens [26]*TrieNode
}

type Trie struct {
    root *TrieNode
}


func Constructor() Trie {
    return Trie{
        root: &TrieNode{
            isEnd: false, 
            childrens: [26]*TrieNode{},
        },
    }
}

// time: o(k) where k is len of input str
// space: o(k)
func (this *Trie) Insert(word string)  {
    cur := this.root
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
// space: o(1)
func (this *Trie) Search(word string) bool {
    cur := this.root
    for i := 0; i < len(word); i++ {
        char := word[i]
        if cur.childrens[char-'a'] == nil {return false}
        cur = cur.childrens[char-'a']
    }
    return cur.isEnd

}

// time: o(k) where k is len of input str
// space: o(1)
func (this *Trie) StartsWith(prefix string) bool {
    cur := this.root
    for i := 0; i < len(prefix); i++ {
        char := prefix[i]
        if cur.childrens[char-'a'] == nil {return false}
        cur = cur.childrens[char-'a']
    }
    return true
}


// to get index of a character in golang
// use unit8-lowerCaseRune ( if looking for idx for lowercase character , upper case otherwise )
// for example
// uint8=97 - 'a' -- gives us idx 0

/*
w := "amrit"
for i := 0; i < len(w); i++ {
    char := w[i]
    fmt.Printf("%v: %T %v\n", string(char), char, char-'a')
}
a: uint8 0
m: uint8 12
r: uint8 17
i: uint8 8
t: uint8 19
*/
