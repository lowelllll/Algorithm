## [Programmers] LEVEL 1 x만큼 간격이 있는 숫자

### 문제

함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

#### 제한 조건

- x는 -10000000 이상, 10000000 이하인 정수입니다.
- n은 1000 이하인 자연수입니다.

#### 입출력 예

| x    | n    | answer       |
| ---- | ---- | ------------ |
| 2    | 5    | [2,4,6,8,10] |
| 4    | 3    | [4,8,12]     |
| -4   | 2    | [-4, -8]     |

### 내 풀이

```java
class Solution {
    static int[] number;
    static int goal;
    static int dfs(int level,int value){ //level번째부터 계산하여 가능한 방법의 수
        if(level==number.length){
            if(value==goal){ return 1;}
            else return 0;
        }
        int ret = 0;
        ret+=dfs(level+1,value+number[level]);
        ret+=dfs(level+1,value-number[level]);
        return ret;
    }
    public int solution(int[] numbers, int target) {
        goal = target;
        number = numbers;
        int answer = dfs(0,0);
        return answer;
    }
}
	 
```

## refer

[x만큼 간격이 있는 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954?language=java)