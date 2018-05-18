# 客户
###新增客户
```
POST /manage/guest/save
```
####参数
```
pwd:123456
name:永胜公司
addr:北京
phone:17843762983
leader1:刘庄
mobile1:18943377687
leader2:陈琦
mobile2:18876743672
note:测试数据
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "5196402861",
        "name": "永胜公司",
        "addr": "北京",
        "phone": "17843762983",
        "mobile1": "18943377687",
        "leader1": "刘庄",
        "mobile2": "18876743672",
        "leader2": "陈琦",
        "note": "测试数据"
    }
}
```
失败
```
{
    "code": 1,
    "msg": "新增客户，失败"
}
```


###删除客户
```
POST /manage/guest/delete
```
####参数
```
id: 8110011548
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功"
}
```


###更新客户
```
POST /manage/guest/update
```
####参数
```
id:5196402861
name:永胜公司
addr:上海
phone:17843762983
leader1:刘庄
mobile1:18943377687
leader2:陈琦
mobile2:18876743672
note:测试数据
```
###返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "5196402861",
        "name": "永胜公司",
        "addr": "上海",
        "phone": "17843762983",
        "mobile1": "18943377687",
        "leader1": "刘庄",
        "mobile2": "18876743672",
        "leader2": "陈琦",
        "note": "测试数据"
    }
}
```
失败
```
{
    "code": 4,
    "msg": "更新客户，失败"
}
```


###更改客户密码
```
POST /manage/guest/updatePwd
```
####参数
```
id:5196402861
pwd:1234567
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功"
}
```


###通过id查询单个客户
```
GET /manage/guest/find
```
####参数
```
id:5196402861
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "5196402861",
        "name": "永胜公司",
        "addr": "上海",
        "phone": "17843762983",
        "mobile1": "18943377687",
        "leader1": "刘庄",
        "mobile2": "18876743672",
        "leader2": "陈琦",
        "note": "测试数据"
    }
}
```


###通过名称模糊查询客户
```
GET /manage/guest/findByNameLike
```
####参数
```
page:0
size:10
name:公司
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "content": [
            {
                "id": "4043164973",
                "pwd": "123456",
                "name": "牛山公司",
                "addr": "北京",
                "phone": "13976298323",
                "mobile1": "18843347687",
                "leader1": "赵昭",
                "mobile2": "18876743672",
                "leader2": "陈紫风",
                "note": "测试数据"
            },
            {
                "id": "5196402861",
                "pwd": "1234567",
                "name": "永胜公司",
                "addr": "上海",
                "phone": "17843762983",
                "mobile1": "18943377687",
                "leader1": "刘庄",
                "mobile2": "18876743672",
                "leader2": "陈琦",
                "note": "测试数据"
            }
        ],
        "totalElements": 2,
        "totalPages": 1,
        "last": true,
        "number": 0,
        "size": 10,
        "first": true,
        "numberOfElements": 2
    }
}
```


###通过id模糊查询客户
```
GET /manage/guest/findByIdLike
```
####参数
```
page:0
size:10
id:43
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "content": [
            {
                "id": "4043164973",
                "pwd": "123456",
                "name": "牛山公司",
                "addr": "北京",
                "phone": "13976298323",
                "mobile1": "18843347687",
                "leader1": "赵昭",
                "mobile2": "18876743672",
                "leader2": "陈紫风",
                "note": "测试数据"
            }
        ],
        "last": true,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0,
        "size": 10,
        "numberOfElements": 1,
        "first": true
    }
}
```


###查询客户列表
```
GET /manage/guest/list
```
####参数
```
page: 0     // 非必须，默认为0
size: 2    // 非必须，默认为10
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "content": [
            {
                "id": "4043164973",
                "name": "牛山公司",
                "addr": "北京",
                "phone": "13976298323",
                "mobile1": "18843347687",
                "leader1": "赵昭",
                "mobile2": "18876743672",
                "leader2": "陈紫风",
                "note": "测试数据"
            },
            {
                "id": "5196402861",
                "name": "永胜公司",
                "addr": "上海",
                "phone": "17843762983",
                "mobile1": "18943377687",
                "leader1": "刘庄",
                "mobile2": "18876743672",
                "leader2": "陈琦",
                "note": "测试数据"
            }
        ],
        "last": true,
        "totalElements": 2,
        "totalPages": 1,
        "number": 0,
        "size": 2,
        "numberOfElements": 2,
        "first": true
    }
}
```
