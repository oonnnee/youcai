###新增
```
POST /manage/pricelist/save
```
####参数
```
guestId:4043164973
pdate:2018-05-11
products:[{"productId":"1024326584", "price":34.5, "note":"测试"},{"productId":"1041469823", "price":7.6, "note":"测试"},{"productId":"4801952018", "price":1.2, "note":"测试"}]
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功"
}
```


###查询
```
GET /manage/pricelist/find
```
####参数
```
guestId:4043164973
pdate:2018-05-11
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "guestId": "4043164973",
        "pdate": 1525968000000,
        "products": [
            {
                "productId": "1024326584",
                "productName": "东莞米粉",
                "productCode": "0400",
                "productUnit": "袋",
                "productImg": "http://xxx.com",
                "price": 34.5,
                "note": "测试"
            },
            {
                "productId": "1041469823",
                "productName": "海带（干）",
                "productCode": "0500",
                "productUnit": "斤",
                "productImg": "http://xxx.com",
                "price": 7.6,
                "note": "测试"
            },
            {
                "productId": "4801952018",
                "productName": "黄心白",
                "productCode": "0100",
                "productUnit": "千克",
                "productImg": "http://xxx.com",
                "price": 1.2,
                "note": "测试"
            }
        ]
    }
}
```


###列表
```
GET /manage/pricelist/pdateList
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
                "guestId": "4043164973",
                "guestName": "牛山公司",
                "dates": [
                    1525968000000	// 报价时间
                ]
            },
            {
                "guestId": "5196402861",
                "guestName": "永胜公司",
                "dates": [
                    1526572800000,	// 报价时间由大到小
                    1525968000000
                ]
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


###删除
```
POST /manage/pricelist/delete
```
####参数
```
guestId:5196402861
pdate:2018-05-11
```
####返回
成功
```
{
    "code": 0,
    "msg": "成功"
}
```
