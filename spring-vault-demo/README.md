# spring-vault-demo

该工程是我之前写的demo，在别的仓库，拷贝进来方便归类, [WeiJiLab/spring-vault-demo](https://github.com/WeiJiLab/spring-vault-demo)

- 在application.yml文件中已经将数据库的连接注释掉，
- 通过config中的DatabaseConfig配置数据源
- 加载过程
  - 项目启动时，从vault服务器中获取mysql用户名和密码进行访问数据库
  - 当在vault更新密码之后，项目启动密码会刷新


### 环境搭建 [./docs/environment.md](./docs/environment.md)

```shell
docker-compose up -d
```

### vault使用

- 启动项目
  - 编译项目
  ```shell
  ./gradlew build
  ```
  - 运行项目
  ```shell
  ./gradlew bootRun
  ```

- 报错，执行脚本插入正确的用户名密码
  - 错误原因：在连接数据库生成bean时，从vault中获取的用户名和密码为null。
```shell
./script/vault/put_mysql_credentials_id_true.sh
```
- 可以访问业务数据
```shell
  ./script/employees/find_all_employees.sh
  ./script/employees/find_employees_with_id.sh
 ```
- 更新密码为错误的数据，再次启动项目，会报错
```shell
./script/vault/put_mysql_credentials_id_false.sh
```
- 也可以通过访问UI界面修改 cubbyhole/mysql中的用户名和密码，启动工程观察结果


#### UI访问
- 访问： http://127.0.0.1:8200/

#### vault写入key-value

- 写入route
    - 注意： value为写入的路由 
      ```shell
      vault secrets enable -version=1 -path value kv
      ```
    - eg: 
      ```shell
      vault secrets enable -version=1 -path transit/encrypt/my-key kv
      ```
    
