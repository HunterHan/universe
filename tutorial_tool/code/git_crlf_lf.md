# git中换行符的问题

## 背景

    CR回车 LF换行Windows/Dos CRLF \r\n
    Linux/Unix LF \n
    MacOS CR \r

## 问题

git做版本控制，平台不同换行符不同造成了问题，windows换行符为crlf(*windows的\r\n才是无意义的换行*)，linux和MAX OS 换行符是 lf, Windows使用回车和换行两个字符来结束一行，而Mac和Linux只使用换行一个字符。linux和MAX os设置为```core.autocrlf input```（貌似是默认值），windows设置为```core.autocrlf true```。还是遇到换行符的问题, review发现有的commit的变化是所有行都被删除重建。

## 解决方案

* windows

Git 在提交时自动地把行结束符 CRLF 转换成 LF，签出代码时把 LF 转换成 CRLF

    ```git config --global core.autocrlf true```

* Linux & Mac

Git 在提交时把 CRLF 转换成 LF，签出时不转换

    ```git config --global core.autocrlf input```

**最终状态**: 
```在Windows系统上的签出文件中保留CRLF，会在Mac和Linux系统上，包括仓库中保留LF```

## 尾巴
    
    一、AutoCRLF
    #提交时转换为LF，检出时转换为CRLF
    git config --global core.autocrlf true   
    
    #提交时转换为LF，检出时不转换
    git config --global core.autocrlf input   
    
    #提交检出均不转换
    git config --global core.autocrlf false
    二、SafeCRLF
    
    #拒绝提交包含混合换行符的文件
    git config --global core.safecrlf true   
    
    #允许提交包含混合换行符的文件
    git config --global core.safecrlf false   
    
    #提交包含混合换行符的文件时给出警告
    git config --global core.safecrlf warn
    

