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
  "access_token": "a8fa44e5-fef6-42bb-b2f4-044511dd4240",
  "token_type": "bearer",
  "refresh_token": "d3b13f53-c76c-4513-af28-60aa069cfd17",
  "expires_in": 43199,
  "scope": "all"
}
 ```
  
 ## flat(db&jwt) 方式 


## 参考
1、Spring Security Oauth2 中实现TokenEnhancer向jwt中添加额外信息：https://blog.csdn.net/cauchy6317/article/details/85123018

2、Sring Cloud OAuth2.0 微服务中配置 Jwt Token 签名/验证：https://www.cnblogs.com/Irving/p/9430460.html (auth2的6个endpoint)

3、WebSecurityConfigurerAdapter与ResourceServerConfigurerAdapter：https://www.jianshu.com/p/fe1194ca8ecd

