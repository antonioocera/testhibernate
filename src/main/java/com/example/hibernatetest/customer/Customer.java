package com.example.hibernatetest.customer;

import com.example.hibernatetest.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull
    @Size(min=1, message="is required")
    private String lastName;

    @NotNull
    @Min(value=0, message = "deve essere più grande o uguale a 0")
    @Max(value=10, message = "deve essere più piccolo o uguale a 10")
    private Integer freePasses;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "solo 5 numeri o caratteri")
    private String postalCode;


    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
