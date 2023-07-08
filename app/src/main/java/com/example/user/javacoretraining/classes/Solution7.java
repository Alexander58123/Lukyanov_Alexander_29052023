package com.example.user.javacoretraining.classes;


import java.util.*;

public class Solution7 {

    // общий список для работы с товарами
    public static List<Tovar> bazaTovarov = new ArrayList<>();

    // черный список клиентов, кто не оплатили
    public static List<Client> chernuiSpisok = new ArrayList<>();


    public static void main(String[] args) {

        // товаровед (менеджер)
        Tovaroved manager = new Tovaroved("Краснова", "Мария", "Александровна");

        // товары
        Tovar tovar1 = new Tovar("Пеноблок",
                "Строительный материал, производящийся из разновидности ячеистого бетона", 78, 100);
        Tovar tovar2 = new Tovar("Доска отделочная",
                "Декоративная доска для отделки стен", 124, 100);
        Tovar tovar3 = new Tovar("Шпатлевка",
                "Материал для выравнивания стен", 230, 100);
        Tovar tovar4 = new Tovar("Плитка керамическая",
                "Плитка для установки на стены, пол", 540, 100);
        Tovar tovar5 = new Tovar("Обои",
                "Применяются для поклейки стен с разной фактурой", 80, 100);
        Tovar tovar6 = new Tovar("Цемент",
                "Предназначен для использования внутри и снаружи помещений", 150, 100);
        Tovar tovar7 = new Tovar("Труба профильная",
                "Профильная труба с прямоугольным сечением 40 х 20 мм", 65, 100);
        Tovar tovar8 = new Tovar("Гипсокартон влагостойкий",
                "Внутренняя отделка в помещениях с повышенным уровнем влажности", 147, 100);
        Tovar tovar9 = new Tovar("Профнастил",
                "Тонкий гофрированный лист из оцинкованной стали", 86, 100);
        Tovar tovar10 = new Tovar("Утеплитель",
                "Минеральный утеплитель для теплоизоляции наружных каркасных стен", 86, 100);



        // менеджер добавил товар в общую базу
        manager.addTovar(tovar1);
        manager.addTovar(tovar2);
        manager.addTovar(tovar3);
        manager.addTovar(tovar4);
        manager.addTovar(tovar5);
        manager.addTovar(tovar6);
        manager.addTovar(tovar7);
        manager.addTovar(tovar8);
        manager.addTovar(tovar9);
        manager.addTovar(tovar10);


        // создали клиента и закрепили за ним менеджера
        Client client1 = new Client("Боков",
                "Алексей", "Васильевич", 89111234567L, manager);


            if (chernuiSpisok.size() == 0) {
                System.out.println("Черный список пуст");
            } else {
                System.out.println("Есть люди в черном списке");
            }


        Order order = new Order(client1); // cоздали заказ для клиента
        order.orderComplete();      // клиент сформировал заказ (генерация)
        order.showOrderComplete(); // выводим информацию перед заказом

        Prodazha prodazha = new Prodazha(order); // в продажу передаем заказ
        System.out.println("Введите true - подтвердить | false - не оплачивать");
        try {
            Scanner scanner = new Scanner(System.in);
            boolean vvod = scanner.nextBoolean();
            prodazha.proverkaOplatu(vvod);
        } catch (InputMismatchException e) {
            System.out.println("Значения должны быть: true или false");
        }


        System.out.println("\nСодержимое черного списка:");
        for (Client client : chernuiSpisok) {
            System.out.println(" -" + client.getFIO());
        }
    }


}

// товаровед (менеджер)
class Tovaroved {
    private String familiya;
    private String imya;
    private String otchestvo;

    public Tovaroved(String familiya, String imya, String otchestvo) {
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
    }

    // товар добавляем
    public void addTovar(Tovar tovar) {
        Solution7.bazaTovarov.add(tovar);
    }

    // вывод товаров
    public void showBazaTovarov() {
        for (Tovar tovar:Solution7.bazaTovarov) {
            System.out.println(tovar);
        }
    }

