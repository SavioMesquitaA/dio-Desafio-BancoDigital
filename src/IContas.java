import java.io.FileNotFoundException;

public interface IContas {

    void pagamento(String codigo, double valor) throws FileNotFoundException;

    void sacar(double valor);

    void depositar(double valor);

    void tranferir(double valor, Contas contaDestino);

    void imprimirExtrato();
}
