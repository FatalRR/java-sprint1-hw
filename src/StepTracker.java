import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int[][] monthToData;
    int targetStepValue=10000;
    String notPlus = "Введено отрицательное значение, введите положительное!";
    String notShort = "Введено значение больше чем нужно, введите другое значение!";

    public StepTracker() {
        monthToData = new int[12][30];
    }
    public void monthSave() {  // метод отвечает за сохранение шагов в определённый день месяца
        System.out.println("За какой месяц вы хотите ввести статистику? от 1 до 12 (где 1 - январь, 12-декабрь");
        int saveMonth = scanner.nextInt();


        if (saveMonth < 0) {    // проверка на корректность ввода
            System.out.println(notPlus);
        } else if (saveMonth > 12) {
            System.out.println(notShort);
        } else {
            System.out.println("За какой день вы хотите ввести статистику? от 1 до 30");
            int saveDay = scanner.nextInt();
            if (saveDay < 0) {  // проверка на корректность ввода
                System.out.println(notPlus);
            } else if (saveDay > 30) {
                System.out.println(notShort);
            } else {
                System.out.println("Введите количество шагов которое вы хотите внести:");
                int saveSteps = scanner.nextInt();
                if (saveSteps <0) {     // проверка на корректность ввода
                    System.out.println(notPlus);
                } else {
                    monthToData[saveMonth-1][saveDay-1]=saveSteps;   // записываем в массив данные с клавиатуры и шагах
                }
            }
        }
    }
    public void monthStat() {  // метод отвечает за вывод и расчет статистики за месяц

        System.out.println("За какой месяц вы хотите просмотреть статистику? от 1 до 12 (где 1 - январь, 12-декабрь");
        int saveMonth = scanner.nextInt();
        int sumSteps=0;
        int maxSteps=0;
        int maxSeries=0;
        int tempSeries=0;

        if (saveMonth < 0) {    // проверка на корректность ввода
            System.out.println(notPlus);
        } else if (saveMonth > 12) {
            System.out.println(notShort);
        } else {
            for (int i=0; i<monthToData[saveMonth-1].length; i++) {  // цикл для поиска в массиве
                sumSteps = sumSteps + monthToData[saveMonth - 1][i];  // суммирование всех шагов в течение введеного месяца
                if (maxSteps < monthToData[saveMonth - 1][i]) {    // поиск максимального значения в массиве
                    maxSteps = monthToData[saveMonth - 1][i];
                }

                if (monthToData[saveMonth - 1][i] >= targetStepValue) { // поиск максимальной серии (шагов больше таргета подряд)
                        tempSeries = tempSeries + 1;
                        if (tempSeries > maxSeries) {
                            maxSeries = tempSeries;
                        }
                    } else {
                    tempSeries=0;
                }

                if (i!=29) {  // условия для постановки точки и перевода на след строку
                    System.out.print((i+1) + " день:" + monthToData[saveMonth - 1][i] + ", ");
                } else {
                    System.out.println((i+1) + " день:" + monthToData[saveMonth - 1][i] + ".");
                }
            }
            System.out.println("Общее количество шагов за месяц: " + sumSteps);  //вывод значений
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
            System.out.println("Среднее количество шагов: " + sumSteps/30);
            System.out.println("Пройденная дистанция: " + converter.convertDist(sumSteps) + " км"); // подсчет в классе Converter
            System.out.println("Количество сожжённых килокалорий " + converter.convertCCal(sumSteps)); // подсчет в классе Converter
            System.out.println("Лучшая серия: " + maxSeries);
        }
    }
    public void changeTargetSteps() {  // метод отвечающий за изменение целевого значения
        System.out.println("Текущее целовое значение шагов " + targetStepValue);
        System.out.println("Введите новое целовое значение шагов:");
        int newTargetStepValue = scanner.nextInt();
        if (newTargetStepValue < 0) { // проверка на корректность ввода
            System.out.println(notPlus);
        } else {
            targetStepValue = newTargetStepValue;
            System.out.println("Новое значение сохранено: " + targetStepValue);
        }
    }
}