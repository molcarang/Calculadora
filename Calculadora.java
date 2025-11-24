import java.util.Scanner;

public class Calculadora {
    private static Scanner scanner;
    
    // Códigos ANSI para colores
    public static final String RESET = "\033[0m";
    public static final String CYAN = "\033[96m";
    public static final String GREEN = "\033[92m";
    public static final String YELLOW = "\033[93m";
    public static final String RED = "\033[91m";
    public static final String MAGENTA = "\033[95m";
    public static final String BLUE = "\033[94m";
    public static final String BOLD = "\033[1m";


    static {
        scanner = new Scanner(System.in);
    }

    public static void mostrarMenu() {
        int opcion = 0;
        
        do {
            System.out.println("\n" + CYAN + BOLD + "╔════════════════════════════════════╗");
            System.out.println("║        CALCULATOR - MENU           ║");
            System.out.println("╚════════════════════════════════════╝" + RESET);
            System.out.println(GREEN + "1." + RESET + " ➕ Add");
            System.out.println(GREEN + "2." + RESET + " ➖ Subtract");
            System.out.println(GREEN + "3." + RESET + " ✖️  Multiply");
            System.out.println(GREEN + "4." + RESET + " ➗ Divide");
            System.out.println(GREEN + "5." + RESET + " 🔢 Power");
            System.out.println(GREEN + "6." + RESET + " √  Square root");
            System.out.println(RED + "0." + RESET + " 🚪 Exit");
            System.out.println(CYAN + "────────────────────────────────────" + RESET);
            System.out.print(YELLOW + "Select an option: " + RESET);
            
            try {
            opcion = scanner.nextInt();
            procesarOpcion(opcion);
            } catch (Exception e) {
            System.out.println(RED + "❌ Error: Enter a valid number" + RESET);
            scanner.nextLine(); // Clear buffer
            }
            
        } while (opcion != 0);
        
        System.out.println("\n" + MAGENTA + BOLD + "¡Hasta luego! 👋" + RESET);
        scanner.close();
    }

    private static void procesarOpcion(int opcion) {
        double num1, num2, resultado;
        
        switch (opcion) {
            case 1:
                System.out.print(BLUE + "Ingrese el primer número: " + RESET);
                num1 = scanner.nextDouble();
                System.out.print(BLUE + "Ingrese el segundo número: " + RESET);
                num2 = scanner.nextDouble();
                resultado = sumar(num1, num2);
                System.out.println(GREEN + "✓ Resultado: " + RESET + num1 + " + " + num2 + " = " + BOLD + GREEN + resultado + RESET);
                break;
                
            case 2:
                System.out.print(BLUE + "Ingrese el primer número: " + RESET);
                num1 = scanner.nextDouble();
                System.out.print(BLUE + "Ingrese el segundo número: " + RESET);
                num2 = scanner.nextDouble();
                resultado = restar(num1, num2);
                System.out.println(GREEN + "✓ Resultado: " + RESET + num1 + " - " + num2 + " = " + BOLD + GREEN + resultado + RESET);
                break;
                
            case 3:
                System.out.print(BLUE + "Ingrese el primer número: " + RESET);
                num1 = scanner.nextDouble();
                System.out.print(BLUE + "Ingrese el segundo número: " + RESET);
                num2 = scanner.nextDouble();
                resultado = multiplicar(num1, num2);
                System.out.println(GREEN + "✓ Resultado: " + RESET + num1 + " × " + num2 + " = " + BOLD + GREEN + resultado + RESET);
                break;
                
            case 4:
                System.out.print(BLUE + "Ingrese el dividendo: " + RESET);
                num1 = scanner.nextDouble();
                System.out.print(BLUE + "Ingrese el divisor: " + RESET);
                num2 = scanner.nextDouble();
                try {
                    resultado = dividir(num1, num2);
                    System.out.println(GREEN + "✓ Resultado: " + RESET + num1 + " ÷ " + num2 + " = " + BOLD + GREEN + resultado + RESET);
                } catch (ArithmeticException e) {
                    System.out.println(RED + "❌ Error: " + e.getMessage() + RESET);
                }
                break;
                
            case 5:
                System.out.print(BLUE + "Ingrese la base: " + RESET);
                num1 = scanner.nextDouble();
                System.out.print(BLUE + "Ingrese el exponente: " + RESET);
                num2 = scanner.nextDouble();
                resultado = potencia(num1, num2);
                System.out.println(GREEN + "✓ Resultado: " + RESET + num1 + "^" + num2 + " = " + BOLD + GREEN + resultado + RESET);
                break;
                
            case 6:
                System.out.print(BLUE + "Ingrese el número: " + RESET);
                num1 = scanner.nextDouble();
                try {
                    resultado = raizCuadrada(num1);
                    System.out.println(GREEN + "✓ Resultado: " + RESET + "√" + num1 + " = " + BOLD + GREEN + resultado + RESET);
                } catch (ArithmeticException e) {
                    System.out.println(RED + "❌ Error: " + e.getMessage() + RESET);
                }
                break;
                
            case 0:
                // Salir
                break;
                
            default:
                System.out.println(RED + "❌ Opción inválida. Intente de nuevo." + RESET);
                break;
        }
    }

    // Operaciones matemáticas
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }

    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public static double raizCuadrada(double numero) throws ArithmeticException {
        if (numero < 0) {
            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
        }
        return Math.sqrt(numero);
    }
}
