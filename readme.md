### 搭建环境
* mvn eclipse:eclipse

### 运行jetty
* 命令行启动
>mvn jetty:run
* eclipse
>选中项目 --> 右键 --> Run As --> Maven build...，在 Goals 栏输入 jetty:run
* 访问
>http://localhost:38080/java-learning-codes/hello


### 运行h2 console
* mvn exec:java

### 一些基础概念
* main/resources下的代码编译后会被放到classes的根目录下，这就是所谓的classpath的起始位置
