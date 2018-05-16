#产品

###新增产品
```
POST /manage/product/save
```
####参数
```
name:大白菜
pCode:0100
unit:千克
price:2.3
imgfile:http://xxx.com
note:好吃的大白菜
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "7811474750",
        "name": "大白菜",
        "unit": "千克",
        "price": 2.3,
        "imgfile": "http://xxx.com",
        "note": "好吃的大白菜",
        "pcode": "0100"
    }
}
```
失败
```
{
    "code": 11,
    "msg": "新增产品，保存时失败",
}
```



###删除产品
```
POST /manage/product/delete
```

####参数
```
id:7811474750
```

####返回
成功
```
{
    "code": 0,
    "msg": "成功"
}
```



###更新产品
```
POST /manage/product/update
```
####参数
```
id:6458262769
name:大白菜
pCode:0100
unit:斤
price:2.4
imgfile:http://xxx.com/
note:好吃的大白菜！！
```

####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "6458262769",
        "name": "大白菜",
        "unit": "斤",
        "price": 2.4,
        "imgfile": "http://xxx.com/",
        "note": "好吃的大白菜！！",
        "pcode": "0100"
    }
}
```
失败
```
{
    "code": 12,
    "msg": "更新产品，更新时失败",
}
```


###查询单个产品
```
GET /manage/product/find
```

####参数
```
id:6458262769
```

####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "6458262769",
        "name": "大白菜",
        "unit": "斤",
        "price": 2.4,
        "imgfile": "http://xxx.com/",
        "note": "好吃的大白菜！！",
        "pcode": "0100"
    }
}
```



###查询全部产品
```
GET /manage/product/list
```

####参数
```
page:0
size:2
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
                "id": "0584338595",
                "name": "猪肉",
                "unit": "千克",
                "price": 20,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0200"
            },
            {
                "id": "6458262769",
                "name": "大白菜",
                "unit": "斤",
                "price": 2.4,
                "imgfile": "http://xxx.com/",
                "note": "好吃的大白菜！！",
                "pcode": "0100"
            }
        ],
        "last": true,
        "totalPages": 1,
        "totalElements": 2,
        "size": 2,
        "number": 0,
        "first": true,
        "numberOfElements": 2
    }
}
```



###根据产品大类查询产品
```
GET /manage/product/findByPCodeIn
```
####参数
```
page:0
size:10
PCodes:0100,0200
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
                "id": "0584338595",
                "name": "猪肉",
                "unit": "千克",
                "price": 20,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0200"
            },
            {
                "id": "6458262769",
                "name": "大白菜",
                "unit": "斤",
                "price": 2.4,
                "imgfile": "http://xxx.com/",
                "note": "好吃的大白菜！！",
                "pcode": "0100"
            }
        ],
        "last": true,
        "totalPages": 1,
        "totalElements": 2,
        "size": 10,
        "number": 0,
        "first": true,
        "numberOfElements": 2
    }
}
```

####参数
```
page:0
size:10
PCodes:''
```

####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "content": [],
        "last": true,
        "totalPages": 0,
        "totalElements": 0,
        "size": 10,
        "number": 0,
        "first": true,
        "numberOfElements": 0
    }
}
```
