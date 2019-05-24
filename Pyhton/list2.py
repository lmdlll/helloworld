# 题目：反向输出一个链表。
# 思路：使用方法reverse

if __name__ == '__main__':
    #定义一个链表
    ptr = []
    print type(ptr)
    j=int(input("输入链表长度:"))
    print('请输入%d个数字' %j)
    for i in range(j):
        num = int(raw_input())
        ptr.append(num)
    print ptr
    ptr.reverse()
    print ptr
