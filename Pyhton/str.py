# 题目：计算字符串中子串出现的次数

#只需要使用一个方法就可以解决，太简单了，比java简单太多，自己判断有无子字符串
if __name__ == '__main__':
    str1 = raw_input('请输入一个字符串:\n')
    str2 = raw_input('请输入一个子字符串:\n')
    ncount = str1.count(str2)
    print ncount

