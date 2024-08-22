package back.sistema;

public class Endereco {
  private String rua;
  private String cidade;
  private String estado;
  private String cep;
  private String pais;

  // Getters and Setters
  public Endereco() {
  }
  public String getRua() {
    return this.rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return this.estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getPais() {
    return this.pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

}
