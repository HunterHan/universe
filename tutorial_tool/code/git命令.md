# git 从远程仓库获取所有分支

```java
git branch -r | grep -v '\->' | while read remote; do git branch --track "${remote#origin/}" "$remote"; done
git fetch --all
git pull --all
```

# 用户名、密码

查看用户名和邮箱地址：

$ git config user.name
$ git config user.email

修改用户名和邮箱地址：

$ git config --global user.name "username"
$ git config --global user.email "email"

# 自动下载source、javadoc

maven：File settings build maven importing，勾选source和javadoc

IDE：

```xml
apply plugin:'idea'

idea {
   module {
      downloadJavadoc = true // defaults to false
      downloadSources = true
   }
}
```

# windows git bash免密

**1.1 创建文件存储GIT用户名和密码**

在%HOME%目录中，一般为C:\users\Administrator，也可以是你自己创建的系统用户名目录，反正都在C:\users\中。文件名为.git-credentials,由于在Window中不允许直接创建以"."开头的文件，所以需要借助git bash进行，打开git bash客户端，进行%HOME%目录，然后用touch创建文件 .git-credentials, 用vim编辑此文件，输入内容格式：

> `touch .git-credentials`
>
> `vim .git-credentials`
>
> `https://{username}:{password}@github.com`

**1.2 添加Git Config 内容**

进入git bash终端， 输入如下命令：

> `git config --global credential.helper store`

执行完后查看%HOME%目录下的.gitconfig文件，会多了一项：

> ```
> [credential]
> 
>     helper = store
> ```

重新开启git bash会发现git push时不用再输入用户名和密码

# LF will be replaced by CRLF in

git config core.autocrlf false 

# mac 配置 gitk

    mac 自带低版本的git 不带 gitk 命令，需要手工升级。
    git update
    git install git
    which git
    brew doctor

# 分支重命名

    git branch -m 老分支名 新分支名

# 重置暂存区的代码

    git reset HEAD file
    git reset 	所做的事情就是修改 master 分支对 commit 对象的引用。
    git reset 	有很多参数，区别在于对仓库文件状态的处理，共同点都是修改 .git/refs/heads 目录下，当前分支对应的引用文件
    git reset --hard xxxx;  // --hard 抛弃当前工作区的修改
    git push origin master / git push -f
    
    git reset --soft xxxx;  //--soft 参数回退到之前的版本，保留当前工作区的修改，可以重新提交
    git push -f;

# 按照合并数量给贡献者排序

    git shortlog -sn --no-merges

# 查看某文件的每一行代码的作者，最新commit和提交时间

    git blame xxx
    git blame -L 40,60 foo
    git blame -L 40,+21 foo
    git blame -L '/^sub hello {/,/^}$/' foo
    git blame v2.6.18.. -- foo
    git blame --since=3.weeks -- foo

# 未在项目初期加入合适的gitignore文件的处理办法

    1. 保持项目clean
    2. 修改gitignore文件
    3，git commit
    4. git rm -r --cached .
    5. git add -A
    	git commit -a
    6. git push -f

# 取消某个文件的修改

    git status -sb
    git checkout .../.../.../xxx.java

# Git集成本地Diff工具

    1、beyond compare	参考同路径下文件 gitDiffBc.txt
    2、WinMerge			参考同路径下文件 gitDiffWinMerge.txt
    3、使用命令git difftool

# git merge提交

    git checkout master
    git fetch --all
    git add . && git commit -am "xxx"
    git rebase origin/develop_salve_v2(不要执行git merge操作)
    git push

# git编码

    git config --global gui.encoding utf-8

# 分支操作

    1、创建branch：			git branch branch_name
    2、切换branch：			git checkout branch_name
    3、创建并切换分支：			git checkout -b branch_name
    4、新建分支推送至远程分支		git push origin branch_name
    5、获取远程分支新建本地分支，建立关联关系：git checkout -b branch_name origin/branch_name
    6、查看远程分支：				git branch -r
       查看本地分支				 git branch
    7、删除本地分支：				git branch -d branch_name
       删除远程branch				git push origin :branch_name

# tag操作

    1、打tag：					git tag -a tagname -m "上线版本"
    2、推送tag到服务器：		git push origin tagname
    3、获取远程tag：			git fetch origin tag tagname
    4、切换到tag工作：			git checkout tagname
    6、查看tag信息：			git show tagname
    7、删除tag：				git tag -d tagname

# git log

    git log --author=author_name
    git log --author=author_name --stat
    git log --oneline

# git revert

    回滚指定的那次提交	git revert 1ddcdcda02b4a48a2527e835ec4c15dc94d5e7c4

# gitk

    查看具体单次提交	gitk 1ddcdcda02b4a48a2527e835ec4c15dc94d5e7c4

# cherry-pick

    1、获取当次提交的key
    git add . && git commit -am "修复获取一度联系人bug"
    [develop_slave_v2 1f047e4] 修复获取一度联系人bug
    2、切换到目标分支			git checkout 其他分支
    3、抓取当次提交			 git cherry-pick 1f047e4

# 安装git

    # centos
    sudo yum install git
    # ubuntu
    sudo apt-get install git

# 配置git

    # 提交代码的log里面会显示提交者的信息
    git config --global user.name xxxxx
    git config --global user.email xxxxx@xxx.com
    
    >生成本地ssh 密钥
    1）查看本地是否已经存在ssh密钥： cd ~/.ssh
       如果没有密钥则不会有此文件夹，有则备份后删除。
    2）生成密钥： ssh-keygen -t rsa -C "xxxxxx@xxx.com" （ps：**一定是你的工作邮箱，勿错！**）
       按三次回车键，密码为空，打印一段文字后，生成两个文件：id_rsa和id_rsa.pub。
    
    >配置Host、端口号
    编辑~/.ssh/config文件，添加以下几行：
    Host xx.xx.xx.xx
    User git
    Port 65360
    
    >上传权限
    1. 登录http://xx.xx.xx.xx/
    2. 点击右上的profile settings
    3. 点击左边栏的ssh keys，添加自己开发机上的public key
    4. 在开发机上即可通过git clone <上面的项目地址>进行代码协作开发

# .gitconfig解析

```
#使用beyond compare来查看文件差异
[diff]
#对比工具名称,必须与difftool项里的名称保持一致
tool = WinMerge
[difftool "WinMerge"]
#beyond compare路径和调用命令
#$REMOTE 表示commit之后的文件
#LOCAL 表示commit到git的文件
cmd = "\"D:/data/app/WinMerge/WinMerge/WinMergeU.exe\" \"$REMOTE\" \"$LOCAL\""
#合并分支
[merge]
#对比工具名称,必须与mergetool项里的名称保持一致
tool = WinMerge
[mergetool]
prompt = false
[mergetool "WinMerge"]
#beyond compare路径和调用命令
cmd = "\"D:/data/app/WinMerge/WinMerge/WinMergeU.exe\" \"$LOCAL\" \"$REMOTE\" \"$BASE\" \"$MERGED\""
[user]
	email = 784622876@qq.com
	name = hanhongtao
[core]
	autocrlf = false
# git 命令别名
	log1 = log --graph --pretty='format:%C(red)%d%C(reset) %C(yellow)%h%C(reset) %ar %C(green)%aN%C(reset) %s'
	log2 = log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset'
	status1 = status -sb
```

> 修改最近一次commit的comment

    git commit --amend

