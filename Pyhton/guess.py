print('---------------------我爱python之猜数游戏--------------')
#input是python的一个内置函数
temp = input("请输入一个数字，看我们之间的默契：")
#temp是一个字符串类型，转换为整形
guess = int(temp)
if guess==8 :
    print("哦，猜中了")
    #缩进是python的灵魂，缩进的错误可能会导致代码的错误（类似于c语言中括号）
    print("猜中没奖励")
else:
    print("看来我们之间没有默契")
print("游戏结束")

# BIF==Built-in function
