import lombok.Setter;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@Getter @Setter
public abstract class Contas implements IContas{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int num_conta;
    protected double saldo;
    protected Cliente cliente;

    public Contas(Cliente cliente){
        this.agencia = Contas.AGENCIA_PADRAO;
        this.num_conta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    //Seria bem melhor se pudesse fazer isso com banco dados e não em um aquivo interno
    @Override
    public void pagamento(String codigo, double valor) throws FileNotFoundException {
        String local = "/home/savio_mesquita/IdeaProjects/Banco/src/boletosDeTeste/teste.txt";
        Scanner scanner = new Scanner(new FileReader(local));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] linha = line.split(" ");

            if (linha[0].equals(codigo)){
                saldo -= valor;
                System.out.println(saldo);
            }else {
                System.out.println("Error. O código não corresponde ao do boleto em aberto");
            }
        }
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void tranferir(double valor, Contas contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInforComuns(){
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d Conta: %d", agencia, num_conta));
        System.out.println(String.format("Saldo:__________ %.2f", saldo));
    }

}
