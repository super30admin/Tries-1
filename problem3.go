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


func (this *Trie) StartsWith(prefix string) string {
    curr := this
    word := ""
    for _,c := range prefix{
        if curr.IsEnd == true{
            break
        }
        
        if curr.Children[c-'a'] == nil{
            return ""
        }
        
        word+=string(c)
        
        curr = curr.Children[c-'a']
    }
    
    return word    
}

func replaceWords(dictionary []string, sentence string) string {
    if len(dictionary) == 0{
        return ""
    }
    
    if len(sentence) == 0{
        return ""
    }
    
    root := Constructor()
    for _,word := range dictionary{
        root.Insert(word)
    }
    
    sentences := strings.Split(sentence," ")
    
    for key,word := range sentences{
        result := root.StartsWith(word)
        if  result == ""{
            continue
        }
        sentences[key] = result 
    }
    
    res := strings.Join(sentences," ")
    
    return res
}




