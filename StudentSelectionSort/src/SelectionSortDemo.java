import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSortDemo {

    // Custom Selection Sort Method
    public static void selectionSort(ArrayList<Student> list,
                                     Comparator<Student> comparator) {

        int n = list.size();

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (comparator.compare(
                        list.get(j),
                        list.get(minIndex)) < 0) {

                    minIndex = j;
                }
            }

            Student temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static void printStudents(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(105, "Brendon", "Phoenix"));
        students.add(new Student(102, "Amanda", "Mesa"));
        students.add(new Student(110, "Sophia", "Tempe"));
        students.add(new Student(101, "Michael", "Scottsdale"));
        students.add(new Student(108, "Emma", "Gilbert"));
        students.add(new Student(103, "Noah", "Chandler"));
        students.add(new Student(109, "Olivia", "Peoria"));
        students.add(new Student(104, "Liam", "Surprise"));
        students.add(new Student(107, "Ava", "Goodyear"));
        students.add(new Student(106, "Ethan", "Glendale"));

        System.out.println("Original List:");
        printStudents(students);

        NameComparator nameComparator = new NameComparator();
        selectionSort(students, nameComparator);

        System.out.println("Sorted By Name:");
        printStudents(students);

        RollNoComparator rollComparator = new RollNoComparator();
        selectionSort(students, rollComparator);

        System.out.println("Sorted By Roll Number:");
        printStudents(students);
    }
}