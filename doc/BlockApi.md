## 1 获取当前最新区块

method：GET  
url: /block/getBlock

response:
```json
[
    {
        "blockhash": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
        "height": 580644,
        "time": "2019-06-14T08:28:23.750+0000",
        "txsize": 2390,
        "size": 1257767,
        "difficulty": 20.6,
        "weight": 1257767,
        "nextBlock": "下一块",
        "prevBlock": "上一块",
        "timestamp": "2019-06-14T14:14:16.247+0000",
        "received": "2019-06-14T14:14:16.247+0000",
        "bits": 12,
        "version": "2.0",
        "noce": 15,
        "blockReward": 25.6

    },
    {
        "blockhash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
        "height": 580643,
        "time": "2019-06-14T08:28:23.750+0000",
        "txsize": 2702,
        "size": 1322496,
        "difficulty": 20.6,
        "weight": 0.26,
        "nextBlock": "下一块",
        "prevBlock": "上一块",
        "timestamp": "2019-06-14T14:19:41.870+0000",
        "received": "2019-06-14T14:19:41.870+0000",
        "bits": 12,
        "version": "2.0",
        "noce": 15,
        "blockReward": 25.6
    }
]
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|   Date |  出块时间 |
|    txsize|   Short |  交易数量 |
|    size|   Integer |  区块大小 |
|    difficulty|   Double | 难度 |
|    weight|   Double |  区块高度 |
|    nextBlock|   String |  下一块 |
|    prevBlock|   String |  上一块 |
|    timestamp|   Date |  出快时间 |
|    received|   Date |  接收时间 |
|    bits|   Int |  区块大小 |
|    version|   String |  版本 |
|    noce|   int |  交易数量 |
|    blockReward|   Double |  奖励 |

  
  
## 2 根据区块hash获取区块详情

method：GET  
url: /block/getByBlockhash?blockhash={blockhash}

response:
```json
{
    "blockhash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
    "height": 580643,
    "prevBlcok": "00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "nextBlock": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
    "merkleRoot": "07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798",
    "txSize": 2702,
    "outputTotal": 25,
    "fees": 8766.38,
    "time": 1560502355355,
    "difficulty": 7409399249090.25,
    "size": 1322496,
    "total_input": 128.924,
    "total_output": 128.923,
    "fee_per_byte": 20.774,
    "fee_per_weight_unit": 25.6,
    "estimated": 29.99
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    prevBlcok|   String | 前一个区块 |
|    nextBlock|   String |  后一个区块 |
|    merkleRoot|   String |  梅尔克树 |
|    txSize|   Short |  交易数量 |
|    outputTotal|   Double |  总输出 |
|    fees|   Double |  交易费用 |
|    time|   Long |  出块时间 |
|    difficulty|   Double |  难度系数 |
|    size|   Integer |  区块大小 |
|    total_input|   Double |  总投入 |
|    total_output|   Double |  总产出 |
|    fee_per_byte|   Long |  每字节费用 |
|    fee_per_weight_unit|   Double |  每重量单位费用 |
|    estimated|   Integer |  估计BTC成交 |
  

## 3 根据区块高度获取区块详情

method：GET  
url: /block/getByHeight?height={height}

response:
```json
{
   
    "height": 580643,
    "Number_Of_Transactions": "2867",
    "output_total": "128.929",
    "emstimated_transaction_volume": "9640.2",
    "timestamp": "2019-06-15T01:05:44.776+0000",
    "relayed_by": "pool",
    "difficulty": 9426.25,
    "bits": 36599,
    "size": 25556.2,
    "weight": 3962.5,
    "version": "0x265",
    "nonce": 264598,
    "block_reward": 108.69,
    "height": 580770,
    "received_time": "2019-06-15T01:05:44.776+0000"
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    height|   String |  区块高度 |
|    Number_Of_Transactions|   Integer |  交易数量 |
|    output_total|   Double | 输出总计 |
|    emstimated_transaction_volume|   Double |  预计交易量 |
|    timestamp|   Date |  时间戳 |
|    relayed_by|   String |  矿主 |
|    difficulty|   Double |  困难 |
|    bits|   Int |  位 |
|    size|   Long |  出块时间 |
|    weight|   Double |  尺寸 |
|    version|   String |  版本 |
|    nonce|   Double |  杜撰 |
|    block_reward|   Double |  拒绝奖励 |
|    received_time|   Date |  接收时间 |


## 4 根据交易哈希值查询具体信息

method：GET  
url: /block/getByTransactionHash?hash={hash}

response:
```json
{
   
    "Address": "00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "Hash": "00000ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "No_Transactions": 1,
    "Total_Received": 10.26,
    "Final_Balance": 10.66549,
    
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    Address|   String |  地址 |
|    Hash|   String |  哈希 |
|    No_Transactions|   Int | 是否交易 |
|    Total_Received|   Double |  收到的总数 |
|    Final_Balance|   Double |  最终余额 |


## 4 根据矿主来查询有矿主出块信息

method：GET  
url: /block/getByRelayed?name={name}

response:
```json
{
   
    "height": 580777,
    "Hash": "00000ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "time": "2019-06-15T01:05:44.776+0000",
    "size": 10.26,
   
    
}
```

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    height|   Int |  高度 |
|    Hash|   String |  哈希 |
|    time|   Int | 时间 |
|    size|   Double |  大小 |



    



