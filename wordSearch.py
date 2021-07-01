class Solution:
    """DFS Implementation with backtracking
    Time Complexity-O(m*n*(3^L)) where L is the length of the word
    Space complexity-O(L) as stack contains the elements of the given word and to track path as we are mutating the input array, no extra space used for that
    BFS--cant backtrack as sequence of operations lost"""
    def __init__(self):
        # self.result=[]
        self.dirs=[[0,1],[1,0],[-1,0],[0,-1]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        path=[]
        if not board:
            return False
        index=0
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.helper(board,i,j, index, word):
                    return True
        return False
    
    def helper(self, board, i, j, index, word):
        if index==len(word):
            return True
        if i<0 or i==len(board) or j<0 or j==len(board[0]) or board[i][j]!=word[index]:
            return False
        
        temp=board[i][j]
        board[i][j]="#"
        for dir in self.dirs:
            r=i+dir[0]
            c=j+dir[1]
            if self.helper(board, r,c, index+1, word):
                return True
            
        board[i][j]=temp
        return False
            
            
        
        
        
        