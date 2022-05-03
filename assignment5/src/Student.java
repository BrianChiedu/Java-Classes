import java.util.ArrayList;

public class Student {

    String name;
    int id;
    ArrayList<Integer> marks;

    public Student(String name, int id,int[] grades) {
        this.name = name;
        this.id = id;
        marks = new ArrayList<Integer>();
//      For each value in the grades array we add it to the arraylist
        for(int grade: grades)
        {
            marks.add(grade);
        }
    }
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        marks = new ArrayList<Integer>();
        for(int i =0; i < 4;i++)
        {
            marks.add(0);
        }
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public ArrayList<Integer> getMarks()
    {
        return marks;
    }

    public void addmarks(int marks){

    }

    public void setMarks(int index,int mark)
    {
        marks.set(index,mark);

    }

    public int getAverage()
    {
        int totalMarks = 0;
        int noOfSubjects = 0;
        for (Integer mark : getMarks()) {
            totalMarks += mark;
            noOfSubjects++;
        }

        int average = totalMarks / noOfSubjects;
       return average;

    }
}
