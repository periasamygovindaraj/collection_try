package com.framework.collection;
import java.util.*;

public class CodeCollection {

	public static Collection foundPassed(Collection<Student> students)
	{
		Collection<Student> passed_student =new ArrayList<>();
		passed_student.addAll(students);
		Iterator<Student> it=passed_student.iterator();
		while(it.hasNext())
		{
			Student s=it.next();
			if(s.tamil<35 || s.english<35 || s.maths<35 || s.science<35 || s.social<35 ) 
			{
				it.remove();
			}
		}
		
		return passed_student;
	}
	
	
	public static Collection<Student> foundFailed(Collection<Student> students)
	{
		Collection<Student> total_student = new ArrayList<>();
		total_student.addAll(students);
		Collection<Student> passed_student=foundPassed(students);
		total_student.removeAll(passed_student);
		return total_student;
	}
	public static Collection<Student> belowFiftyAvg(Collection<Student> students)
	{
		
		Collection<Student> belowFifty = new ArrayList<>();
		belowFifty.addAll(students);
		Collection<Student> aboveFifty=aboveFiftyAvg(students);
		belowFifty.removeAll(aboveFifty);
		return belowFifty;
	}
	public static Collection<Student> aboveFiftyAvg(Collection<Student> students)
	{
		Collection<Student> aboveFifty=new ArrayList<Student>();
		Iterator<Student> it=students.iterator();
		while(it.hasNext())
		{
			Student s=it.next();
			int avg=(s.tamil+s.english+s.maths+s.science+s.social)/5;
			if(avg>=50) 
			{
				aboveFifty.add(s);
			}
		}
		return aboveFifty;
	}
	public static void display(Collection<Student> students)
	{
		for(Student s:students) {
			System.out.println("name:"+s.name+"\n tamil:"+s.tamil+"\n english:"+s.english+"\n maths:"+s.maths+"\n science:"+s.science+"\n social:"+s.social);
			System.out.println("----------------------------------------");
		}
	}
	public static void main(String[] args)  {
		
		//Adding student list detail to the collection
		Student mani=new Student("mani",23,0,0,0,0);
		Student kumar=new Student("kumar",73,78,98,56,76);
		Student ravi=new Student("ravi",98,78,98,56,76);
		
		//student from class b
		Student maari=new Student("maari",23,78,98,56,76);
		Student mesy=new Student("mesy",70,78,98,56,76);
		Student guru=new Student("guru",35,78,98,56,76);
		
		
		Collection<Student> studentsFromA=new ArrayList<Student>();
		System.out.println(studentsFromA);
		Collection<Student> studentsFromB=new ArrayList<Student>();
		studentsFromB.add(maari);
		studentsFromB.add(mesy);
		studentsFromB.add(guru);
		
		studentsFromA.add(mani);
		studentsFromA.add(kumar);
		studentsFromA.add(ravi);
		
		Collection<Student> tenth=new ArrayList<>();
		tenth.addAll(studentsFromB);
		tenth.addAll(studentsFromA);
		
		init(tenth);

	}
	public static void init(Collection<Student> tenth)
	{
		Scanner sc=new Scanner(System.in);
		int stop=0;
		while(stop !=6)
		{	
		System.out.println("Enter below option to display the student name");
		System.out.println("------------------------------------------");
		System.out.println("Enter:1=======>for diplay all the student name with mark");
		System.out.println("Enter:2=======>for diplay all the passed student name with mark");
		System.out.println("Enter:3=======>for diplay all the failed student name with mark");
		System.out.println("Enter:4=======>for diplay all the above fifty plus average student name with mark");
		System.out.println("Enter:5=======>for diplay all the below fifty plus average student name with mark");
		System.out.println("Enter:6=======>for EXIT");
		int key=sc.nextInt();
		stop=key;
		switch(key)
		{
		case 1:
			System.out.println("--------------------------------------");
			System.out.println("All student name and their mark");
			display(tenth);
			break;
		case 2:
			System.out.println("--------------------------------------");
			System.out.println("passed student name and their mark");
			Collection<Student> passed=foundPassed(tenth);
			if(passed.isEmpty())
			{
				System.out.println("none of the students were passed");
			}
			display(passed);
			break;
		case 3:
			System.out.println("--------------------------------------");
			System.out.println("failed student name and their mark");
			Collection<Student> failled=foundFailed(tenth);
			if(failled.isEmpty())
			{
				System.out.println("none of the students were failed");
			}
			display(failled);
			break;
		case 4:
			System.out.println("--------------------------------------");
			System.out.println("above 50+ avarage marks gained student name and their mark");
			Collection<Student> above_fifty=aboveFiftyAvg(tenth);
			if(above_fifty.isEmpty())
			{
				System.out.println("none of the students got above 50+ average");
			}
			display(above_fifty);
			break;
		case 5:
			System.out.println("--------------------------------------");
			System.out.println("below 50+ avarage marks gained student name and their mark");
			Collection<Student> below_fifty=belowFiftyAvg(tenth);
			if(below_fifty.isEmpty())
			{
				System.out.println("none of the students got below 50 average");
			}
			display(below_fifty);
			break;
		case 6:
			System.exit(0); 
		}
		
		}
	}

}
