print ("输出100内的偶数")
#定义初始值
flag=1
#判断start的值若其为51，则说明上一次已经输出了100，跳出循环
while True :
    if flag==51:
        break
    print(flag*2)
    flag+=1


