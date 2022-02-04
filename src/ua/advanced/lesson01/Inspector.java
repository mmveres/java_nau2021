package ua.advanced.lesson01;

class Inspector {
    public static <T> void inspect(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        Inspector.inspect(1);
        Inspector.inspect(1.1);
        Inspector.inspect('1');
    }
}

