package Module33;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {
    private static Course [] courses;

    public static void main(String[] args) {
        createAllObjects();
    }

    private static void createAllObjects() {
        createCourses();
        createStudets();
        createCollageStudent();
        createSpecialStudents();

    }

    private static void createSpecialStudents() {
        SpecialStudent s = new SpecialStudent(100);
        SpecialStudent specialStudentHarry = new SpecialStudent("Harry", "Kaine", 321);
        SpecialStudent specialStudentCole = new SpecialStudent("Cole", selectCourses(3, 4), "Columbia Unv.", 245,124433);
    }

    private static void createCollageStudent() {
        CollegeStudent collegeStudentGear = new CollegeStudent("Gear", selectCourses(1, 1));
        CollegeStudent collegeStudentSteave = new CollegeStudent("Steve", "Butler", 116);
        CollegeStudent collegeStudentNash = new CollegeStudent("Nash", selectCourses(0,4), "MIT", 223, 12982);
    }

    private static void createStudets() {
        Student studentAndrew = new Student("Andrew", "Howard", 291);
        Student studentBobby = new Student("Bobby", selectCourses(0,2));
    }

    private static Course [] createCourses() {
        Calendar dateStart = new GregorianCalendar();
        dateStart.set(2016, Calendar.FEBRUARY, 02, 8, 00, 00);
        Course javaCourse = new Course(dateStart.getTime(), "Java Core Course");
        Course sqlCourse = new Course(dateStart.getTime(), "SQL Course");
        dateStart.set(2017, Calendar.JANUARY, 15, 14, 30, 00);
        Course javaScriptCourse = new Course("JavaScript", 55, "Mike Posner");
        Course uxCourse = new Course(dateStart.getTime(), "Frond-end-Developer Course");
        Course unixСourse = new Course("Nuclear by UNIX System", 120, "Elisha Cutberd");
        courses = new Course[]{javaCourse, javaScriptCourse, sqlCourse, unixСourse, uxCourse};
        return courses;
    }

    private static Course [] selectCourses(int idFirstCourse, int idLastCourse){
        if (courses == null) {
            createCourses();
        } else {
            int i = 0;
            Course [] selectedCourses = new Course[idLastCourse - idFirstCourse + 1];
            while (idFirstCourse <= idLastCourse) {
                selectedCourses[i] = courses[idFirstCourse];
                i++;
                idFirstCourse++;
            }
            return  selectedCourses;
        }
        throw new NullPointerException();
    }
}
