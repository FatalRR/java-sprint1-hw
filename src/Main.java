import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                stepTracker.monthSave();// 1 - Ввести количество шагов за определённый день
            } else if (userInput == 2) {
                stepTracker.monthStat();// 2 - Посмотреть на статистику за определённый месяц
            } else if (userInput == 3) {
                stepTracker.changeTargetSteps(); //3 - Изменить цель по количеству шагов в день
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }


    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Посмотреть на статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}