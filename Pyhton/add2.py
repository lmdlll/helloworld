#��Ŀ��ͳ�� 1 �� 100 ֮�͡�
#˼·��ѭ��
def func1():
    tmp = 0
    tmp2 = 0
    for i in range(1,101):
        tmp += i
    while i!=0:
        tmp2 += i
        i -= 1
    print ('1+2+3+4+����+99+100=%d' % tmp)
    print ('1+2+3+4+����+99+100=%d' % tmp2)

func1()

