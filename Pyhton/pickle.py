#pickle��ʹ�ã�python����-->�����ƴ�ŵ��ֽ���

def pickuse():
    #���ȣ�����pickle
    import cPickle as pickle  
    #����һ���б�
    my_lists=[123,3.14,-8,'hello',['another']]
    #����һ���ļ����Կ�д������Ƹ�ʽ��
    pickle_file=open('C:\Users\acer\Desktop\python��ϰ\my_list.pkl','wb')
    #д������
    pickle.dump(my_lists,pickle_file)
    #�ر�pickle
    pickle_file.close()

#��֤��
#���ȴ��ļ����Զ�ȡ�����Ƹ�ʽ��
pickle_file2=open('my_list.pkl','rb')
#����һ�����б������ȡ������
my_list2=pickle.load(pickle_file2)
print my_list2
