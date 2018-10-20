### 简介

antlr是一个强大的语言解析工具，用于处理结构化文本、二进制文件，也可以这么认为，antlr是更强大的正则表达式工具，能完成正则无法胜任的工作。正则表达式适合于做文本匹配、拆分、替换的工作，
关注的是文本大区域，正则表达式是粗粒度的工具，antlr侧重于细粒度，antlr可以具体到每一个语法、词法。和antlr类似的工具还有lex、yacc、JavaCC。

### 词法、语法

antlr有两个东西组成，一个是词法（Lexer），一个是语法（Parser），语法由一个个的词法堆积而成。

* 标识符，即各类编程语言中所说的以下划线、字母开头的字符串

* 字面量，英文叫Literal，其实就是可以当作值的东西，放在操作符两边。如数字、单引号字符串、双引号字符串、各个进制写法等
* 字符，单字符（!、~、=、>等）、双字符（>=、<=）等
* 关键字，如Java中的class、package、import、public等

语法就很容易理解了，比如变量定义、类定义，这些都是语法。所以antlr就是由这两个东西组成的，分别放在两个文件里，一个叫xxxLexer.g4，一个叫xxxParser.g4。当然名字是否包含Lexer、Parser不是强制的，看各人喜好。不过两个文件内容的第一行可以看出来是lexer还是parser。此外antlr也提供一个combine模式，即把lexer、parser写在同一个文件里。为求简便，下面的例子先用这个方法写一个例子吧。


```
grammar Hello;  //Definea grammar called Hello
r :'hello' ID;  //match key word hello followed by an identifier
ID : [a-z]+;    //match lower-case identifiers
WS : [\t\r\n ]+->skip;  //skip spaces,tabs,newlines,\r(Windows)
```

* 第一行是语法文件名Hello，保存之后文件要按这个名字取，即Hello.g4
* 第二行以小写字母开头，是一个语法规则。hello后面跟着一个ID标识符。ID标识符的定义在第三行定义
* 第三行以大写字母开头，是一个词法规则。ID由a-z这26个英文小写字母的一个或多个组成
* 第四行以大写字母开头，是一个词法规则。WS由制表符、换行符的一个或多个组成。->skip是action，表示当处理这个词法规则时采取的处理方法。skip表示跳过，不处理制表符、换行符，直接处理下一个词法规则。

### 开发环境

antlr有一套自己的语法来声明目标语言的语法，因此它本身就需要编译或者使用antlr提供的api来读取这些语法规则，并使之可以在目标平台上使用。比如我在用Java写一个SQL语言的解析工具，那么antlr就需要有Java平台的API给我使用。确实也是如此，只不过antlr除了提供这些API外，还会将g4这些语法文件编译成目标平台的类文件（仅对Java而言，其他语言也会编译成对应的文件）。这些编译生成的文件不需要使用者去关注，因为它们是给antlr自身使用的。使用者只需要关注antlr提供的API即可。

antlr有一套自己的编译环境，推荐【IntelliJ IDEA + Complete ANTLR 4.4 Java binaries.jar + intellij idea plugin】

1. 本地

```
export CLASSPATH=".:/usr/local/lib/antlr-4.7-complete.jar:$CLASSPATH"

alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.7-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java org.antlr.v4.gui.TestRig'
```

验证安装是否成功：java org.antlr.v4.Tool 或者 java -jar /usr/local/lib/antlr-4.7-complete.jar

新建一个g4文件

```
antlr4 Hello.g4 -visitor -o out/

cd out/

javac Hello*.java

cd out/

$ grun Hello r -tree
hello parrt
^D
(r hello parrt)
(That ^D means EOF on unix; it's ^Z in Windows.) The -tree option prints the parse tree in LISP notation.
It's nicer to look at parse trees visually.
$ grun Hello r -gui
hello parrt
^D

 - tokens #打印出token流
 - tree   #用LISP表单打印出解析树
 - gui    #在对话框中可视化地展示解析树

```


