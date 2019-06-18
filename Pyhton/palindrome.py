#题目：判断回文数：一个5位数，判断它是不是回文数。
#12321
#123321

# -*- coding: UTF-8 -*-

class Palindrome:
    def judge(self,a):
        x = str(a)
        flag = True
        for i in range(len(x)/2):
            if x[i] != x[-i - 1]:
                flag = False
                break
        if flag:
            print("%d 是一个回文数!" %a)
        else:
            print("%d 不是一个回文数!" %a)

if __name__=='__main__':
    pa=Palindrome()
    a = int(raw_input("请输入一个数字:\n"))
    pa.judge(a)
