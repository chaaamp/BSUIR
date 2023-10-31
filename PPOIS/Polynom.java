import java.util.Arrays;

// Определение класса Polynom
public class Polynom {
    //поля класса
    private int degree;
    private double[] coefficients;

    // Конструктор класса
    public Polynom(int degree, double[] coefficients) {
        // Проверка соответствия числа коэффициентов степени многочлена
        if (coefficients.length != degree + 1) {
            throw new IllegalArgumentException("Number of coefficients must match the degree of the polynomial");
        }

        // Инициализация полей объекта
        this.degree = degree;
        this.coefficients = coefficients.clone(); // Копирование массива коэффициентов
    }

    // Получение значения коэффициента по индексу
    public double getCoefficient(int index) {
        // Возвращение 0, если индекс невалиден
        if (index < 0 || index > degree) {
            return 0.0;
        }
        return coefficients[index];
    }

    // Вычисление значения многочлена для заданного аргумента
    public double evaluate(double x) {
        double result = 0.0;

        // Вычисление значения многочлена по схеме Горнера
        for (int i = degree; i >= 0; i--) {
            result += coefficients[i] * Math.pow(x, i);
        }

        return result;
    }

    // Сложение двух многочленов
    /*Определяется максимальная степень многочлена=результат сложения
      Создание массива для коэф. результата сложения
      Проход по степеням мночленов и добавление коэф. в массив
      Создание нового многочлена= this+other
      */
    public Polynom add(Polynom other) {
        int maxDegree = Math.max(this.degree, other.degree);
        double[] resultCoefficients = new double[maxDegree + 1];

        // Сложение коэффициентов многочленов
        for (int j = 0; j <= this.degree; j++) {
            resultCoefficients[j] += this.getCoefficient(j);
        }

        for (int j = 0; j <= other.degree; j++) {
            resultCoefficients[j] += other.getCoefficient(j);
        }

        // Создание нового многочлена с результатом сложения
        return new Polynom(maxDegree, resultCoefficients);
    }

    // Вычитание двух многочленов
    /* Та же процедура что и со сложением, только с вычитанием*/
    public Polynom subtract(Polynom other) {
        int maxDegree = Math.max(this.degree, other.degree);
        double[] resultCoefficients = new double[maxDegree + 1];

        // Вычитание коэффициентов многочленов
        for (int j = 0; j <= this.degree; j++) {
            resultCoefficients[j] += this.getCoefficient(j);
        }

        for (int j = 0; j <= other.degree; j++) {
            resultCoefficients[j] -= other.getCoefficient(j);
        }

        // Создание нового многочлена с результатом вычитания
        return new Polynom(maxDegree, resultCoefficients);
    }

    // Произведение двух многочленов
    /*степень результирующего многочлена=сумма степеней умножаемых
      Создание массива для коэффициентов результата умножения
      В каждой итерации внутреннего цикла коэффициенты умножаются и добавляются
      к соответствующему коэффициенту в массиве resultCoefficients
      Новый многочлен с результатом */
    public Polynom multiply(Polynom other) {
        int resultDegree = this.degree + other.degree;
        double[] resultCoefficients = new double[resultDegree + 1];

        // Умножение многочленов методом "каждый на каждый"
        for (int i = 0; i <= this.degree; i++) {
            for (int j = 0; j <= other.degree; j++) {
                resultCoefficients[i + j] += this.getCoefficient(i) * other.getCoefficient(j);
            }
        }

        // Создание нового многочлена с результатом произведения
        return new Polynom(resultDegree, resultCoefficients);
    }

    // Деление двух многочленов
    /*Определяются степени делимого и делителя
       Проверяется, что делитель не является нулевым многочленом, чтобы избежать деления на ноль.
       Проверяется, что степень делимого не меньше степени делителя.
       Если это так, возвращается новый полином с нулевой степенью и единственным коэффициентом, равным нулю.
       Создается массив для коэффициентов результата деления.
       Создается копия коэффициентов делимого, которая будет изменяться в процессе деления.
       Выполнение цикла пока степень делимого больше делителя.
       Определяется текущая степень результата деления.
       Вычисляется коэффициент, на который нужно умножить делитель для вычитания из делимого.
       Устанавливается соответствующий коэффициент в массиве результата.*/
    public Polynom divide(Polynom divisor) {
        int dividendDegree = this.degree;
        int divisorDegree = divisor.degree;

        // Проверка деления на ноль
        if (divisorDegree == 0 && divisor.getCoefficient(0) == 0) {
            throw new ArithmeticException("Division by zero");
        }

        // Проверка степени делимого
        if (dividendDegree < divisorDegree) {
            return new Polynom(0, new double[]{0.0});
        }

        double[] resultCoefficients = new double[dividendDegree - divisorDegree + 1];
        double[] remainderCoefficients = this.coefficients.clone();

        // Выполнение деления многочленов
        while (dividendDegree >= divisorDegree) {
            int currentDegree = dividendDegree - divisorDegree;
            double factor = remainderCoefficients[dividendDegree] / divisor.getCoefficient(divisorDegree);

            resultCoefficients[currentDegree] = factor;

            for (int i = 0; i <= divisorDegree; i++) {
                remainderCoefficients[currentDegree + i] -= factor * divisor.getCoefficient(i);
            }

            dividendDegree--;
        }

        // Удаление ведущих нулей в остатке
        int i = remainderCoefficients.length - 1;
        while (i >= 0 && remainderCoefficients[i] == 0) {
            i--;
        }

        // Создание нового многочлена с результатом деления
        if (i < 0) {
            return new Polynom(0, new double[]{0.0});
        } else {
            return new Polynom(i, Arrays.copyOf(remainderCoefficients, i + 1));
        }
    }

    // Оператор +=
    /*создание нового объекта
      Степень текущего многочлена (this) устанавливается равной степени созданного многочлена sum
      Ссылка на массив коэффициентов текущего многочлена (this) заменяется ссылкой на массив коэффициентов многочлена sum*/
    public void addInPlace(Polynom other) {
        // Выполнение сложения "на месте"
        Polynom sum = this.add(other);
        this.degree = sum.degree;
        this.coefficients = sum.coefficients;
    }

    // Оператор -=
    public void subtractInPlace(Polynom other) {
        // Выполнение вычитания "на месте"
        Polynom difference = this.subtract(other);
        this.degree = difference.degree;
        this.coefficients = difference.coefficients;
    }

    // Оператор *=
    public void multiplyInPlace(Polynom other) {
        // Выполнение умножения "на месте"
        Polynom product = this.multiply(other);
        this.degree = product.degree;
        this.coefficients = product.coefficients;
    }

    // Оператор /=
    public void divideInPlace(Polynom divisor) {
        // Выполнение деления "на месте"
        Polynom quotient = this.divide(divisor);
        this.degree = quotient.degree;
        this.coefficients = quotient.coefficients;
    }

    // Переопределение метода toString для удобного вывода
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            double coefficient = coefficients[i];
            if (coefficient != 0) {
                if (sb.length() > 0) {
                    sb.append(coefficient > 0 ? " + " : " - ");
                } else if (coefficient < 0) {
                    sb.append("-");
                }
                coefficient = Math.abs(coefficient);
                if (i > 1) {
                    sb.append(coefficient);
                    sb.append("x^");
                    sb.append(i);
                } else if (i == 1) {
                    sb.append(coefficient);
                    sb.append("x");
                } else {
                    sb.append(coefficient);
                }
            }
        }
        if (sb.length() == 0) {
            sb.append("0");  // Если многочлен нулевой
        }
        return sb.toString();
    }
}


