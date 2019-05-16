#题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
#思路：对n进行分解质因数，应先找到一个最小的质数k,利用循环
 
def reduceNum(n):
    print '{} = '.format(n),
    #对输入的值n进行非法判断
    if not isinstance(n, int) or n <= 0 :
        print '输入数字有问题 !'
        exit(0)
    #如果n=1：
    elif n in [1] :
        print '{}'.format(n)
    #循环保证递归 while(n!=1)
    while n not in [1] : 
        for index in xrange(2, n + 1) : #2~n
            if n % index == 0:
                n /= index
                if n == 1: 
                    print index 
                else : # index 一定是素数
                    print '{} *'.format(index),
                break
            
reduceNum(90)
reduceNum(100)
reduceNum(1)



