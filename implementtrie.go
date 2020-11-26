// Time Complexity : O(wordlen)
// Space Complexity : O(wordlen)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
struct will be array of 26 trie node pointers and isEnd bool
to insert for each letter if root.children present at that index just set the value or if not create and set then move x to x.child[index]
once all letters are done set isEnd to true

to search for each letter if child at index is nil then return false or if letters finished then if x.isEnd is true then return true else false

to find prefix do same as search for prefix but return true irrespective of is end

*/
package main

import "fmt"

type Trie struct {
	children [26]*Trie
	isEnd bool
}


/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	x := this
	for _, c := range word {
		index := c - 'a'
		if x.children[index] == nil {
			x.children[index] = &Trie{}
		}
		x = x.children[index]
	}
	x.isEnd = true
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	x := this
	for _, c := range word {
		index := c - 'a'
		if x.children[index] == nil {
			return false
		}
		x = x.children[index]
	}
	return x.isEnd
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	x := this
	for _, c := range prefix {
		index := c - 'a'
		if x.children[index] == nil {
			return false
		}
		x = x.children[index]
	}
	return true
}

func MainImplementTrie() {
	trie := Constructor()

	trie.Insert("apple")
	fmt.Println(trie.Search("apple"))   // returns true
	fmt.Println(trie.Search("app"))     // returns false
	fmt.Println(trie.StartsWith("app")) // returns true
	trie.Insert("app")
	fmt.Println(trie.Search("app"))     // returns true
}