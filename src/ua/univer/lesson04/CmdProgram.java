package ua.univer.lesson04;

public class CmdProgram {
    public static void main(String... args) {
            for(int i = 0; i<args.length; i++) {
                System.out.println("args[" + i + "]: " +  args[i]);
            }
        }
    }

