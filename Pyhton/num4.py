#��Ŀ������һ��������Ȼ���ж����ټ��� 9 ���ڸ����Ľ��Ϊ������
#���������999999 / 13 = 76923��
 
if __name__ == '__main__':
    zi = int(raw_input('����һ������:\n'))
    n1 = 1
    c9 = 1
    m9 = 9
    sum = 9
    while n1 != 0:
        if sum % zi == 0:
            n1 = 0
        else:
            m9 *= 10
            sum += m9
            c9 += 1
    print '%d �� 9 ���Ա� %d ���� : %d' % (c9,zi,sum)
    r = sum / zi
    print '%d / %d = %d' % (sum,zi,r)
