# mpc-api
SpringBootの最小をもう一度
## GETメソッドは
```
http://[host]:[port]/getList?name=[適当な字]
```
です
## POSTメソッドは
curlなら
```
curl -X POST -H "Content-Type: application/json" http://[host]:[port]/setListPost -d "{\"id\": \"3\", \"name\": \"aaa\", \"content\": \"www\"}"
```
です

{"id":4, "name": "名前", "content": "適当"}

src\main\resources\send.json に構造かいてます

```mermaid
graph LR;
    A[ですよ] -->|なにかしら| B[ですね];
```

## ビルド時に、環境依存部分を動的に切り替えたい (mvn package)

```mvn package -Pdev1```

-P の後ろにPom.xmlで書いたprofilesタグにしたがって上書きするようにしております。
directoryタグの順番が何気に重要で、上書きしたいファイルを先に書きます。