# 정수를 2진수로 변환하기 
import math

value = int(input())
result = []
while value >= 1:
	result.append(str(value%2))
	value = math.floor(value/2) # 버림함수 
	
result.reverse() 
print(''.join(result))
