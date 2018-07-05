package com.example.nicolaipc.ungdungcauhoitracnghiem.capnhat;

public class Tracnghiem {
    public int _id;
    public String question;
    public String ans_a;
    public String ans_b;
    public String ans_c;
    public String ans_d;
    public String result;
    public int num_exam;
    public String subject;
    public String image;

    public Tracnghiem(int _id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, int num_exam, String subject, String image) {
        this._id = _id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.num_exam = num_exam;
        this.subject = subject;
        this.image = image;
    }
}
