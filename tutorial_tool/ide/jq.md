###jq 手册

查询指定 path 的 Object
>jq '.person.sdk.gps.most_location' 123.json

查询指定 path 的 Object 的 size
>jq '.reqInfo.applyPersonList | lenght' 123.json