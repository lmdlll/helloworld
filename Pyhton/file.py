# 有两个磁盘文件A和B,各存放一行字母,把这两个文件中的信息合并(按字母顺序排列), 输出到一个新文件C中

#open()读取文件
fo=open("/Users/lmd/Desktop/python/a.txt")
str1=fo.read()
fo2=open("/Users/lmd/Desktop/python/b.txt")
str2=fo2.read()
#文件内容合并
str3=list(str1+str2)
#使用sort()，对内容进行排序
str3.sort()
s=''
s=s.join(str3)

fo3=open("/Users/lmd/Desktop/python/c.txt")
#向文件中输入内容
fo3.write(s)
