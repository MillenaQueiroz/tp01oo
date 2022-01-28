package trabalho_um;

import java.util.Scanner; 
import java.util.Random;


public class jogo {
	
    public static void main(String[] args) {
    	
    	Scanner ler = new Scanner(System.in);
    	Random random = new Random();
    	
    	String temas[][] = new String[50][50];
    	
    	String pesquisa = " ";
    	int col=1;
    	int opc=0;
    	int opc_tema = 0;
    	int opc_palavra=0;
    	int i = 0;
    	String saida = "0";
    	boolean verif1=false;
    	
    
    	
    	while(true) {
    	System.out.println("1.Gerenciar temas\n 2.Gerenciar palavras\n 3.Jogar\n 4.Sair\n");
    	opc = ler.nextInt();
    	
    	int index;
		switch (opc) {
    	case 1:
    		System.out.println("1.Cadastrar tema\n 2.Excluir tema\n 3.Buscar tema");
        	opc_tema = ler.nextInt();
        	
        	switch(opc_tema) {
        	case 1:
        		//C A D A S T R A R
        		String nomeTema = " ";
            	
        		do {
        		    
            		System.out.println("Digite o nome do tema (para sair digite 0)");
            		nomeTema = ler.next(); 
            		if(jaExiste(temas,nomeTema,i)) {
            			System.out.println("Esse tema já existe!");
            		}else {
	            		if(nomeTema.equals(saida)) {
	            			verif1=true;
	            		}else {
	            		temas[0][i]=nomeTema;
	            		
	            		i++;
	            		}
            		}
            		
        			
            	}while(!verif1);
        		
        		break;
        	case 2:
        		
        		//E X C L U I R
        		String temaExcluido;
        		boolean verif2=false;
        		int size=i;
        		System.out.println("Digite o tema que deseja excluir: ");
        		temaExcluido = ler.next();
        		for(int c = 0; c<size; c++) { 
        			if(temas[0][c].equals(temaExcluido)) { 
        				verif2 = true; 
        				System.out.println("Tema deletado com sucesso!");
        				temas[0][c] = " ";
        				size--;
        			}
        		}
        		
        		if(!verif2) {
        			System.out.println("Esse tema não está cadastrado!");
        		}
        		
        		break;
        	case 3:
        		//B U S C A R
        		int index1=0;
        		System.out.println("Digite o tema a ser pesquisado");
        		pesquisa = ler.next();
        		buscar(temas,pesquisa, i, index1);
        		
        		break;
        	default:
        		System.out.print("entrada invalida");
        	}
        	
    		break;
    		
    	case 2:
    		System.out.println("1.Cadastrar palavra\n 2.Excluir palavra\n 3.Buscar palavra\n 4.Listar palavras");
        	opc_palavra = ler.nextInt();
    		switch(opc_palavra) {
    		
	        	case 1:
	        		
		    		int index2=0;
		    		String escolhaTema, palavra;
		    		boolean verifiq=false;
		    	
		    		
		    		System.out.println("Digite o tema a ser escolhido:");
		    		escolhaTema=ler.next();
		    		
		    		//BUSCANDO TEMA
		    		boolean foi_encontrado = false;
		        	
		        	for(int c=0;c<i;c++) {
		        		if(temas[0][c].equals(escolhaTema)) {
		        			index2=c;
		        			foi_encontrado=true;
		        		}
		    		}
		        	if(!foi_encontrado) {
		        		System.out.println("Tema não encontrado!");
		        	}
		        	
		        	boolean existePalavra=false;
		        	
		    		do {
	        		    
		    			System.out.println("Digite a palavra que deseja cadastrar (para sair digite 0):");
			    		palavra=ler.next();
			    		
			    		existePalavra=jaExistePalavra(temas,palavra,index2,col);
	            		if(existePalavra) {
	            			System.out.println("Essa palavra já existe!");
	            		}else {
		            		if(palavra.equals(saida)) {
		            			verifiq=true;
		            		}else {
		            		temas[col][index2]=palavra;
		            		col++;
		            		}
	            		}
	            		
	            	}while(!verifiq);
		    		
		        break;
		        
	        	case 2:
	        		//excluir palavra
	        		System.out.println("Digite a palavra que deseja excluir: ");
	        		palavra=ler.next();
	        		excluirPalavra(temas,palavra,col,i);
		    	break;
	        	case 3:
	        		//encontrar palavra
	        		System.out.println("Digite a palavra que deseja buscar: ");
	        		palavra=ler.next();
	        		encontrarPalavra(temas,palavra,col,i);
	        	break;
	        	case 4:
	        		//listar palavras do tema
	        		String temaLista;
	        		System.out.println("Digite o tema que deseja listar: ");
	        		temaLista=ler.next();
	        		int index4=0;
	        		buscarTema(temas,temaLista, i, index4,col);
	        	break;
	        	
	        	
    		}
		    	
		    	
				break;
        	
    	case 3:
    			
    			if(pesquisa != "0") {
    				pesquisa=pegarTema(temas, i,col,ler);
    			}
        		
    		
    		
        	break;
    	case 4:
    		
    		String aux;
    		
    		
    		for (int c = 0; c < i; c++){
    			
                for (int l = 0; l < col; l++){
                	aux=temas[l][c];
                	if(aux != null) {
                		System.out.print(temas[l][c] +"\t");
                	}
                
                }
                
                
            System.out.println();
            }
    		
    		System.out.println("Até a próxima!");
    		System.exit(0);
    		
    		break;
    	
     
    	default:
    		
    		System.out.print("entrada invalida!");
    	}
    	
    	}
    }
    
