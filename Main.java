import java.util.*;

class student {
    String id;
    String name;
    List<Number> gradez;
    String pass = "unknown";
    boolean honor;
    String letterGrade;

    public student(String i, String n) {
        id = i;
        name = n;
        gradez = new ArrayList<Number>();
    }

    public void AddG(Number g) {
        if (g == null) {
            System.out.println("Error: grade cannot be empty.");
            return;
        }
        double grade = g.doubleValue();

        if (grade < 0 || grade > 100) {
            System.out.println("Error: grade must be between 0 and 100.");
            return;
        }
        gradez.add(g);
        System.out.println("Grade added successfully.");
    }

    public Number average() {
        if (gradez.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (Number g : gradez) {
            total += g.doubleValue();
        }

        return total / gradez.size();
    }

    public void checkHonorStatus() {
        if (average().doubleValue() >= 90) {
            honor = true; // Type mismatch (boolean vs String), kept broken
        }
    }

    public void removeGradeByIndex(int i) {
        try {
            gradez.remove(i);
            System.out.println("Grade removed successfully.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: index out of bounds.");
        }
    }

    public void removeGradeByValue(double value) {
        boolean removed = false;

        for (int i = 0; i < gradez.size(); i++) {
            if (gradez.get(i).doubleValue() == value) {
                gradez.remove(i);
                removed = true;
                System.out.println("Grade removed successfully.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Error: grade does not exist.");
        }
    }
    

    public void isPass(){
        if (average().doubleValue() < 60.0) {
            this.pass= "Failed";
        } else {
            this.pass= "Passed";
        }
    }

    public void setLetterGrade(){
        double avg = average().doubleValue();
        if (avg >= 90) {
            letterGrade= "A";
        } else if (avg >= 80) {
            letterGrade= "B";
        } else if (avg >= 70) {
            letterGrade= "C";
        } else if (avg >= 60) {
            letterGrade= "D";
        } else {
            letterGrade= "F";
        }
    }

    public void reportCard() {
        System.out.println("Student: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grades #: " + gradez.size());
        System.out.println("Average: " + average()); 
        System.out.println("Letter Grade: " + letterGrade);
        System.out.println("Honor Roll: " + honor);
        System.out.println("Pass: " + pass); 
    }
}

public class Main {
    public static void main(String[] args) {
        student s = new student("abc", null);
        s.AddG(100);
        s.average();
        s.checkHonorStatus();
        s.isPass();
        s.setLetterGrade();
        s.removeGradeByIndex(9);
        s.reportCard();
    }
}
