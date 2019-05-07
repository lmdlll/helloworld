import random
print("猜数字游戏2：")
#产生随机数字
sel=random.randint(1,100)
i=0
while i<5:
    flag=input("请输入：")
    guess=int(flag)
    if guess==sel:
        print("猜对了")
        print("没奖励，游戏退出")
        break
    #开始我使用的是else if 结果疯狂报错，通过查书，Python独有的elif
    elif guess>sel:
        print("大了，再猜")
    else:
        print("小了，再猜")
    #python中没有i++操作
    i+=1
if i==5:
    print("猜错5次，游戏结束")
