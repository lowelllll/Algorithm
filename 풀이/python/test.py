def solution(answers):
    students = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    check = {'1':{'idx':1, 'correct':0},'2':{'idx':2, 'correct':0},'3':{'idx':3, 'correct':0}}
    for idx, student in enumerate(students):
        for a_idx, answer in enumerate(answers):
            if student[a_idx%len(student)] == answer:
                check[str(idx+1)]['correct'] += 1

    scores = list(check.values())
    max_correct = max(tuple((score['correct'] for score in scores)))
    print(max_correct)
    print(scores)

    return [score['idx'] for score in scores if score['correct'] >= max_correct]


print(solution([1,3,2,4,2]))