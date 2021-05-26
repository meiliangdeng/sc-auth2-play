# sc-auth2-play
## flat(in-memory) 方式
参考: https://blog.csdn.net/liuying1802028915/article/details/105112256
### 测试方式
http://localhost:8082/oauth/authorize?client_id=client1&response_type=code  GET方式
http://client1:server1@localhost:8082/oauth/token  POST方式,参数(grant_type=authorization_code、code)
返回值:
``{
      "access_token": "a8fa44e5-fef6-42bb-b2f4-044511dd4240",
      "token_type": "bearer",
      "refresh_token": "d3b13f53-c76c-4513-af28-60aa069cfd17",
      "expires_in": 43199,
      "scope": "all"
  }
  ``
  
 ## flat(db&jwt) 方式 

