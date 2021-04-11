# [LeetCode] 329. Longest Increasing Path in a Matrix

#### 분류

DFS, Memoization

[문제 링크](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

### 내 풀이

```python
from typing import List

class Solution:
    def __init__(self):
        self.matrix = None
        self.max_long_increase_matrix = None
        self.max_long_increase = 0
        self.m = 0
        self.n = 0

    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        self.m = len(matrix)
        self.n = len(matrix[0])
        self.matrix = matrix
        self.max_long_increase_matrix = [[0 for j in range(self.n)] for i in range(self.m)]

        for i in range(self.m):
            for j in range(self.n):
                if self.max_long_increase_matrix[i][j] == 0:
                    self.find(i, j)

        return self.max_long_increase

    def find(self, i, j):
        if self.max_long_increase_matrix[i][j] != 0:
            return self.max_long_increase_matrix[i][j]

        direction = [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]

        max_increase = 0
        for x, y in direction:
            try:
                if x < 0 or y < 0:
                    value = -1
                else:
                    value = self.matrix[x][y]
            except Exception:
                value = -1

            if value > self.matrix[i][j]:
                max_increase = max(max_increase, self.find(x, y))

        max_increase += 1
        self.max_long_increase_matrix[i][j] = max_increase
        self.max_long_increase = max(self.max_long_increase, max_increase)
        return max_increase


if __name__ == '__main__':
    print(Solution().longestIncreasingPath([[9,9,4],[6,6,8],[2,1,1]]))
```

### 배운점
릿코드에서 처음 푼 문제...  
3시간 걸렸다 ㅎ......  
빨리 풀고싶은 맘에 코드는 더럽지만... hard 풀어서 뿌듯하당  
나중에 개선해야징~ 
