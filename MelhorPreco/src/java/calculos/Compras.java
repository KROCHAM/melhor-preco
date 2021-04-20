/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author kyron_rocha
 */
@ManagedBean(name="compras")
public class Compras { 

    public String codigo;
    public int quantidade;    
    public float preco;  
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    public float precoFinal(){ 
        
        int qtd = this.getQuantidade();
        float desconto = 1; 
                
        if (this.getCodigo().equals("1")){ this.setPreco(3.49f);if(qtd>=3){desconto = 0.75f;}}
        
        if (this.getCodigo().equals("2")){ this.setPreco(7.20f);if(qtd>=6){desconto = 0.85f;}}
        
        if (this.getCodigo().equals("3")){this.setPreco(4.25f);desconto = 0.95f;}
        
        if (this.getCodigo().equals("4")){ this.setPreco(10.50f);if(qtd>=2){desconto = 0.70f;}}
        
        if (this.getCodigo().equals("5")){ this.setPreco(8.30f); desconto = 0.85f;}        
          
        float precoCarrinho = this.getPreco() * qtd * desconto;
        
         
        return precoCarrinho;
    }
    
    public String erro(){
        List<String> codigos = new ArrayList<>();
        codigos.add("1");
        codigos.add("2");
        codigos.add("3");
        codigos.add("4");
        codigos.add("5");
         if (codigos.contains(this.getCodigo())) {
            return "carrinho";
        }
        if(this.getQuantidade()<=0){
            return "erro";
        } 
        return "erro";
    }
    
    
    
    
}
