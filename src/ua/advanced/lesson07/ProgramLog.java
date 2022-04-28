package ua.advanced.lesson07;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

class User{
    @NotNull
    private String name;
    @Range(min = 18, max = 65)
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
//    @Range(min = 18, max = 65)
    public void setAge(int age) throws Exception {
        this.age = age;
//        try {
            ValidatorUser.validate(this);
//        } catch (Exception e) {
//            ProgramLog.logger.log(Level.SEVERE,"Not age Validate "+this+ " : "+ Arrays.toString(e.getStackTrace()));
//        }

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ProgramLog {
    public static Logger logger = Logger.getLogger(ProgramLog.class.getSimpleName());
    static {
        try {
            Handler fh = new FileHandler("prog.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.SEVERE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        User u= new User("Tom", 20);
        try {
            logger.log(Level.INFO,"Validate User "+u+Boolean.toString(ValidatorUser.validate(u)));
            u.setAge(10);
      //      logger.log(Level.INFO,"Validate User "+u+Boolean.toString(ValidatorUser.validate(u)));
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Not age Validate "+u+ " : "+ Arrays.toString(e.getStackTrace()));
            throw e;
        }

    }
}
