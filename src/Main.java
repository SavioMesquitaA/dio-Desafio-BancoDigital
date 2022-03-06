import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Contas contaCorrente = new ContaCorrente(cliente);
        Contas contaPoupanca = new ContaPoupanca(cliente);

        String nome = sc.next();
        int operacao;
        long cpf = sc.nextLong();
        String codigo;
        double valor;

        cliente.setNome(nome);
        cliente.setCpf((int) cpf);

        System.out.println("Que operação deseja fazer?\n"+
                "1 - Saque;\n" +
                "2 - Deposito;\n" +
                "3 - Tranferencia;\n" +
                "4 - Pagamento.");
        operacao = sc.nextInt();
        contaCorrente.depositar(200);
        switch (operacao){
            case 1: valor = sc.nextDouble();
                    contaCorrente.sacar(valor);
                    break;

            case 2: valor = sc.nextDouble();
                    contaCorrente.depositar(valor);
                    break;
            case 3: valor = sc.nextDouble();
                    contaCorrente.tranferir(valor, contaPoupanca);
                    break;
            case 4: valor = sc.nextDouble();
                    codigo = sc.next();
                    contaCorrente.pagamento(codigo, valor);
                    break;
            default:
                System.out.println("Opção invalida!!!");

        }

        contaCorrente.imprimirExtrato();
    }

}

