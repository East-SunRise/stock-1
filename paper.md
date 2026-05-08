# 参考页面
[https://www.zhihu.com/special/all](https://www.zhihu.com/special/all)

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775713874940-9661e8ea-25be-41e6-bd7e-a9db4ceb8128.png" width="1505" title="" crop="0,0,1,1" id="u9a7a9a2b" class="ne-image">

# 准备工作
## 获取数据
浏览器打开开发者工具，网络面板—> Fetch/XHR ，滚动页面，可以看到发起的网络请求，出现形如 limit=10&offset=xxx 这样的链接后，点击链接，选择 Headers 选项卡，可以看到此次请求的 URL。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775713921223-fdee9925-a19c-4a00-8ba3-c937d34bb59a.png" width="1505" title="" crop="0,0,1,1" id="u5c623669" class="ne-image">

可以修改起止分页数据量（limit），当前页（offset）等：[https://www.zhihu.com/api/v4/news_specials/list?limit=100&offset=0](https://www.zhihu.com/api/v4/news_specials/list?limit=100&offset=0)

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775714086322-5fa0cd39-d7a8-4886-a633-313a09136fab.png" width="1503" title="" crop="0,0,1,1" id="u73da9466" class="ne-image">

全选页面数据，将得到的 JSON 数据保存到本地 data.json ，然后用 VSCode 打开，去掉外层的一些属性值，最终保留 data 的那个数组（外层是 [ ] ），如图：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775714143047-6f2ee1ff-67f6-4a2f-a448-2ec36c4835c0.png" width="1512" title="" crop="0,0,1,1" id="u32d8c0c0" class="ne-image">

## 清洗数据
通过网站 [JSON to CSV Converter](https://data.page/json/csv) 将 data.json 转成 csv 文件。

<img src="https://cdn.nlark.com/yuque/0/2025/png/228333/1758048281743-7a94eafc-3aed-41d1-b3db-fb4e13749e1b.png" width="1505" title="" crop="0,0,1,1" id="u4988e1df" class="ne-image">

转换完成后下载 csv，让 AI 将其中的空行删掉。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775714288289-f7ae04c9-83b7-46d2-85dc-7ba0205ba142.png" width="1046" title="" crop="0,0,1,1" id="u005c03c7" class="ne-image">

形成最终有效的 CSV（这里去掉了 section 相关的两列）

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715613267-e64a2125-7c4b-444a-a64d-feb7f4c75869.png" width="1496" title="" crop="0,0,1,1" id="u17a5634a" class="ne-image">

## 导入数据
Navicat 选择数据库，选择“表”，右键 —> 导入向导：

<img src="https://cdn.nlark.com/yuque/0/2024/png/228333/1726221837078-0bd310db-6584-4923-83c1-999f07931085.png" width="323" title="" crop="0,0,1,1" id="u765d66ce" class="ne-image">

选择 CSV 文件

<img src="https://cdn.nlark.com/yuque/0/2024/png/228333/1726222135499-ec4149cd-40fa-415f-96f7-5308a84eda08.png" width="809" title="" crop="0,0,1,1" id="uabd84ff4" class="ne-image">

选择之前清洗好的 data.csv 文件，继续：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715470181-db203ef0-9a6e-4c71-855b-2b87efe2e0d5.png" width="809" title="" crop="0,0,1,1" id="u2e41bd0c" class="ne-image">

到这个界面，点击下一步

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715481695-2fff788b-4036-40ab-a0cd-ca7cc110faae.png" width="809" title="" crop="0,0,1,1" id="u44b827a8" class="ne-image">

到这个界面，选择一个日期格式 YMD（年月日），然后继续下一步：

<img src="https://cdn.nlark.com/yuque/0/2024/png/228333/1726222495560-6e4bb743-f7bc-4c28-a47a-f340b1666d8e.png" width="809" title="" crop="0,0,1,1" id="u5a2d16e9" class="ne-image">

下一步，可以输入你需要的表名：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715499455-d331c450-6d54-4d8f-ac41-b8e7d6c7af70.png" width="809" title="" crop="0,0,1,1" id="u5428b8a4" class="ne-image">

到这个界面，我们将 id 标注为主键，将有可能超出限制的字段长度做修改。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715566721-b41859bd-fe9f-41e0-aeb3-f8761439049c.png" width="809" title="" crop="0,0,1,1" id="u89981524" class="ne-image">

点击下一步，选择“追加或更新”方式，继续下一步。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715634600-12f22372-556f-47bd-8d5f-e64514b0d0d7.png" width="809" title="" crop="0,0,1,1" id="ufb0c7a18" class="ne-image">

点击开始，执行导入。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715653867-b35d21fe-92cc-4755-99bf-e30347b76e52.png" width="809" title="" crop="0,0,1,1" id="ud3dc1f0c" class="ne-image">

执行成功。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715665132-a497e03d-7a8b-4869-b36f-6ae912ea88a3.png" width="809" title="" crop="0,0,1,1" id="u5490a8ee" class="ne-image">

最终得到了 t_special 数据表：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775715712772-3497d46a-7613-4254-81e9-6fbb34179f7b.png" width="1512" title="" crop="0,0,1,1" id="u17b0d818" class="ne-image">

可以修改数据表，对某些字段做修改，如时间戳一般为长整型，字段加上注释更友好规范。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775718424855-8f5b5a06-1175-479f-8f5e-c3d6b270770d.png" width="856" title="" crop="0,0,1,1" id="u73235a3c" class="ne-image">

# 后端 API 开发
## 创建项目
新建 Spring Boot 项目 zhihu-api，如图：

<img src="https://cdn.nlark.com/yuque/0/2024/png/228333/1711336124493-683d3bfc-5df2-4e52-af34-7e5a42feb282.png" width="1181" title="" crop="0,0,1,1" id="uaed81789" class="ne-image">

添加 Web、MySQL 驱动、MyBatis 、Lombok 等依赖：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.11</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>top.mqxu</groupId>
    <artifactId>zhihu-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>zhihu-api</name>
    <description>zhihu-api</description>

    <properties>
        <java.version>17</java.version>
        <mp.version>3.5.7</mp.version>
        <openapi.version>2.8.16</openapi.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-spring-boot3-starter</artifactId>
            <version>${mp.version}</version>
        </dependency>


        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${openapi.version}</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

如图建立目录结构：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775719310359-853eac69-5f4c-4ab7-8b60-4b629cfc4d74.png" width="417" title="" crop="0,0,1,1" id="u7a2fb7a0" class="ne-image">

## 配置项目
### application.yml
配置数据源和 MyBatis Plus：

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/springboot3_db?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
  jackson: # 日期格式化
    date-format: yyyy-MM-dd HH:mm:ss # 日期格式
    time-zone: GMT+8 # 时区

# mp 配置
mybatis-plus:
  mapper-locations: classpath:mapper/**/*.xml # 指定mapper文件位置
  type-aliases-package: top.mqxu.zhihu.api.entity # 扫描entity
  configuration:
    map-underscore-to-camel-case: true  # 开启驼峰命名
    log-impl: org.apache.ibatis.logging.slf4j.Slf4jImpl # 打印sql
```

### 配置 MP、OpenAPI
config 包创建 MyBatisPlusConfig 配置类，进行分页拦截器配置：

```java
package top.mqxu.zhihu.api.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {

    /**
     * 配置 MyBatis-Plus 拦截器
     * 添加分页插件，指定数据库类型为 MySQL
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        // DbType.MYSQL：指定数据库类型为 MySQL，生成的分页 SQL 会使用 LIMIT
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 设置请求的页面大于最大页后的操作：true 返回首页，false 继续请求（默认 false）
        paginationInterceptor.setOverflow(false);
        // 设置单页分页条数限制（默认 500 条，-1 不限制）
        paginationInterceptor.setMaxLimit(500L);
        interceptor.addInnerInterceptor(paginationInterceptor);
        return interceptor;
    }
}
```

config 包创建 OpenApiConfig 配置类，进行 API 文档个性化配置：

```java
package top.mqxu.zhihu.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * SpringDoc OpenAPI 配置类
 *
 */
@Configuration
public class OpenApiConfig {

    /**
     * 配置 OpenAPI 基本信息
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // API 信息
                .info(new Info()
                        .title("知乎专栏 API")
                        .description("知乎专栏 API 接口文档")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("mqxu")
                                .email("mqxu@gmail.com")
                                .url("https://github.com/mqxu"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                // 服务器配置
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("本地开发环境"),
                        new Server()
                                .url("https://api.example.com")
                                .description("生产环境")
                ))
                // 全局 Schema 配置
                .components(new io.swagger.v3.oas.models.Components()
                        .addSchemas("PageResult", createPageResultSchema())
                );
    }

    /**
     * 创建分页结果 Schema
     */
    private Schema<?> createPageResultSchema() {
        return new Schema<>()
                .type("object")
                .addProperty("records", new io.swagger.v3.oas.models.media.ArraySchema()
                        .items(new Schema<>().$ref("#/components/schemas/Special")))
                .addProperty("total", new IntegerSchema())
                .addProperty("size", new IntegerSchema())
                .addProperty("current", new IntegerSchema())
                .addProperty("pages", new IntegerSchema());
    }
}
```

## 编写代码
### 实体类
entity 子包添加专题实体类，注意指定表名（因为不符合严格的驼峰映射）。

```java
package top.mqxu.zhihu.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@TableName("t_special")
public class Special {
    @Schema(description = "主键")
    private String id;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "封面")
    private String banner;

    @Schema(description = "描述")
    private String introduction;

    @Schema(description = "是否关注")
    private String isFollowing;

    @Schema(description = "关注数量")
    private Integer followersCount;

    @Schema(description = "浏览数量")
    private Integer viewCount;

    @Schema(description = "更新时间")
    private Long updated;
}
```

### Mapper 层
mapper 包新建 SpecialMapper 接口，继承 BaseMapper，自动拥有若干 CRUD 方法。

```java
package top.mqxu.zhihu.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.mqxu.zhihu.api.entity.Special;


@Mapper
public interface SpecialMapper extends BaseMapper<Special> {
}
```

### Service 层
service 包新建 SpecialService 接口，声明：根据标题获取专栏（分页）方法，以及根据专题 id 获取专题详情的方法。

```java
package top.mqxu.zhihu.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.mqxu.zhihu.api.entity.Special;


public interface SpecialService {

    /**
     * 根据标题获取专栏（分页）
     *
     * @param title    标题
     * @param pageNum  页码
     * @param pageSize 页大小
     * @return 专栏列表
     */
    Page<Special> selectByTitle(String title, int pageNum, int pageSize);

    /**
     * 获取专栏详情
     *
     * @param id 专栏ID
     * @return 专栏详情
     */
    Special getById(String id);
}
```

service 包新建 impl 子包，新建 SpecialServiceImpl 实现类，实现上述两个方法：

```java
package top.mqxu.zhihu.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.mqxu.zhihu.api.entity.Special;
import top.mqxu.zhihu.api.mapper.SpecialMapper;
import top.mqxu.zhihu.api.service.SpecialService;


@Service
@RequiredArgsConstructor
public class SpecialServiceImpl implements SpecialService {
    private final SpecialMapper specialMapper;


    @Override
    public Page<Special> selectByTitle(String title, int pageNum, int pageSize) {
        // 1. 构造分页参数：pageNum（页码，从1开始）、pageSize（每页条数）
        Page<Special> page = Page.of(pageNum, pageSize);
        // 2. 构造条件构造器：LambdaQueryWrapper（类型安全，避免字段名写错）
        LambdaQueryWrapper<Special> wrapper = new LambdaQueryWrapper<>();
        // 条件：标题不为空时，模糊查询（第一个参数为条件，满足才拼接）
        wrapper.like(title != null && !title.isEmpty(), Special::getTitle, title);
        // 3. 调用BaseMapper的selectPage方法，实现条件分页
        return specialMapper.selectPage(page, wrapper);
    }

    @Override
    public Special getById(String id) {
        return specialMapper.selectById(id);
    }
}
```

对 SpecialService  创建单元测试：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775719001680-6023d0d1-97a0-4ac4-8f17-fe3da3a60384.png" width="759" title="" crop="0,0,1,1" id="ud1aa3d30" class="ne-image">

```java
package top.mqxu.zhihu.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.mqxu.zhihu.api.entity.Special;

@SpringBootTest
@Slf4j
class SpecialServiceTest {
    @Resource
    private SpecialService specialService;

    @Test
    void selectByTitle() {
        Page<Special> specialPage = specialService.selectByTitle("", 1, 10);
        log.info("专题记录数量:{}", specialPage.getRecords().size());
    }

    @Test
    void getById() {
        Special special = specialService.getById("1915458132534101000");
        log.info("专题记录:{}", special);
    }
}
```

测试结果：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775719494187-bbc128fc-07f3-4618-b9f2-400ef8270156.png" width="1260" title="" crop="0,0,1,1" id="u6d345aee" class="ne-image">

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775724330221-a63d03d7-c966-44d4-8164-6bf4bb681682.png" width="1295" title="" crop="0,0,1,1" id="ucc254f01" class="ne-image">

### Controller 层
common 包新建 Result.java，统一封装返回结果。

```java
package top.mqxu.zhihu.api.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class Result<T> {
    @Schema(description = "状态码")
    private Integer code;

    @Schema(description = "消息")
    private String message;

    @Schema(description = "返回数据")
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }


    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}

```

controller 包新建 SpecialController 控制器，编写专题列表分页接口、专题详情接口。

```java
package top.mqxu.zhihu.api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.mqxu.zhihu.api.common.Result;
import top.mqxu.zhihu.api.entity.Special;
import top.mqxu.zhihu.api.service.SpecialService;


@RestController
@RequestMapping("/api/v1/special")
@Tag(name = "专栏接口", description = "专栏接口")
@RequiredArgsConstructor
public class SpecialController {
    private final SpecialService specialService;

    /**
     * 根据标题查询专栏
     *
     * @param title    标题
     * @param pageNum  页码
     * @param pageSize 页大小
     * @return 专栏列表
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询专栏", description = "分页查询专栏接口")
    public Result<Page<Special>> selectByTitle(@RequestParam(required = false) String title, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success("查询成功", specialService.selectByTitle(title, pageNum, pageSize));
    }

    /**
     * 获取专栏详情
     *
     * @param id 专栏ID
     * @return 专栏详情
     */
    @GetMapping("/detail")
    @Operation(summary = "获取专栏详情", description = "获取专栏详情接口")
    public Result<Special> get(@RequestParam String id) {
        return Result.success("查询成功", specialService.getById(id));
    }
}
```

### 接口测试
启动应用，访问：[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)，测试接口：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775724388883-a7f7cae9-3fb4-48a5-abec-a933d6d4ca06.png" width="1491" title="" crop="0,0,1,1" id="u1d7dc4e5" class="ne-image">

**自行测试两个接口。**

# Web 前端开发
## 简介
前端使用 Vue 3 + TypeScript + Vite，通过 Axios 请求后端专题接口，使用 Element Plus 提供输入框、按钮、分页、骨架屏与空状态等组件。列表布局与视觉参考 [知乎专题](https://www.zhihu.com/special/all)：浅灰背景、白底卡片、左侧封面图、标题与元信息（更新时间、浏览量）、右侧操作按钮风格接近「关注专题」。

## 技术栈与版本
| **<font style="color:rgb(52, 73, 94);">技术</font>**     | **<font style="color:rgb(52, 73, 94);">用途</font>**                                                                                                                                                                                                                                                                                               |
| :------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <font style="color:rgb(52, 73, 94);">Vue 3</font>        | <font style="color:rgb(52, 73, 94);">框架（Composition API + </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);"><script setup></font>`<font style="color:rgb(52, 73, 94);">）</font>                                                                                                                                |
| <font style="color:rgb(52, 73, 94);">TypeScript</font>   | <font style="color:rgb(52, 73, 94);">类型与构建检查</font>                                                                                                                                                                                                                                                                                         |
| <font style="color:rgb(52, 73, 94);">Vite</font>         | <font style="color:rgb(52, 73, 94);">开发与打包</font>                                                                                                                                                                                                                                                                                             |
| <font style="color:rgb(52, 73, 94);">Axios</font>        | <font style="color:rgb(52, 73, 94);">HTTP 客户端（封装见 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/utils/http.ts</font>`<font style="color:rgb(52, 73, 94);">）</font>                                                                                                                                 |
| <font style="color:rgb(52, 73, 94);">Vue Router</font>   | <font style="color:rgb(52, 73, 94);">路由（列表 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/special</font>`<font style="color:rgb(52, 73, 94);">、详情 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/special/:id</font>`<font style="color:rgb(52, 73, 94);">）</font> |
| <font style="color:rgb(52, 73, 94);">Element Plus</font> | <font style="color:rgb(52, 73, 94);">UI 组件库（中文语言包）</font>                                                                                                                                                                                                                                                                                |


## <font style="color:rgb(52, 73, 94);">目标与架构</font>
<font style="color:rgb(52, 73, 94);">最终要达到的效果：</font>

+ **<font style="color:rgb(52, 73, 94);">技术</font>**<font style="color:rgb(52, 73, 94);">：Vue 3 + TypeScript + Vite，用 Axios 调接口，Element Plus 做 UI，Vue Router 做多页面。</font>
+ **<font style="color:rgb(52, 73, 94);">分层</font>**<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">utils/http</font>`<font style="color:rgb(52, 73, 94);"> 统一请求 → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">api/special</font>`<font style="color:rgb(52, 73, 94);"> 业务接口 → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">api/specialNormalize</font>`<font style="color:rgb(52, 73, 94);"> 解析后端 JSON → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">views</font>`<font style="color:rgb(52, 73, 94);"> 页面 + </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">components</font>`<font style="color:rgb(52, 73, 94);"> 组件。</font>
+ **<font style="color:rgb(52, 73, 94);">路由</font>**<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/</font>`<font style="color:rgb(52, 73, 94);"> 重定向到 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/special</font>**`<font style="color:rgb(52, 73, 94);">（列表），</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/special/:id</font>**`<font style="color:rgb(52, 73, 94);">（详情）。</font>
+ **<font style="color:rgb(52, 73, 94);">开发联调</font>**<font style="color:rgb(52, 73, 94);">：前端请求 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api/...</font>**`<font style="color:rgb(52, 73, 94);">，由 Vite </font>**<font style="color:rgb(52, 73, 94);">代理</font>**<font style="color:rgb(52, 73, 94);">到 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">http://localhost:8080</font>**`<font style="color:rgb(52, 73, 94);">，避免浏览器跨域。</font>

<font style="color:rgb(52, 73, 94);">下面步骤按：</font>**<font style="color:rgb(52, 73, 94);">脚手架 → 依赖 → 配置 → 工具层 → 业务层 → 界面 → 入口</font>**<font style="color:rgb(52, 73, 94);"> 展开。</font>

## <font style="color:rgb(52, 73, 94);">用 Vite 创建 Vue + TS 项目</font>
<font style="color:rgb(52, 73, 94);">在你希望生成项目的地方，如 zhihu 目录，执行命令（项目名可自定，这里用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">zhihu-vue</font>`<font style="color:rgb(52, 73, 94);">）：</font>

```bash
npm create vite@latest zhihu-vue -- --template vue-ts
```

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775807495333-ad56c852-dfff-4933-b3eb-d6af0988337e.png" width="970" title="" crop="0,0,1,1" id="uda7fa5c7" class="ne-image">

<font style="color:rgb(52, 73, 94);">说明：</font>

+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">--template vue-ts</font>`<font style="color:rgb(52, 73, 94);"> 表示 </font>**<font style="color:rgb(52, 73, 94);">Vue 3 + TypeScript</font>**<font style="color:rgb(52, 73, 94);">，会生成 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">vite.config.ts</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/main.ts</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/App.vue</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">tsconfig*.json</font>`<font style="color:rgb(52, 73, 94);"> 等文件。</font>

<font style="color:rgb(52, 73, 94);">完成后可用确认默认页面能打开。</font>

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775807527285-21833583-5b56-4af7-bea4-3eb09d97973d.png" width="1352" title="" crop="0,0,1,1" id="u6733404f" class="ne-image">

确认后，终端按 ctrl + c 退出，后续用 VS Code 打开项目。

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775807582508-da9a2df9-863c-4a5d-88e8-fd7128a10cad.png" width="970" title="" crop="0,0,1,1" id="ufd6fb07d" class="ne-image">

## <font style="color:rgb(52, 73, 94);">安装业务依赖</font>
<font style="color:rgb(52, 73, 94);">项目需要 </font>**<font style="color:rgb(52, 73, 94);">HTTP 客户端用于访问后端接口</font>**<font style="color:rgb(52, 73, 94);">、</font>**<font style="color:rgb(52, 73, 94);">组件库</font>**<font style="color:rgb(52, 73, 94);">、</font>**<font style="color:rgb(52, 73, 94);">路由</font>**<font style="color:rgb(52, 73, 94);">，因此，我们需要安装 axios、EP、Vue-Router 这几个库，执行下面的命令安装。</font>

```bash
 npm install axios element-plus vue-router@4
```

<font style="color:rgb(52, 73, 94);">说明：</font>

+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">axios</font>`<font style="color:rgb(52, 73, 94);">：请求后端（会再次封装）。</font>
+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">element-plus</font>`<font style="color:rgb(52, 73, 94);">：输入框、按钮、分页、骨架屏等。</font>
+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">vue-router@4</font>`<font style="color:rgb(52, 73, 94);">：与 Vue 3 配套。</font>

> <font style="color:rgb(52, 73, 94);">当前 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">package.json</font>`<font style="color:rgb(52, 73, 94);"> 里版本会随发布时间变化，以</font>**<font style="color:rgb(52, 73, 94);">安装当时</font>**<font style="color:rgb(52, 73, 94);">解析到的版本为准。</font>
>

安装后，`package.json` 变化如下：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775807664412-419f9955-f4c2-4f7c-9728-937ff48277d1.png" width="725" title="" crop="0,0,1,1" id="uc811c8a7" class="ne-image">

## <font style="color:rgb(52, 73, 94);">配置 Vite 开发代理</font>
<font style="color:rgb(52, 73, 94);">编辑</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">vite.config.ts</font>**`<font style="color:rgb(52, 73, 94);">：在 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">defineConfig</font>`<font style="color:rgb(52, 73, 94);"> 里增加 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">server.proxy</font>`<font style="color:rgb(52, 73, 94);">，把前端的 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api</font>`<font style="color:rgb(52, 73, 94);"> 转到真正的后端，避免因端口不同导致的跨域问题。</font>

```typescript
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
    },
  },
})
```

<font style="color:rgb(52, 73, 94);">这样，当我们请求 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">http://localhost:5173/api/v1/...</font>`<font style="color:rgb(52, 73, 94);"> 时，会被转发到 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">http://localhost:8080/api/v1/...</font>`<font style="color:rgb(52, 73, 94);">。后端若不在 8080，只改 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">target</font>`<font style="color:rgb(52, 73, 94);"> 即可。</font>

## <font style="color:rgb(52, 73, 94);">调整 HTML 与环境变量</font>
`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">index.html</font>**`<font style="color:rgb(52, 73, 94);">：建议将 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">lang</font>`<font style="color:rgb(52, 73, 94);"> 改为 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">zh-CN</font>`<font style="color:rgb(52, 73, 94);">，</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">title</font>`<font style="color:rgb(52, 73, 94);"> 改为相关文案，例如：</font>

