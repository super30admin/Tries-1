class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        roots = set(dictionary)
        res = []

        for word in sentence.split():
            prefix = ""
            replaced = False

            for ch in word:
                prefix += ch
                if prefix in roots:
                    res.append(prefix)
                    replaced = True
                    break

            if not replaced:
                res.append(word)

        return " ".join(res)