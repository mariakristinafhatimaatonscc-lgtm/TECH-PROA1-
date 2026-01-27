class Student {
	String name;
	
	void displayName() {
	System.out.println("Student Name: + name");
	}
}

public class SecondSemSW6 {
    public static void main(String[] args) {
        
        //Object reference declared but Not created 
        Student s1 = null;
        
        try {
            //this display will cause error
            s1.displayName();
        }catch (Exception e) {
            System.out.println("Error:Student object is not created");
            
        }
    }
}