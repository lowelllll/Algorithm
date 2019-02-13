# [Programmers] LEVEL 1 문자열 내 p와 y의 개수

### 문제

- 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

  예를들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

  ##### 제한사항

  - 문자열 s의 길이 : 50 이하의 자연수
  - 문자열 s는 알파벳으로만 이루어져 있습니다.

##### 입출력 예

| s       | answer |
| ------- | ------ |
| pPoooyY | true   |
| Pyy     | false  |

##### 입출력 예 설명

입출력 예 #1
'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.

입출력 예 #2
'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.

### 내 풀이

```python
def numPY(s):
    # 함수를 완성하세요
    s = s.lower()
    p_count = s.count('p')
    y_count = s.count('y')
    if p_count != y_count:
        return False
    return True
```

## refer

[문자열 내 p와 y의 개수](https://programmers.co.kr/learn/courses/30/lessons/12916?language=python3)

