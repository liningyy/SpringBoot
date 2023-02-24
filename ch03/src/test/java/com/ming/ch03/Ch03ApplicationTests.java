package com.ming.ch03;

import com.ming.ch03.dto.Student;
import com.ming.ch03.dto.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
@Slf4j
class Ch03ApplicationTests {

    @Autowired
    private Student student;

    @Test
    void testBinding() {
//        log.info(student.getUserId().toString());
//        log.info(student.getUserName());
//        log.info(student.getAge().toString());
//        log.info(Arrays.toString(student.getTels()));
//        log.info(student.getList().toString());
//        for (String s : student.getScore().keySet()) {
//            log.info(s + ":\t" + student.getScore().get(s));
//        }
//        student.getTeachers().stream().forEach(t -> log.info(t.toString()));
//        Map<String, Teacher> map = student.getTeacherMap();
//        map.keySet().forEach(s -> log.info(s + ":\t" + map.get(s).toString()));
    }

    @Test
    void testEnv() {
        log.info(student.getUserId().toString());
        log.info(student.getUserName());
        log.info(student.getAge().toString());
    }

    @Test
    void testStudent() {
        log.info(student.getUserId().toString());
        log.info(student.getUserName());
        log.info(student.getAge().toString());
        log.info(Arrays.toString(student.getTels()));
        for (Teacher teacher : student.getTeachers()) {
            log.info(teacher.toString());
        }
        for (String list : student.getLists()) {
            log.info(list);
        }
        for (String key : student.getMaps().keySet()) {
            log.info(key + ":\t" + student.getMaps().get(key));
        }
        for (String key : student.getMap().keySet()) {
            log.info(key + ":\t" + student.getMap().get(key).toString());
        }
        List objects = new LinkedList<>();
    }

}
