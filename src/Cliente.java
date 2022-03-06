import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {

    protected String nome;
    protected Integer cpf;

    public Cliente(String nome, Integer cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente() {

    }


}
