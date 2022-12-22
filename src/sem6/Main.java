package sem6;

public class Main {
    public static void main(String[] args) {
        Person vlad = new Person("Kira", 31);
//        vlad.name = "Vlad";
//        vlad.age = 33;
        System.out.println(vlad.getName());
        vlad.setAge(23);
        System.out.println(vlad.getAge());
        System.out.println(vlad);
        System.out.println();

        Phone myPhone1 = new Phone("999-9990-00-00", "Nokia Super4", 230);
        Phone myPhone2 = new Phone("999-9990-00-01", "Nokia Super4", 230);
        Phone myPhone3 = new Phone("999-9990-00-02", "Nokia Super4", 230);
        Phone myPhone4 = new Phone("998-2233-11-00", "Samsung Gal");
        System.out.println(myPhone1.getNumber());
        System.out.println(myPhone2.getNumber());
        System.out.println(myPhone3.getNumber());
        System.out.println(myPhone1);
        System.out.println(myPhone2);
        System.out.println(myPhone3);
        System.out.println(myPhone4);
        System.out.println(myPhone1.receiveCall("Olya"));
        System.out.println(myPhone4.receiveCall("Olga", "991-9971-33-12"));
        myPhone1.sendMessage("This message", new String[]{"999-1111-11-11", "444-1111-22-22"});
        myPhone1.sendMessage("My message", "999-999-99-99", "999-000-000-00");
    }
}
