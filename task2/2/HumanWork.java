public class HumanWork implements IEmployee {
private Employee employee;
private String lastname = "Sobolevskii";
private String firstname = "Piotr";
private Integer workExperience = 5;
public HumanWork() {
System.out.println("HumanWork");
}
@Override
public String getLastName() {
return lastname;
}
@Override
public String getFirstName() {
return firstname;
}
public void setLastname(String lastname) {
this.lastname = lastname;
}
public void setFirstname(String firstname) {
this.firstname = firstname;
}
public Integer getWorkExperience() {
return workExperience;
}
public void setWorkExperience(Integer workExperience) {
this.workExperience = workExperience;
}
}
