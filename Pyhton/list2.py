#ȥ���б����ظ�Ԫ��[0,1,2,3,4,5,5,3,1]

#����˼·��
def divit(list1):
    num=[]
    for each in list1:
        if each not in num:
            num.append(each)
    return num

#���ü���set
def divit2(list1):
    num=list(set(list1))

listi=[1,2,3,4,5,5,3,1,0]
list1 = divit(listi)
list2 = divit(listi)
print list1
print list2
