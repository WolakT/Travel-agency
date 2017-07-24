package sample;

import java.util.Date;

/**
 * Created by Tomcio on 2017-07-23.
 */
public class Clerk {
    private int id;
    private String name;
    private String jobTitle;
    private Date hireDate;

    public Clerk(int id, String name, String jobTitle, Date hireDate) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
