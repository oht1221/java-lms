package nextstep.courses.domain;

import nextstep.users.domain.NsUser;

public class SessionStudents {
    private final Students students;
    private int maxStudentCount;

    public SessionStudents(Students students, int maxStudentCount) {
        this.students = students;
        this.maxStudentCount = maxStudentCount;
    }

    public SessionStudents(int maxStudentCount) {
        this.students = new Students();
        this.maxStudentCount = maxStudentCount;
    }

    public SessionStudents(Students students) {
        this.students = students;
    }

    public void add(NsUser student) {
        this.students.add(student);
    }

    public void approve(Student student) {
        this.students.approve(student);
    }

    public void refuse(Student student) {
        this.students.refuse(student);
    }

    public boolean isMaxStudents() {
        return this.students.approvalStudentsCount() == this.maxStudentCount;
    }

    public int maxStudentsCount() {
        return this.maxStudentCount;
    }

    public int applyStudentsCount() {
        return this.students.applyStudentsCount();
    }
}