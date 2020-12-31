package com.ptit.tcp.objectstream;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {

    private String studentCode;
    private String studentName;

    public Student() {
    }

    public Student(String studentCode, String studentName) {
        this.studentCode = studentCode;
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(studentCode, student.studentCode) && Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, studentName);
    }
}
