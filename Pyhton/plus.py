#阶乘
#递归
def plus(i):
	if i==1:
		return 1
	return plus(i-1)*i

#for循环
def plus2(n):
	j=1
	for i in range(1,n+1):
		j *= i
	print j


number = int(input("请输入一个正整数："))
plus2(number)
result1 = plus(number)
print(result1)
