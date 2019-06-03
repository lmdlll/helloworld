# 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
# -*- coding: UTF-8 -*-

class Soultion(object):
    def __init__(self):
        self.run1()
        self.run2()
        self.run3()
        
    #方法一：
    def run1(self):
        a = 2.0
        b = 1.0
        s = 0
        for n in range(1,21):
            s += a / b
            t = a
            a = a + b
            b = t
        print s

#方法二：
    def run2(self):
        a = 2.0
        b = 1.0
        s = 0.0
        for n in range(1,21):
            s += a / b
            b,a = a , a + b
        print s
        
        s = 0.0
        for n in range(1,21):
            s += a / b
            b,a = a , a + b
        print s

#方法三：
    def run3(self):
        a = 2.0
        b = 1.0
        l = []
        l.append(a / b)
        for n in range(1,20):
            b,a = a,a + b
            l.append(a / b)
        print reduce(lambda x,y: x + y,l)
        
    
if __name__=='__main__':
    sol=Soultion()


