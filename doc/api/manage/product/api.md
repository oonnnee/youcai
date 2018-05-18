###新增产品
```
/manage/product/save
```
####参数
```
name:木耳（湿）
pCode:0500
unit:斤
price:3
imgfile:http://xxx.com
note:实惠
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "3732823387",
        "name": "木耳（湿）",
        "unit": "斤",
        "price": 3,
        "imgfile": "http://xxx.com",
        "note": "实惠",
        "pcode": "0500"
    }
}
```


###删除产品
```
POST /manage/product/delete
```
####参数
```
id:9279507559
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
id:3732823387
name:木耳（湿）
pCode:0500
unit:斤
price:2.3
imgfile:http://xxx.com/
note:实惠
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "3732823387",
        "name": "木耳（湿）",
        "unit": "斤",
        "price": 2.3,
        "imgfile": "http://xxx.com/",
        "note": "实惠",
        "pcode": "0500"
    }
}
```


###查询单个产品
```
GET /manage/product/find
```
####参数
```
id:3732823387
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "id": "3732823387",
        "name": "木耳（湿）",
        "unit": "斤",
        "price": 2.3,
        "imgfile": "http://xxx.com/",
        "note": "实惠",
        "pcode": "0500"
    }
}
```


###根据产品名称和分类查询产品
```
GET /manage/product/findBy
```
####参数
```
page:0
size:10
pCodes:0100,0200    // 非必须，如果没有表示查询全部大类
name:肉  // 非必须，如果没有表示查询全部名称
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
                "id": "5928083942",
                "name": "肥肉",
                "unit": "千克",
                "price": 6,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0200"
            },
            {
                "id": "7384054974",
                "name": "前腿肉",
                "unit": "千克",
                "price": 11.5,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0200"
            },
            {
                "id": "7883073348",
                "name": "瘦肉",
                "unit": "千克",
                "price": 11.5,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0200"
            },
            {
                "id": "9001062832",
                "name": "后腿肉",
                "unit": "千克",
                "price": 11.5,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0200"
            },
            {
                "id": "9970027287",
                "name": "五花肉",
                "unit": "千克",
                "price": 11,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0200"
            }
        ],
        "last": true,
        "totalElements": 5,
        "totalPages": 1,
        "number": 0,
        "size": 10,
        "numberOfElements": 5,
        "first": true
    }
}
```


###查询全部产品
```
/manage/product/list
```
####参数
```
page:0
size:4
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
                "id": "1024326584",
                "name": "东莞米粉",
                "unit": "袋",
                "price": 35,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0400"
            },
            {
                "id": "1041469823",
                "name": "海带（干）",
                "unit": "斤",
                "price": 8,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0500"
            },
            {
                "id": "1046188992",
                "name": "福寿鱼",
                "unit": "千克",
                "price": 6,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0300"
            },
            {
                "id": "1299761438",
                "name": "京包菜",
                "unit": "千克",
                "price": 1,
                "imgfile": "http://xxx.com",
                "note": "实惠",
                "pcode": "0100"
            }
        ],
        "last": false,
        "totalElements": 32,
        "totalPages": 8,
        "number": 0,
        "size": 4,
        "numberOfElements": 4,
        "first": true
    }
}
```
