#题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
#思路：两种方法，while与for ，还有利用一些方法判断是否是字母还是数字等

import string
class Fun():
    #方法1 while：
    def func1():
        s = raw_input('请输入一个字符串:\n')

        #英文字母
        letters = 0
        #空格
        space = 0
        #数字
        digit = 0
        #其他
        others = 0
        i=0
        while i < len(s):
            c = s[i]
            i += 1
            #isalpha：判断是否为字母
            if c.isalpha():
                letters += 1
            #isspace：判断是否为字母
            elif c.isspace():
                space += 1
            #isdigit：判断是否为字母
            elif c.isdigit():
                digit += 1
            else:
                others += 1
        print ('字母：%d,空格：%d,数字：%d,其他：%d' %(letters,space,digit,others))




    #方法2 for:
    def func2():
        s = raw_input('请输入一个字符串:\n')

        #英文字母
        letters = 0
        #空格
        space = 0
        #数字
        digit = 0
        #其他
        others = 0
        for c in s:
            if c.isalpha():
                letters += 1
            elif c.isspace():
                space += 1
            elif c.isdigit():
                digit += 1
            else:
                others += 1
        print ('字母：%d,空格：%d,数字：%d,其他：%d' %(letters,space,digit,others))

if __name__=='__main__':
    fu=Fun()
    c=fu.func1
    c=fu.func2

    

