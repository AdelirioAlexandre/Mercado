package Mercado2.Model;
import java.util.ArrayList;
public class Crud{
    private static ArrayList<Produto> pro = new ArrayList<Produto>();

    //Metodos de editar produto
    public static boolean editaNome(Produto numero_d, String novoNome){
        String nomeOriginal = numero_d.getNome(); //Pegando o nome original antes da troca
        numero_d.setNome(novoNome);//Realizando a troca
        String nomeAlterado = numero_d.getNome();//Pegando o novo nome para verifica
        return nomeOriginal != nomeAlterado;// Se o valor for diferente ira me retorna true, se não false
    }
    public static boolean editaPreco(Produto numero_d, double novoPreco){
        double precoOriginal = numero_d.getPreco();
        numero_d.setPreco(novoPreco);
        double precoAlterdo = numero_d.getPreco();
        return precoOriginal != precoAlterdo;
    }
    public static boolean editaPeso(Produto numero_d, double novoPeso){
        double pesoOriginal = numero_d.getPeso();
        numero_d.setPeso(novoPeso);
        double pesoAlterado = numero_d.getPeso();
        return pesoOriginal != pesoAlterado;
    }

    //Metodo lista
    public static boolean listaProduto(String lista){
        if(pro.size() > 0){
            return false; //ArrayList vazio
        }else{
            return true; //ArrayList cheio
        }
    }
    
}