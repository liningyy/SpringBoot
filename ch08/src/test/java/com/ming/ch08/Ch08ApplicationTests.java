package com.ming.ch08;

import com.ming.ch08.mapping.User;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Slf4j
class Ch08ApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate template;

    /**
     * 创建索引
     */
    @Test
    void testCreateIndex() {
        if (!template.indexOps(User.class).exists()) {
            template.indexOps(User.class).create();
        } else {
            log.info("索引已存在！");
        }
    }

    /**
     * 删除索引 ture表示删除成功 false表示文件不存在
     */
    @Test
    void testDeleteIndex() {
        if (template.indexOps(User.class).delete()) {
            log.info("删除成功!");
        } else {
            log.info("文件已不存在");
        }
    }

    /**
     * 测试添加文档
     */
    @Test
    void testAddDocument() {
        User user1 = new User(1001, "李四", 19, "珠海");
        User user2 = new User(1002, "张三", 18, "深圳");
        User user3 = new User(1003, "王五", 20, "广州");
        User user4 = new User(1004, "赵六", 21, "中三");
        User user5 = new User(1005, "田七", 22, "深海");
        List<User> list = new ArrayList();
        Collections.addAll(list, user1, user2, user3, user4, user5);
        template.save(list);

    }

    /**
     * 修改文档记录
     */
    @Test
    void testUpdateDocument() {
        Document doc = Document.create();
        doc.setIndex("user");
        doc.setId("1001");
        doc.put("name", "张三");
        doc.put("age", 18);
        UpdateQuery updateQuery = UpdateQuery.builder(doc.getId()).withDocument(doc).build();
        template.update(updateQuery, IndexCoordinates.of(doc.getIndex()));
    }

    /**
     * 根据编号查询文档记录
     * 查询如果没有记录，会返回 null
     */
    @Test
    void testQueryDocumentById() {
        User user = template.get("1001", User.class);
        log.info("user：" + user);
    }

    /**
     * 查询所有的所有记录
     */
    @Test
    void testQueryDocument() {
        NativeSearchQuery query = new NativeSearchQueryBuilder().build();
        SearchHits<User> hits = template.search(query, User.class);
        hits.stream().forEach(h -> {
            log.info(h.getContent().toString());
        });
    }

    /**
     * 根据某个字段分词查询数据
     */
    @Test
    void testTerm() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.termQuery("birthplace", "深"));
        SearchHits<User> hits = template.search(builder.build(), User.class);
        hits.stream().forEach(s -> log.info(s.getContent().toString()));
    }

    /**
     * 根据文档编号删除文档信息
     */
    @Test
    void testDeleteDocumentById() {
        String delete = template.delete("1001", User.class);
        log.info("删除返回后的值：" + delete);
    }

    /**
     * 根据分页查询文档信息
     */
    @Test
    void testPageInfoDocument() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withPageable(PageRequest.of(0, 2));
        SearchHits<User> hits = template.search(builder.build(), User.class);
        /*Iterator<SearchHit<User>> iterator = hits.stream().iterator();
        while (iterator.hasNext()){
            SearchHit<User> hit = iterator.next();
            log.info(hit.getContent().toString());
        }*/
        hits.stream().forEach(hit -> {
            log.info(hit.getContent().toString());
        });
    }

    /**
     * 通过某个字段来进行排序（降序或升序）
     */
    @Test
    void testSort() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        FieldSortBuilder sortBuilder = SortBuilders.fieldSort("age").order(SortOrder.ASC);
        builder.withSorts(sortBuilder);
        SearchHits<User> hits = template.search(builder.build(), User.class);
        hits.stream().forEach(hit -> log.info(hit.getContent().toString()));
    }

    /**
     * 根据 term 分词查询
     */
    @Test
    void testTrem2() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("birthplace", "海");
        SearchHits<User> hits = template.search(builder.withQuery(queryBuilder).build(), User.class);
        hits.stream().forEach(hit -> log.info(hit.getContent().toString()));
    }

    /**
     * 根据 match 分词查询
     */
    @Test
    void testMatch() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("birthplace", "深海");
        SearchHits<User> hits = template.search(builder.withQuery(queryBuilder).build(), User.class);
        hits.stream().forEach(hit -> log.info("用户消息：" + hit.getContent()));
    }

}
