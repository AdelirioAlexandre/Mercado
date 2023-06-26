package Mercado2.View;
import Mercado2.Model.Crud;
import Mercado2.Model.Produto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Mercado {
    private static  ArrayList<Produto> pro = new ArrayList<Produto>();
    public static void main(String[] args) {
        Produto carne = new Produto("Carne", 50, "Mercearia", 2, 0);
        pro.add(carne);
        Mercado.menuFuncionario();
    }

    public static void menuFuncionario(){
        String[] opcao = {"Cadastra Produto", "Listar Produto", "Editar produto", "Deletar produto", "Gerar arquivo TXT"};

        int resposta = JOptionPane.showOptionDialog(null, "O que voce deseja  ?", "Menu funcionario",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

        switch (resposta) {
            case 0:
                Mercado.cadastraProduto();
                break;
            case 1:
                Mercado.listaProduto();
                break;
            case 2:
                Mercado.editarProduto();
                break;
            case 3:
                Mercado.deletarProduto();
                break;
            case 4:
                Mercado.gerarTxt(pro);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    //Cadastra
    public static void cadastraProduto(){// 31 linha
        String[] opcao2 = {"Mercearia", "Limpeza", "Higiene", "Bebida"};
        String nome = JOptionPane.showInputDialog(null, "Informe o nome do produto ?");
        if(nome == null || nome.isEmpty()){//Verificando se a pessoa clicou em cancelar
            Mercado.menuFuncionario();
        }
        String preco_o = JOptionPane.showInputDialog(null, "Informe o preço ?");
        if(preco_o == null || preco_o.isEmpty()){
            Mercado.menuFuncionario();
        }
        double preco = Integer.parseInt(preco_o);
        String peso_o = JOptionPane.showInputDialog(null, "Informe o peso/volume ?");
        if(peso_o == null || peso_o.isEmpty()){
            Mercado.menuFuncionario();
        }
        double peso = Integer.parseInt(peso_o);
        int resposta2 = JOptionPane.showOptionDialog(null, "Qual o tipo do produto ?", "Menu funcionario",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao2, opcao2[0]);
        String tipo = "";
        if(opcao2[resposta2].equals("Mercearia")){
            tipo = "Mercearia";
        }else if(opcao2[resposta2].equals("Limpeza")){
            tipo = "Limpeza";
        }else if(opcao2[resposta2].equals("Higiene")){
            tipo = "Higiene";
        }else if(opcao2[resposta2].equals("Bebida")){
            tipo = "Bebida";
        }
        Produto produto = new Produto(nome, preco, tipo, peso, 0);
        pro.add(produto);
        JOptionPane.showMessageDialog(null, "Produto foi cadastrado com sucesso !");
        Mercado.menuFuncionario();
    }

    //Lista
    public static void listaProduto(){
        if(Mercado.pro.size() > 0){
            for(int i = 0; i < pro.size(); i++){
                JOptionPane.showMessageDialog(null, pro.get(i));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não existe produto cadastrado !");
        }
        Mercado.menuFuncionario();
    }

    //Editar
    public static void editarProduto(){// 56 linhas
        String numero_o = JOptionPane.showInputDialog(null, "Digite o codigo do produto !");
        if(numero_o == null || numero_o.isEmpty()){
            Mercado.menuFuncionario();
        }
        int numero = Integer.parseInt(numero_o);
        Produto numero_d = Mercado.buscaProdutoPorNumero(numero);
        if(numero_d != null){
            int opcao = 0;
            do{
                String[] opcao2 = {"Nome", "Preço", "Peso", "Voltar"};
                int resposta = JOptionPane.showOptionDialog(null, "Produto: " +numero_d.getNome(), "Menu funcionario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao2, opcao2[0]);
                if(opcao2[resposta].equals("Nome")){
                    String novoNome = JOptionPane.showInputDialog("Qual o novo nome ?");
                    if(novoNome == null || novoNome.isEmpty()){
                        Mercado.menuFuncionario();
                    }
                    boolean n = Crud.editaNome(numero_d, novoNome);
                    if(n == true){
                        JOptionPane.showMessageDialog(null, "O nome foi trocado com sucesso !!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Errou ao trocar o nome do produto !");
                    }
                }else if(opcao2[resposta].equals("Preço")){
                    String novoPrco_o = JOptionPane.showInputDialog("Qual o novo preço ?");
                    if(novoPrco_o == null || novoPrco_o.isEmpty()){
                        Mercado.menuFuncionario();
                    }
                    double novoPreco = Integer.parseInt(novoPrco_o);
                    boolean n = Crud.editaPreco(numero_d, novoPreco);
                    if(n == true){
                        JOptionPane.showMessageDialog(null, "O preço foi trocado com sucesso !!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Errou ao trocar o preço do produto !");
                    }
                }else if(opcao2[resposta].equals("Peso")){
                    String novoPeso_o = JOptionPane.showInputDialog("Qual o novo peso ?");
                    if(novoPeso_o == null || novoPeso_o.isEmpty()){
                        Mercado.menuFuncionario();
                    }
                    double novoPeso = Integer.parseInt(novoPeso_o);
                    boolean n = Crud.editaPeso(numero_d, novoPeso);
                    if(n == true){
                        JOptionPane.showMessageDialog(null, "O peso foi trocado com sucesso !!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Errou ao trocar o peso do produto !");
                    }
                }else if(opcao2[resposta].equals("Voltar")){
                    Mercado.menuFuncionario();
                }
            }while(opcao != 0);
        }else{
            JOptionPane.showMessageDialog(null, "O codigo informado não existe !");
        }
        Mercado.menuFuncionario();
    }

    //Deletar
    public static void deletarProduto(){
        String nome = JOptionPane.showInputDialog(null, "Informe o codigo do produto para ser deletado !");
        if(nome == null || nome.isEmpty()){
            Mercado.menuFuncionario();
        }
        int numero = Integer.parseInt(nome);
        Produto numero_d = buscaProdutoPorNumero(numero);
        if(numero_d != null){
            String[] opcao = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(null, "Deseja remover o produto: " +numero_d.getNome(), "Menu funcionario",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
            if(opcao[resposta].equals("Sim")){
                pro.remove(numero_d);
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso !");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Codigo invalido !");
        }
        Mercado.menuFuncionario();
    }

    //TXT
    public static void gerarTxt(ArrayList<Produto>pro){//13 linhas
        try {
            String nomeArquivo = JOptionPane.showInputDialog(null, "Qual sera o nome do arquivo");
            FileWriter arquivo = new FileWriter(nomeArquivo+".txt");
            BufferedWriter gravador = new BufferedWriter(arquivo);
            for(Produto produto : Mercado.pro){
                gravador.write(produto.toString());
            }
            gravador.close();
            JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gera arquivo");
        }
        Mercado.menuFuncionario();
    }

    //Busca
    public static Produto buscaProdutoPorNumero(int numero){// 9 linhas
        Produto c = null;
        if(Mercado.pro.size() > 0){
            for(Produto produto : Mercado.pro){
                if(produto.getCodigo() == numero){
                    c = produto;
                }
            }
        }
        return c;
    }
}