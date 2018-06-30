/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho;

/**
 *
 * @author Vitor Reis
 */
public class Controlador {
    AdicionarProduto chAdc;
    AlterarProduto chAlt;
    RemoverProduto chRmv;
    public Controlador(){
        chAdc = new AdicionarProduto();
        chAlt = new AlterarProduto();
        chRmv = new RemoverProduto();
    }
    
    public void adicionarProduto(int iD, String nome, double preco){
        chAdc.adicionar(iD, nome, preco);
    } 
    public void alterarPruduto(int iD, String nome, double preco){
        chAlt.alterar(iD, nome, preco);
    }
    public void removerProduto(int iD){
        chRmv.remover(iD);
    }
}
