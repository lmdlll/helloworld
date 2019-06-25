#题目：求0—7所能组成的奇数个数。
'''
程序分析：
1位数是 4 个。     1 3 5 7
2位数是 7*4个。  x1 x3 x5 x7 x=1,2,3,4,5,6,7
3位数是 7*8*4个。
4位数是 7*8*8*4个。
......
'''
# -*- coding: UTF-8 -*-
 
if __name__ == '__main__':
    sum = 4
    s = 4
    for j in range(2,9):
        print sum
        if j <= 2:
            s *= 7
        else:
            s *= 8
        sum += s
    print 'sum = %d' % sum
