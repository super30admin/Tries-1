// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
type Trie struct {
    Children    []*Trie
    IsEnd       bool
}


func Constructor() Trie {
    root := Trie{
        Children: make([]*Trie,26),
        IsEnd: false,
    }
    
    return root
}


func (this *Trie) Insert(word string)  {
    curr := this
    for _,c := range word{
        if curr.Children[c-'a'] == nil{
            curr.Children[c-'a'] = &Trie{
                Children: make([]*Trie,26),
                IsEnd: false,
            } 
        }
        curr = curr.Children[c-'a']
    }
    curr.IsEnd = true
}


func (this *Trie) Search(word string) bool {
    curr := this
    for _,c := range word{
        if curr.Children[c-'a'] == nil{
            return false
        }
        curr = curr.Children[c-'a']
    }
    
    return curr.IsEnd    
}


func (this *Trie) StartsWith(prefix string) bool {
    curr := this
    for _,c := range prefix{
        if curr.Children[c-'a'] == nil{
            return false
        }
        curr = curr.Children[c-'a']
    }
    
    return true    
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
