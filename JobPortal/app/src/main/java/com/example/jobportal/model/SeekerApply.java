package com.example.jobportal.model;


public class SeekerApply{
    private int id;
    private String fname;
    private String lname;
    private String nid;
    private String email;
    private String address;
    private String projal;
    private String file;

    public SeekerApply() {
    }

    public SeekerApply(int id, String fname, String lname, String nid, String email, String address, String projal, String file) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.nid = nid;
        this.email = email;
        this.address = address;
        this.projal = projal;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProjal() {
        return projal;
    }

    public void setProjal(String projal) {
        this.projal = projal;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
