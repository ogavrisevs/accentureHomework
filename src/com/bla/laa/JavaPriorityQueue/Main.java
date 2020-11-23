package com.bla.laa.JavaPriorityQueue;
import java.util.*;


class StudentComparator implements Comparator<Student> {


    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() > s2.getCgpa()) {
            return -1;
        } else if (s1.getCgpa() == s2.getCgpa()){
            if (s1.getName().compareTo(s2.getName()) > 0)
                return -1;

        } else if ((s1.getCgpa() == s2.getCgpa()) && (s1.getName().equals(s2.getName()))) {
            if (s1.getID() < s2.getID()){
                return -1;
            }
        } return +1;

    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        Integer queueSize =0 ;
        for (String str : events) {
            if (str.contains("ENTER"))
                queueSize++;
        }
        PriorityQueue<Student> students = new PriorityQueue<Student>(queueSize, new StudentComparator());

        for (String str : events){
            if (str.contains("ENTER")) {
                str = str.replace("ENTER", "").trim();
                String[] arry = str.split(" ");
                String name = arry[0];
                Double cgpa = Double.valueOf(arry[1]);
                Integer id = Integer.valueOf(arry[2]);
                Student s1 = new Student(id, name, cgpa);
                students.add(s1);
                //System.out.println("add : "+ s1.toString());
            }
            if (str.contains("SERVED")) {
                Student s = students.poll();
                //System.out.println("remove : "+ s.toString());
            }
        }

        return new ArrayList(students);
    }
}

class Student {

    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }
    public Integer getID(){
        return id;
    }
    public Double getCgpa(){
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}


public class Main {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        List<String> events = new ArrayList<>();
        int totalEvents = Integer.parseInt(scan.nextLine());

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }

    }
}
