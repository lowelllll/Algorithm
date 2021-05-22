# [LeetCode] 19. Remove Nth Node From End of List

#### 분류

LinkedList

[문제 링크](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

### 내 풀이

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        self.prev = None

        
class Solution:

    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        nextNode = head
        tail = head
        head.prev = None

        while nextNode.next:
            nextNode.next.prev = nextNode
            nextNode = nextNode.next
            tail = nextNode

        targetNode = tail
        for _ in range(n-1):
            targetNode = targetNode.prev

        if targetNode.prev:
            targetNode.prev.next = targetNode.next
        else: # -> head
            head = targetNode.next

        return head
```

### 과정
소요 시간: 40분  
미리 만들어져있는 `ListNode`에 `prev`가 선언이 안되어있어서 `next`만 가지고 풀어보다가 그냥 `prev`추가해서 풀었다.  

### 배운점
https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/1164537/Short-and-Simple-One-Pass-Solution-w-Explanation-or-Beats-100-or-No-dummy-node-required!
