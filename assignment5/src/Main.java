import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students;

    public static void main(String[] args) {
        students = new ArrayList<Student>();
//      Here we declare the file
        File gradesFile = new File("BSCH.csv");

        String fileName;

//      Here we ask the user to input in the file name
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        File file = new File(str + ".csv");

//      If file doesn't exist we ask the user to enter the correct name
        while (!file.exists()) {
            System.out.println("Enter the correct file name");

            str = sc.nextLine();
            file = new File(str + ".csv");
        }


//      We read our correct file and print the contents out
        try {
            Scanner scan = new Scanner(gradesFile);
//           We add the code below to skip the headers row as we don't need it
            if (scan.hasNextLine())
                scan.nextLine();
//          This loop keeps running till all the students are added to the object and printed out
            while (scan.hasNextLine()) {
//              Below we split each cell by the delimiter which is the comma and put it as individual indices inside the info array
                String[] info = scan.nextLine().split(",");
//              We create a subject marks array and we start storing the values of the info array, but we jump by 2 columns to start at the grades which is what we need
                int[] subMarks = new int[4];
                for (int i = 0; i < 4; i++) {
                    subMarks[i] = Integer.parseInt(info[i + 2]);
                }
//              Here the student name and ID are added to the student object, we pass the values in
                Student student = new Student(info[0], Integer.parseInt(info[1]), subMarks);
                students.add(student);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//    Here we print out the marks in a table format
        for (Student child : students) {
            String printedMarks = "";
            for (int subMark : child.getMarks()) {

                printedMarks += Integer.toString(subMark) + "\t";
            }
            System.out.println(child.getName() + "\t" + child.getId() + "\t" + printedMarks);
        }
        System.out.println();

// Here we print out the menu along with the options
        System.out.println("Select one of the options below by entering the option number:");
        boolean input = true;
        while (input) {
            System.out.println("1. Enter new marks." + "\n" + "2. Add new student" + "\n" + "3. Remove student" + "\n" + "4. Save changes" + "\n" + "5. Exit");
            System.out.println();

// Here we collect user input to get the option the user selects from the menu
            int menuNo = sc.nextInt();

// Here we state what should happen if user chooses an option
            if (menuNo == 1) {
                System.out.println("Please enter the student ID");
                int studID = sc.nextInt();

                boolean wrongID = true;
                sc.nextLine();
                for (Student student : students) {
                    if (student.getId() == studID) {
                        wrongID = false;
                        addMarks(student);
                    }
                }
                if (wrongID) {
                    System.out.println("Student ID not found");
                    System.out.println();
                }
                printTable();
            } else if (menuNo == 2) {

                System.out.println("Please enter the new student's name ");
                String newStudName = sc.nextLine();
                boolean valid = false;
                while (!valid) {
                    System.out.println("Please enter the new student's ID ");
                    int newStudID = Integer.parseInt(sc.nextLine());
                    valid = true;
                    for (Student student : students) {
                        if (student.getId() == newStudID) {
                            System.out.println("This student already exists");
                            valid = false;
                        }
                    }
                    if (valid) {
                        Student student = new Student(newStudName, newStudID);
                        students.add(student);


                System.out.println("Type yes below if you would like to add the marks for this student and type no if you wouldn't");
                String answer = sc.nextLine();

                if (answer.equals("yes")) {
                    addMarks(student);
                }
                    }
                }
                printTable();
            } else if (menuNo == 3) {
                System.out.println("Please enter the student's ID");
                int delStudID = sc.nextInt();
                int index = -1;
                for (int i =0; i < students.size();i++) {
                    if (students.get(i).getId() == delStudID) {
                        index = i;
                    }
                }
                if(index == -1)
                {
                    System.out.println("The student ID entered is invalid");
                }else {
                    students.remove(index);
                    System.out.println("The student has been removed");
                    System.out.println();
                }
                printTable();
            } else if (menuNo == 4) {
                try{
                    PrintWriter writer = new PrintWriter("BSCH.csv");
                    writer.write("Student Name,Student ID,CP,SAD,OSD,ELD,Average");
                    for(Student student : students){
                        ArrayList<Integer> marks = student.getMarks();
                        writer.printf("%s,%d,%d,%d,%d,%d,%d",student.getName(),student.getId(),marks.get(0),marks.get(1),marks.get(2),marks.get(3),student.getAverage());
                    }
                    writer.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                input = false;
            }
        }

    }

    public static void addMarks(Student student) {
        Scanner sc = new Scanner(System.in);
        String[] subjects = {"CP", "SAD", "OSD", "ELD"};

        int count = 0;
        for (Integer mark : student.getMarks()) {
            boolean validMark = true;

            while (validMark) {
                System.out.println("Enter a number to change " + subjects[count] + ":" + mark);
                String in = sc.nextLine();
                if (in.length() > 0) {
                    int newMark = Integer.parseInt(in);
                    if (newMark > 100) {
                        System.out.println("Please enter a valid mark");
                    }
                    if (newMark < 0) {
                        System.out.println("Please enter a valid mark");
                    } else {
                        mark = newMark;
                        student.setMarks(count, newMark);
                        System.out.println("The mark for the subject " + subjects[count] + " is now " + mark);
                        validMark = false;
                    }
                } else {
                    validMark = false;
                }

            }
            count++;

        }
//                      Below we calculate the average after all the marks have been entered
            int totalMarks = 0;
            int noOfSubjects = 0;
            for (Integer mark : student.getMarks()) {
                totalMarks += mark;
                noOfSubjects++;
            }

            int average = totalMarks / noOfSubjects;
            System.out.println("Average for this student is " + average);
            System.out.println();
        }

    public static void printTable() {
        for (Student child : students) {
            String printedMarks = "";
            for (int subMark : child.getMarks()) {

                printedMarks += Integer.toString(subMark) + "\t";
            }
            System.out.println(child.getName() + "\t" + child.getId() + "\t" + printedMarks);
        }
        System.out.println();
    }

    }

