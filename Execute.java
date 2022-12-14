package PrjLog;

import java.util.Scanner;

public class Execute {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminLog admin =new AdminLog();
		StudentModule student = new StudentModule();

		Scanner sc =new Scanner(System.in);
		System.out.println("press 1=> for admin \n press 2=> for user");
		int ch = sc.nextInt();
		
		if(ch==1) {
			System.out.println("Welcome To Admin Portal");
			System.out.print("Enter the User Name  :");
			String u=sc.next();
			System.out.print("Enter the Password  :");
			String p=sc.next();
			
			boolean r = admin.adminLogin(u,p);
			
			if(r==true) {
				while(true) {
					System.out.println("1.Add\n 2.View\n 3.Edit\n 4.Remove\n 5.Exit");
					System.out.println("Enter the Option");
					int n = sc.nextInt();
					
					if(n==1) {
						System.out.println("Enter the userNmae");
						String un= sc.next();
						System.out.print("Enter the Name  :");
						String name=sc.next();
						System.out.println("Enter Date of Birth");
						String dob = sc.next();
						System.out.println("Enter 10th mark");
						int mark1=sc.nextInt();
						System.out.print("Enter the 12th Mark  :");
						int mark2=sc.nextInt();
						System.out.println("Enter department:");
						String dpt=sc.next();
						System.out.print("Enter the Email  :");
						String email=sc.next();
					
						int res = admin.adminInsert(un,name,dob,mark1,mark2,dpt,email);
						System.out.println(res>=1?"Added":"NotAdded");
					}
					
					else if(n==2) {
						admin.adminselect();
					}
					
					else if(n==3) {
						//updatecode
						System.out.print("Enter the userName  :");
						String un=sc.next();
						System.out.print("Enter the 10th Mark  :");
						int mark1=sc.nextInt();
						System.out.print("Enter the 12th Mark  :");
						int mark2=sc.nextInt();
						System.out.println("Enter Email");
						String email = sc.next();
						
						int res = admin.adminupdate(un,mark1,mark2,email);
						System.out.println((res>=1)?"Updated":"NotUpdated");
					}
					
					else if(n==4) {
						System.out.print("Enter the User UserName  :");
						String un=sc.next();
						
						int res = admin.admindelete(un);
						System.out.println((res>=1)?"Deletion":"Not Deletion");
					}
					
					else if(n==5) {
						System.out.println("...Exiting!!!");
						break;
					}
				}
			}
			else {
				System.out.println("Invalid Operation");
			}
			
			
			
		}else if(ch==2) {
			//user Module
			String user="";
			System.out.println("Welcome to student Portal");
			System.out.println("1=>Sigin  \n2=>Login");
			System.out.println("Enter option");
			int n = sc.nextInt();
			
			switch(n) {
			case 1:
				// sigin code
				System.out.println("Enter user name:");
				String un = sc.next();
				System.out.println("Enter password");
				String pass = sc.next();
				student.stuentSigin(un, pass);
				break;
			
			case 2:
				//Login code
				
				System.out.print("Enter the User Name  :");
				String u=sc.next();
				user=u;
				System.out.print("Enter the Password  :");
				String p=sc.next();
				
				
				boolean r=student.userLogin(u, p);

				if(r==true) {
					while(true) {
						System.out.println("1.View\n 2.Edit\n 3.Remove\n 4.Exit");
						System.out.print("Enter the Option :");
						int o=sc.nextInt();
						
						if(o==1) {
							//select
							student.studentSelect(user);
						}
						else if(o==2) {
							//update	
							System.out.print("Enter the 10th Mark  :");
							int mark1=sc.nextInt();
							System.out.print("Enter the 12th Mark  :");
							int mark2=sc.nextInt();
							System.out.println("Enter Email");
							String email = sc.next();
						
							int res = student.studentUpdate(user,mark1,mark2,email);
							System.out.println((res>=1)?"Updated":"NotUpdated");
						}
						
						else if(o==3) {
							//delete
							int res = admin.admindelete(user);
							System.out.println((res>=1)?"Deletion":"Not Deletion");	
						}
						else if(o==4) {
							System.out.println("exitting.....");
							break;
						}
					}}
				break;
				default:
					System.out.println("invalid operation");

					
			}
						
			
		}else {
			System.out.println("invalid operation");
		}
		}
	}




