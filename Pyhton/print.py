#��Ŀ����ӡ������ͼ�������Σ�:
'''
   *
  ***
 *****
*******
 *****
  ***
   *
�������ֳ������֣�ǰ����,�����У�����˫��forѭ������һ������У��ڶ�������С�
'''

from sys import stdout
#�ϰ벿��
for i in range(4):
    for j in range(2 - i + 1):
        stdout.write(' ')
    for k in range(2 * i + 1):
        stdout.write('*')
    print
#�°벿��
for i in range(3):
    for j in range(i + 1):
        stdout.write(' ')
    for k in range(4 - 2 * i + 1):
        stdout.write('*')
    print

print

for i in range(4):
    for _ in range(row - i - 1):
        print(' ', end='')
    for _ in range(2 * i + 1):
        print('*', end='')
    print()

