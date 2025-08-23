def find_element(L, x):
    find_idx = 0
    idx = 0
    answer = []

    while find_idx!=None:
        if x in L[find_idx:]:
            idx = L[find_idx:].index(x)+find_idx
            answer.append(idx)
            find_idx = idx+1
        else:
            find_idx = None

    if not answer:
        answer.append(-1)

    return answer

print(find_element([1,2,1],1))