def longestWord(self, words: List[str]) -> str:
    #sort the words, then keep in the set and check for nextWord[:-1] in the set
    words.sort()
    st, res = set(), "" #res == result
    st.add("")
    for word in words:
        if word[:-1] in st:
            if len(word) > len(res):
                res = word
            st.add(word)
    
    return res