# _*_ coding: utf-8 _*_
#总是出现文字乱码现象

#这只是一个练习
'''
class A():
    def __str__(self):
        return "可以直接返回输出，无需调用"

class B():
    def __repr__(self):
        return "也可以直接返回输出，无需调用   hello "
'''

import time as t

class MyTimer():
    def __init__(self):
        self.unit=['年','月','日','时','分','秒']
        self.prompt="未开始计时"
        self.lasted=[]
        self.begin=0
        self.end=0
    
    
    def __str__(self):
        return self.prompt

    __repr__=__str__


    def __add__(self,other):
        prompt="总共运行了"
        result=[]
        for index in range(6):
            result.append(self.lasted[index]+other.other[index])
            if result[index]:
                prompt += (str(result[index])+self.unit[index])
        return prompt
      
    #开始计时
    def start(self):
        self.begin=t.localtime()
        self.prompt="请调用stop()停止计时"
        print ("计时开始……")

    #停止计时
    def stop(self):
        if not self.begin:
            print("请先调用start()进行计时")
        else:
            self.end=t.localtime()
            print ("计时结束")
            self._calc()
            

    #内部方法，计算运行时间  Python中方法前面加_相当于私有方法
    def _calc(self):
        self.lasted=[] #计算过程
        self.prompt="总共运行了"
        #range(6)是因为localtime返回元祖，计算时间只用前6个量即可
        for index in range(6):
            self.lasted.append(self.end[index]-self.begin[index])
            if self.lasted[index]:
                self.prompt += (str(self.lasted[index])+self.unit[index])
        #为下一轮的计时初始化变量
        self.begin=0
        self.end=0
                

#类的方法名与类的属性名相同时，属性就会覆盖方法


if __name__=='__main__':
    '''
    a=A()
    print a
    #汉字有乱码，英文没问题，为什么
    b=B()
    print b
    '''




    
