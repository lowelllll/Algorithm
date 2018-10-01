# 이진 탐색 알고리즘
# 매개변수로 받아오는 L(list)는 정렬되어있다는 가정하에 탐색.

def binary_search(L, x):
    lower = 0
    upper = len(L) - 1
    index = 0
    middle = 0

    if x < L[lower] or x > L[upper]:
        return -1

    if x == L[lower]:
        return lower
    elif x == L[upper]:
        return upper

    while lower <= upper: # lower가 upper보다 커지게 되는 경우 요소가 없음.
        middle = (lower + upper) // 2
        if L[middle] == x:
            return middle

        if L[middle] > x:
            upper = middle - 1
        elif L[middle] < x:
            lower = middle + 1

    return -1


print(binary_search([i for i in range(1,50,3)],31))
print(binary_search([4,40,60],54))

