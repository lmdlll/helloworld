#题目：打印出如下图案（菱形）:
'''
   *
  ***
 *****
*******
 *****
  ***
   *
分析：分成两部分，前四行,后三行，利用双重for循环，第一层控制行，第二层控制列。
'''

from sys import stdout
#上半部分
for i in range(4):
    for j in range(2 - i + 1):
        stdout.write(' ')
    for k in range(2 * i + 1):
        stdout.write('*')
    print
#下半部分
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

