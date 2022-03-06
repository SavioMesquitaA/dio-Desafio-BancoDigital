public class ContaCorrente extends Contas{

    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("========== Extrato da Conta Corrente ==========");
        super.imprimirInforComuns();
    }
}
