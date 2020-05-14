import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Student{
	private String name;
	private String Id;
	private int Age;
	private Student child;

	public Student(){
		this.child = null;
		this.name = null;
		this.Id = "0";
		this.Age = 18;
	}


	public String getName(){
		return this.name;
	}

	public String getId(){
		return this.Id;
	}

	public Student getChild(){
		return this.child;
	}

	public int getAge(){
		return this.Age;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setId(String id){
		this.Id = id;
	}

	public void setAge(int age){
		this.Age = age;
	}

	public void setChild(Student child){
		this.child = child;
	}

	public String toString(){
		return " name : " + this.getName() + " Id : " + this.getId() + " Age : " + this.getAge() + " child is : " + this.getChild();
	}
}


public class GsonTester2{
	public static void main(String[] args){
		GsonTester2 gsontester = new GsonTester2();

		try{
			Student student = new Student();
			student.setName("abc");
			student.setAge(20);
			student.setId("S20180010069");

			Student child = new Student();
			child.setName("xyz");
			child.setAge(12);
			child.setId("S20180010061");

			student.setChild(child);

			gsontester.writeJson(student);

			Student studentOne = gsontester.readJson();
			System.out.println(studentOne);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	private void writeJson(Student student) throws Exception{
		// GsonBuilder  builder = new GsonBuilder();
		// builder.setPrettyPrinting();
		// Gson gson = builder.create();
		Gson gson = new Gson();
		FileWriter writer = new FileWriter("Student.json");
		writer.write(gson.toJson(student));
		writer.close();
	}

   
   private Student readJson() throws Exception { 
      // GsonBuilder builder = new GsonBuilder(); 
      // builder.setPrettyPrinting();
      // Gson gson = builder.create();
      Gson gson = new Gson(); 
      BufferedReader bufferedReader = new BufferedReader(
         new FileReader("Student.json"));   
      
      Student student = gson.fromJson(bufferedReader, Student.class); 
      return student; 
   } 



}