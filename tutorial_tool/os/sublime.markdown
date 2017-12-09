#### 集成Graphviz

第一步：下载https://github.com/munro/SublimeGraphvizPreview/archive/master.zip

第二步：打开Preferences -> Packages Settings-> Packages Control -> Settings User，来确认一下installed_packages没有GraphVizPreview。并且增加”remove_orphaned”: false防止Sublime Text 把手动安装的插件包给删除了。

```
{
  "bootstrapped": true,
  "in_process_packages":
  [
  ],
  "installed_packages":
  [
  "EncodingHelper",
  "Package Control",
  "Theme - Spacegray"
  ],
  "remove_orphaned": false
}
```

第三步：打开Preferences -> Browse Packages…进入到Sublime Text的插件包下Packagas。

第四步：解压zip文件到Packagas下，并且更改文件夹SublimeGraphvizPreview-master为GraphVizPreview。

第五步：重启Sublime Text。

注：快捷键为Win+Shift+G，调用Graphviz 调用dot引擎去绘制当前脚本。

#### 查找字符串：

    ^(.+)$[\r\n](^\1$[\r\n]{0, 1})+

#### 删除重复行

排序好后，按Ctrl+H，调出替换面板

查找字符串：

    ^(.+)$[\r\n](^\1$[\r\n]{0, 1})+
注意：确保正则模式开关打开；若不可用，按Alt+R进行切换
替换字符串：

    \1

点击Replace

#### 命令行启动sublime

```
alias sublime=\''/Applications/Sublime.app/Contents/SharedSupport/bin/subl'\'
```
#### next

