#�׳�
#�ݹ�
def plus(i):
	if i==1:
		return 1
	return plus(i-1)*i

#forѭ��
def plus2(n):
	j=1
	for i in range(1,n+1):
		j *= i
	print j


number = int(input("������һ����������"))
plus2(number)
result1 = plus(number)
print(result1)
