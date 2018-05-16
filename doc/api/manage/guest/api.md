# 客户
###新增客户
```
POST /manage/guest/save
```
####参数
```
pwd: 123456
name: 赵无极
addr: 北京
phone: 17843762983
leader1: 陈晨
mobile1: 18943377687
leader2: 吴奋斗
mobile2: 18876743672
note: this is a note
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "6103404811",
        "name": "赵无极",
        "addr": "北京",
        "phone": "17843762983",
        "mobile1": "18943377687",
        "leader1": "陈晨",
        "mobile2": "18876743672",
        "leader2": "吴奋斗",
        "note": "this is a note"
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
###更新客户
```
POST /manage/guest/update
```
####参数
```
id: 6103404811
pwd: 123456
name: 赵无极
addr: 上海
phone: 17843762983
leader1: 陈晨
mobile1: 18943377687
leader2: 吴奋斗
mobile2: 18876743672
note: this is a note
```
###返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "6103404811",
        "name": "赵无极",
        "addr": "上海",
        "phone": "17843762983",
        "mobile1": "18943377687",
        "leader1": "陈晨",
        "mobile2": "18876743672",
        "leader2": "吴奋斗",
        "note": "this is a note"
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

###查询单个客户
```
GET /manage/guest/find
```
####参数
```
id: 6103404811
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "6103404811",
        "name": "赵无极",
        "addr": "上海",
        "phone": "17843762983",
        "mobile1": "18943377687",
        "leader1": "陈晨",
        "mobile2": "18876743672",
        "leader2": "吴奋斗",
        "note": "this is a note"
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
                "id": "7811978269",
                "pwd": "qing1016..",
                "name": "赵无极",
                "addr": "北京",
                "phone": "17843762983",
                "mobile1": "18943377687",
                "leader1": "陈晨",
                "mobile2": "18876743672",
                "leader2": "吴奋斗",
                "note": "this is a note"
            },
            {
                "id": "8110011548",
                "pwd": "qing1016..",
                "name": "陈琦",
                "addr": "北京",
                "phone": "17843762983",
                "mobile1": "18943377687",
                "leader1": "陈晨",
                "mobile2": "18876743672",
                "leader2": "吴奋斗",
                "note": "this is a note"
            }
        ],
        "last": false,  // 是否为最后一页
        "totalElements": 4, // 客户总数
        "totalPages": 2,    // 总页数
        "size": 2,  // 前端传来的size
        "number": 0,    // 前端传来的page
        "first": true,  // 是否为第一页
        "numberOfElements": 2   // content的size
    }
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