# 369 게임에서 몇 번 박수를 치는지 구함.
n = input()
m = input()

clap = 0

for num in range(int(n),int(m)+1):
	if '3' in str(num) or '6' in str(num) or '9' in str(num):
		clap += 1
		print(num)


print(clap)