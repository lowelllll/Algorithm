# fibonacci
# 0 1 1 2 3 5 8 13
# f0 = 0 , f1 = 1 , fn = fn-1 + fn -2 n>=2

def fn(n):
    if n <= 1:
        return n
    else:
        return fn(n-1)+fn(n-2)


def iter_fn(n):
    left_n = 0
    right_n = 1

    if n == 0:
        return left_n
    elif n <= 2:
        return right_n
    else:
        for i in range(1,n):
            result = left_n + right_n
            left_n,right_n = right_n,result
        return result

print(iter_fn(7))