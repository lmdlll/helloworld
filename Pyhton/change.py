# 题目：八进制转换为十进制
 
if __name__ == '__main__':
    n = 0
    p = raw_input('请输入一个数字:\n')
    for i in range(len(p)):
        n = n * 8 + ord(p[i]) - ord('0')
    print ("转换为十进制的数字为%d " %n)
