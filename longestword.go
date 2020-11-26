// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
insert each word into the trie containing 26 children and the word itself if its ending at that node
add root to q and have a pointer of trie
while q is not empty
set pointer to popped element of q
check each of its children in descending order if its not nil and has an word value associated with it, if so add it to q
they are added level-wise (bfs) so last element will have longest and lexicographically smallest word return that word

*/
package main

import "fmt"

type Trie1 struct {
	children [26]*Trie1
	fword string
}

func Constructor1() Trie1 {
	return Trie1{}
}

func (this *Trie1) InsertTrie1(w string) {
	curr := this
	for i:=0;i<len(w);i++ {
		if curr.children[w[i] - 'a'] == nil {
			curr.children[w[i] - 'a'] = &Trie1{}
		}
		curr = curr.children[w[i] - 'a']
	}
	curr.fword = w
}

func longestWord(words []string) string {
	root := Constructor1()
	for i:=0;i<len(words);i++ {
		root.InsertTrie1(words[i])
	}
	q := []Trie1{root}
	var elem *Trie1
	for len(q) > 0 {
		elem = &q[0]
		q = q[1:]
		for x:=25;x>=0;x-- {
			if elem.children[x] != nil {
				if len(elem.children[x].fword) > 0 {
					q = append(q, *elem.children[x])
				}
			}
		}
	}
	return elem.fword
}

func MainLongestWord() {
	fmt.Println(longestWord([]string{"a", "banana", "app", "appl", "ap", "apply", "apple"})) //expected apple
}
