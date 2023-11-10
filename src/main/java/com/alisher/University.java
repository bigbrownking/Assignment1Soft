package com.alisher;

import com.alisher.entity.canteen.*;
import com.alisher.entity.data.*;
import com.alisher.entity.library.*;
import com.alisher.entity.people.*;
import com.alisher.entity.people.Observer;
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


        student1.putGrade(Math.getMath(),0);
        student1.putGrade(History.getHistory(), 0);

        student2.putGrade(Programming.getProgramming(), 0);
        student2.putGrade(Math.getMath(), 0);

        student3.putGrade(Programming.getProgramming(), 0);
        student3.putGrade(Math.getMath(), 0);
        student3.putGrade(History.getHistory(), 0);

        student3.putGrade(Programming.getProgramming(),0);
        student3.putGrade(History.getHistory(),0);

        student4.putGrade(Math.getMath(),0);
        student4.putGrade(History.getHistory(), 0);

        student5.putGrade(Math.getMath(),0);

        student6.putGrade(History.getHistory(),0);

        student7.putGrade(Programming.getProgramming(),0);

        student8.putGrade(Math.getMath(),0);
        student8.putGrade(Programming.getProgramming(),0);
        student8.putGrade(History.getHistory(),0);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);

        Teacher teacher = new Teacher(globalId++, "Sayat", "Kalnazar", Programming.getProgramming(), false);
        teacher.setManager(new NotificationManager());
        teachers.add(teacher);

        Teacher teacher1 = new Teacher(globalId++, "Kairat","Batalov",History.getHistory(), false);
        teacher1.setManager(new NotificationManager());
        teachers.add(teacher1);

        Teacher teacher2 = new Teacher(globalId++,"Zhanat","Karashbayeva",Math.getMath(),false);
        teacher2.setManager(new NotificationManager());
        teachers.add(teacher2);

        subjects.add(Math.getMath());
        subjects.add(History.getHistory());
        subjects.add(Programming.getProgramming());

        Book book1 = new Book(bookId++, "Intro To Prog", "Robert Martin","22/09/98", 4);
        Book book2 = new Book(bookId++, "History", "Batalov Kairat","28/04/17",5);

        books.add(book1);
        books.add(book2);

        addObservers(History.getHistory());
        addObservers(Math.getMath());
        addObservers(Programming.getProgramming());
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

    public void showStudents() {
        students.forEach(System.out::println);
    }

    public void showTeachers() {
        teachers.forEach(System.out::println);
    }
    public void showBooks(){
        books.stream().filter(x -> x.getCount() > 0).forEach(System.out::println);
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter group");
        String group = scanner.next();
        Student student = new Student(globalId++, name, surname, group, false);
        System.out.println("Enter subjects(Math, Programming, History)");
        scanner.nextLine();
        String[] ans = scanner.nextLine().split(" ");
        Arrays.stream(ans)
                .forEach(sub -> {
                    if(sub.equalsIgnoreCase("Math")) student.putGrade(Math.getMath(), 0);
                    else if(sub.equalsIgnoreCase("Programming")) student.putGrade(Programming.getProgramming(),0);
                    else student.putGrade(History.getHistory(),0);
                });

        students.add(student);
        addObservers(History.getHistory());
        addObservers(Math.getMath());
        addObservers(Programming.getProgramming());
        System.out.println("Added");
    }

    public void putGradeToStudent(Scanner scanner) {
        Teacher teacher = findTeacher(scanner);
        if(teacher != null){
            Set<Observer> observers = teacher.getManager().getObservers();
            System.out.println("Choose student id");
            observers.forEach(System.out::println);
            int studId = scanner.nextInt();
            Student student = observers.stream()
                    .map(x -> (Student)x)
                    .filter(x -> x.getId() == studId)
                    .findFirst()
                    .orElse(null);
            if(student != null){
                System.out.println("Enter grade");
                int grade = scanner.nextInt();
                student.putGrade(teacher.getSubject(), grade);
                System.out.println("Added");
            } else System.out.println("We don't have this student");

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
        showStudents();
        int studId = scanner.nextInt();
        Optional<Student> studentOptional = university.getStudents().stream()
                .filter(x -> x.getId() == studId)
                .findFirst();
        return studentOptional.orElse(null);
    }
    public void goToLibrary(Scanner scanner, boolean accessibility){
        Person person;
        if(accessibility) person = findTeacher(scanner);
        else person = findStudent(scanner);
        LocalLibrary library = new LocalLibrary(new ExternalLibrary());
        if (person != null) {
        System.out.println("Welcome to library!");
        System.out.println("We have:");
        showBooks();
        Book book = findBook(scanner);
            if(book != null) library.borrowBook(person.getId(),book);
            else {
                System.out.println("We don't have this book, but another library have.");
                System.out.println("Enter the name of book");
                scanner.nextLine();
                String bookName = scanner.nextLine();
                Book deliveredBook = new Book();
                deliveredBook.setBookName(bookName);
                library.deliverBook(person.getId(), deliveredBook);
                System.out.println("Be care for this book");
            }
        } else System.out.println("We don't have this person");
    }
    public Book findBook(Scanner scanner){
        System.out.println("Which one?");
        int bookId = scanner.nextInt();
        Optional<Book> bookOptional = books.stream()
                .filter(x -> x.getBookId() == bookId)
                .findFirst();
        return bookOptional.orElse(null);
    }
    public void goToCanteen(Scanner scanner, boolean accessibility){
        Person person;
        if(accessibility) person = findTeacher(scanner);
        else person = findStudent(scanner);
        if(person != null) {
            System.out.println("Welcome to the canteen!");
            System.out.println("Please choose your meal:");
            System.out.println("1. First Meal");
            System.out.println("2. Second Meal");
            System.out.println("3. Set Meal");
            int choice = scanner.nextInt();
            Canteen canteen = FactoryChoice.getCanteen(choice);
            assert canteen != null;
            canteen.showMenu();
            System.out.println("Enter a description for your meal:");
            scanner.nextLine();
            String description = scanner.nextLine();
            Dish studDish = canteen.makeOrder(description);
            System.out.println(person.getName() + " have ordered " + studDish.description() + "for " + studDish.price() + " tenge");
        } else System.out.println("We don't have this person");
    }
    public void messageFromTeacher(Scanner scanner){
        Teacher teacher = findTeacher(scanner);
        if(teacher != null) teacher.sendMessage(scanner);
         else System.out.println("We don't have this teacher");
    }
    public Teacher findTeacher(Scanner scanner) {
        System.out.println("Which teacher? (id)");
        teachers.stream()
                .map(teacher -> "{id="+teacher.getId() + "} " + "{name="+teacher.getName() + "} " + "{surname="+teacher.getSurname()+"}")
                .forEach(System.out::println);
        int teachId = scanner.nextInt();
        Optional<Teacher> teacherOptional = university.getTeachers().stream()
                .filter(x -> x.getId() == teachId)
                .findFirst();
        return teacherOptional.orElse(null);
    }
    public void addObservers(Subject subject){
        teachers.stream()
                .filter(x -> x.getSubject() == subject)
                .forEach(teach -> {
                    for (Student student : students.stream()
                            .filter(x -> x.getGrades().containsKey(subject))
                            .toList()) {
                        teach.addObserver(student);
                    }
                });
    }
}
