def solution(heights):
    index_q = [1]
    queue = [heights[0]]
    result = [0 for _ in range(len(heights) + 1)]

    for i in range(1, len(heights)):
        while len(queue)!=0:
            if heights[i] >= queue[-1]:
                queue.pop(-1)
                cnt = index_q.pop(-1)
                if len(queue) == 0:
                    result[cnt] = 0
                    break
                else:
                    result[cnt] = index_q[-1]
            else:
                break
        queue.append(heights[i])
        index_q.append(i + 1)


    while len(queue) != 0:
        queue.pop(-1)
        cnt = index_q.pop(-1)
        if len(queue) != 0:
            result[cnt] = index_q[-1]
        else:
            result[cnt] = 0

    result.pop(0)
    return result

# 입력값 〉	[1, 5, 3, 6, 7, 6, 5]
# 기댓값 〉	[0, 0, 2, 0, 0, 5, 6]

print(solution([1,5,3,6,7,6,5]))