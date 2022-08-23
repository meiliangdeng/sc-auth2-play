# sc-auth2-play
## 标准auth2.0的6个endpoint
```
* /oauth/authorize：授权端点
* /oauth/token：令牌端点
* /oauth/confirm_access：用户确认授权提交端点
* /oauth/error：授权服务错误信息端点
* /oauth/check_token：用于资源服务访问的令牌解析端点
* /oauth/token_key：提供公有密匙的端点，如果使用JWT令牌的话

```
## flat(in-memory) 方式
参考: https://blog.csdn.net/liuying1802028915/article/details/105112256
### 测试方式
http://localhost:8082/oauth/authorize?client_id=client1&response_type=code  GET方式
http://client1:server1@localhost:8082/oauth/token  POST方式,参数(grant_type=authorization_code、code)
返回值:
```
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJvcmdhbml6YXRpb24iOiJhZG1pbiIsImV4cCI6MTY2MTI3NTAwNywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiI1NDcwNzJkYS05MjI5LTRjNWUtYTY4Ni1iNzE5ZTkwZjczZGIiLCJjbGllbnRfaWQiOiJjbGllbnQxIn0.ZWGHKNPnvvM12EVzuJsEaYmEPJbi3cb-IPzyf9DIAig",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJvcmdhbml6YXRpb24iOiJhZG1pbiIsImF0aSI6IjU0NzA3MmRhLTkyMjktNGM1ZS1hNjg2LWI3MTllOTBmNzNkYiIsImV4cCI6MTY2MzgyMzgwNywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiI1NzU1MjZlNS1kYzU1LTQwNTQtYmM0OS0xNjI2MjFjNDIwYTEiLCJjbGllbnRfaWQiOiJjbGllbnQxIn0.EtxxsLPZ9Cs8tVSTGpaYsMFmJ8KR9pw5qCqPMFlxtIU",
    "expires_in": 43199,
    "scope": "all",
    "organization": "admin",
    "jti": "547072da-9229-4c5e-a686-b719e90f73db"
}
 ```
  
 ## flat(db&jwt) 方式 


## 参考
1、Spring Security Oauth2 中实现TokenEnhancer向jwt中添加额外信息：https://blog.csdn.net/cauchy6317/article/details/85123018

2、Sring Cloud OAuth2.0 微服务中配置 Jwt Token 签名/验证：https://www.cnblogs.com/Irving/p/9430460.html (auth2的6个endpoint)

3、WebSecurityConfigurerAdapter与ResourceServerConfigurerAdapter：https://www.jianshu.com/p/fe1194ca8ecd

4、Spring Security OAuth2 Demo：https://www.cnblogs.com/pangguoming/p/7885162.html

5、Spring Boot OAuth 2.0 客户端：https://www.cnblogs.com/cjsblog/p/9241217.html

6、Spring Cloud(6.3)：搭建OAuth2 Resource Server：https://www.cnblogs.com/storml/p/11246113.html

7、http://www.360doc.com/content/18/0112/18/41344223_721399934.shtml：auth2 resource资源集成

8、SpringCloud——安全认证（Security）：https://www.pianshen.com/article/115710337/

9、Spring Security 与 OAuth2（介绍）：https://www.jianshu.com/p/68f22f9a00ee

10、SpringCloud微服务间安全调用实现（SpringSecurity+Oauth2+Jwt）：https://blog.csdn.net/q438944209/article/details/82920461

11、Spring Cloud OAuth2 token存数据库实现：https://www.jianshu.com/p/4ce5577bab74

