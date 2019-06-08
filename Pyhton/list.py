# -*- coding:UTF-8 -*-
# 列表使用实例。

#新建一个链表：
List=[10086,'移动@_@',[0,0,0]]  
#访问列表长度  
print(len(List))  
#打印下标为1以后的
print (List[1:])

#向列表后添加元素  
List.append('哎，移动的网不好啊~!')
print ('列表长度：'+len(List))
print (List)

#添加元素
List=List[:1]+['hi']+List[1:]
print (List)
#弹出列表的最后一个元素  
print(List.pop(1)) 
print(len(List),List)

