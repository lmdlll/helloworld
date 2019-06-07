#一个图形用户界面的小游戏

import easygui as g
import sys

while True:
    g.msgbox("hi，来一个图形用户界面的小游戏吧")

    msg = "请问您想要玩什么游戏呢？"
    title = "小游戏互动"
    chooses=["coding","谈恋爱","王者荣耀","五子棋"]
    choice=g.choicebox(msg,title,chooses)

    g.msgbox("您的选择是："+str(choice),"结果")

    msg="您希望重新开始小游戏码？"
    title="请选择"

    if g.ccbox(msg,title):
        pass
    else:
        sys.exit(0)
        