```html
<html lang="zh-CN">
  <!-- ... -->
  <title>知乎专题</title>
```

<font style="color:rgb(52, 73, 94);">新建</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">.env.example</font>**`<font style="color:rgb(52, 73, 94);">：说明可选环境变量 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">VITE_API_BASE</font>`<font style="color:rgb(52, 73, 94);">（直连后端时需配置且后端要开 CORS；不设则开发环境用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api</font>`<font style="color:rgb(52, 73, 94);"> 走代理）。</font>

```properties
# 后端 API 根路径（无末尾 /）
# 留空：开发时用 /api，由 Vite 代理到 http://localhost:8080（见 vite.config.ts）
# 填写：浏览器直连（后端需 CORS），开发示例：VITE_API_BASE=http://localhost:8080/api
VITE_API_BASE=

# 生产构建同理：不填则请求当前站点下的 /api，需 Nginx 等到后端的反代
```

<font style="color:rgb(52, 73, 94);">新建</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/vite-env.d.ts</font>**`<font style="color:rgb(52, 73, 94);">：为 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">import.meta.env.VITE_API_BASE</font>`<font style="color:rgb(52, 73, 94);"> 补充 TypeScript 类型，内容可参考本仓库同名文件（</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/// <reference types="vite/client" /></font>`<font style="color:rgb(52, 73, 94);"> + </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">ImportMetaEnv</font>`<font style="color:rgb(52, 73, 94);"> 接口）。</font>

```typescript
/// <reference types="vite/client" />

interface ImportMetaEnv {
  /**
   * 后端 API 前缀，如 `http://localhost:8080/api`。
   * 不设则开发环境使用 `/api` 并由 Vite 代理到后端（见 vite.config.ts）。
   */
  readonly VITE_API_BASE?: string
}

