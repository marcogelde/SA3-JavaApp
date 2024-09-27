import java.util.Scanner;

public class CalculadoraDeTroco {

    // Array com as notas e moedas
    private static final double[] notasMoedas = {100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 0.50, 0.25, 0.10, 0.05, 0.01};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor Total das Compras: R$ ");
        double valorCompra = sc.nextDouble();

        System.out.print("Valor Recebido: R$ ");
        double valorRecebido = sc.nextDouble();

        // Verificar se o valor recebido é maior ou igual o da compra
        if (valorRecebido >= valorCompra) {
            double troco = valorRecebido - valorCompra;
            System.out.printf("Troco: R$ %.2f\n", troco);

            calcularTroco(troco);
        } else {
            System.out.println("Valor recebido é menor que o valor da compra.");
        }

        sc.close();
    }

    private static void calcularTroco(double troco) {
        for (double valor : notasMoedas) {
            int quantidade = (int) (troco / valor);
            if (quantidade > 0) {
                if (valor >= 1.00) {
                    System.out.printf("%d Nota(s) de R$ %.2f\n", quantidade, valor);
                } else {
                    System.out.printf("%d Moeda(s) de R$ %.2f\n", quantidade, valor);
                }
                troco -= quantidade * valor;
            }
        }
    }
}
