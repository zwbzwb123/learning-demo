package patterns.proxy.staticproxy;

import patterns.proxy.Subject;

import java.util.Scanner;

public class SubjectProxy implements Subject {

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("do other thing");
        subject.request();
        System.out.println("post process");
    }


    public static String input(String msg) {
        print(msg);
        return new Scanner(System.in).nextLine();
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

}
