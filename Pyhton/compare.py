#��Ŀ��������������x,y,z���������������С���������
class PrintTable(object):
    def __init__(self):
        print("�Ƚ��������֣���С����")
        self.func1()
        self.func2()
        self.func3()
        print("over")
    #����һ��
    def func1(self):
        l = []
        for i in range(3): #i(0~2)
            x = int(raw_input('integer:\n'))
            l.append(x) #������append()������׷��Ԫ��
            l.sort()
        print l


    #�������������һ���������洢��Сֵ�����������бȽϺ���������
    def func2(self):
        x = input("input a num: ")
        y = input("input a num: ")
        z = input("input a num: ")
        temp = 0
        if x < y:
            temp = x
            x = y
            #y����С�� x�ڶ�С
            y = temp
        if x < z:
            temp = x
            x = z
            z = temp
        if y < z:
            temp = y
            y = z
            z = temp
        print z,y,x #������������С�������ȽϺͽ����ģ�����������Ҫ�������
 


#������������ú���sort��������sort�������԰����ְ��մ�С�����˳������������С�
    def func3(self):
        x = input("input a num:")
        y = input("input a num:")
        z = input("input a num:")
        y = [x,y,z] #ע�⣬����ֻ�����б�������Ԫ�飬��ΪԪ���ǲ��ɸı�ģ���
        y.sort()
        print y


if __name__=='__main__':
    fc=PrintTable()


