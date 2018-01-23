####智能选中
<li>在 iTerm2 中，双击选中，三击选中整行，四击智能选中，可以识别网址，引号引起的字符串，邮箱地址等。
<li>选中即复制, 任何选中状态的字符串都被放到了系统剪切板中。

####巧用 Command 键
按住⌘键:<li>可以拖拽选中的字符串；</li><li>点击 url：调用默认浏览器访问该网址；</li><li>点击文件：调用默认程序打开文件；</li><li>如果文件名是filename:42，且默认文本编辑器是 Macvim、Textmate或BBEdit，将会直接打开到这一行；</li><li>点击文件夹：在 finder 中打开该文件夹；</li><li>同时按住option键，可以以矩形选中，类似于vim中的ctrl v操作。

####常用快捷键

<li>切换 tab：⌘+←, ⌘+→, ⌘+{, ⌘+}。⌘+数字直接定位到该 tab；
<li>切分屏幕：⌘+d 水平切分，⌘+Shift+d 垂直切分；
<li>智能查找，支持正则查找：⌘+f

#### 命令搜索
<li>ctrl-r来搜索命令历史记录

####alias显示所有别名

```
bogon:risk_control_cloud hanhongtao$ alias
alias antlr4='java -Xmx500M -cp "/usr/local/antlr/antlr-4.7-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias gl='git log1'
alias grun='java org.antlr.v4.gui.TestRig'
alias gs='git status'
alias la='ll -a'
alias lh='ll -h'
alias ll='ls -l'
alias sublime=''\''/Applications/Sublime.app/Contents/SharedSupport/bin/subl'\'''
```
####快速切换目录
<li>autojump插件使你能够快速切换路径

    brew install autojump 