    public static void buscar( String temas[][], String pesquisa, int i,int index) {
    	boolean foi_encontrado = false;
    	
    	for(int c=0;c<i;c++) {
    		if(temas[0][c].equals(pesquisa)) {
    			System.out.println("Tema encontrado na linha "+c);
    			index=c;
    			foi_encontrado=true;
    		}
		}
    	if(!foi_encontrado) {
    		System.out.println("Tema não encontrado!");
    	}
    	
    
    }
    
    public static void buscarTema( String temas[][], String pesquisa, int i,int index,int col) {
    	boolean foi_encontrado = false;
    	String aux;
    	
    	for(int c=0;c<i;c++) {
    		if(temas[0][c].equals(pesquisa)) {
    			System.out.println("Tema encontrado na linha "+c);
    			index=c;
    			foi_encontrado=true;
    		}
		}
    	if(!foi_encontrado) {
    		System.out.println("Tema não encontrado!");
    	}else {
    		 for (int l = 0; l < col; l++){
 	           	aux=temas[l][index];
 	           	if(aux!=null) {
 	           		
 	           			System.out.println(aux);
 	           		
 	           	}
 	           	
            }
    	}
    	
    
    }
    
   
    
    
    public static boolean jaExiste( String temas[][], String pesquisa, int i) {
    	
    	for(int c=0;c<i;c++) {
    		
    		if(temas[0][c].equals(pesquisa)){
    			return true;
    		}
		}
		return false;
	
    }
    
   public static boolean jaExistePalavra( String temas[][], String pesquisa, int index,int col) {
	   String aux;
	   
           for (int l = 0; l < col; l++){
	           	aux=temas[l][index];
	           	if(aux!=null) {
	           		if(aux.equals(pesquisa)){
	           			
	           			return true;
	           		}
	           	}
	           	
           }
           return false;
	   
    }
   
   public static void excluirPalavra( String temas[][], String pesquisa, int col, int i) {
	   String aux;
	   boolean encontrou=false;
		
		for (int c = 0; c < i; c++){
           for (int l = 0; l < col; l++){
           	aux=temas[l][c];
           	if(aux != null) {
           		if(aux.equals(pesquisa)){
           			encontrou=true;
           			temas[l][c]=null;
           		}
           	}
           
           }
           
       }
		if(!encontrou) {
			System.out.println("Palavra não encontrada!");
		}
	   
    }
   
