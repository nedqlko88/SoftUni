package p03_mankind;

public class Student extends Human{
    private String facultyNumber;

    public Student(String firstName, String lastName, String facNumber) {
        super(firstName, lastName);
        this.setFacNumber(facNumber);
    }

    public String getFacNumber() {
        return this.facultyNumber;
    }

    private void setFacNumber(String facNumber) {
        if (facNumber.length() < 5 || facNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facNumber;
    }

    @Override
    public String toString() {
          return super.toString() + String.format("Faculty number: %s",this.getFacNumber());
    }
}
