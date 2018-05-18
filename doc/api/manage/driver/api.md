###新增司机
```
POST /manage/driver/save
```
####参数
```
name:李师傅
cardid:612312197610230910
mobile:18834973686
note:测试
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": 1,
        "name": "李师傅",
        "cardid": "612312197610230910",
        "mobile": "18834973686",
        "note": "测试"
    }
}
```


###删除司机
```
POST /manage/driver/delete
```
####参数
```
id:1
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功"
}
```


###更新司机
```
POST /manage/driver/update
```
####参数
```
id:2
name:李师傅
cardid:612312197610230911
mobile:18834973686
note:测试
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": 2,
        "name": "李师傅",
        "cardid": "612312197610230911",
        "mobile": "18834973686",
        "note": "测试"
    }
}
```


###查询单个司机
```
GET /manage/driver/find
```
####参数
```
id:2
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": 2,
        "name": "李师傅",
        "cardid": "612312197610230911",
        "mobile": "18834973686",
        "note": "测试"
    }
}
```


###根据名称模糊查询
```
GET /manage/driver/findByNameLike
```
####参数
```
name:师傅
page:0
size:10
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
                "id": 2,
                "name": "李师傅",
                "cardid": "612312197610230911",
                "mobile": "18834973686",
                "note": "测试"
            }
        ],
        "totalPages": 1,
        "totalElements": 1,
        "last": true,
        "number": 0,
        "size": 10,
        "first": true,
        "numberOfElements": 1
    }
}
```


###司机列表
```
GET /manage/driver/list
```
####参数
```
page:0
size:10
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
                "id": 2,
                "name": "李师傅",
                "cardid": "612312197610230911",
                "mobile": "18834973686",
                "note": "测试"
            }
        ],
        "totalPages": 1,
        "totalElements": 1,
        "last": true,
        "number": 0,
        "size": 10,
        "first": true,
        "numberOfElements": 1
    }
}
```
