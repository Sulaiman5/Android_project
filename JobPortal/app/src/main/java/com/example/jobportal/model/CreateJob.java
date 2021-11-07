package com.example.jobportal.model;

public class CreateJob {
    private int id;
    private String code;
    private String jobname;
    private String jobtitle;
    private String responsibilities;
    private String educational;
    private String experience;
    private String age;
    private String joblocation;
    private String salary;
    private String adver_code;
    private String fname;

    public CreateJob() {
    }

    public CreateJob(int id, String code, String jobname, String jobtitle, String responsibilities, String educational, String experience, String age, String joblocation, String salary, String adver_code, String fname) {
        this.id = id;
        this.code = code;
        this.jobname = jobname;
        this.jobtitle = jobtitle;
        this.responsibilities = responsibilities;
        this.educational = educational;
        this.experience = experience;
        this.age = age;
        this.joblocation = joblocation;
        this.salary = salary;
        this.adver_code = adver_code;
        this.fname = fname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getEducational() {
        return educational;
    }

    public void setEducational(String educational) {
        this.educational = educational;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJoblocation() {
        return joblocation;
    }

    public void setJoblocation(String joblocation) {
        this.joblocation = joblocation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAdver_code() {
        return adver_code;
    }

    public void setAdver_code(String adver_code) {
        this.adver_code = adver_code;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