interface ImportMeta {
  readonly env: ImportMetaEnv
}
```

## <font style="color:rgb(52, 73, 94);">封装 HTTP 与错误文案</font>
<font style="color:rgb(52, 73, 94);">目标：</font>**<font style="color:rgb(52, 73, 94);">所有接口</font>**<font style="color:rgb(52, 73, 94);">共用同一个 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">baseURL</font>`<font style="color:rgb(52, 73, 94);"> 和超时，业务代码只调 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">httpGet</font>`<font style="color:rgb(52, 73, 94);">，不写散落的 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">axios.create</font>`<font style="color:rgb(52, 73, 94);">。</font>

1. 新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/utils/http.ts</font>**`
    - <font style="color:rgb(52, 73, 94);">用环境变量 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">VITE_API_BASE</font>`<font style="color:rgb(52, 73, 94);">（有则去掉末尾 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/</font>`<font style="color:rgb(52, 73, 94);">）作为 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">baseURL</font>`<font style="color:rgb(52, 73, 94);">，否则用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api</font>**`<font style="color:rgb(52, 73, 94);">。 </font>
    - `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">export async function httpGet<T>(url, config?)</font>`<font style="color:rgb(52, 73, 94);">，内部 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">instance.get</font>`<font style="color:rgb(52, 73, 94);">，</font>**<font style="color:rgb(52, 73, 94);">返回 </font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">response.data</font>**`<font style="color:rgb(52, 73, 94);">。 </font>
    - <font style="color:rgb(52, 73, 94);">开发环境可 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">console.info</font>`<font style="color:rgb(52, 73, 94);"> 打印当前 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">baseURL</font>`<font style="color:rgb(52, 73, 94);">，便于排查。 </font>
    - <font style="color:rgb(52, 73, 94);">可同时 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">export const http = instance</font>`<font style="color:rgb(52, 73, 94);"> 供将来扩展拦截器。</font>

```typescript
import axios, { type AxiosRequestConfig } from 'axios'

function baseURL() {
  const v = import.meta.env.VITE_API_BASE?.trim()
  return v ? v.replace(/\/$/, '') : '/api'
}

const instance = axios.create({
  baseURL: baseURL(),
  timeout: 30_000,
})

if (import.meta.env.DEV) {
  console.info('[http] baseURL =', instance.defaults.baseURL)
}

/** 统一封装：返回响应 body（`data`），错误仍抛 AxiosError */
export async function httpGet<T = unknown>(
  url: string,
  config?: AxiosRequestConfig,
): Promise<T> {
  const res = await instance.get<T>(url, config)
  return res.data
}

export { instance as http }
```

2. 新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/utils/httpError.ts</font>**`
    - `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">export function axiosErrorMessage(e, fallback?)</font>`<font style="color:rgb(52, 73, 94);">：若 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">axios.isAxiosError(e)</font>`<font style="color:rgb(52, 73, 94);">，拼出状态码与 URL；否则返回兜底文案。供列表/详情页 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">ElMessage</font>`<font style="color:rgb(52, 73, 94);"> 使用。</font>

```typescript
import axios from 'axios'

export function axiosErrorMessage(
  e: unknown,
  fallback = '请求失败',
): string {
  if (!axios.isAxiosError(e)) return fallback
  if (e.response?.status) {
    const url = e.config?.baseURL
      ? `${e.config.baseURL}${e.config.url ?? ''}`
      : e.config?.url
    return `接口 ${e.response.status}${url ? `：${url}` : ''}`
  }
  return e.message || fallback
}
```

3. 新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/utils/coverPlaceholder.ts</font>**`
    - <font style="color:rgb(52, 73, 94);">根据标题生成占位图 URL（无封面或图片加载失败时用），避免页面破版。</font>

```typescript
export function coverPlaceholder(title: string, w = 200, h = 120) {
  const t = encodeURIComponent(title.slice(0, 4) || '专题')
  return `https://via.placeholder.com/${w}x${h}/f0f2f5/8590a6?text=${t}`
}
```

## <font style="color:rgb(52, 73, 94);">定义前端数据类型</font>
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/types/special.ts</font>**`<font style="color:rgb(52, 73, 94);">：定义列表项与分页结果，与后端 DTO 映射后的</font>**<font style="color:rgb(52, 73, 94);">展示结构</font>**<font style="color:rgb(52, 73, 94);">一致，例如：</font>

+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialItem</font>`<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">id</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">title</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">cover</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">introduction</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">isFollowing</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">updateLabel</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">visitLabel</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">followersLabel</font>`<font style="color:rgb(52, 73, 94);"> 等。</font>
+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialPageResult</font>`<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">list: SpecialItem[]</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">total: number</font>`<font style="color:rgb(52, 73, 94);">。</font>

```typescript
/** 列表项（与后端 DTO 对齐后再映射的展示结构） */
export interface SpecialItem {
  id: string | number | undefined
  title: string
  /** 对应后端 banner */
  cover: string
  /** 专题简介 */
  introduction: string
  /** 是否已关注（后端可能为字符串 "true"/"false"） */
  isFollowing: boolean
  /** 展示用更新时间 */
  updateLabel: string
  /** 展示用浏览量 */
  visitLabel: string
  /** 展示用关注人数 */
  followersLabel: string
}

export interface SpecialPageResult {
  list: SpecialItem[]
  total: number
}
```

## <font style="color:rgb(52, 73, 94);">数据归一化 + 专题 API</font>
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/api/specialNormalize.ts</font>**`<font style="color:rgb(52, 73, 94);">（内容与后端返回结构强相关）：</font>

```typescript
import type { SpecialItem } from '../types/special'

/**
 * 安全将未知值转为普通对象（Record）
 * 仅当值是对象、非null、非数组时才返回对象，否则返回null
 * @param v 未知类型的值
 * @returns 普通对象 或 null
 */
export function asRecord(v: unknown): Record<string, unknown> | null {
  return v && typeof v === 'object' && !Array.isArray(v)
    ? (v as Record<string, unknown>)
    : null
}

/**
 * 从接口返回 payload 中智能提取列表数组（兼容多种字段名）
 * 优先取：list / records / rows / items / dataList
 * 其次取：data.list / data.records 等嵌套结构
 * @param payload 接口返回的原始数据
 * @returns 提取到的数组，无数据则返回空数组
 */
export function pickRows(payload: unknown): unknown[] {
  // 如果 payload 本身就是数组，直接返回
  if (Array.isArray(payload)) return payload

  // 转为根对象，转换失败则返回空数组
  const root = asRecord(payload)
  if (!root) return []

  // 定义常用列表字段名（通用列表接口命名）
  const keys = ['list', 'records', 'rows', 'items', 'dataList'] as const

  // 从对象中批量取出这些key对应的值
  const tryArrays = (o: Record<string, unknown>) => keys.map((k) => o[k])

  // 遍历根对象的列表字段，找到数组就返回
  for (const v of tryArrays(root)) {
    if (Array.isArray(v)) return v
  }

  // 兼容根节点下直接是 data 数组的情况
  if (Array.isArray(root.data)) return root.data

  // 尝试解析 data 嵌套对象
  const data = asRecord(root.data)
  if (data) {
    // 从 data 内部再次查找列表字段
    for (const v of tryArrays(data)) {
      if (Array.isArray(v)) return v
    }
  }

  // 都没找到，返回空数组
  return []
}

/**
 * 从接口返回中智能提取总数（total/totalCount）
 * 支持根节点 或 data 嵌套节点
 * @param payload 接口返回原始数据
 * @returns 合法数字总数，无数据则返回0
 */
export function pickTotal(payload: unknown): number {
  const root = asRecord(payload)
  if (!root) return 0

  // 尝试解析 data 字段为对象
  const dataRec = asRecord(root.data)

  // 依次检查可能的总数字段
  for (const c of [
    root.total,
    root.totalCount,
    dataRec?.total,
    dataRec?.totalCount,
  ]) {
    const n = Number(c)
    // 确保是有效非负数字
    if (Number.isFinite(n) && n >= 0) return n
  }

  return 0
}

/**
 * 详情接口：智能提取单条数据
 * 优先取 { data: {...} }，其次取根对象本身
 * 判断依据：包含 id 或 title 字段视为有效数据
 * @param payload 详情接口返回数据
 * @returns 单条对象 或 null
 */
export function pickOneRecord(payload: unknown): Record<string, unknown> | null {
  const root = asRecord(payload)
  if (!root) return null

  // 尝试取 data 内部对象
  const inner = asRecord(root.data)
  if (inner && ('id' in inner || 'title' in inner)) return inner

  // 否则判断根节点是否是有效数据
  if ('id' in root || 'title' in root) return root

  return null
}

/**
 * 格式化浏览量/关注数：显示万、千分位分隔
 * @param n 原始数字
 * @returns 格式化后字符串，无数据显示 —
 */
function formatVisit(n: unknown): string {
  const num = Number(n)
  // 非有效数字，返回占位符
  if (!Number.isFinite(num)) return String(n ?? '—')

  // 大于等于1万，显示 x.x万
  if (num >= 10_000) return `${(num / 10_000).toFixed(1)} 万`

  // 小于1万，显示千分位
  return num.toLocaleString('zh-CN')
}

/**
 * 格式化更新时间：时间戳 → YYYY-MM-DD 更新
 * 自动兼容秒/毫秒级时间戳
 * @param n 时间戳（秒/毫秒）
 * @returns 格式化文案 或 null（无效时间）
 */
function formatUpdatedField(n: unknown): string | null {
  const num = Number(n)
  if (!Number.isFinite(num) || num <= 0) return null

  // 小于1e12视为秒级时间戳，转毫秒
  const ms = num < 1e12 ? num * 1000 : num
  const d = new Date(ms)

  // 无效日期返回null
  if (Number.isNaN(d.getTime())) return null

  // 格式化日期
  const y = d.getFullYear()
  const m = String(d.getMonth() + 1).padStart(2, '0')
  const day = String(d.getDate()).padStart(2, '0')

  return `${y}-${m}-${day} 更新`
}

/**
 * 解析是否关注：兼容布尔、字符串、数字
 * @param v 原始值
 * @returns 布尔值是否关注
 */
function parseFollowing(v: unknown): boolean {
  if (typeof v === 'boolean') return v

  // 转小写并去空格，兼容多种传参
  const s = String(v).toLowerCase().trim()
  return s === 'true' || s === '1' || s === 'yes'
}

/**
 * 专题原始数据标准化：将后端杂乱字段映射为前端统一结构
 * 统一取标题、封面、ID、简介、更新时间、浏览量、关注数等
 * @param raw 后端返回的原始单条数据
 * @returns 标准化后的 SpecialItem
 */
export function normalizeItem(raw: Record<string, unknown>): SpecialItem {
  // 统一取标题：兼容多种命名
  const title = String(
    raw.title ?? raw.name ?? raw.specialTitle ?? '未命名专题',
  )

  // 统一取封面图：兼容多种字段
  const cover = String(
    raw.banner ??
      raw.bannerUrl ??
      raw.cover ??
      raw.coverUrl ??
      raw.image ??
      raw.pic ??
      raw.avatar ??
      '',
  )

  // 统一取ID
  const id = raw.id ?? raw.specialId ?? raw.topicId

  // 简介
  const introduction = String(raw.introduction ?? '').trim()

  // 格式化更新时间标签
  const updatedTs = formatUpdatedField(raw.updated)

  // 备用更新时间原始值
  const updateRaw =
    raw.updateTime ??
    raw.updatedAt ??
    raw.updateDate ??
    raw.gmtModified ??
    raw.lastUpdate

  // 最终展示的更新标签
  let updateLabel = '—'
  if (updatedTs) updateLabel = updatedTs
  else if (updateRaw != null && updateRaw !== '') {
    const s = String(updateRaw)
    updateLabel = s.includes('更新') ? s : `${s} 更新`
  }

  // 统一取浏览量：兼容 viewCount 对象嵌套 views
  const vc = raw.viewCount
  const visit =
    (typeof vc === 'object' && vc !== null && 'views' in (vc as object)
      ? (vc as { views?: unknown }).views
      : vc) ??
    raw.views ??
    raw.readCount ??
    raw.visitCount ??
    raw.count

  // 统一取关注数
  const followers = raw.followersCount ?? raw.followers ?? raw.followCount

  // 返回标准化结构
  return {
    id: id as string | number | undefined,
    title,
    cover,
    introduction,
    isFollowing: parseFollowing(raw.isFollowing),
    updateLabel,
    visitLabel: `${formatVisit(visit)} 次浏览`,
    followersLabel: `${formatVisit(followers)} 关注`,
  }
}
```

+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">asRecord</font>**`<font style="color:rgb(52, 73, 94);">：安全把 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">unknown</font>`<font style="color:rgb(52, 73, 94);"> 收窄成对象。 </font>
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickRows</font>**`<font style="color:rgb(52, 73, 94);">：从各种常见包装里取出</font>**<font style="color:rgb(52, 73, 94);">数组</font>**<font style="color:rgb(52, 73, 94);">（如顶层 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">list</font>`<font style="color:rgb(52, 73, 94);"> / </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">records</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">data</font>`<font style="color:rgb(52, 73, 94);"> 为数组、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">data.list</font>`<font style="color:rgb(52, 73, 94);"> 等）。 </font>
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickTotal</font>**`<font style="color:rgb(52, 73, 94);">：取分页总数 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">total</font>`<font style="color:rgb(52, 73, 94);"> / </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">totalCount</font>`<font style="color:rgb(52, 73, 94);"> 等。 </font>
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickOneRecord</font>**`<font style="color:rgb(52, 73, 94);">：详情接口里取出</font>**<font style="color:rgb(52, 73, 94);">单条对象</font>**<font style="color:rgb(52, 73, 94);">（如 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">{ data: { ... } }</font>`<font style="color:rgb(52, 73, 94);"> 或扁平对象）。 </font>
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">normalizeItem</font>**`<font style="color:rgb(52, 73, 94);">：把后端一条 DTO 转成 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialItem</font>`<font style="color:rgb(52, 73, 94);">（</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">banner</font>`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">cover</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">updated</font>`<font style="color:rgb(52, 73, 94);"> 时间戳 → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">updateLabel</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">viewCount</font>`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">visitLabel</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">isFollowing</font>`<font style="color:rgb(52, 73, 94);"> 字符串转布尔等）。</font>

