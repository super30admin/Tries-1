// Time Complexity : O(mn) bigger of length of dicionary or sentence
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
insert each word of dictionary into the trie containing 26 children and the word itself if its ending at that node
split the sentence by " " for each word in sentence search and replace current word by search in trie that returns smallest prefix or the word itself
join and return the words of sentence
*/
package main

import (
	"fmt"
	"strings"
)

type Trie2 struct {
	children [26]*Trie2
	fword string
}

func Constructor2() Trie2 {
	return Trie2{}
}

func (this *Trie2) InsertTrie2(w string) {
	curr := this
	for i:=0;i<len(w);i++ {
		if curr.children[w[i] - 'a'] == nil {
			curr.children[w[i] - 'a'] = &Trie2{}
		}
		curr = curr.children[w[i] - 'a']
	}
	curr.fword = w
}

func (this *Trie2) SearchPreTrie2(w string) string {
	curr := this
	for i:=0;i<len(w);i++ {
		if curr.children[w[i] - 'a'] != nil {
			if len(curr.children[w[i] - 'a'].fword) > 0 {
				return curr.children[w[i] - 'a'].fword
			}
			curr = curr.children[w[i] - 'a']
		} else {
			return w
		}
	}
	return w
}

func replaceWords(dictionary []string, sentence string) string {
	root := Constructor2()
	for i:=0;i<len(dictionary);i++ {
		root.InsertTrie2(dictionary[i])
	}
	words := strings.Fields(sentence)
	for i:=0;i<len(words);i++ {
		words[i] = root.SearchPreTrie2(words[i])
	}
	return strings.Join(words, " ")
}

func MainReplaceWords() {
	fmt.Println(replaceWords([]string{"cat","bat","rat"}, "the cattle was rattled by the battery")) //expected "the cat was rat by the bat"
}

/*func replaceWords(dict []string, sentence string) string {
	magic := make(map[string]interface{})
	// max, min for speed up
	max, min := 0, 1000
	for _, v := range dict {
		magic[v] = nil
		l := len(v)
		if l > max {
			max = l
		}
		if l < min {
			min = l
		}
	}
	fields := strings.Fields(sentence)
	for i, v := range fields {
		// j < len(v) is better than j ≤ len(v)
		for j := min; j < len(v) && j <= max; j++ {
			vs := v[:j]
			if _, exist := magic[vs]; exist {
				fmt.Println(fields[i], vs)
				fields[i] = vs
				break
			}
		}
	}
	return strings.Join(fields, " ")
}*/
