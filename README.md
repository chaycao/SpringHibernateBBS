# SpringHibernateBBS

[![apm](https://img.shields.io/badge/language-java-brightgreen.svg)]()

## Description

基于“HibernateBBS”的基础上，添加Spring框架，进行重构。

## 改动
1. Spring管理Hibernate的SessionFactory，为每个dao层类注入SessionFactory
2. dao层划分为实现类和接口，且设有dao层基类BaseDaoHibernate
3. 不再使用HibernateUtil
4. 文章列表缓存，存于Session里


## 遇到的问题
1.Could not obtain transaction-synchronized Session for current thread 
http://www.cnblogs.com/chyu/p/4817291.html
spring4+hibernate4,使用hibernate的api的时候需要配置事务的,如果不配置事务会导致获取当前session抛出异常.