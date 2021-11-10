package ua.univer.lesson03;
enum SortEnum{ASC, DESC}
public class ProgEnum {
    public static void main(String[] args) {
        SortEnum sortEnum = SortEnum.ASC;

        isSort(sortEnum);
    }

    private static void isSort(SortEnum sortEnum) {
        if (sortEnum == SortEnum.ASC){
            System.out.println("asc");
        }
        else
        {
            System.out.println("desc");
        }
    }
}
