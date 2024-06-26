import model.ConversaoMoeda;
import service.ConversorMoedas;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        boolean execucao = true;
        Scanner scanner = new Scanner(System.in);
        while (execucao) {
            Menu.exibirMenu();
            ConversorMoedas conversor = new ConversorMoedas();

            int opcao = Integer.parseInt(scanner.nextLine());

            System.out.println("Digite o valor a ser convertido: ");

            Double valor = Double.parseDouble( scanner.nextLine());

            switch (opcao) {
                case 1:
                    conversor.converter(valor, ConversaoMoeda.USD, ConversaoMoeda.ARS);
                    break;
                case 2:
                    conversor.converter(valor, ConversaoMoeda.ARS, ConversaoMoeda.USD);
                    break;
                case 3:
                    conversor.converter(valor, ConversaoMoeda.USD, ConversaoMoeda.BRL);
                    break;
                case 4:
                    conversor.converter(valor, ConversaoMoeda.USD, ConversaoMoeda.COP);
                    break;
                case 5:
                    conversor.converter(valor, ConversaoMoeda.COP, ConversaoMoeda.USD);
                    break;
                case 6:
                    conversor.converter(valor, ConversaoMoeda.ARS, ConversaoMoeda.BRL);
                    break;
                case 7:
                    execucao = false;
                    break;
            }
        }

    }
}
