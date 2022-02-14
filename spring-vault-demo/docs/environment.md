# 项目环境
* 基础环境：
  * Gradle
  * JDK 11
  * SpringBoot 2.6.3
  * SpringCloud 2021.0.0
  * MySQL latest

## 使用 docker-compose 项目环境搭建
* 运行 script文件夹中run.sh的脚本
```shell
./script/docker/down.sh
```
* 快速删除
```shell
./script/docker/down.sh
```

## 单独创建mysql和vault

* docker安装mysql:
  * 安装mysql
    ```shell
    docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d -i -p 3306:3306 --restart=always  mysql:latest
    ```
  * 数据配置
    * 创建test表
* brew 安装 vault
  * 安装vault
  ```shell
  brew install vault
  ```
  * 快速启动 vault
  ```shell
  vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"
  ```
  * 访问vault web
  ```
   http://127.0.0.1:8200
  ```
  