package Mercado2.Model;
public class Produto {
    private String nome, tipo;
    private double preco, peso;
    private int codigo;
    public static int contador = 1;
    
    public Produto(String nome, double preco, String tipo, double peso, int codigo) {
        this.codigo = Produto.contador;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.peso = peso;
        Produto.contador += 1;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String toString(){
        return 
        "=========================" +"\n" +
        "=====   Produto: " + getNome() +"   =====" + "\n" +
        "- Codigo: " + getCodigo() + "\n" +
        "- Tipo: " + getTipo() + "\n" +
        "- Peso: " + getPeso() + "\n" +
        "- Preço: R$" + getPreco() + "\n" +
        "=========================";
    }
}

