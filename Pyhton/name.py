# _*_ coding: utf-8 _*_

#python2与python3的输入略有不同:
#   python2如果要输入字符串，使用raw_input；输入数字的话直接input
#     当然，也可以输入一个数字字符串，转换为int
'''
eg:
>>> a=raw_input("输入：")
输入：123
>>> a
'123'
>>> type(a)
<type 'str'>
>>> b=input("输入：")
输入：123
>>> type(b)
<type 'int'>
>>> c=int(raw_input("输入："))
输入：123
>>> type(c)
<type 'int'>
'''
#   python3输入字符串还是数字都是input
def Print():
    name=str(raw_input("请输入您的姓名："))
    print(name)


def test():
    a=int(input("输入一个数字"))
    print(a)