新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/api/special.ts</font>**`<font style="color:rgb(52, 73, 94);">（薄封装，只负责 URL 与调用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">httpGet</font>`<font style="color:rgb(52, 73, 94);">）：</font>

```typescript
import { httpGet } from '../utils/http'
import {
  normalizeItem,
  pickOneRecord,
  pickRows,
  pickTotal,
  asRecord,
} from './specialNormalize'
import type { SpecialItem, SpecialPageResult } from '../types/special'

/**
 * 根据专题标题【模糊搜索】+ 分页查询专题列表
 * 自动处理后端返回数据结构，统一返回标准化列表 + 总数
 * @param params 查询参数：标题 + 页码 + 每页条数
 * @returns 标准化分页结果 { list: SpecialItem[], total: number }
 */
export async function fetchSpecialByTitle(params: {
  title: string
  pageNum: number
  pageSize: number
}): Promise<SpecialPageResult> {
  // 调用 GET 接口，获取原始未知结构数据
  const data = await httpGet<unknown>('/v1/special/page', {
    params: {
      title: params.title,
      pageNum: params.pageNum,
      pageSize: params.pageSize,
    },
  })

  // 数据处理流水线：
  // 1. pickRows：从返回值中智能提取列表数组
  // 2. asRecord：确保每一项都是对象，过滤非对象
  // 3. filter(Boolean)：剔除 null/undefined 项
  // 4. normalizeItem：统一格式化为前端专用 SpecialItem
  const list = pickRows(data)
    .map((r) => asRecord(r))
    .filter(Boolean)
    .map((r) => normalizeItem(r!))

  // 提取总数
  let total = pickTotal(data)

  // 兼容兜底：后端没返回总数，但列表有数据时，用列表长度当总数
  if (total <= 0 && list.length > 0) total = list.length

  // 返回标准化分页数据
  return { list, total }
}

/**
 * 根据专题ID【查询专题详情】
 * 自动兼容后端多种返回结构 { data: {...} } / 扁平对象
 * @param id 专题ID
 * @returns 标准化详情对象 / null（无数据）
 */
export async function fetchSpecialById(id: string): Promise<SpecialItem | null> {
  // 请求详情接口，获取原始数据
  const data = await httpGet<unknown>('/v1/special/detail', {
    params: { id },
  })

  // 智能提取单条记录
  const row = pickOneRecord(data)

  // 存在记录则标准化，否则返回 null
  return row ? normalizeItem(row) : null
}
```

+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchSpecialByTitle({ title, pageNum, pageSize })</font>**`
    - `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">GET /v1/special/selectByTitle</font>`<font style="color:rgb(52, 73, 94);">，</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">params</font>`<font style="color:rgb(52, 73, 94);"> 传上述三个字段。 </font>
    - <font style="color:rgb(52, 73, 94);">用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickRows</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickTotal</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">normalizeItem</font>`<font style="color:rgb(52, 73, 94);"> 得到 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">{ list, total }</font>`<font style="color:rgb(52, 73, 94);">。</font>
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchSpecialById(id)</font>**`
    - <font style="color:rgb(52, 73, 94);">当前仓库默认为 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">GET /v1/special/selectById</font>**`**<font style="color:rgb(52, 73, 94);">，query：</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">id</font>**`<font style="color:rgb(52, 73, 94);">（与 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">selectByTitle</font>`<font style="color:rgb(52, 73, 94);"> 命名风格一致）。 </font>
    - <font style="color:rgb(52, 73, 94);">若后端是 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/v1/special/{id}</font>**`<font style="color:rgb(52, 73, 94);"> 或别的路径，</font>**<font style="color:rgb(52, 73, 94);">只改此文件一处</font>**<font style="color:rgb(52, 73, 94);">即可。</font>

## <font style="color:rgb(52, 73, 94);">配置路由</font>
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/router/index.ts</font>**`<font style="color:rgb(52, 73, 94);">：</font>

```typescript
import { createRouter, createWebHistory } from 'vue-router'
// 专题列表页组件
import SpecialListView from '../views/SpecialListView.vue'
// 专题详情页组件
import SpecialDetailView from '../views/SpecialDetailView.vue'

// 创建 Vue Router 实例（使用 HTML5 历史模式）
export default createRouter({
  // 路由模式：history 模式（不带 #）
  history: createWebHistory(),
  
  // 路由配置表
  routes: [
    // 根路径自动重定向到专题列表页
    { path: '/', redirect: '/special' },
    
    // 专题列表路由
    {
      path: '/special',
      name: 'special-list',       // 路由名称（用于编程式导航）
      component: SpecialListView  // 列表页组件
    },
    
    // 专题详情路由（带动态 id 参数）
    {
      path: '/special/:id',       // 动态路由参数：id = 专题ID
      name: 'special-detail',     // 路由名称
      component: SpecialDetailView // 详情页组件
    }
  ]
})
```

+ <font style="color:rgb(52, 73, 94);">路由表： </font>
    - `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">path: '/'</font>`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">redirect: '/special'</font>`
    - `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">path: '/special'</font>`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">name: 'special-list'</font>`<font style="color:rgb(52, 73, 94);">，组件 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialListView.vue</font>**`
    - `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">path: '/special/:id'</font>`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">name: 'special-detail'</font>`<font style="color:rgb(52, 73, 94);">，组件 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialDetailView.vue</font>**`

修改`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/main.ts</font>**`<font style="color:rgb(52, 73, 94);">：在 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">createApp(App)</font>`<font style="color:rgb(52, 73, 94);"> 之后执行 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">app.use(router)</font>**`<font style="color:rgb(52, 73, 94);">，再执行 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">app.use(ElementPlus)</font>`<font style="color:rgb(52, 73, 94);">，最后执行 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">mount('#app')</font>`<font style="color:rgb(52, 73, 94);">。</font>

```typescript
// Vue 核心创建应用方法
import { createApp } from 'vue'

// Element Plus 组件库 + 中文语言包
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

// Element Plus 全局样式
import 'element-plus/dist/index.css'

// 根组件
import App from './App.vue'

// 路由配置
import router from './router'

// 创建 Vue 应用实例
const app = createApp(App)

// 注册路由
app.use(router)

// 注册 Element Plus 并配置中文
app.use(ElementPlus, { locale: zhCn })

// 将应用挂载到页面 #app 节点
app.mount('#app')
```

<font style="color:rgb(52, 73, 94);">注意 ：</font>

+ <font style="color:rgb(52, 73, 94);">Element Plus 需引入样式：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">import 'element-plus/dist/index.css'</font>`<font style="color:rgb(52, 73, 94);">；</font>
+ <font style="color:rgb(52, 73, 94);">中文本地化需引入：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">import zhCn from 'element-plus/es/locale/lang/zh-cn'</font>`<font style="color:rgb(52, 73, 94);">，再执行</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">app.use(ElementPlus, { locale: zhCn })</font>`<font style="color:rgb(52, 73, 94);">。</font>

## <font style="color:rgb(52, 73, 94);">封装列表卡片组件</font>
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/components/SpecialCard.vue</font>**`<font style="color:rgb(52, 73, 94);">，把每个专题内容封装为一个卡片组件。</font>

```vue
<script setup lang="ts">
import { computed } from 'vue'
import { RouterLink } from 'vue-router'
import type { SpecialItem } from '../types/special'
// 封面图占位图生成工具
import { coverPlaceholder } from '../utils/coverPlaceholder'

// 组件 Props：接收标准化后的专题项
const props = defineProps<{ item: SpecialItem }>()

// 计算属性：生成详情页路由跳转对象
const to = computed(() => ({
  name: 'special-detail' as const, // 路由名称（固定）
  params: { id: String(props.item.id ?? '') }, // 动态路由参数：专题ID
}))

// 生成封面占位图（使用标题生成）
const ph = () => coverPlaceholder(props.item.title)
</script>

<template>
  <!-- 自定义路由链接：使用 custom 实现完全自定义点击区域 -->
  <RouterLink v-slot="{ navigate }" :to="to" custom>
    <!-- 专题卡片容器 -->
    <li class="card-row" role="link" @click="navigate">
      <!-- 封面图区域 -->
      <div class="cover-wrap">
        <img
          class="cover"
          :src="item.cover || ph()"
          :alt="item.title"
          loading="lazy"
          @error="(e) => ((e.target as HTMLImageElement).src = ph())"
        />
      </div>

      <!-- 内容主体区域 -->
      <div class="body">
        <!-- 标题 -->
        <h2 class="card-title">{{ item.title }}</h2>
        <!-- 简介（有值才显示） -->
        <p v-if="item.introduction" class="intro">{{ item.introduction }}</p>
        <!-- 元信息：更新时间 + 浏览量 + 关注数 -->
        <p class="meta">
          <span>{{ item.updateLabel }}</span>
          <span class="dot">·</span>
          <span>{{ item.visitLabel }}</span>
          <span class="dot">·</span>
          <span>{{ item.followersLabel }}</span>
        </p>
        <!-- 关注按钮 -->
        <el-button
          class="follow-btn"
          round
          :class="{ 'follow-btn--following': item.isFollowing }"
          @click.stop.prevent
        >
          {{ item.isFollowing ? '已关注' : '关注专题' }}
        </el-button>
      </div>
    </li>
  </RouterLink>
</template>

<style scoped>
/* 专题卡片整体样式 */
.card-row {
  display: flex;
  gap: 20px;
  cursor: pointer;
  padding: 20px;
  margin-bottom: 12px;
  background: #fff;
  border-radius: 4px;
  box-shadow: 0 1px 3px rgba(18, 18, 18, 0.06);
  border: 1px solid #f0f0f0;
  list-style: none;
  transition: box-shadow 0.2s ease;
}
/* 卡片 hover 悬浮效果 */
.card-row:hover {
  box-shadow: 0 4px 12px rgba(18, 18, 18, 0.08);
}

/* 封面图容器 */
.cover-wrap {
  flex-shrink: 0;
  width: 200px;
  border-radius: 4px;
  overflow: hidden;
  background: #f6f6f6;
}
/* 封面图 */
.cover {
  display: block;
  width: 100%;
  height: 120px;
  object-fit: cover;
}

/* 内容主体 */
.body {
  flex: 1;
  min-width: 0;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  text-align: left;
}

/* 标题 */
.card-title {
  margin: 0 0 10px;
  font-size: 18px;
  font-weight: 600;
  color: #121212;
  line-height: 1.35;
}

/* 简介：最多显示2行，超出省略 */
.intro {
  margin: 0 0 10px;
  font-size: 14px;
  color: #646464;
  line-height: 1.55;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

/* 底部元信息 */
.meta {
  margin: 0 0 16px;
  font-size: 14px;
  color: #8590a6;
  line-height: 1.5;
}
/* 分隔点 */
.dot {
  margin: 0 6px;
  opacity: 0.7;
}

/* 关注按钮默认样式 */
.follow-btn {
  --el-button-border-color: #0084ff;
  --el-button-text-color: #0084ff;
  --el-button-bg-color: #fff;
  --el-button-hover-text-color: #0084ff;
  --el-button-hover-bg-color: rgba(0, 132, 255, 0.06);
  --el-button-hover-border-color: #0084ff;
}
/* 已关注状态按钮样式 */
.follow-btn.follow-btn--following {
  --el-button-border-color: #ebebeb;
  --el-button-text-color: #8590a6;
  --el-button-bg-color: #f6f6f6;
  --el-button-hover-text-color: #8590a6;
  --el-button-hover-bg-color: #f0f0f0;
  --el-button-hover-border-color: #e0e0e0;
}

/* 移动端响应式适配 */
@media (max-width: 640px) {
  .card-row {
    flex-direction: column;
  }
  .cover-wrap {
    width: 100%;
  }
  .cover {
    height: 160px;
  }
}
</style>
```

