# 从控制台输入或从文件中读入一段文本，统计出其中每个字符出现的次数，并按照出现次数排序输出

    #range() 函数可创建一个整数列表，一般用在 for 循环中
        #语法：range(start, stop[, step])
        #参数说明：
        #start: 计数从 start 开始。默认是从 0 开始。例如range（5）等价于range（0， 5）;
        #stop: 计数到 stop 结束，但不包括 stop。例如：range（0， 5） 是[0, 1, 2, 3, 4]没有5
        #step：步长，默认为1。例如：range（0， 5） 等价于 range(0, 5, 1)
    #list.count(obj)    统计某个元素在列表中出现的次数
    #list.append(obj)   在列表末尾添加新的对象
def countstr():
    stra=raw_input("请输入一串英文字符：")
    list=[]
    for i in range(len(stra)):
        num=str(stra.count(stra[i]))
        strb=stra[i]+":"+num
        if strb not in list:
            list.append(strb)
    print list

countstr()   
      

"""
str=raw_input("请输入一个字符串:")
res={}
for i in str:      
    if  i  in res:            
        res[i]=res[i]+1   
    else:           
        res[i]=1
print(res)
"""