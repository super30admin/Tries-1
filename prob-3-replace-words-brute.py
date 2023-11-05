class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        """
		Time Complexity:  O ( total_words_in_sentence * avg_length_of_word )
        Space Complexity: O(n) where N is the length of the sentence - the space used by rootset
        Did this code successfully run on Leetcode: Yes
        Any problem you faced while coding this: No
        Approach: 
        Create a set of the root words.
        For each word in the sentence, and for each combination of the prefixes in the word,
        find if there is a match in the set of root words. 
        We do prefix match from smallest prefix to largest, 
        the first match will be the replacement word.
        """
        root_set = set(dictionary) # this gives me O(1) lookup

        def replace(word):
            # This will give me the smallest match on a root word
            # since I am matching from the smallest word to largest
            # e.g. if ap, app are present, then for apple, I will match with ap and return
            for i in range(1, len(word)):
                if word[:i] in root_set:
                    return word[:i]
            #if not found, then just return word
            return word

        new_sentence = ''
        for word in sentence.split():
            new_word = replace(word)
            new_sentence = new_sentence + new_word + " "
            #print(f"word={word} new_word = {new_word} new_sentence={new_sentence}")


        return new_sentence.strip() # Remove the last space
        #return " ".join(map(replace, sentence.split()))