+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">props</font>`<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">item: SpecialItem</font>`<font style="color:rgb(52, 73, 94);">。 </font>
+ <font style="color:rgb(52, 73, 94);">用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">RouterLink</font>**`**<font style="color:rgb(52, 73, 94);"> + </font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">custom</font>**`**<font style="color:rgb(52, 73, 94);"> + </font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">v-slot="{ navigate }"</font>**`<font style="color:rgb(52, 73, 94);"> 包一层，使整张卡片点击进详情；关注按钮上加 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">@click.stop.prevent</font>**`<font style="color:rgb(52, 73, 94);">，避免误触跳转。 </font>
+ <font style="color:rgb(52, 73, 94);">封面图失败时用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">coverPlaceholder</font>**`<font style="color:rgb(52, 73, 94);">；样式与知乎卡片类似（白底、左图右文、元信息一行）。</font>

<font style="color:rgb(52, 73, 94);">这样列表页只负责「拉数据 + </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">v-for</font>`<font style="color:rgb(52, 73, 94);">」，卡片样式与跳转集中在一处。</font>

## <font style="color:rgb(52, 73, 94);">列表页与详情页</font>
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/views/SpecialListView.vue</font>**`<font style="color:rgb(52, 73, 94);">列表页，代码如下：</font>

```vue
<script setup lang="ts">
import { computed, onMounted, ref } from 'vue'
import { ElMessage } from 'element-plus'
// 专题列表接口请求方法
import { fetchSpecialByTitle } from '../api/special'
// 专题数据类型
import type { SpecialItem } from '../types/special'
// 请求错误信息格式化工具
import { axiosErrorMessage } from '../utils/httpError'
// 专题卡片子组件
import SpecialCard from '../components/SpecialCard.vue'

// 搜索关键词
const titleQuery = ref('')
// 当前页码
const pageNum = ref(1)
// 每页条数
const pageSize = ref(10)
// 加载状态（控制骨架屏/按钮禁用）
const loading = ref(false)
// 专题列表数据
const list = ref<SpecialItem[]>([])
// 总条数
const total = ref(0)

// 计算属性：总条数字符串（带千分位）
const totalText = computed(() =>
  total.value > 0 ? `共有 ${total.value.toLocaleString('zh-CN')} 个专题` : '',
)

/**
 * 加载列表数据（搜索 + 分页通用）
 * 1. 开启loading
 * 2. 请求接口
 * 3. 赋值列表/总数
 * 4. 异常捕获并提示
 * 5. 关闭loading
 */
async function load() {
  loading.value = true
  try {
    const res = await fetchSpecialByTitle({
      title: titleQuery.value.trim() || '',
      pageNum: pageNum.value,
      pageSize: pageSize.value,
    })
    list.value = res.list
    total.value = res.total
  } catch (e) {
    console.error(e)
    ElMessage.error(axiosErrorMessage(e, '加载失败'))
    list.value = []
    total.value = 0
  } finally {
    loading.value = false
  }
}

/**
 * 搜索事件：重置为第1页并重新加载
 */
function onSearch() {
  pageNum.value = 1
  load()
}

/**
 * 每页条数改变：重置页码为1并重新加载
 */
function onSizeChange(s: number) {
  pageSize.value = s
  pageNum.value = 1
  load()
}

// 页面挂载后自动加载第一页数据
onMounted(load)
</script>

<template>
  <div class="page">
    <!-- 页面头部：标题 + 搜索栏 -->
    <header class="head">
      <h1 class="title-all">全部专题</h1>
      <p v-if="totalText" class="sub">{{ totalText }}</p>
      <div class="toolbar">
        <el-input
          v-model="titleQuery"
          class="search"
          clearable
          placeholder="关键词，如：安全"
          @keyup.enter="onSearch"
        />
        <el-button type="primary" @click="onSearch">搜索</el-button>
      </div>
    </header>

    <!-- 骨架屏 + 列表区域 -->
    <el-skeleton :loading="loading" animated :count="3">
      <!-- 加载中骨架模板 -->
      <template #template>
        <div class="sk">
          <el-skeleton-item variant="image" style="width: 200px; height: 120px" />
          <div style="flex: 1; padding-left: 20px">
            <el-skeleton-item variant="h3" style="width: 50%" />
            <el-skeleton-item variant="text" style="margin-top: 16px" />
          </div>
        </div>
      </template>

      <!-- 加载完成：显示列表 / 空状态 -->
      <template #default>
        <ul class="list">
          <SpecialCard
            v-for="it in list"
            :key="String(it.id ?? it.title)"
            :item="it"
          />
        </ul>
        <el-empty v-if="!loading && list.length === 0" description="暂无数据" />
      </template>
    </el-skeleton>

    <!-- 分页组件：有数据时显示 -->
    <footer v-if="total > 0" class="pager">
      <el-pagination
        v-model:current-page="pageNum"
        v-model:page-size="pageSize"
        :total="total"
        :page-sizes="[10, 20, 50]"
        layout="total, sizes, prev, pager, next"
        background
        @current-change="load"
        @size-change="onSizeChange"
      />
    </footer>
  </div>
</template>

<style scoped>
/* 页面容器：居中、最大宽度、内边距 */
.page {
  max-width: 1000px;
  margin: 0 auto;
  padding: 24px 20px 48px;
  box-sizing: border-box;
}
/* 头部区域 */
.head {
  margin-bottom: 28px;
}
/* 主标题 */
.title-all {
  margin: 0 0 8px;
  font-size: 26px;
  font-weight: 600;
  color: #1a1a1a;
}
/* 总数副标题 */
.sub {
  margin: 0 0 20px;
  font-size: 14px;
  color: #8590a6;
}
/* 搜索栏容器 */
.toolbar {
  display: flex;
  gap: 12px;
  flex-wrap: wrap;
}
/* 搜索框宽度 */
.search {
  width: min(420px, 100%);
}
/* 列表清除默认样式 */
.list {
  margin: 0;
  padding: 0;
}
/* 骨架屏项样式 */
.sk {
  display: flex;
  padding: 20px;
  margin-bottom: 12px;
  background: #fff;
  border: 1px solid #f0f0f0;
  border-radius: 4px;
}
/* 分页居中 */
.pager {
  display: flex;
  justify-content: center;
  margin-top: 28px;
}
</style>
```

+ <font style="color:rgb(52, 73, 94);">状态：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">titleQuery</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pageNum</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pageSize</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">loading</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">list</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">total</font>`<font style="color:rgb(52, 73, 94);">。 </font>
+ `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">load()</font>`<font style="color:rgb(52, 73, 94);"> 内调用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchSpecialByTitle</font>`<font style="color:rgb(52, 73, 94);">，</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">catch</font>`<font style="color:rgb(52, 73, 94);"> 里 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">ElMessage.error(axiosErrorMessage(...))</font>`<font style="color:rgb(52, 73, 94);">。 </font>
+ <font style="color:rgb(52, 73, 94);">模板：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">el-input</font>`<font style="color:rgb(52, 73, 94);"> + 搜索按钮、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">el-skeleton</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialCard</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">el-pagination</font>`<font style="color:rgb(52, 73, 94);">（</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">@current-change</font>`<font style="color:rgb(52, 73, 94);"> / </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">@size-change</font>`<font style="color:rgb(52, 73, 94);"> 里调用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">load</font>`<font style="color:rgb(52, 73, 94);">）。 </font>
+ <font style="color:rgb(52, 73, 94);">样式：页面容器最大宽度、工具栏布局等。</font>

新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/views/SpecialDetailView.vue</font>**`<font style="color:rgb(52, 73, 94);">详情页，代码如下：</font>

```vue
<script setup lang="ts">
import { onMounted, ref, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
// 根据ID获取专题详情接口
import { fetchSpecialById } from '../api/special'
// 专题类型定义
import type { SpecialItem } from '../types/special'
// 请求错误提示格式化
import { axiosErrorMessage } from '../utils/httpError'
// 封面图占位图生成工具
import { coverPlaceholder } from '../utils/coverPlaceholder'

// 路由实例：获取当前路由参数
const route = useRoute()
// 路由跳转：返回列表页
const router = useRouter()

// 加载状态（控制骨架屏）
const loading = ref(true)
// 详情数据
const item = ref<SpecialItem | null>(null)

/**
 * 根据ID加载专题详情
 * @param id 专题ID
 */
async function load(id: string) {
  // 无ID直接清空数据
  if (!id) {
    item.value = null
    loading.value = false
    return
  }

  loading.value = true
  try {
    // 请求接口获取标准化详情数据
    item.value = await fetchSpecialById(id)
    // 未查询到数据给出提示
    if (!item.value) ElMessage.warning('未找到该专题')
  } catch (e) {
    console.error(e)
    ElMessage.error(axiosErrorMessage(e, '加载详情失败'))
    item.value = null
  } finally {
    // 无论成功失败，关闭loading
    loading.value = false
  }
}

// 页面挂载：根据路由ID加载数据
onMounted(() => load(String(route.params.id ?? '')))

// 监听路由ID变化：切换详情时自动刷新
watch(
  () => route.params.id,
  (id) => load(String(id ?? '')),
)

/** 返回专题列表页 */
function back() {
  router.push({ name: 'special-list' })
}

/** 生成详情页大图占位图 */
function ph(t: string) {
  return coverPlaceholder(t, 800, 260)
}
</script>

<template>
  <div class="page">
    <!-- 返回按钮 -->
    <el-button link type="primary" class="back" @click="back">← 返回列表</el-button>

    <!-- 骨架屏 + 详情内容 -->
    <el-skeleton :loading="loading" animated>
      <!-- 加载中骨架模板 -->
      <template #template>
        <el-skeleton-item variant="image" style="width: 100%; height: 200px" />
        <el-skeleton-item variant="h1" style="margin-top: 16px; width: 60%" />
        <el-skeleton-item variant="text" style="margin-top: 12px" />
      </template>

      <!-- 加载完成：显示详情 / 空状态 -->
      <template #default>
        <template v-if="item">
          <!-- 封面大图 -->
          <div class="banner-wrap">
            <img
              class="banner"
              :src="item.cover || ph(item.title)"
              :alt="item.title"
              @error="(e) => ((e.target as HTMLImageElement).src = ph(item!.title))"
            />
          </div>
          <!-- 标题 -->
          <h1 class="title">{{ item.title }}</h1>
          <!-- 元信息：更新时间 + 浏览 + 关注 -->
          <p class="meta">
            {{ item.updateLabel }} · {{ item.visitLabel }} · {{ item.followersLabel }}
          </p>
          <!-- 简介 -->
          <p v-if="item.introduction" class="intro">{{ item.introduction }}</p>
          <!-- 关注按钮 -->
          <el-button round :class="item.isFollowing ? 'fol-on' : 'fol'">
            {{ item.isFollowing ? '已关注' : '关注专题' }}
          </el-button>
        </template>

        <!-- 无数据空状态 -->
        <el-empty v-else-if="!loading" description="无数据" />
      </template>
    </el-skeleton>
  </div>
</template>

<style scoped>
/* 页面容器：居中、最大宽度 */
.page {
  max-width: 1000px;
  margin: 0 auto;
  padding: 20px 20px 48px;
  box-sizing: border-box;
}
/* 返回按钮间距 */
.back {
  margin-bottom: 16px;
}
/* 封面图容器 */
.banner-wrap {
  border-radius: 6px;
  overflow: hidden;
  background: #f0f0f0;
}
/* 封面大图 */
.banner {
  display: block;
  width: 100%;
  height: 260px;
  object-fit: cover;
}
/* 标题样式 */
.title {
  margin: 20px 0 8px;
  font-size: 24px;
  font-weight: 600;
  color: #1a1a1a;
}
/* 底部信息 */
.meta {
  margin: 0 0 16px;
  font-size: 14px;
  color: #8590a6;
}
/* 简介 */
.intro {
  margin: 0 0 20px;
  font-size: 15px;
  line-height: 1.6;
  color: #444;
}
/* 关注按钮-未关注 */
.fol {
  --el-button-border-color: #0084ff;
  --el-button-text-color: #0084ff;
}
/* 关注按钮-已关注 */
.fol-on {
  --el-button-text-color: #8590a6;
}
</style>
```

+ <font style="color:rgb(52, 73, 94);">用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">useRoute()</font>**`<font style="color:rgb(52, 73, 94);"> 取 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">route.params.id</font>**`<font style="color:rgb(52, 73, 94);">，</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">onMounted</font>`<font style="color:rgb(52, 73, 94);"> 与 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">watch(() => route.params.id)</font>**`<font style="color:rgb(52, 73, 94);"> 里调用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchSpecialById</font>`<font style="color:rgb(52, 73, 94);">，避免同组件内切换 id 不刷新。 </font>
+ <font style="color:rgb(52, 73, 94);">展示大图、标题、元信息、简介、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">ElMessage</font>`<font style="color:rgb(52, 73, 94);"> 处理失败与空数据；</font>**<font style="color:rgb(52, 73, 94);">返回列表</font>**<font style="color:rgb(52, 73, 94);">按钮 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">router.push({ name: 'special-list' })</font>`<font style="color:rgb(52, 73, 94);">。</font>

## <font style="color:rgb(52, 73, 94);">根组件</font>
修改`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/App.vue</font>**`<font style="color:rgb(52, 73, 94);">根组件代码，只保留路由入口。</font>

```vue
<script setup lang="ts">
// Vue Router 路由视图容器
// 用于渲染当前路由匹配到的页面组件
import { RouterView } from 'vue-router'
</script>

<template>
  <!-- 路由出口：匹配到的页面组件将在这里渲染 -->
  <RouterView />
</template>

<style>
/* 全局根节点 #app 样式重置与基础布局 */
#app {
  width: 100%;                /* 全屏宽度 */
  max-width: none;            /* 取消最大宽度限制 */
  margin: 0;                  /* 清除默认外边距 */
  text-align: initial;        /* 重置文本对齐 */
  border: none;               /* 清除边框 */
  min-height: 100vh;          /* 最小高度撑满视口 */
  background: #f6f6f6;        /* 页面全局背景色 */
}
</style>
```

+ <font style="color:rgb(52, 73, 94);">只保留 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);"><RouterView /></font>**`<font style="color:rgb(52, 73, 94);">。 </font>
+ <font style="color:rgb(52, 73, 94);">全局样式：如 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">#app</font>`<font style="color:rgb(52, 73, 94);"> 铺满宽度、浅灰背景 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">#f6f6f6</font>`<font style="color:rgb(52, 73, 94);">，与专题列表视觉统一。</font>

