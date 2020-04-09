# Homework-Management-System

一个基于Tomcat, Servlet, JSP的简单作业管理系统，通过Maven管理依赖，使用HikariCP数据库连接池。

## 环境

 - macOS Catalina 10.15.3
 - IntelliJ IDEA Ultimate 2019.3.4
 - Java SE 11.0.5 LTS
 - MySQL 8.0.19
 - MySQL Connector for Java 8.0.19
 - HikariCP 3.4.2
 - Apache-Tomcat 8.5.51
 - Apache-Maven 3.6.1
 - Spring 5.2.3

相关的环境配置过程可以看我上篇文章：[https://blog.csdn.net/Yiang0/article/details/104665062](https://blog.csdn.net/Yiang0/article/details/104665062)



## 系统设计

### 项目结构

![在这里插入图片描述](https://github.com/Yi1275432232/Homework-Management-System/blob/3.x/images/3.x项目结构.png)

<br>

- jdbc包结构
  ![在这里插入图片描述](https://github.com/Yi1275432232/Homework-Management-System/blob/2.x/images/jdbc包结构.png)

<br>

- model包结构

![在这里插入图片描述](https://github.com/Yi1275432232/Homework-Management-System/blob/2.x/images/model包结构.png)

<br>

- controller包结构
![在这里插入图片描述](https://github.com/Yi1275432232/Homework-Management-System/blob/3.x/images/3.x%20Controller包结构.png)

<br>

### 数据库设计

![在这里插入图片描述](https://github.com/Yi1275432232/Homework-Management-System/blob/2.x/images/数据库结构.png)

<br>

### 交互结构

![在这里插入图片描述](https://github.com/Yi1275432232/Homework-Management-System/blob/2.x/images/2.x交互设计.png)

<br>