   public static void encontrarPalavra( String temas[][], String pesquisa, int col, int i) {
	   String aux;
	   boolean encontrou=false;
	   int indiceTema;
		
		for (int c = 0; c < i; c++){
           for (int l = 0; l < col; l++){
           	aux=temas[l][c];
           	if(aux != null) {
           		if(aux.equals(pesquisa)){
           			encontrou=true;
           			indiceTema=l;
           			System.out.println("Palavra encontrada no tema "+temas[0][c]);
           		}
           	}
           
           }
           
       }
		if(!encontrou) {
			System.out.println("Palavra não encontrada!");
		}
	   
    }
   
   public static String pegarTema( String temas[][], int i,int col, Scanner ler) {
	 Random random = new Random();
   	boolean foi_encontrado = false;
   	//String sorteada;
   	String pesquisa = " ";
   	do {
   	
   	int index=0;
	
	
	System.out.println("Bem vinda ao jogo da forca! Para prosseguir escolha um tema (digite 0 para sair): ");
	pesquisa = ler.next();
	
   	if(pesquisa == "0") {
   		return pesquisa;
   		//break;
   	}
   	boolean acabouVidas = false;
	   	for(int c=0;c<i;c++) {
	   		if(temas[0][c].equals(pesquisa)) {
	   			foi_encontrado = true;
	   			index=c;
	   			
	   		}
		}
	   	if(!foi_encontrado) {
	   		System.out.println("Tema não encontrado!");
	   		break;
	   	}else {
	   		if(pesquisa != "0") {
		   		String aux;
		   		String forca=" ";
		   		String letrasEscolhidas=" ";
		   		
		   		char letra;
		   		int vidas=5;
		   		int indiceSort = random.nextInt(col);
		   		
		   		aux = temas[indiceSort][index];
		   		if(aux == null) {
		   			indiceSort = random.nextInt(col);
		   	   		aux = temas[indiceSort][index];
		   		}
		   		for (int l = 0; l < aux.length(); l++){
		   			
			         forca+="_";
			         for(int tent=0; ;tent++) {
			        	
			        	 if(vidas<1) {
			        		 if(!acabouVidas) {
			        			 System.out.println("------------------------------------------");
			        			 System.out.println(" ");
			        			 System.out.println("Você perdeu! \n");
			        			 System.out.println(" ");
				        		 System.out.println("------------------------------------------");
				        		 acabouVidas=true;
				        		 return pesquisa;
			        		 }
			        		 
			        		 break;
			        	 }
			        	 
			        	 System.out.print(forca);
			        	 System.out.println("\nDigite uma letra (você tem "+vidas+" vidas)\n");
			        	 letra = ler.next().charAt(0);
			        	 if(letrasEscolhidas.indexOf(letra)>=0) {
			        		 System.out.println("Teste outra letra!");
			        	 }else {
			        		 letrasEscolhidas+=letra;
			        		 if(aux.indexOf(letra)>=0) {
			        			 forca=" ";
			        			 for(int k=0;k<aux.length();k++) {
			        				 forca+=letrasEscolhidas.indexOf(aux.charAt(k)) >= 0 ? aux.charAt(k) : "_";
			        				 
			        				 }
			        			 if(forca.contains("_")) {
			        				 System.out.println("Essa letra existe na palavra!");
			        			 }else {
			        				 System.out.println("------------------------------------------");
				        			 System.out.println(" ");
			        				 System.out.println("Parabéns! Você acertou a palavra! Deseja jogar novamente?");
			        				 System.out.println(" ");
			        				 System.out.println("------------------------------------------");
			        				 return pesquisa;
			        				 
			        			 }
			        			 break;
			        		 }else {
			        			 vidas--;
			        			 System.out.println("Opa, essa letra não existe na palavra! Você agora tem "+vidas+" vidas");
			        		 }
			        	 }
			         }
		        }
		   		
	   	}
		   	}
	   	
   		}while(pesquisa != "0");
	return pesquisa;
   }
  }
    