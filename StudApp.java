package student_management;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import conn_pro.Insert_Table;

public class StudApp {

	public static void main(String[] args) {
		try {
			System.out.println("************Welcome to Student Management System*************");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.println("MENU");
				System.out.println("1.Insert Student Records");
				System.out.println("2.Delete Student Records");
				System.out.println("3.Display Student Records");
				System.out.println("4.Update Student Records");
				System.out.println("5.Exit");
				System.out.println("6.Create Table");
				
				System.out.println("Select operation : ");
				int op = Integer.parseInt(br.readLine());
				
				//insert record
				if(op==1) {
					System.out.println("Enter student name : ");
					String name = br.readLine();
					
					System.out.println("Enter student phone : ");
					String mob = br.readLine();
					
					System.out.println("Enter student City : ");
					String city = br.readLine();
					
					System.out.println("Enter mail: ");
					String mail=br.readLine();
					Student st = new Student(name, city, mail, mob);
					boolean answer = Student_me.insertRecord(st);
					
					if(answer) {
						System.out.println("Data Inserted successfully");
					}
					else {
						System.out.println("Insertion Failed");
					}
					
					System.out.println(st);
				}
				else if(op==2) {				//Delete record
					System.out.println("Delete Data");
					System.out.println("Enter id: ");
					int id=Integer.parseInt(br.readLine());
					
					boolean result = Student_me.deleteRecord(id);
					if(result) {
						System.out.println("Record deleted");
					}else {
						System.out.println("Record not deleted");
					}
				}
				else if(op==3) {				//Display record
					Student_me.displayRecord();
				}
				else if(op==4) {				//Update Record
					System.out.println("Update data");
					System.out.println("Enter id: ");
					int id=Integer.parseInt(br.readLine());
					System.out.println("Enter new name: ");
					String name=br.readLine();
					System.out.println("Enter new city: ");
					String city = br.readLine();
					System.out.println("Enter new mail: ");
					String mail= br.readLine();
					System.out.println("Enter new mobile number: ");
					String mob= br.readLine();
					Student st=new Student(name, city, mail, mob);
					boolean answer = Student_me.updateRecord(st, id);
					if(answer) {
						System.out.println("Data updated successfully");
					}else {
						System.out.println("Data not updated");
					}
				}
				else if(op==5){					//Exit
					System.out.println("Program ends...");
					System.exit(0);
				}else if(op==6) {
					boolean result=Student_me.createTable();
					if(result) {
						System.out.println("Table created");
					}else 
						System.out.println("Table is not created");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
