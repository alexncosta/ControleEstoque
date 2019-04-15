package br.com.pitagoras.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.pitagoras.entity.*;

public class ItemDao {
	
	public String path = "C:\\Users\\1622847\\git\\repository\\ControleEstoqueWeb\\WebContent\\FilesDatabase\\ItensDatabase";

	public int insertItem(Item item) {

		String itemData;
		
		try {
			FileWriter arq = new FileWriter(path);
			PrintWriter write = new PrintWriter(arq);
			
			itemData = item.getCodigo() 	+ "|" + 
					   item.getDescricao()  + "|" + 
					   item.getFornecedor() + "|" + 
					   item.getMarca() 		+ "|" + 
					   item.getQuantidade() + "|" + 
					   item.getDataVencimento();
			
			write.println(itemData);
			write.close();
		}
		catch(IOException ex) {
			
		}
		
		return 0;
	}

	public int geraCodigo() {
		
		String linha;
		String[] codAnterior;
		int codigo = 1;
		
		try {
			FileReader rd = new FileReader(path);
			BufferedReader brd = new BufferedReader(rd);
			linha = brd.readLine();
			
			while(brd.ready()) {
				linha = brd.readLine();
			}
			
			if (linha != null) {
				codAnterior = linha.split("|");
				codigo = Integer.parseInt(codAnterior[0]) + 1;
			}
			rd.close();
		}
		catch(IOException ex) {
			
		}
		
		return codigo;
	}
}
