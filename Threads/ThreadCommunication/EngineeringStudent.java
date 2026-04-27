package com.thread.ThreadCommunication;

public class EngineeringStudent {
    public static void main(String[] args){
        Student student = new Student() {
            @Override
            public String getBio(String name) {
                return name + " is Engineering Student";
            }
        };

        Student lawStudent = (name) -> {
            return name + " is Law Student";
        };

        String bio = student.getBio("Ram");
        System.out.println(bio);
    }
}
