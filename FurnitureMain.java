import java.util.Arrays;
import java.util.Comparator;

// Для класу Furniture я визначила наступні атрибути:
 
class Furniture {
    private int id;        // Унікальний ідентифікатор меблів
    private String type;   // Тип меблів (наприклад, стіл, стілець)
    private String color;  // Колір меблів
    private double price;   // Ціна меблів
    private int quantity;   // Кількість на складі

    // Конструктор для ініціалізації об'єкта Furniture
    public Furniture(int id, String type, String color, double price, int quantity) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    // Геттери для полів
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Furniture{id=" + id + ", type='" + type + "', color='" + color + 
               "', price=" + price + ", quantity=" + quantity + "}";
    }
}

public class FurnitureMain {
    public static void main(String[] args) {
        // Створення масиву меблів
        Furniture[] furnitureArray = {
            new Furniture(1, "Chair", "Red", 50.0, 20),
            new Furniture(2, "Table", "Blue", 150.0, 5),
            new Furniture(3, "Chair", "Green", 50.0, 10),
            new Furniture(4, "Table", "Red", 200.0, 15),
            new Furniture(5, "Sofa", "Blue", 300.0, 8)
        };

        // Сортування масиву за першим полем (id) за зростанням,
        // а за другим полем (price) за спаданням
        Arrays.sort(furnitureArray, Comparator.comparingInt(Furniture::getId)
                .thenComparing(Comparator.comparingDouble(Furniture::getPrice).reversed()));

        // Виведення відсортованого масиву
        System.out.println("Sorted Furniture Array:");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        // Пошук об'єкта за значенням id
        int searchId = 3;
        Furniture foundFurniture = findFurnitureById(furnitureArray, searchId);
        
        // Виведення знайденого об'єкта або повідомлення, якщо не знайдено
        if (foundFurniture != null) {
            System.out.println("Found: " + foundFurniture);
        } else {
            System.out.println("Furniture with id " + searchId + " not found.");
        }
    }

    // Метод для пошуку меблів за id
    private static Furniture findFurnitureById(Furniture[] furnitureArray, int id) {
        for (Furniture furniture : furnitureArray) {
            if (furniture.getId() == id) {
                return furniture;
            }
        }
        return null; // Якщо не знайдено
    }
}
