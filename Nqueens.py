class Solution:
    """Backtracking
    Time complexity-O(n!) as for first row we have n choices, for next row n-2 and so on
    Space complexity-O(n^2) as board of n*n matrix is used in auxilary space and call stack will consist of n elements(queens), so this can be ignored"""
    def __init__(self):
        self.result=[]
        self.board=[]
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board=[[False]*n for _ in range(n)]
        """for i in range(n):
            l = []
            for j in range(n):
                l.append(False)
            self.board.append(l)"""
        self.helper(0,n)
        print(self.result)
        return self.result
    
    def helper(self, r, n):
        if r==n:
            li=[]
            for k in range(n):
                sb=[]
                for l in range(n):
                    if self.board[k][l]==False:
                        sb.append(".")
                    else:
                        sb.append("Q")
                li.append("".join(sb))
            self.result.append(li)
            return
                        
        for j in range(n):
            if self.isSafe(r, j, n):
                self.board[r][j]=True
                self.helper(r+1, n)
                self.board[r][j]=False
                
    def isSafe(self, r, c, n): 
        
        i=r
        j=c
        'diagnol left'
        while i>=0 and j>=0:
            if self.board[i][j]:
                return False
            i-=1
            j-=1
        'diagnol right'
        i=r
        j=c
        while i>=0 and j<n:
            if self.board[i][j]:
                return False
            i-=1
            j+=1
        'column'
        for i in range(0,r):
            if self.board[i][c]:
                return False
        return True
        
            
        
        
        
        