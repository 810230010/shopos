#shopos接口文档-v1.0

接口前缀地址:http://shopos.wuliangit.com/

# 返回合适的状态码

为每一次的响应返回合适的HTTP状态码。 好的响应应该使用如下的状态码:

200: GET请求成功，及DELETE或PATCH同步请求完成，或者PUT同步更新一个已存在的资源

使用身份认证（authentication）和授权（authorization）错误码时需要注意：
401 Unauthorized: 用户未认证，请求失败
403 Forbidden: 用户无权限访问该资源，请求失败

422 Unprocessable Entity: 请求被服务器正确解析，但是包含无效字段
429 Too Many Requests: 因为访问频繁，你已经被限制访问，稍后重试
500 Internal Server Error: 服务器错误，确认状态并报告问题

# 接口列表

## 1. 登录接口
* url:/api/v1/member/login
* 请求方式：POST
* 请求参数：

返回样例：
```json

```


## 2. 登出
* url:/api/v1/member/logout

## 3. 注册获取验证码
* url:/api/v1/member/register/get-code

## 4. 注册
* url:/api/v1/member/register

## 5. 忘记密码（修改密码）获取验证码
* url:/api/v1/member/repass/get-code

## 6. 修改密码
* url:/api/v1/member/repass

## 7. 获取用户信息
* url:/api/v1/member/info

## 8. 获取用户信息
* url:/api/v1/member/info/update

## 9. 实名认证
* url:/api/v1/member/authenticate

## 10. 申请成为推客
* url:/api/v1/member/tuike/apply

## 11. 推客收益
* url:/api/v1/member/tuike/earnings

## 12. 推客提现
* url:/api/v1/member/tuike/earnings/cash

## 13. 成为商家
* url:/api/v1/member/new-store

## 14. 我的收货地址
* url:/api/v1/member/address/list

## 13. 设置默认收货地址
* url:/api/v1/member/address/default/{addressId}

## 15. 删除收货地址
* url:/api/v1/member/address/delete/{addressId}

## 16. 更新收货地址
* url:/api/v1/member/address/update/{addressId}

## 17. 添加收货地址
* url:/api/v1/member/address/add

## 18. 获取默认收货地址
* url:/api/v1/member/address/get-default

## 19. 用户收藏商品列表
* url:/api/v1/member/collect/goods/list

## 20. 用户收藏商品
* url:/api/v1/member/collect/goods/add

## 21. 删除收藏商品
* url:/api/v1/member/collect/goods/delete

## 22. 用户收藏店铺列表
* url:/api/v1/member/collect/goods/list

## 23. 用户收藏店铺
* url:/api/v1/member/collect/goods/add

## 24. 删除收藏店铺
* url:/api/v1/member/collect/goods/delete

## 25. 收藏商品列表
* url:/api/v1/member/cart/list

## 26. 移除商品
* url:/api/v1/member/cart/delete/{goodsId}

## 27. 更新商品数量
* url:/api/v1/member/cart/update/{goodsId}/{goodsNum}

## 28. 订单列表
* url:/api/v1/member/order/list

## 29. 订单详情
* url:/api/v1/member/order/detail/{orderId}

## 30. 订单评价
* url:/api/v1/member/order/evaluate/{orderId}

## 31. 删除订单
* url:/api/v1/member/order/delete/{orderId}





## 32. 购买下单确认订单
* url:/api/v1/order/check

## 33. 购买下单
* url:/api/v1/order/submit





## 34. 商家中心（我的店铺）
* url:/api/v1/store/info

## 35. 商家中心（我的订单---搜索）
* url:/api/v1/store/order

## 36. 商家中心（余额）
* url:/api/v1/store/earnings

## 37. 商家中心（余额提现）
* url:/api/v1/store/earnings/cash

## 38. 商家中心（添加商品）
* url:/api/v1/store/goods/add

## 39. 订单列表（商家中心）
* url:/api/v1/store/order/list

## 40. 订单详情（商家中心）
* url:/api/v1/store/order/detail/{orderId}

## 41. 订单评价（商家中心）
* url:/api/v1/store/order/evaluate/{orderId}

## 42. 删除订单（商家中心）
* url:/api/v1/store/order/delete/{orderId}






## 43. 首页banner
* url:/api/v1/public/banner

## 44. 首页获取商品（搜索）
* url:/api/v1/public/goods/search

## 45. 商品详情
* url:/api/v1/public/goods/detail

## 46. 商品评价列表
* url:/api/v1/public/goods/evaluate/list

## 47. 店铺详情
* url:/api/v1/public/store/detail

## 48. 商品分类
* url:/api/v1/public/category/list

## 49. 商品分类内广告
* url:/api/v1/public/ad/category










































