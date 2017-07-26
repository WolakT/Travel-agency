package sample;

import javax.persistence.*;
/**
 * Created by RENT on 2017-07-21.
 */
@Entity
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    private String question1;
    private String question2;
    private String question3;
    public Survey(){}

    public Survey(int id, String question1, String question2, String question3) {
        this.id = id;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", question1='" + question1 + '\'' +
                ", question2='" + question2 + '\'' +
                ", question3='" + question3 + '\'' +
                '}';
    }
}