<font style="color:rgb(52, 73, 94);">此时目录上应已具备：</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/utils/*</font>**`**<font style="color:rgb(52, 73, 94);">、</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/types/special.ts</font>**`**<font style="color:rgb(52, 73, 94);">、</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/api/*</font>**`**<font style="color:rgb(52, 73, 94);">、</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/router</font>**`**<font style="color:rgb(52, 73, 94);">、</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/components/SpecialCard.vue</font>**`**<font style="color:rgb(52, 73, 94);">、</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/views/*</font>**`**<font style="color:rgb(52, 73, 94);">、</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">App.vue</font>**`**<font style="color:rgb(52, 73, 94);">、</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">main.ts</font>**`<font style="color:rgb(52, 73, 94);">。</font>

## <font style="color:rgb(52, 73, 94);">运行、联调与构建</font>
1. **<font style="color:rgb(52, 73, 94);">启动后端</font>**<font style="color:rgb(52, 73, 94);">（确保 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">http://localhost:8080</font>`<font style="color:rgb(52, 73, 94);"> 上接口可用）。 </font>
2. <font style="color:rgb(52, 73, 94);">前端 Vue 项目根目录执行：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">npm run dev</font>`<font style="color:rgb(52, 73, 94);">，浏览器打开终端提示的地址 </font>[http://localhost:5173](http://localhost:5173)<font style="color:rgb(52, 73, 94);">。 </font>
3. <font style="color:rgb(52, 73, 94);">打开开发者工具 </font>**<font style="color:rgb(52, 73, 94);">Network</font>**<font style="color:rgb(52, 73, 94);">：应能看到对后端接口 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api/v1/special/page</font>**`<font style="color:rgb(52, 73, 94);"> 的请求；状态 200 且 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickRows</font>`<font style="color:rgb(52, 73, 94);"> 能解析时列表才有数据。 </font>
4. <font style="color:rgb(52, 73, 94);">点击某条进入详情：应对后端接口 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api/v1/special/detail</font>**`<font style="color:rgb(52, 73, 94);">发起请求。 </font>
5. <font style="color:rgb(52, 73, 94);">发版前执行</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">npm run build</font>`<font style="color:rgb(52, 73, 94);">，再用 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">npm run preview</font>`<font style="color:rgb(52, 73, 94);"> 本地预览 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">dist</font>`<font style="color:rgb(52, 73, 94);">。生产环境若前后端不同域，需配置 </font>**<font style="color:rgb(52, 73, 94);">Nginx 反代 </font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api</font>**`<font style="color:rgb(52, 73, 94);"> 或 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">VITE_API_BASE</font>**`<font style="color:rgb(52, 73, 94);">。</font>

# UniApp 小程序开发
## 简介
+ **<font style="color:rgb(52, 73, 94);">列表</font>**<font style="color:rgb(52, 73, 94);">：知乎式卡片（封面、标题、简介、更新/浏览/关注）。</font>
+ **<font style="color:rgb(52, 73, 94);">分页</font>**<font style="color:rgb(52, 73, 94);">：</font>**<font style="color:rgb(52, 73, 94);">下拉刷新</font>**<font style="color:rgb(52, 73, 94);">重置第一页；</font>**<font style="color:rgb(52, 73, 94);">触底（上拉）</font>**<font style="color:rgb(52, 73, 94);">追加下一页（无 Web 端分页器）。</font>
+ **<font style="color:rgb(52, 73, 94);">详情</font>**<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">uni.navigateTo</font>`<font style="color:rgb(52, 73, 94);"> 传 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">id</font>`<font style="color:rgb(52, 73, 94);">，请求详情接口展示横幅与正文信息。</font>
+ **<font style="color:rgb(52, 73, 94);">后端</font>**<font style="color:rgb(52, 73, 94);">：默认 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">http://localhost:8080</font>`<font style="color:rgb(52, 73, 94);"> 上的 Spring Boot（</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialController</font>`<font style="color:rgb(52, 73, 94);">）。</font>

## <font style="color:rgb(52, 73, 94);">技术栈</font>
| **<font style="color:rgb(52, 73, 94);">技术</font>**                                           | **<font style="color:rgb(52, 73, 94);">用途</font>**                                                                                                                                                                                                                                                                        |
| :--------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <font style="color:rgb(52, 73, 94);">uni-app Vue3 + Vite</font>                                | <font style="color:rgb(52, 73, 94);">跨端（</font>**<font style="color:rgb(52, 73, 94);">H5</font>**<font style="color:rgb(52, 73, 94);"> 与 </font>**<font style="color:rgb(52, 73, 94);">微信小程序</font>**<font style="color:rgb(52, 73, 94);">）</font>                                                                |
| <font style="color:rgb(52, 73, 94);">TypeScript</font>                                         | <font style="color:rgb(52, 73, 94);">类型与 IDE 提示</font>                                                                                                                                                                                                                                                                 |
| `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pages.json</font>`  | **<font style="color:rgb(52, 73, 94);">页面路由</font>**<font style="color:rgb(52, 73, 94);">（非 vue-router）</font>                                                                                                                                                                                                       |
| `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">uni.request</font>` | <font style="color:rgb(52, 73, 94);">经 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">httpGet</font>`<br/><font style="color:rgb(52, 73, 94);"> 封装，</font>**<font style="color:rgb(52, 73, 94);">不使用 axios</font>**<font style="color:rgb(52, 73, 94);">（小程序端更稳妥）</font> |
| <font style="color:rgb(52, 73, 94);">easycom</font>                                            | `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">components/</font>`<br/><font style="color:rgb(52, 73, 94);"> 下组件自动按需引入</font>                                                                                                                                                          |


<font style="color:rgb(52, 73, 94);">版本以 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">package.json</font>**`<font style="color:rgb(52, 73, 94);"> 为准。</font>

## <font style="color:rgb(52, 73, 94);">和 Web 端的差异</font>
| **<font style="color:rgb(52, 73, 94);">目标</font>** | **<font style="color:rgb(52, 73, 94);">说明</font>**                                                                                                                                                                                                                                                                                                                            |
| :--------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| <font style="color:rgb(52, 73, 94);">跨端</font>     | <font style="color:rgb(52, 73, 94);">同一套业务代码可编到 </font>**<font style="color:rgb(52, 73, 94);">H5</font>**<font style="color:rgb(52, 73, 94);">、</font>**<font style="color:rgb(52, 73, 94);">微信小程序</font>**<font style="color:rgb(52, 73, 94);"> 等</font>                                                                                                      |
| <font style="color:rgb(52, 73, 94);">路由</font>     | <font style="color:rgb(52, 73, 94);">使用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pages.json</font>**`<br/><font style="color:rgb(52, 73, 94);"> 注册页面，</font>**<font style="color:rgb(52, 73, 94);">不用</font>**<font style="color:rgb(52, 73, 94);"> vue-router</font>                                                       |
| <font style="color:rgb(52, 73, 94);">请求</font>     | <font style="color:rgb(52, 73, 94);">使用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">uni.request</font>**`<br/><font style="color:rgb(52, 73, 94);"> 封装为 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">httpGet</font>**`<br/><font style="color:rgb(52, 73, 94);">，不推荐直接引 axios</font> |
| <font style="color:rgb(52, 73, 94);">分页</font>     | <font style="color:rgb(52, 73, 94);">列表页用 </font>**<font style="color:rgb(52, 73, 94);">下拉刷新 + onReachBottom</font>**<font style="color:rgb(52, 73, 94);">，不用分页组件</font>                                                                                                                                                                                         |


<font style="color:rgb(52, 73, 94);">完成后目录与 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">zhihu-vue</font>**`<font style="color:rgb(52, 73, 94);"> 在业务上对齐：</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">api/special*</font>**`<font style="color:rgb(52, 73, 94);">、</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">types/special</font>**`<font style="color:rgb(52, 73, 94);">、</font>**<font style="color:rgb(52, 73, 94);">归一化逻辑</font>**<font style="color:rgb(52, 73, 94);"> 可复用思路。</font>

## <font style="color:rgb(52, 73, 94);">目录结构说明</font>
```perl
zhihu-uniapp/
├── docs/
│   ├── 开发文档.md   
├── src/
│   ├── api/
│   │   ├── special.ts          # fetchSpecialByTitle / fetchSpecialById
│   │   └── specialNormalize.ts # Result/Page → SpecialItem
│   ├── components/
│   │   └── special-card/       # 列表卡片（点击进详情）
│   ├── pages/
│   │   └── special/
│   │       ├── list.vue        # 列表：搜索、下拉刷新、触底加载
│   │       └── detail.vue      # 详情：onLoad 取 id
│   ├── types/
│   │   └── special.ts          # SpecialItem、SpecialPageResult
│   ├── utils/
│   │   └── http.ts             # uni.request + httpGet
│   ├── pages.json              # 页面路径、导航栏、下拉刷新开关
│   ├── manifest.json           # 各端 appid、mp-weixin 等
│   ├── env.d.ts                # VITE_API_BASE 类型
│   ├── main.ts / App.vue       # uni-app 入口（与模板一致）
│   └── uni.scss                # 全局样式变量（可选）
├── vite.config.ts              # Vite 插件 + H5 开发代理
├── index.html
├── .env.example
├── package.json
└── README.md
```

## <font style="color:rgb(52, 73, 94);">创建项目</font>
执行命令，使用脚手架创建 <font style="color:rgb(52, 73, 94);">uni-app（Vue3 + Vite + TS）工程（项目名可自定）：</font>

```bash
npx degit dcloudio/uni-preset-vue#vite-ts zhihu-uniapp
```

创建完毕后，用 VS Code 打开项目，安装依赖

```bash
npm install
```

在`manifest.json` 中配置之前申请的微信小程序 id：

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775745589671-2e6cb513-d0ec-4eea-9f1f-37d15731612a.png" width="1512" title="" crop="0,0,1,1" id="u307fcc46" class="ne-image">

以微信小程序方式运行：

```bash
npm run dev:mp-weixin
```

<font style="color:rgb(52, 73, 94);">终端会输出编译结果目录，一般为：</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">dist/dev/mp-weixin</font>**`

## <font style="color:rgb(52, 73, 94);">运行项目</font>
<font style="color:rgb(52, 73, 94);">打开 </font>**<font style="color:rgb(52, 73, 94);">微信开发者工具</font>**<font style="color:rgb(52, 73, 94);"> → 导入项目，选择上述 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">dist/dev/mp-weixin</font>**`<font style="color:rgb(52, 73, 94);">，如图：</font>

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775745879762-baaa7dbf-f2a4-424a-88f4-42bd62db18cf.png" width="711" title="" crop="0,0,1,1" id="u2768bafc" class="ne-image">

<font style="color:rgb(52, 73, 94);">开发阶段可在「详情 → 本地设置」勾选 </font>**<font style="color:rgb(52, 73, 94);">不校验合法域名、web-view（业务域名）、TLS 版本以及 HTTPS 证书</font>**<font style="color:rgb(52, 73, 94);">，以便 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">http</font>`<font style="color:rgb(52, 73, 94);"> + 局域网调试，初始运行效果如图：</font>

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775745923235-f1b01007-0609-42ee-981b-03a469567ce8.png" width="1250" title="" crop="0,0,1,1" id="ue85eb205" class="ne-image">

## <font style="color:rgb(52, 73, 94);">环境变量</font>
**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">根目录新建</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">.env.development</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">，</font>**<font style="color:rgb(52, 73, 94);">为 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">VITE_API_BASE</font>**`<font style="color:rgb(52, 73, 94);"> 赋值，注意换成你电脑的局域网地址。</font>

```bash
# 真机连本机后端示例（把 IP 换成你电脑的局域网地址）
VITE_API_BASE=http://192.168.3.83:8080/api
```

## <font style="color:rgb(52, 73, 94);">类型与数据归一化</font>
1. `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/types/special.ts</font>**`
    - <font style="color:rgb(52, 73, 94);">定义 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialItem</font>**`<font style="color:rgb(52, 73, 94);">、</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialPageResult</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);"> </font>**

```typescript
export interface SpecialItem {
  id: string | number | undefined;
  title: string;
  cover: string;
  introduction: string;
  isFollowing: boolean;
  updateLabel: string;
  visitLabel: string;
  followersLabel: string;
}

export interface SpecialPageResult {
  list: SpecialItem[];
  total: number;
}
```

2. `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/api/specialNormalize.ts</font>**`
    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickRows</font>**`<font style="color:rgb(52, 73, 94);">：从 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">Result</font>`<font style="color:rgb(52, 73, 94);"> / </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">Page</font>`<font style="color:rgb(52, 73, 94);"> / 数组等结构中取出列表。 </font>
    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickTotal</font>**`<font style="color:rgb(52, 73, 94);">：取 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">total</font>**`<font style="color:rgb(52, 73, 94);">。 </font>
    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pickOneRecord</font>**`<font style="color:rgb(52, 73, 94);">：详情取 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">data</font>**`<font style="color:rgb(52, 73, 94);"> 内单条。 </font>
    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">normalizeItem</font>**`<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">banner</font>`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">cover</font>`<font style="color:rgb(52, 73, 94);">、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">updated</font>`<font style="color:rgb(52, 73, 94);"> → 日期文案等。 </font>

```typescript
import type { SpecialItem } from "@/types/special";

export function asRecord(v: unknown): Record<string, unknown> | null {
  return v && typeof v === "object" && !Array.isArray(v)
    ? (v as Record<string, unknown>)
    : null;
}

export function pickRows(payload: unknown): unknown[] {
  if (Array.isArray(payload)) return payload;
  const root = asRecord(payload);
  if (!root) return [];
  const keys = ["list", "records", "rows", "items", "dataList"] as const;
  const tryArrays = (o: Record<string, unknown>) => keys.map((k) => o[k]);
  for (const v of tryArrays(root)) {
    if (Array.isArray(v)) return v;
  }
  if (Array.isArray(root.data)) return root.data;
  const data = asRecord(root.data);
  if (data) {
    for (const v of tryArrays(data)) {
      if (Array.isArray(v)) return v;
    }
  }
  return [];
}

export function pickTotal(payload: unknown): number {
  const root = asRecord(payload);
  if (!root) return 0;
  const dataRec = asRecord(root.data);
  for (const c of [
    root.total,
    root.totalCount,
    dataRec?.total,
    dataRec?.totalCount,
  ]) {
    const n = Number(c);
    if (Number.isFinite(n) && n >= 0) return n;
  }
  return 0;
}

export function pickOneRecord(
  payload: unknown,
): Record<string, unknown> | null {
  const root = asRecord(payload);
  if (!root) return null;
  const inner = asRecord(root.data);
  if (inner && ("id" in inner || "title" in inner)) return inner;
  if ("id" in root || "title" in root) return root;
  return null;
}

function formatVisit(n: unknown): string {
  const num = Number(n);
  if (!Number.isFinite(num)) return String(n ?? "—");
  if (num >= 10_000) return `${(num / 10_000).toFixed(1)} 万`;
  return num.toLocaleString("zh-CN");
}

function formatUpdatedField(n: unknown): string | null {
  const num = Number(n);
  if (!Number.isFinite(num) || num <= 0) return null;
  const ms = num < 1e12 ? num * 1000 : num;
  const d = new Date(ms);
  if (Number.isNaN(d.getTime())) return null;
  const y = d.getFullYear();
  const m = String(d.getMonth() + 1).padStart(2, "0");
  const day = String(d.getDate()).padStart(2, "0");
  return `${y}-${m}-${day} 更新`;
}

function parseFollowing(v: unknown): boolean {
  if (typeof v === "boolean") return v;
  const s = String(v).toLowerCase().trim();
  return s === "true" || s === "1" || s === "yes";
}

export function normalizeItem(raw: Record<string, unknown>): SpecialItem {
  const title = String(
    raw.title ?? raw.name ?? raw.specialTitle ?? "未命名专题",
  );
  const cover = String(
    raw.banner ??
      raw.bannerUrl ??
      raw.cover ??
      raw.coverUrl ??
      raw.image ??
      raw.pic ??
      raw.avatar ??
      "",
  );
  const id = raw.id ?? raw.specialId ?? raw.topicId;
  const introduction = String(raw.introduction ?? "").trim();
  const updatedTs = formatUpdatedField(raw.updated);
  const updateRaw =
    raw.updateTime ??
    raw.updatedAt ??
    raw.updateDate ??
    raw.gmtModified ??
    raw.lastUpdate;

  let updateLabel = "—";
  if (updatedTs) updateLabel = updatedTs;
  else if (updateRaw != null && updateRaw !== "") {
    const s = String(updateRaw);
    updateLabel = s.includes("更新") ? s : `${s} 更新`;
  }

  const vc = raw.viewCount;
  const visit =
    (typeof vc === "object" && vc !== null && "views" in (vc as object)
      ? (vc as { views?: unknown }).views
      : vc) ??
    raw.views ??
    raw.readCount ??
    raw.visitCount ??
    raw.count;

  const followers = raw.followersCount ?? raw.followers ?? raw.followCount;

  return {
    id: id as string | number | undefined,
    title,
    cover,
    introduction,
    isFollowing: parseFollowing(raw.isFollowing),
    updateLabel,
    visitLabel: `${formatVisit(visit)} 次浏览`,
    followersLabel: `${formatVisit(followers)} 关注`,
  };
}

```

> 这两个文件可以用之前 Vue 项目的
>

## <font style="color:rgb(52, 73, 94);">封装 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">httpGet</font>`
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/utils/http.ts</font>**`<font style="color:rgb(52, 73, 94);">：</font>

```typescript
function apiBase(): string {
  const fromEnv = import.meta.env.VITE_API_BASE?.trim();
  if (fromEnv) return fromEnv.replace(/\/$/, "");
  /* 浏览器 H5：走 Vite 代理 /api；小程序等无 window.location：直连后端（真机请配置 VITE_API_BASE） */
  return typeof location !== "undefined" ? "/api" : "http://localhost:8080/api";
}

