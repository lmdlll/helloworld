#��Ŀ����һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
#˼·����n���зֽ���������Ӧ���ҵ�һ����С������k,����ѭ��
 
def reduceNum(n):
    print '{} = '.format(n),
    #�������ֵn���зǷ��ж�
    if not isinstance(n, int) or n <= 0 :
        print '�������������� !'
        exit(0)
    #���n=1��
    elif n in [1] :
        print '{}'.format(n)
    #ѭ����֤�ݹ� while(n!=1)
    while n not in [1] : 
        for index in xrange(2, n + 1) : #2~n
            if n % index == 0:
                n /= index
                if n == 1: 
                    print index 
                else : # index һ��������
                    print '{} *'.format(index),
                break
            
reduceNum(90)
reduceNum(100)
reduceNum(1)