    // клиентов в черный список
    public void addClientBlackList(Client client) {
        Solution7.chernuiSpisok.add(client);
    }

}


// товар
class Tovar {
    private String title;
    private String description;
    private int price;
    private int kolvo;

    public Tovar(String title, String description, int price, int kolvo) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.kolvo = kolvo;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return "Tovar [Title=" + title
                + ", Description=" + description
                + ", Price=" + price + " руб." + "]";
    }
}

// клиент
class Client {
    private String familiya;
    private String imya;
    private String otchestvo;
    private long telephone;
    private Tovaroved tovaroved;

    public Client(String familiya, String imya, String otchestvo, long telephone, Tovaroved tovaroved) {
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.telephone = telephone;
        this.tovaroved = tovaroved;
    }

    public Tovaroved getTovaroved() {
        return tovaroved;
    }

    public void setTovaroved(Tovaroved tovaroved) {
        this.tovaroved = tovaroved;
    }

    public String getFIO() {
        return familiya + " " + imya + " " + otchestvo;
    }
}

// заказ

// здесь формируется перечень заказов в общий список
class Order {
    private Client client;
    private List<Tovar> tovaru;
    private List<Integer> kolvoTovarov;
    private Tovaroved tovaroved;
    private int stoimostObshaya;

    public Order(Client client) {
        this.client = client;
        this.tovaru = new ArrayList<>(); // сложим все товары в этот список
        this.tovaroved = client.getTovaroved();
        stoimostObshaya = 0;
    }

    public Tovaroved getTovaroved() {
        return tovaroved;
    }

    public Client getClient() {
        return client;
    }

    // от 2 до 10 случайные числа
    public static int generateKolvoTovarov() {
        Random random = new Random();
        int temp = random.nextInt(8 + 1) + 2;
        return temp;
    }

    // от 2 до 5
    public static int generateKolichestvo() {
        Random random = new Random();
        int temp = random.nextInt(3 + 1) + 2;
        return temp;
    }

    // Информация перед оплатой
    public void showOrderComplete() {
        System.out.println("Клиент: " + client.getFIO());
        System.out.println("Список заказанных товаров:");
        for (int i = 0; i < tovaru.size(); i++) {
            System.out.println(tovaru.get(i) + " " + kolvoTovarov.get(i) + " шт.");
        }

        System.out.println("---------------");
        System.out.println("Сумма к оплате: " + stoimostObshaya + " руб.");
    }

    // формирование заказа - генерация списка товаров для продажи
    public void orderComplete() {
        List<Tovar> tovaruPeremesh = new ArrayList<>(Solution7.bazaTovarov); // временный для эффекта рандома, общую базу помешали
        Collections.shuffle(tovaruPeremesh); // перемешали нашу полную базу

        int countTovarovRandom = generateKolvoTovarov();
        for (int i = 0; i < countTovarovRandom; i++) {
            tovaru.add(tovaruPeremesh.get(i));
        }

        kolvoTovarov = new ArrayList<>();
        for (int i = 0; i < countTovarovRandom; i++) {
            kolvoTovarov.add(generateKolichestvo());
        }


        // посчитали общую стоимость заказа
        for (int i = 0; i < tovaru.size(); i++) {
            stoimostObshaya = (tovaru.get(i).getPrice() * kolvoTovarov.get(i)) + stoimostObshaya;
        }

    }
}

// продажа
class Prodazha {
    Order order;
    boolean oplataYesOrNo;

    public Prodazha(Order order) {
        this.order = order;
    }

    public void proverkaOplatu(boolean value) {

        if (value == true) {
            System.out.println("Спасибо, платеж успешно прошел");
            System.out.println("Ваш чек .......");
        } else if (value == false){
            System.out.println("Платеж отклонен");
            System.out.println("В черный список добавлен: " + order.getClient().getFIO());
            order.getTovaroved().addClientBlackList(order.getClient());
        }
    }
}