function joinUrl(
  path: string,
  params?: Record<string, string | number | boolean>,
) {
  const base = apiBase();
  const p = path.startsWith("/") ? path : `/${path}`;
  const url = path.startsWith("http") ? path : `${base}${p}`;
  if (!params || !Object.keys(params).length) return url;
  const q = Object.entries(params)
    .filter(([, v]) => v !== undefined && v !== null && v !== "")
    .map(
      ([k, v]) => `${encodeURIComponent(k)}=${encodeURIComponent(String(v))}`,
    )
    .join("&");
  return q ? `${url}?${q}` : url;
}

export function httpGet<T = unknown>(
  path: string,
  opts?: { params?: Record<string, string | number | boolean> },
): Promise<T> {
  const url = joinUrl(path, opts?.params);
  return new Promise((resolve, reject) => {
    uni.request({
      url,
      method: "GET",
      timeout: 30_000,
      success: (res) => {
        if (res.statusCode >= 200 && res.statusCode < 300) {
          resolve(res.data as T);
        } else {
          reject(new Error(`HTTP ${res.statusCode}`));
        }
      },
      fail: (e) => reject(e),
    });
  });
}

```

+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">apiBase()</font>**`<font style="color:rgb(52, 73, 94);">：优先 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">VITE_API_BASE</font>**`<font style="color:rgb(52, 73, 94);">；否则 </font>**<font style="color:rgb(52, 73, 94);">浏览器</font>**<font style="color:rgb(52, 73, 94);"> 用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">/api</font>**`<font style="color:rgb(52, 73, 94);">，</font>**<font style="color:rgb(52, 73, 94);">非浏览器</font>**<font style="color:rgb(52, 73, 94);"> 用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">http://localhost:8080/api</font>**`<font style="color:rgb(52, 73, 94);">（真机需要修改为 IP 地址）。 </font>
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">httpGet(path, { params })</font>**`<font style="color:rgb(52, 73, 94);">：拼 query、</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">uni.request</font>`<font style="color:rgb(52, 73, 94);"> GET、</font>**<font style="color:rgb(52, 73, 94);">2xx</font>**<font style="color:rgb(52, 73, 94);"> 时 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">resolve(res.data)</font>`<font style="color:rgb(52, 73, 94);">，否则 </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">reject</font>`<font style="color:rgb(52, 73, 94);">。</font>

## <font style="color:rgb(52, 73, 94);">业务 API</font>
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/api/special.ts</font>**`<font style="color:rgb(52, 73, 94);">：</font>

+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchSpecialByTitle</font>**`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">GET /v1/special/page</font>`
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchSpecialById</font>**`<font style="color:rgb(52, 73, 94);"> → </font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">GET /v1/special/detail?id=</font>`

<font style="color:rgb(52, 73, 94);">路径需与后端 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">zhihu-api</font>**`中的`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">SpecialController</font>**`<font style="color:rgb(52, 73, 94);"> 一致。</font>

```typescript
import { httpGet } from "@/utils/http";
import {
  asRecord,
  normalizeItem,
  pickOneRecord,
  pickRows,
  pickTotal,
} from "@/api/specialNormalize";
import type { SpecialItem, SpecialPageResult } from "@/types/special";

/** 分页列表 */
export async function fetchSpecialByTitle(params: {
  title: string;
  pageNum: number;
  pageSize: number;
}): Promise<SpecialPageResult> {
  const data = await httpGet<unknown>("/v1/special/page", {
    params: {
      title: params.title,
      pageNum: params.pageNum,
      pageSize: params.pageSize,
    },
  });
  const list = pickRows(data)
    .map((r) => asRecord(r))
    .filter(Boolean)
    .map((r) => normalizeItem(r!));
  let total = pickTotal(data);
  if (total <= 0 && list.length > 0) total = list.length;
  return { list, total };
}

/** 详情 */
export async function fetchSpecialById(
  id: string,
): Promise<SpecialItem | null> {
  const data = await httpGet<unknown>("/v1/special/detail", {
    params: { id },
  });
  const row = pickOneRecord(data);
  return row ? normalizeItem(row) : null;
}
```

## `<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pages.json</font>`<font style="color:rgb(52, 73, 94);"> 配置</font>
修改`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pages.json</font>**`

```json
{
  "easycom": {
    "autoscan": true,
    "custom": {}
  },
  "pages": [
    {
      "path": "pages/special/list",
      "style": {
        "navigationBarTitleText": "全部专题",
        "enablePullDownRefresh": true,
        "onReachBottomDistance": 100,
        "backgroundColor": "#f6f6f6"
      }
    },
    {
      "path": "pages/special/detail",
      "style": {
        "navigationBarTitleText": "专题详情",
        "backgroundColor": "#f6f6f6"
      }
    }
  ],
  "globalStyle": {
    "navigationBarTextStyle": "black",
    "navigationBarTitleText": "知乎专题",
    "navigationBarBackgroundColor": "#ffffff",
    "backgroundColor": "#f6f6f6"
  }
}
```

    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">easycom.autoscan: true</font>**`<font style="color:rgb(52, 73, 94);">。 </font>
    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pages</font>**`<font style="color:rgb(52, 73, 94);"> 第一项为 </font>**<font style="color:rgb(52, 73, 94);">列表</font>**<font style="color:rgb(52, 73, 94);">（应用启动页），第二项为 </font>**<font style="color:rgb(52, 73, 94);">详情</font>**<font style="color:rgb(52, 73, 94);">。 </font>
    - <font style="color:rgb(52, 73, 94);">列表 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">style</font>**`<font style="color:rgb(52, 73, 94);">：</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">enablePullDownRefresh: true</font>**`<font style="color:rgb(52, 73, 94);">、</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">onReachBottomDistance</font>**`<font style="color:rgb(52, 73, 94);">（如 100）。</font>

## 编写页面
**<font style="color:rgb(52, 73, 94);">删除</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/pages/index</font>**`<font style="color:rgb(52, 73, 94);">目录，</font>**<font style="background-color:rgb(248, 248, 248);">创建</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/pages/special/list.vue</font>**`，如下：

```vue
<template>
  <view class="page">
    <view class="toolbar">
      <input
        v-model="keyword"
        class="input"
        type="text"
        placeholder="关键词，如：安全"
        confirm-type="search"
        @confirm="onSearch"
      />
      <button class="btn-search" size="mini" @click="onSearch">搜索</button>
    </view>

    <special-card
      v-for="it in list"
      :key="String(it.id ?? it.title)"
      :item="it"
    />

    <view v-if="loading && !list.length" class="tip">加载中…</view>
    <view v-else-if="footText" class="foot">{{ footText }}</view>
  </view>
