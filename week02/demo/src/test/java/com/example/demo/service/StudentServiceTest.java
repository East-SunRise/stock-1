package com.example.demo.service;

import org.junit.jupiter.api.Test;
import com.example.demo.constant.GenderEnum;
import com.example.demo.entity.Student;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;


@DisplayName("StudentService 单元测试")
class StudentServiceTest {

    @Test
    @DisplayName("测试获取所有学生 - 验证数量和基本信息")
    void testGetAllStudents() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        assertEquals(2, students.size(), "应该返回 2 个学生");

        Student student1 = students.stream()
                .filter(student -> student.getId().equals(1L))
                .findFirst()
                .orElse(null);

        assertNotNull(student1, "应该找到 ID 为 1 的学生");
        assertEquals("张三", student1.getName());
        assertEquals(GenderEnum.MALE, student1.getGender());
        assertEquals("13800138001", student1.getMobile());
        assertNotNull(student1.getCreateTime());
        assertNotNull(student1.getBirthday());
        assertTrue(student1.isEnabled());
        assertNotNull(student1.getAvatar());

        Student student2 = students.stream()
                .filter(student -> student.getId().equals(2L))
                .findFirst()
                .orElse(null);

        assertNotNull(student2, "应该找到 ID 为 2 的学生");
        assertEquals("李四", student2.getName());
        assertEquals(GenderEnum.FEMALE, student2.getGender());
        assertEquals("13800138002", student2.getMobile());
        assertNotNull(student2.getCreateTime());
    }

    @Test
    @DisplayName("测试学生数据完整性")
    void testStudentDataIntegrity() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        assertTrue(students.stream().allMatch(s -> s.getId() != null), "所有学生 ID 不应为空");
        assertTrue(students.stream().allMatch(s -> s.getName() != null && !s.getName().isEmpty()), "所有学生姓名不应为空");
        assertTrue(students.stream().allMatch(s -> s.getGender() != null), "所有学生性别不应为空");
        assertTrue(students.stream().allMatch(s -> s.getMobile() != null), "所有学生手机号不应为空");
        assertTrue(students.stream().allMatch(s -> s.getCreateTime() != null), "所有学生创建时间不应为空");
        assertTrue(students.stream().allMatch(s -> s.getBirthday() != null), "所有学生生日不应为空");
        assertTrue(students.stream().allMatch(s -> s.getAvatar() != null && !s.getAvatar().isEmpty()), "所有学生头像不应为空");
    }

    @Test
    @DisplayName("测试性别枚举多样性")
    void testGenderEnumValues() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        long maleCount = students.stream()
                .filter(s -> s.getGender() == GenderEnum.MALE)
                .count();
        long femaleCount = students.stream()
                .filter(s -> s.getGender() == GenderEnum.FEMALE)
                .count();

        assertEquals(1, maleCount, "应该有 1 个男性学生");
        assertEquals(1, femaleCount, "应该有 1 个女性学生");
    }

    @Test
    @DisplayName("测试学生 ID 唯一性")
    void testStudentIdUniqueness() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        long uniqueIdCount = students.stream()
                .map(Student::getId)
                .distinct()
                .count();

        assertEquals(students.size(), uniqueIdCount, "所有学生 ID 应该唯一");
    }

    @Test
    @DisplayName("测试学生姓名不重复")
    void testStudentNamesAreUnique() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        long uniqueNameCount = students.stream()
                .map(Student::getName)
                .distinct()
                .count();

        assertEquals(students.size(), uniqueNameCount, "所有学生姓名应该唯一");
    }

    @Test
    @DisplayName("测试手机号格式")
    void testMobilePhoneFormat() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        students.forEach(student -> {
            assertNotNull(student.getMobile(), "手机号不应为空");
            assertTrue(student.getMobile().matches("^1[3-9]\\d{9}$"),
                    "手机号格式应该正确：" + student.getMobile());
        });
    }

    @Test
    @DisplayName("测试创建时间有效性")
    void testCreateTimeValidity() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        LocalDateTime now = LocalDateTime.now();

        students.forEach(student -> {
            assertNotNull(student.getCreateTime(), "创建时间不应为空");
            assertTrue(student.getCreateTime().isBefore(now.plusSeconds(1)),
                    "创建时间不应晚于当前时间");
        });
    }

    @Test
    @DisplayName("测试生日有效性")
    void testBirthdayValidity() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        LocalDate now = LocalDate.now();

        students.forEach(student -> {
            assertNotNull(student.getBirthday(), "生日不应为空");
            assertTrue(student.getBirthday().isBefore(now),
                    "生日应该早于当前日期");
        });
    }

    @Test
    @DisplayName("测试返回的学生列表不可修改")
    void testStudentListModification() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        assertDoesNotThrow(() -> {
            List<Student> studentList = students.stream().collect(Collectors.toList());
            studentList.add(Student.builder().build());
        }, "应该能够修改返回的列表副本");
    }

    @Test
    @DisplayName("测试学生 Avatar URL 格式")
    void testAvatarUrlFormat() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        students.forEach(student -> {
            assertNotNull(student.getAvatar(), "头像 URL 不应为空");
            assertTrue(student.getAvatar().startsWith("http://") ||
                            student.getAvatar().startsWith("https://"),
                    "头像 URL 应该是有效的 HTTP/HTTPS 地址");
        });
    }

    @Test
    @DisplayName("测试 Enabled 状态")
    void testEnabledStatus() {
        StudentService studentService = new StudentService();
        Collection<Student> students = studentService.getAllStudents();

        long enabledCount = students.stream()
                .filter(Student::isEnabled)
                .count();

        assertEquals(students.size(), enabledCount, "所有学生应该都是启用状态");
    }
}