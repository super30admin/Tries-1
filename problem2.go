// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//TC - O(nl) -- O(N)
//SC- O(nl)
//BFS
type Trie struct{
    Children []*Trie
    Word string
}

func constructor() *Trie{
    return &Trie{
        Children: make([]*Trie,26),
        Word: "",
    }
}

func (this *Trie) Insert(word string){
    curr := this
    for _,c := range word{
        if curr.Children[c-'a'] == nil{
            curr.Children[c-'a'] = &Trie{
                Children: make([]*Trie,26),
                Word: "",
            }
        }
        
        curr = curr.Children[c-'a']
    }
    
    curr.Word = word
}

func longestWord(words []string) string {
    if len(words) == 0{
        return ""
    }
    
    root := constructor()
    
    for _,word := range words{
        root.Insert(word)
    }
    
    q := []*Trie{}
    q = append(q,root)
    result := ""
    for len(q) > 0{
        curr := q[0]
        q = q[1:]
        for i:=25;i>=0;i--{
            if curr.Children[i] != nil && curr.Children[i].Word != ""{
                q = append(q,curr.Children[i])
            }
            
            result =  curr.Word
        }
    }
    
    return result
     
    
}
