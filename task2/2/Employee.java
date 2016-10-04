import java.util.List;
public class Employee implements IEmployee {
private List<HumanWork> humanwork;
private Departure departure;
private String lastname = "Ushko";
private String firstname = "Fidosevich";
private String position = "Chief Specialist";
public Employee() {
System.out.println("Employee");
}
public String getPosition() {
return position;
}
public void setPosition(String position) {
this.position = position;
}
public void setLastname(String lastname) {
this.lastname = lastname;
}
public void setFirstname(String firstname) {
this.firstname = firstname;
}
@Override
public String getLastName() {
return lastname;
}
@Override
public String getFirstName() {
return firstname;
}
public void takeToWork(IEmployee emp) {
System.out.println("Take to work");
}
}