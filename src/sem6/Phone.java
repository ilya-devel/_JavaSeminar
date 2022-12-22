package sem6;

public class Phone {
    private String number;
    private String model;
    private int weight;

    public Phone() {
    }

    public Phone(String number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }


    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String receiveCall(String name) {
        return "Звонит " + name + " на номер " + this.number;
    }

    public String receiveCall(String name, String number) {
        return "Звонит " + name + " с номера " + number + " на номер " + this.number;
    }

//    public void sendMessage(String[] numbers) {
//        for (String number : numbers) System.out.println(number);
//    }

    public void sendMessage(String message, String... numbers) {
        System.out.printf("С телефона %s отправляем сообщения\n", this.number);
        for (String number : numbers) {
            System.out.printf("На телефон %s, отправлено сообщение: %s\n", number, message);
        }
    }
}
