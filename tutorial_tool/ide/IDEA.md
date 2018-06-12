#### properties配置文件正常显示

project settings - File Encoding - Transparent native-to-ascii conversion

#### 设置忽略@param注释中的参数与方法中的参数 不一致的 取消错误提示

Editor - Inspections - Java - Javadoc issues - Declaration has problems in Javadoc references 改为 warning 

#### 取消IDEA启动后默认打开工程
Preference  -> Appearance & Behavior>System Settings

去掉默认的勾选Reopen last project on startup（在启动的时候打开上次的项目）

#### 关闭注释中param错误的提示

preferences -> 输入javadoc -> Insections -> 找到Javadoc issues -> Declararion has problems in Javadoc references
右侧 error 改为 warning

#### 多项目、多窗口打开

>先打开一个项目，打开Preferences，点击Appearance & Settings, 点击System Settings, 找到Project Opening，打钩Open project in new window

#### 犯毛病Finished, Saving caches

>1. echo $HOSTNAME 
>2. vim /etc/hosts, 添加 127.0.0.1 localhost bogon 即可

#### Version Control

Local Changes 颜色显示

>红色 -> 冲突

>绿色 -> 新增

>蓝色 -> 修改

>灰色 -> 删除

#### 关联Beyond Compare
Preference -> Tools -> Diff & Merge -> External Diff Tools

#### UTF-8编码
Preference -> Tools -> Diff & Merge -> File Encodings
三个均选择UTF-8

#### IDEA Editor Tabs设置
Preferences→Editor→General→Editor Tabs
1. unchecked - > show tabs in single row
2. unchecked - > show 'close' button on editor tabs
3. checked   - > Mark modified tabs with asterisk
4. Tab limited - > 10

#### 正则表达式插件

regexplugin