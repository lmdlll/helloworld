#题目：从键盘输入一个字符串，将小写字母全部转换成大写字母，大写转小

if __name__ == '__main__':
    fp = open('test.txt','w')
    string = raw_input('please input a string:\n')
    string = string.upper()
    fp.write(string)
    fp = open('test.txt','r')
    print fp.read()
    fp.close()
