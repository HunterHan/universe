## 环境搭建

1. 安装 pycharm 并破解
    
    http://idea.lanyus.com/help/help.html

2. 安装集成开发包 ipython

    https://mirrors.tuna.tsinghua.edu.cn/anaconda/archive/
    
 3. 执行以下命令
    
    sudo chmod 777 Anaconda2-5.1.0-MacOSX-x86_64.sh
    ./Anaconda2-5.1.0-MacOSX-x86_64.sh
    
    env
    cat ~/.bash_profile
    source ~/.bash_profile
  
    ipython
  
4. 启动工程 main 方法

    出现异常，根据异常信息进行修正，直至运行成功。
    
## MySQLdb 模块

现在使用新的模块 pip install pymysql，修改引用了MySQLdb 的源代码，间接下载 MySQLdb 模块

import pymysql
pymysql.install_as_MySQLdb()

## yaml 模块

下载yaml的安装包

http://pyyaml.org/wiki/PyYAML

下载，解压 ,安装

tar -zxvf PyYAML-3.12.tar.gz 

cd PyYAML-3.12

python setup.py install

即可



    


