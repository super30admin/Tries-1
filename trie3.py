#Brute force, implementing tre solution, will commit the solution
# Time Complexity: O(n)
# Space Complexity: O(n)
def longestword(words):
    wordSet =list(set(words))
    max = 0
    word = ""
    for i in range(len(wordSet)):
        if len(wordSet[i] > max):
            max = len(word)
            word = wordSet[i]
    return word

words = ["w","wo","wor","worl", "world"]
w = longestword(words)
print(w)