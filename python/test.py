import pdb

def solution(priorities, location):
    queue = [i for i in range(len(priorities))]
    max_value = max(priorities)
    count = 0
    # pdb.set_trace()
    while len(queue) != 0:
        if priorities[queue[0]] != max_value:
            data = queue.pop(0)
            queue.append(data)
        else:
            data = queue.pop(0)
            priorities[data] = -1
            count += 1
            max_value = max(priorities)
            if data == location:
                break

    return count


print(solution([1, 1, 9, 1, 1, 1], 0))