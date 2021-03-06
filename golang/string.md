
## 常用字符串操作
> Go 源码文件默认采用 Unicode 字符集，Unicode 码点和内存中字节序列的变换实现使用了 UTF-8，在编程无需考虑编码转换的问题

> string 是所有 8位字节 字符串的集合，所以底层是一个 byte 数组
> > 
> > 以 utf-8 编码，一个汉字需要 3个字节 编码
> > 
> > 本质是只读的字符型数组
> > 
> > 字符串可能为空，但是不能为 nil
> >
> > 字符串类型的值是不可变的

> byte 是 uint8 的别名，在所有方面都等同于 uint8
> 
> > 用于区分 字节值 和 8位无符号整数值，常用来处理 ascii 字符

> rune 是 int32 的别名，在所有方面都等同于 int32
> 
> > 用于区分 字符值 和 整数值，常用来处理 unicode 或 utf-8 字符
> > 
> > rune 存储 Unicode 的码，即一个 中文 占一个 Unicode 码值
> > 

#### 判断字符串 s 是否以 prefix 开头
```
strings.HasPrefix(s, prefix string) bool
```

#### 判断字符串 s 是否以 suffix 结尾
```
strings.HasSuffix(s, suffix string) bool
```

#### 判断字符串 s 是否包含 substr
```
strings.Contains(s, substr string) bool
```

#### 判断子字符串在父字符串中第一次出现的位置 (-1表示字符串 str 不包含字符串 substr )，索引从0开始
```
strings.Index(s, str string) int
```

#### 判断子字符串在父字符串中最后出现的位置 (-1表示字符串 str 不包含字符串 substr )，索引从0开始
```
strings.LastIndex(s, str string) int
```

#### 将字符串中的所有 字母 都转为对应的小写字符
```
strings.ToLower(s) string
```

#### 将字符串中的所有 字母 都转为对应的大写字符
```
strings.ToUpper(s) string
```

#### 去除字符串两侧的空白字符
```
strings.TrimSpace(s string) string
```

#### 去掉字符串两侧的 cutset 字符串中的任意字符
```
strings.Trim(s string, cutset string) string
```

#### 以空格分隔字符串
```
strings.Fields(s string) []string
```

#### 分隔字符串 (注意：即使用空字符串去分隔也返回一个长度为1)
```
strings.Split(s string, sep string) []string
```

#### 以换行分隔字符串
```
# 1
lines := bufio.NewScanner(strings.NewReader("以\n换\r\n分隔\n字符串"))
lines.Split(bufio.ScanLines)
for lines.Scan() {
    fmt.Println(lines.Text())
}
# 2
```

#### 拼接字符串 
```
strings.Join(a []string, sep string) string
// 其它拼接可使用 strings.Builder
```

#### 替换字符串
```
strings.Replace(s, old, new string, n int) string
```

#### 替换字符串(多个)-使用特定规则对字符串进行替换操作
```
var replacer = strings.NewReplacer(
    "&", "&amp;", // 把 & 替换为 &amp
    "<", "&lt;",
    ">", "&gt;",
    `"`, "&#34;",
    "'", "&#39;",
)
fmt.Println(replacer.Replace("替换<字符串>-使用\"特定\"规则对字符串进行'替换'操作"))
```

#### 判断两个字符串是否相等，忽略大小写，同时它还会对特殊字符进行转换
```
strings.EqualFold(s, t) bool
```
