# JavaEE java平台企业版
环境部署
在 "系统变量" 中设置 3 项属性，JAVA_HOME、PATH、CLASSPATH(大小写无所谓),若已存在则点击"编辑"，不存在则点击"新建"。

**变量设置参数如下**：

- 变量名：**JAVA_HOME**
- 变量值：**C:\Program Files (x86)\Java\jdk1.8.0_91**     // 要根据自己的实际路径配置

- 变量名：**CLASSPATH**
- 变量值：**.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;**     //记得前面有个"."

- 变量名：**Path**
- 变量值：**%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;**