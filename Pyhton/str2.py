#��Ŀ������һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
#˼·�����ַ�����while��for ����������һЩ�����ж��Ƿ�����ĸ�������ֵ�

import string
#����1 while��
s = raw_input('������һ���ַ���:\n')
#Ӣ����ĸ
letters = 0
#�ո�
space = 0
#����
digit = 0
#����
others = 0
i=0
while i < len(s):
    c = s[i]
    i += 1
    #isalpha���ж��Ƿ�Ϊ��ĸ
    if c.isalpha():
        letters += 1
    #isspace���ж��Ƿ�Ϊ��ĸ
    elif c.isspace():
        space += 1
    #isdigit���ж��Ƿ�Ϊ��ĸ
    elif c.isdigit():
        digit += 1
    else:
        others += 1
print ('��ĸ��%d,�ո�%d,���֣�%d,������%d' %(letters,space,digit,others))




#����2 for:
'''
s = raw_input('������һ���ַ���:\n')
#Ӣ����ĸ
letters = 0
#�ո�
space = 0
#����
digit = 0
#����
others = 0
for c in s:
    if c.isalpha():
        letters += 1
    elif c.isspace():
        space += 1
    elif c.isdigit():
        digit += 1
    else:
        others += 1
print ('��ĸ��%d,�ո�%d,���֣�%d,������%d' %(letters,space,digit,others))
'''
