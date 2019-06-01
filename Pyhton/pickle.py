#pickle的使用：python对象-->二进制存放的字节流

def pickuse():
    #首先，引用pickle
    import cPickle as pickle  
    #创建一个列表
    my_lists=[123,3.14,-8,'hello',['another']]
    #创建一个文件，以可写入二进制格式打开
    pickle_file=open('C:\Users\acer\Desktop\python练习\my_list.pkl','wb')
    #写入数据
    pickle.dump(my_lists,pickle_file)
    #关闭pickle
    pickle_file.close()

#验证：
#首先打开文件，以读取二进制格式打开
pickle_file2=open('my_list.pkl','rb')
#创建一个新列表，保存读取的数据
my_list2=pickle.load(pickle_file2)
print my_list2
