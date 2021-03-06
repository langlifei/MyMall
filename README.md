#### 项目简介

在线购物系统是为商家和用户开发的一套在线购物平台，旨在合理化减少商家租房成本，提高商家的销售额以及方便用户的购物，在传统商家与用户之间架起了一道绿色通道。通过该平台，商家能够更加便捷的推销自己的商品，提高日常销售量；用户可以更加方便的浏览商品并以低于市场价的价格对有需求的商品进行购买，实现了用户和商家的双赢。

#### 功能特性

1. 用户信息模块：用户的注册登录。

   ​	由于了使用Shiro框架的MD5算法对密码进行加密，故数据库中只能看到加密后的密码。

   ​	加密方式为以用户名为盐值，加密次数为：1024次。

   ​	注：账号：admin 密码：123456

2. 商城管理模块：查看所有商品的信息、按类别查看商品、查看新上架的商品(可筛选)

3. 收藏模块：商品加入收藏、移除商品、查看商品详情、加入购物车

4. 比较模块：将商品加入比较、移除商品、添加到购物车

5. 购物车模块：商品加入购物车、购物车查看、增加商品数量、移除商品、购物车下单

6. 订单管理模块：查看以往订单、查看商品详情

#### 环境依赖

1. 该系统是基于SpringBoot快速搭建的SSM项目。
2. 开发环境：IDEA(2019.2)+JDK(1.8)+SpringBoot(2.2.5)+Maven(3.6.1)+MySQL(5.7.17)
3. 系统采用MVC三层架构：
   1. SpringMVC主要负责Controller层的管理;
   2. Spring主要负责service层的管理;
   3. Mybatis主要负责Dao层的管理;

#### 页面截图

1. **首页**
   ![home_1](https://github.com/langlifei/MyMall/raw/master/screenshots/home_1.png)
   ![home_2](https://github.com/langlifei/MyMall/raw/master/screenshots/home_2.png)
2. **注册**
   ![regist](https://github.com/langlifei/MyMall/raw/master/screenshots/regist.png)
3. **登录**
   ![login](https://github.com/langlifei/MyMall/raw/master/screenshots/login.png)
4. **购物车**
   ![cart](https://github.com/langlifei/MyMall/raw/master/screenshots/cart.png)
5. **订单**
   ![orders](https://github.com/langlifei/MyMall/raw/master/screenshots/orders.png)
