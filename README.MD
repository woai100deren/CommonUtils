## 日常使用到的一些工具类

- MD5
- 日志打印

- 数字相关工具类

- 日期时间工具类

- 设备相关工具类

- 文件操作工具类

- 常用单位转换的辅助类



## 如何使用

在工程build.gradle添加

```css
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

添加依赖

```css
dependencies {
	   implementation 'com.github.woai100deren:CommonUtils:0.2'
}
```

