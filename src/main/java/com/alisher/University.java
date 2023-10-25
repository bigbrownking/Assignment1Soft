package com.alisher;

import com.alisher.entity.canteen.Canteen;
import com.alisher.entity.canteen.Dish;
import com.alisher.entity.data.*;
import com.alisher.entity.library.*;
import com.alisher.entity.people.Observed;
import com.alisher.entity.people.Student;
import com.alisher.entity.people.Teacher;
import com.alisher.entity.subjects.Math;
import com.alisher.entity.subjects.History;
import com.alisher.entity.subjects.Programming;
import com.alisher.entity.subjects.Subject;

import java.util.*;

public class University {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    private int globalId = 1;
    private int bookId = 1;
    private static University university;

    private University() {
        Student student1 = new Student(globalId++, "Alisher", "Khairullin", "SE-2207", true);
        Student student2 = new Student(globalId++, "Shakhnur", "Aubakirov", "CS-2208", true);
        Student student3 = new Student(globalId++, "Rayimbek", "Bokhorov", "SE-2209", false);
        Student student4 = new Student(globalId++, "Abay", "Dyussembayev","SE-2210", false);
        Student student5 = new Student(globalId++, "Amirzhan", "Mukhidinov","SE-2211", false);
        Student student6 = new Student(globalId++, "Alinur", "Shayakhmet","CS-2210", false);
        Student student7 = new Student(globalId++, "Adlet", "Zhaksylyk","CS-2209", false);
        Student student8 = new Student(globalId++, "Ilya", "Shelestov","SE-2212", false);


        student1.putGrade(Math.getMath(), 100);
        student1.putGrade(History.getHistory(), 89);

        student2.putGrade(Programming.getProgramming(), 90);
        student2.putGrade(Math.getMath(), 100);

        student3.putGrade(Programming.getProgramming(), 60);
        student3.putGrade(Math.getMath(), 78);
        student3.putGrade(History.getHistory(), 70);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);

        Teacher teacher1 = new Teacher(globalId++, "Sayat", "Kalnazar", Programming.getProgramming());

        teachers.add(teacher1);

        subjects.add(Math.getMath());
        subjects.add(History.getHistory());
        subjects.add(Programming.getProgramming());

        Book book1 = new Book(bookId++, "Intro To Prog", "Robert Martin","22/09/98", 4);
        Book book2 = new Book(bookId++, "History", "Batalov Kairat","28/04/17",5);

        books.add(book1);
        books.add(book2);

    }

    public static University getUniversity() {
        if (university == null) university = new University();
        return university;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void showStudents() {
        students.stream().forEach(System.out::println);
    }

    public void showTeachers() {
        teachers.stream().forEach(System.out::println);
    }

    public void showSubjects() {
        subjects.stream().forEach(System.out::println);
    }
    public void showBooks(){
        books.stream().forEach(System.out::println);
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter group");
        String group = scanner.next();
        Student student = new Student(globalId++, name, surname, group, false);
        students.add(student);
        System.out.println("Added");
    }

    public void addSubjectToStudent(Scanner scanner) {
        System.out.println("We have 3 subjects: Math, History, Programming");
        String ans = scanner.next();
        Subject subject;
        if (ans.equalsIgnoreCase("Math")) subject = Math.getMath();
        else if (ans.equalsIgnoreCase("History")) subject = History.getHistory();
        else if (ans.equalsIgnoreCase("Programming")) subject = Programming.getProgramming();
        else {
            System.out.println("Invalid input");
            return;
        }
        Student stud = findStudent(scanner);
        if (stud != null) {
            Random rd = new Random();
            stud.putGrade(subject, rd.nextInt(1, 100));
            System.out.println("Added");
        } else System.out.println("We don't have this student");
    }

    public void additionalInfoAboutStudent(Scanner sc) {
        Student stud = findStudent(sc);
        if (stud != null) {
            Data data;
            boolean SE = false;
            boolean scholarship = false;
            if (stud.getGroup().contains("SE")) SE = true;
            if (stud.getGPA() >= 3.0) scholarship = true;

            if (SE && scholarship) data = new SEstudent(new ScholarshipStudent(new StudentData()));
            else if (!SE && scholarship) data = new CSstudent(new ScholarshipStudent(new StudentData()));
            else if (SE && !scholarship) data = new SEstudent(new WithoutScholarshipStudent(new StudentData()));
            else data = new CSstudent(new WithoutScholarshipStudent(new StudentData()));

            System.out.println(data.showData());
        } else System.out.println("We don't have this student");
    }

    public Student findStudent(Scanner scanner) {
        System.out.println("Which student? (id)");
        int studId = scanner.nextInt();
        Optional<Student> studentOptional = university.getStudents().stream()
                .filter(x -> x.getId() == studId)
                .findFirst();
        if (studentOptional.isPresent()) return studentOptional.get();
        return null;
    }
    public void goToLibrary(Scanner scanner){
        LocalLibrary library = new LocalLibrary(new ExternalLibrary());
        Student stud = findStudent(scanner);
        if (stud != null) {
        System.out.println("Welcome to library!");
        System.out.println("We have:");
        showBooks();
        Book book = findBook(scanner);
            if(book != null) library.borrowBook(stud.getId(),book);
            else {
                System.out.println("We don't have this book, but another library have.");
                System.out.println("Enter the name of book");
                scanner.nextLine();
                String bookName = scanner.nextLine();
                Book deliveredBook = new Book();
                deliveredBook.setBookName(bookName);
                library.deliverBook(stud.getId(), deliveredBook);
                System.out.println("Be care for this book");
            }
        } else System.out.println("We don't have this student");
    }
    public Book findBook(Scanner scanner){
        System.out.println("Which one?");
        int bookId = scanner.nextInt();
        Optional<Book> bookOptional = books.stream()
                .filter(x -> x.getBookId() == bookId)
                .findFirst();
        if(bookOptional.isPresent()) return bookOptional.get();
        return null;
    }
    public void goToCanteen(Scanner scanner){
        Student stud = findStudent(scanner);
        Canteen canteen = new Canteen();
        if (stud != null) {
            System.out.println("Welcome to canteen");
            canteen.showMenu();
            System.out.println("Choose dishType");
            scanner.nextLine();
            String dishType = scanner.nextLine();
            System.out.println("Enter your dish");
            String description = scanner.nextLine();
            Dish dish = canteen.makeOrder(dishType, description);
            if (dish != null) System.out.println(stud.getName() + " has ordered " + dish.getDescription() + " for " + dish.price() + " tenge.");
            else System.out.println("Invalid dish selection.");
        } else System.out.println("We don't have this student");
    }
    public void messageFromTeacher(Scanner scanner){
        Teacher teacher = findTeacher(scanner);
        if(teacher != null){
            for(Student observer : getStudents()){
                teacher.addObserver(observer);
            }
            teacher.sendMessage(scanner);
        } else System.out.println("We don't have this teacher");
    }
    public Teacher findTeacher(Scanner scanner) {
        System.out.println("Which teacher? (id)");
        int teachId = scanner.nextInt();
        Optional<Teacher> teacherOptional = university.getTeachers().stream()
                .filter(x -> x.getId() == teachId)
                .findFirst();
        if (teacherOptional.isPresent()) return teacherOptional.get();
        return null;
    }
}
