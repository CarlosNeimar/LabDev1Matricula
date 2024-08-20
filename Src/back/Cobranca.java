package back;
import java.util.Objects;

public class Cobranca {
  private String nome;
  private int []Cobranca;

  public Cobranca() {
  }

  public Cobranca(String nome, int[] Cobranca) {
    this.nome = nome;
    this.Cobranca = Cobranca;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int[] getCobranca() {
    return this.Cobranca;
  }

  public void setCobranca(int[] Cobranca) {
    this.Cobranca = Cobranca;
  }

  public Cobranca nome(String nome) {
    setNome(nome);
    return this;
  }

  public Cobranca Cobranca(int[] Cobranca) {
    setCobranca(Cobranca);
    return this;
  }
  
  public void gerarcobranca(){

  }
}
