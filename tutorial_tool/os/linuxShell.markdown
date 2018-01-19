#### grep
1. 满足任意关键字

    >  grep -E 'string1|string2|string3' 123.txt;

2. 满足所有关键字

    > grep string1 123.txt | grep string2 | grep string3;

3. 排除 1 个关键字

    > grep -v 'string1' 123.txt;

4. 排除多个关键字

    > grep -v 'string1\|string2|string2' 123.txt;

#### 计算字符串长度

> echo "Alex"|awk '{print length($0)}';

#### 日志分析

>cat 1234.txt |grep "location" | awk -F ':' '{print $2}'|sort| uniq;

#### 文件

1. 查找文件

    >find / -name 'dump.rdb';

#### 磁盘

1. 显示当前目录各文件的容量，不包含子文件夹

    >du -sh;

#### wget 获取整个网站

    wget -r -p -np -k;

    wget -np -nH -r --span-hosts;

    wget -c -r -np -k -L -p;

参数:

1. -r --recursive

    递归, 如果该文件是一个HTML文档的话, 递归下载该文件所引用（超级连接）的所有文件（递 归深度由参数-l指定）.对FTP主机，该参数意味着要下载URL指定的目录中的所有文件，递归方法与HTTP主机类似。

2. -p --page-requisites

    下载页面所需要的所有元素

3. -np --no-parent

    不追溯至父级, 不跟随链接，只下载指定目录及子目录里的东西

4. -k, --convert-links

    将下载的HTML页面中的链接转换为相对链接即本地链接, 方便本地阅读

5. -U "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; GTB5)"

    修改agent，伪装浏览器

6. -c

    断点续传功能

7. -nc

    不下载已经存在的文件

8. -nd

    递归下载时不创建一层一层的目录，把所有的文件下载到当前目录

9. -L

    递归时不进入其它主机

10. -o, –output-file=FILE

    把记录写到FILE文件中

11. --span-hosts

    当递归时转到外部主机


#### 安装youtube-dl

sudo curl -L https://yt-dl.org/downloads/latest/youtube-dl -o /usr/local/bin/youtube-dl;
sudo chmod a+rx /usr/local/bin/youtube-dl;
youtube-dl https://www.youtube.com/watch?v=IHP4P1BR8ck;
