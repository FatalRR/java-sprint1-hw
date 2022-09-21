import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean startLoop = true;  // булево значение для работы цикла while
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while(startLoop) {   // цикл для перезапуска switch
            switch (userInput) {
                case 1:
                    stepTracker.monthSave(); // 1 - Ввести количество шагов за определённый день
                    break;
                case 2:
                    stepTracker.monthStat(); // 2 - Посмотреть на статистику за определённый месяц
                    break;
                case 3:
                    stepTracker.changeTargetSteps(); // 3 - Изменить цель по количеству шагов в день
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    startLoop = false; // если значение false цикл прекращает свою работу
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }


    private static void printMenu() {
        System.out.println("Что вы хотите сделать? \n " +
                "1 - Ввести количество шагов за определённый день \n " +
                "2 - Посмотреть на статистику за определённый месяц \n " +
                "3 - Изменить цель по количеству шагов в день \n " +
                "0 - Выход");
    }
}