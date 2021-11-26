package ua.univer.lesson08;
enum Coin{
    Coin1(1),
    Coin2(2),
    Coin5(5),
    Coin10(10),
    Coin25(25),
    Coin50(50);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
public class ProgramEnum {
    public static void main(String[] args) {
        Coin [] coins = new Coin[]{
                Coin.Coin1,
                Coin.Coin2,
                Coin.Coin5,
                Coin.Coin10

        };
        for(var coin : coins)
            System.out.println(coin.getValue());

        for(var coin : Coin.values())
            System.out.println(coin.getValue());
    }
}
