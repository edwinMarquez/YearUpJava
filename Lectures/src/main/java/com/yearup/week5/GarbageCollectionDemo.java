package com.yearup.week5;
public class GarbageCollectionDemo {

    public static void createStudentObjects()
    {
        Student s4 = new Student("105","April","Grade 5",91);
        Student s5 = new Student("106","Mary","Grade 6",93);
        Student s6 = new Student("107","Sid","Grade 5",92);

        //All these three student objects are eligible for Grabage collection once the method completes

    }

    public static void main(String[] args) {
        Student s1 = new Student("101","Pete","Grade 5",90);
        Student s2 = new Student("102","Rick","Grade 6",95);
        Student s3 = new Student("103","Matt","Grade 5",94);

        s1 = null;//s1 becomes eligible for Garbage Collection
        s2 = s3; //s2 becomes eligible for Garbage Collection

        createStudentObjects();

        Runtime rt = Runtime.getRuntime();

        System.out.println("total memory of the heap :"+rt.totalMemory());
        System.out.println("free memory of the heap :"+rt.freeMemory());

        for (int i=0;i<10000;i++)
        {
            Student s4 = new Student("369","Michael Jackson","Grade 5",90);

        }
        System.out.println("total memory of the heap :"+rt.totalMemory());
        rt.gc();
        System.out.println("free memory of the heap :"+rt.freeMemory());

        //Student s5= new Student("105","Michael Jackson","Grade 18",100);


    }
}
