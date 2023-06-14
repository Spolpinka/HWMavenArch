package model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private int cityId;

    public Employee(String firstName, String lastName, String gender, int age, int city_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = city_id;
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                " id= " + id +
                ", first_name= " + firstName +
                ", last_name= " + lastName +
                ", gender= " + gender +
                ", age= " + age +
                ", city_id=" + cityId;
    }
}
