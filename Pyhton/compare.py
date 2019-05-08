#题目：输入三个整数x,y,z，请把这三个数由小到大输出。
class PrintTable(object):
    def __init__(self):
        print("比较三个数字，由小到大")
        self.func1()
        self.func2()
        self.func3()
        print("over")
    #方法一：
    def func1(self):
        l = []
        for i in range(3): #i(0~2)
            x = int(raw_input('integer:\n'))
            l.append(x) #这里用append()函数，追加元素
            l.sort()
        print l


    #程序分析二：用一个变量来存储最小值，三个数进行比较后两两交换
    def func2(self):
        x = input("input a num: ")
        y = input("input a num: ")
        z = input("input a num: ")
        temp = 0
        if x < y:
            temp = x
            x = y
            #y是最小的 x第二小
            y = temp
        if x < z:
            temp = x
            x = z
            z = temp
        if y < z:
            temp = y
            y = z
            z = temp
        print z,y,x #由于上面是由小到大来比较和交换的，所以这里需要逆序输出
 


#程序分析三：用函数sort进行排序，sort函数可以把数字按照从小到大的顺序进行重新排列。
    def func3(self):
        x = input("input a num:")
        y = input("input a num:")
        z = input("input a num:")
        y = [x,y,z] #注意，这里只能是列表，不能是元组，因为元组是不可改变的！！
        y.sort()
        print y


if __name__=='__main__':
    fc=PrintTable()


