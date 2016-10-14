import java.io.*;
import java.util.*;
public class Menu{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
        Scanner a = new Scanner(System.in);
		List<Student> sList = new ArrayList<Student>();
        int choice = 0;
        while(choice != 5){
        
        System.out.println("Choose--1: REGISTER 2: SEARCH");
        choice = a.nextInt();
        if(choice == 1){
        System.out.println("Enter Student Number:");   
        String snum = s.nextLine();
        System.out.println("Enter Student's FirstName:");
        String fname = s.nextLine();
        System.out.println("Enter Student's MiddleInitial:");
        String midname = s.nextLine();
        char mname = midname.charAt(0);
        System.out.println("Enter Student's LastName:");
        String lname = s.nextLine();
        System.out.println("Enter Student's Course:");
        String course = s.nextLine();
        System.out.println("Enter Student's YearLevel:");
        int level = s.nextInt();
        Student student = new Student(snum, fname, mname, lname, course, level);
        BufferedReader br = null;


        try {
            String sCurrentLine;
            System.out.println(snum);
            br = new BufferedReader(new FileReader("db.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
              if (snum.equals(sCurrentLine)){
                System.out.println("Student exists");
                break;
                
              }
              else{
                sList.add(student);
              }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    else if(choice == 2){
        System.out.println("Enter Student Number:");   
        String searchNum = s.nextLine();
      
       
         BufferedReader bt = null;

        try {
            String sCurrentLine;
              String upNum = "";String upfName = "";String uplName = "";String upCourse = "";
              Student studentUpload = null;
              char upmName = 0;
              int upLevel = 0;
              int ctr = 0;
            bt = new BufferedReader(new FileReader("db.txt"));

            while ((sCurrentLine = bt.readLine()) != null) {
                if( ctr % 6 == 0)
               upNum = sCurrentLine;
                if( ctr % 6 == 1)
               upfName = sCurrentLine;
                if( ctr % 6 == 2)
               upmName = sCurrentLine.charAt(0);
                if( ctr % 6 == 3)
               uplName = sCurrentLine;
                if( ctr % 6 == 4)
               upCourse = sCurrentLine;
                if( ctr % 6 == 5){
               upLevel = Integer.parseInt(sCurrentLine);
               studentUpload = new Student(upNum, upfName, upmName, uplName, upCourse, upLevel);
                sList.add(studentUpload);
                }

                ctr++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bt != null) bt.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
        System.out.println(sList.get(1));
        System.out.println(sList.get(2));
        System.out.println(sList.get(0));
    }
        


    }
	}
