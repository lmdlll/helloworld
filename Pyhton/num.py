# ��Ŀ�����ĸ����֣�1��2��3��4������ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
# 4*4*4
# �����������ڰ�λ��ʮλ����λ�����ֶ���1��2��3��4��������е����к���ȥ �����������������С�

#��Ŀ����ͣһ�������
#���������ʹ�� time ģ��� sleep() ������

# -*- coding: UTF-8 -*-

import time
class Print(object):
    def __init__(self):
        print('��ӡ1,2,3,4����λ���������')
        self.Count()
    
    def Count(self):
        count = 0
        #��λ
        for i in range(1,5):
            #ʮλ
            for j in range(1,5):
                #��λ
                for k in range(1,5):
                    count+=1
                    print(i,j,k)
                    # ��ͣ1��
                    time.sleep(1) 
        print(count)

    def printf(self):
        myD = {1: 'a', 2: 'b'}
        for key, value in dict.items(myD):
            print key, value
            time.sleep(1) # ��ͣ 1 ��

if __name__=='__main__':
    pt=Print()
