#题目：同样大小的小球1~10，随机取出一个球，计算在一定测试次数中各个小球被取出的概率
#-*- coding:utf-8 -*-
#随机数
import random

class SelectBall(object):
    def __init__(self):
        self.run()

    def run(self):
        while True:
            #类似于java中的try catch
            try:
                num = int(input('输入测试的次数： '))
            except ValueError as e:
                print('出错了'+e)
                print('请输入一个整数')
                continue
            else:
                break
        ball=[0,0,0,0,0,0,0,0,0,0]
        for i in range(num):
            n=random.randint(1,10)
            ball[n-1] += 1
        for i in range(1,11):
            print('获取到%d号球的概率：%f' %(i,ball[i-1]*1.0/num))



if __name__ == '__main__':
    SB=SelectBall()