</template>

<script setup lang="ts">
import { computed, ref } from "vue";
import { onLoad, onPullDownRefresh, onReachBottom } from "@dcloudio/uni-app";
import { fetchSpecialByTitle } from "@/api/special";
import type { SpecialItem } from "@/types/special";

const keyword = ref("");
const list = ref<SpecialItem[]>([]);
const pageNum = ref(1);
const pageSize = ref(10);
const total = ref(0);
const loading = ref(false);

const footText = computed(() => {
  if (loading.value && list.value.length) return "加载中…";
  if (!list.value.length || !total.value) return "";
  if (list.value.length >= total.value) return "— 没有更多了 —";
  return "上拉加载更多";
});

async function fetchPage(p: number, append: boolean) {
  if (loading.value) return;
  loading.value = true;
  try {
    const res = await fetchSpecialByTitle({
      title: keyword.value.trim() || "",
      pageNum: p,
      pageSize: pageSize.value,
    });
    if (append) {
      list.value = list.value.concat(res.list);
    } else {
      list.value = res.list;
    }
    total.value = res.total;
    pageNum.value = p;
  } catch (e) {
    console.error(e);
    uni.showToast({ title: "加载失败", icon: "none" });
    if (!append) {
      list.value = [];
      total.value = 0;
    }
  } finally {
    loading.value = false;
    uni.stopPullDownRefresh();
  }
}

function onSearch() {
  fetchPage(1, false);
}

onLoad(() => {
  fetchPage(1, false);
});

onPullDownRefresh(() => {
  fetchPage(1, false);
});

onReachBottom(() => {
  if (loading.value) return;
  if (list.value.length >= total.value) return;
  fetchPage(pageNum.value + 1, true);
});
</script>

<style scoped>
.page {
  min-height: 100vh;
  padding-bottom: 40rpx;
  background: #f6f6f6;
}
.toolbar {
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 24rpx;
  background: #fff;
  margin-bottom: 8rpx;
}
.input {
  flex: 1;
  height: 72rpx;
  padding: 0 24rpx;
  border: 1px solid #eee;
  border-radius: 8rpx;
  font-size: 28rpx;
  margin-right: 16rpx;
}
.btn-search {
  background: #0084ff;
  color: #fff;
}
.tip,
.foot {
  text-align: center;
  font-size: 24rpx;
  color: #8590a6;
  padding: 24rpx;
}
</style>
```

    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">onLoad</font>**`<font style="color:rgb(52, 73, 94);">：首次 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchPage(1, false)</font>**`<font style="color:rgb(52, 73, 94);">。 </font>
    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">onPullDownRefresh</font>**`<font style="color:rgb(52, 73, 94);">：第一页，替换列表，</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">stopPullDownRefresh</font>`<font style="color:rgb(52, 73, 94);">。 </font>
    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">onReachBottom</font>**`<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">pageNum+1</font>`<font style="color:rgb(52, 73, 94);">，</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">append</font>**`<font style="color:rgb(52, 73, 94);">，且 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">list.length < total</font>**`<font style="color:rgb(52, 73, 94);"> 时才请求。 </font>
    - <font style="color:rgb(52, 73, 94);">搜索框 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">confirm</font>**`**<font style="color:rgb(52, 73, 94);"> / 按钮</font>**<font style="color:rgb(52, 73, 94);">：关键词变后 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchPage(1, false)</font>**`<font style="color:rgb(52, 73, 94);">。</font>

新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/pages/special/detail.vue</font>**`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">，</font>**如下：

```vue
<template>
  <view class="page">
    <view v-if="loading" class="tip">加载中…</view>
    <template v-else-if="item">
      <image
        v-if="bannerSrc"
        class="banner"
        :src="bannerSrc"
        mode="aspectFill"
        @error="imgErr = true"
      />
      <view v-else class="banner banner-ph">
        <text class="ph">{{ item.title.slice(0, 2) }}</text>
      </view>
      <view class="content">
        <text class="title">{{ item.title }}</text>
        <text class="meta"
          >{{ item.updateLabel }} · {{ item.visitLabel }} ·
          {{ item.followersLabel }}</text
        >
        <text v-if="item.introduction" class="intro">{{
          item.introduction
        }}</text>
        <view class="fol" :class="{ on: item.isFollowing }">
          {{ item.isFollowing ? "已关注" : "关注专题" }}
        </view>
      </view>
    </template>
    <view v-else class="tip">暂无数据</view>
  </view>
</template>

<script setup lang="ts">
import { computed, ref, watch } from "vue";
import { onLoad } from "@dcloudio/uni-app";
import { fetchSpecialById } from "@/api/special";
import type { SpecialItem } from "@/types/special";

const id = ref("");
const item = ref<SpecialItem | null>(null);
const loading = ref(true);
const imgErr = ref(false);

const bannerSrc = computed(() => {
  if (!item.value?.cover || imgErr.value) return "";
  return String(item.value.cover);
});

watch(
  () => item.value?.cover,
  () => {
    imgErr.value = false;
  },
);

async function load() {
  if (!id.value) {
    item.value = null;
    loading.value = false;
    return;
  }
  loading.value = true;
  try {
    item.value = await fetchSpecialById(id.value);
    if (!item.value) {
      uni.showToast({ title: "未找到专题", icon: "none" });
    }
  } catch (e) {
    console.error(e);
    uni.showToast({ title: "加载失败", icon: "none" });
    item.value = null;
  } finally {
    loading.value = false;
  }
}

onLoad((q) => {
  id.value = q?.id ? decodeURIComponent(String(q.id)) : "";
  load();
});
</script>

<style scoped>
.page {
  min-height: 100vh;
  background: #f6f6f6;
}
.banner {
  width: 100%;
  height: 360rpx;
  background: #e8e8e8;
}
.banner-ph {
  display: flex;
  align-items: center;
  justify-content: center;
}
.ph {
  font-size: 48rpx;
  color: #8590a6;
}
.content {
  padding: 32rpx;
  background: #fff;
  margin-top: 16rpx;
}
.title {
  font-size: 40rpx;
  font-weight: 600;
  color: #1a1a1a;
}
.meta {
  display: block;
  margin-top: 16rpx;
  font-size: 26rpx;
  color: #8590a6;
}
.intro {
  display: block;
  margin-top: 24rpx;
  font-size: 28rpx;
  line-height: 1.6;
  color: #444;
}
.fol {
  display: inline-block;
  margin-top: 32rpx;
  padding: 12rpx 40rpx;
  font-size: 28rpx;
  border-radius: 999rpx;
  border: 1px solid #0084ff;
  color: #0084ff;
}
.fol.on {
  border-color: #ebebeb;
  color: #8590a6;
  background: #f6f6f6;
}
.tip {
  padding: 48rpx;
  text-align: center;
  color: #8590a6;
}
</style>
```

    - `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">onLoad((q) => { id = q.id; load() })</font>**`<font style="color:rgb(52, 73, 94);">。 </font>
    - <font style="color:rgb(52, 73, 94);">调用 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">fetchSpecialById</font>**`<font style="color:rgb(52, 73, 94);">，展示横幅、标题、元信息、简介。</font>

<font style="color:rgb(52, 73, 94);">页面跳转使用：</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">uni.navigateTo({ url: '/pages/special/detail?id=' + encodeURIComponent(id) })</font>**`<font style="color:rgb(52, 73, 94);">。</font>

## <font style="color:rgb(52, 73, 94);">列表组件</font>
新建`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">src/components/special-card/special-card.vue</font>**`<font style="color:rgb(52, 73, 94);">：</font>

```vue
<template>
  <view class="card" @click="go">
    <image
      v-if="showImg"
      class="cover"
      :src="String(item.cover)"
      mode="aspectFill"
      @error="imgErr = true"
    />
    <view v-else class="cover cover-ph">
      <text class="ph-text">{{ item.title.slice(0, 2) || "专" }}</text>
    </view>
    <view class="body">
      <text class="title">{{ item.title }}</text>
      <text v-if="item.introduction" class="intro">{{
        item.introduction
      }}</text>
      <text class="meta"
        >{{ item.updateLabel }} · {{ item.visitLabel }} ·
        {{ item.followersLabel }}</text
      >
      <view
        class="btn"
        :class="{ on: item.isFollowing }"
        @click.stop.prevent="noop"
      >
        {{ item.isFollowing ? "已关注" : "关注专题" }}
      </view>
    </view>
  </view>
</template>

<script setup lang="ts">
import { computed, ref, watch } from "vue";
import type { SpecialItem } from "@/types/special";

const props = defineProps<{ item: SpecialItem }>();

const imgErr = ref(false);
watch(
  () => [props.item.cover, props.item.id],
  () => {
    imgErr.value = false;
  },
);

const showImg = computed(() => Boolean(props.item.cover) && !imgErr.value);

function go() {
  const id = props.item.id;
  if (id === undefined || id === "") return;
  uni.navigateTo({
    url: `/pages/special/detail?id=${encodeURIComponent(String(id))}`,
  });
}

function noop() {
  /* 预留关注接口 */
}
</script>

<style scoped>
.card {
  display: flex;
  flex-direction: row;
  padding: 24rpx;
  margin: 0 24rpx 24rpx;
  background: #fff;
  border-radius: 12rpx;
  box-shadow: 0 2rpx 12rpx rgba(0, 0, 0, 0.06);
}
.cover {
  width: 200rpx;
  height: 160rpx;
  border-radius: 8rpx;
  background: #f0f0f0;
  flex-shrink: 0;
}
.cover-ph {
  display: flex;
  align-items: center;
  justify-content: center;
}
.ph-text {
  font-size: 36rpx;
  color: #8590a6;
}
.body {
  flex: 1;
  margin-left: 24rpx;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}
.title {
  font-size: 32rpx;
  font-weight: 600;
  color: #121212;
  margin-bottom: 12rpx;
}
.intro {
  font-size: 26rpx;
  color: #646464;
  margin-bottom: 12rpx;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  line-clamp: 2;
  -webkit-box-orient: vertical;
}
.meta {
  font-size: 24rpx;
  color: #8590a6;
  margin-bottom: 16rpx;
}
.btn {
  align-self: flex-start;
  padding: 8rpx 28rpx;
  font-size: 26rpx;
  border-radius: 999rpx;
  border: 1px solid #0084ff;
  color: #0084ff;
}
.btn.on {
  border-color: #ebebeb;
  color: #8590a6;
  background: #f6f6f6;
}
</style>

```

+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">props</font>**`<font style="color:rgb(52, 73, 94);">：</font>`<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">item: SpecialItem</font>`<font style="color:rgb(52, 73, 94);">。 </font>
+ <font style="color:rgb(52, 73, 94);">封面 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">image</font>**`<font style="color:rgb(52, 73, 94);">，失败时用占位 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">view</font>**`<font style="color:rgb(52, 73, 94);">。 </font>
+ `**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">@click</font>**`<font style="color:rgb(52, 73, 94);"> 整卡跳转详情；</font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">关注</font>**`<font style="color:rgb(52, 73, 94);"> 区域 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">@click.stop</font>**`<font style="color:rgb(52, 73, 94);"> 避免误触（预留接口）。</font>

> <font style="color:rgb(52, 73, 94);">当路径符合 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">components/组件名/组件名.vue</font>**`<font style="color:rgb(52, 73, 94);"> 时，</font>**<font style="color:rgb(52, 73, 94);">easycom</font>**<font style="color:rgb(52, 73, 94);"> 自动生成标签 </font>`**<font style="color:rgb(233, 105, 0);background-color:rgb(248, 248, 248);">special-card</font>**`<font style="color:rgb(52, 73, 94);">。</font>
>

## 运行效果
<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775747799457-96c77386-35b9-4d82-b590-1962a6a79c27.png" width="1512" title="" crop="0,0,1,1" id="u404616ca" class="ne-image">

<img src="https://cdn.nlark.com/yuque/0/2026/png/228333/1775747831374-a188f9e6-32c8-40e8-b376-c7e2e162008e.png" width="1512" title="" crop="0,0,1,1" id="udde36c06" class="ne-image">
