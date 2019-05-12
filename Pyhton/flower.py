# 题目：打印出所有的“水仙花数”，所谓“水仙花数”是指一个三位数，其各位数字立方和等于该数本身。
# 分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。 
for n in range(100,1001):
    i = n / 100
    j = n / 10 % 10
    k = n % 10
    if i * 100 + j * 10 + k == i + j ** 2 + k ** 3:
        print "%-5d" % n
