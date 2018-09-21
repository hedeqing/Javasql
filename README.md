# Javasql

    这是我们大二时一个数据库课设，我负责的项目是物流信息管理系统。
    语言：java
    系统： windows 10
    数据库 SQL server 2017
    编译软件 ：idea
数据库课程，题目为物流集散中心信息管理系统，数据库sql_server2017，系统win10，前端java，个人建数据库的代码也放在这吧.create table UserCol（Uname nchar（20）not null，UID nchar（30）not not null主键，Upassword nchar（20）not null，Uadd nchar（40）not null，Utel nchar（20）not null，）create table Administrator（Aname nchar（20）not null，AID nchar（30）not null primary key， Atel nchar（20）not null，Aadd nchar（40）not null，Apassword nchar（20）not null                 

create table Courier（Cname nchar（20）not null，Ctel nchar（20）not null，Ctracknumber nchar（40）not null primary key，Ctime nchar（20）not null，）create table Goods（Gnumber nchar（40）not null主键，Gname nchar（40）not null，Gspecification nchar（40）not null，Gquantity nchar（20）not null，Gweight nchar（20）not null，）create table Warehouse（WID nchar（10）not null主键， Wtem nchar（10）not null，Whumidity nchar（10）not null，）create table Company（Cnumber nchar（40）not null primary key，Cname nchar（10）not null，）create table Track（Tsname nchar（20）not not null，TID nchar（30）not null，Tstel nchar（20）not null，Tsadd nchar（40）not null，Trname nchar（20）not null，Trtel nchar（20）not null，Tradd nchar（40）not null， Tnumber nchar（40）not null主键，Twarehouseid nchar（10）not null，Tstate nchar（10）not null，外键（Tnumber）引用公司（Cnumber），外键（Tnumber）引用Courier（Ctracknumber），外键（Tnumber）引用商品（Gnumber），外键（Twarehouseid）引用仓库（WID），）
