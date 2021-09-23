package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import DAO.EmployeesDAO;
import DAO.ProjectManagerDAO;
import DAO.RequirementsDAO;
import DAO.SourcingTeamDAO;
import Model.Employees;
import Model.ProjectManager;
import Model.Requirements;
import Model.SourcingTeam;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, ClassNotFoundException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int option, option1;
		Requirements requirements = new Requirements();
		RequirementsDAO requirementsdao = new RequirementsDAO();
		ProjectManager projectmanager= new ProjectManager();
		ProjectManagerDAO projectmanagerdao = new ProjectManagerDAO();
		SourcingTeam sourcingteam = new SourcingTeam();
		SourcingTeamDAO sourcingteamdao = new SourcingTeamDAO();
		Employees employees = new Employees();
		EmployeesDAO employeesdao = new EmployeesDAO();
		do
		{
			
			System.out.println("1.Requirements");
			System.out.println("2.Exit");
			option=Integer.parseInt(br.readLine());
			switch(option)
			{ case 1:
				
			    System.out.println("enetr the number of requirements for project");
			    int n=Integer.parseInt(br.readLine());
			    requirements.setN(n);
			    if(requirementsdao.validate(requirements)==true)
			    {
			    	System.out.println("Internal Source Team received the job notification from the HR");
			    	System.out.println("please enetr the types of required enginners");
			    	String sector1=br.readLine();
			    	String sector2=br.readLine();
			    	System.out.println("please enetr the no.of required jopb members for  sector1");
			    	int rjmfsct1= Integer.parseInt(br.readLine());
			    	System.out.println("please enetr the no.of required jopb members for  sector2");
			    	int rjmfsct2= Integer.parseInt(br.readLine());
			    	projectmanagerdao.addDetails(projectmanager);
			    	do
			    	{
			    		System.out.println("1.Applicant");
			    		System.out.println("2.projectManager");
			    		System.out.println("3.Exit");
			    		option1 = Integer.parseInt(br.readLine());
			    		switch(option1)
			    		{
			    		case 1:
			    			System.out.println("Eneter the Registration Link");
			    			String rl =br.readLine();
			    			sourcingteam.setRl(rl);
			    			if(sourcingteamdao.validate1(sourcingteam)==true)
			    			{
			    				System.out.println("Please enter your full details");
								System.out.println("------------------------------------------------------------------------------------------------------");
								System.out.println("Enetr the first name");
								String First_name=br.readLine();
								System.out.println("Enetr the Last name");
								String Last_name= br.readLine();
								System.out.println("Enetr the university name");
								String University_name= br.readLine();
								System.out.println("Enetr the  college_name");
								String college_name= br.readLine();
								System.out.println("Enetr the passed_out_year");
								int passed_out_year= Integer.parseInt(br.readLine());
								System.out.println("Enetr the  your Branch");
								String branch_name=br.readLine();
								System.out.println("Enetr the your whole academic gaps ");
								String gap= br.readLine();
								System.out.println("enetr your valid e_ mail");
								String e_mail=br.readLine();
								System.out.println("YOU'R APPLICATION HAS BEEN SUBMITED");
								employees.setFirst_name(First_name);
								employees.setLast_name(Last_name);
								employees.setUniversity_name(University_name);
								employees.setCollege_name(college_name);
								employees.setPassed_out_year(passed_out_year);
								employees.setBranch_name(branch_name);
								employees.setGap(gap);
								employees.setE_mail(e_mail);
								employeesdao.addDetails1(employees);
								
							//	break;
			    			}else 
			    			{
			    				System.out.println("please  enter valid registration link");
			    			}
			    			break;
							case 2:
								employeesdao.Display();
								break;
								
							case 3 :	
								break;
			    			
			    		}
			    		
			    	}while(option1!=3);
			    	
			    	
			    }
			case 2: System.exit(0);
			 		break;
			
			}
			
				
		
		} 
		while(option!=2);
	}

}
