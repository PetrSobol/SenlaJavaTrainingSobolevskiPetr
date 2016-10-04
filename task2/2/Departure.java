import java.util.List;
public class Departure {
private List<Employee> employee;
private String nameDeparture="245";
public Departure() {
System.out.println("Human Resources Department");
}
public String getNameDeparture() {
return nameDeparture;
}
public void setNameDeparture(String nameDeparture) {
this.nameDeparture = nameDeparture;
}
}