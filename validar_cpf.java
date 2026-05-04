import java.util.Scanner;

public class validar_cpf
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o seu CPF(somente números): ");
	    String CPF = sc.nextLine();
	    
	    if (CPF.length() != 11) {
	       System.out.println("CPF invalido!");
	        return;
	    } 
	    
	    // verifica o primeiro digito
	    int soma = 0;
	    
	    for (int i = 0; i < 9; i++) {
	        int num = CPF.charAt(i) - '0';
	        soma += num * (10 - i);
	    }
	        
	    int resto = soma % 11;
	    int digito1;
	        
	    if (resto < 2) {
	        digito1 = 0;
	    } else {
	        digito1 = 11 - resto;
	    }
	        
	    // verifica o segundo digito
	    soma = 0;
	    
	    // usa os 9 primeiros numeros
	    for (int i = 0; i < 9; i++) {
	        int num = CPF.charAt(i) - '0';
	        soma += num * (11 - i);
	    }
	    
	    // usa o digito1 calculado
	    soma += digito1 * 2;
	   
	    resto = soma % 11;
	    
	    int digito2;
	        
	    if (resto < 2) {
	        digito2 = 0;
	    } else {
	        digito2 = 11 - resto;
	    }
	   
	    // pega o decimo e o decimo primeiro numero
	    int ultimo1 = CPF.charAt(9) - '0';
	    int ultimo2 = CPF.charAt(10) - '0';
	    
	    if (digito1 == ultimo1 && digito2 == ultimo2) {
	        System.out.println("CPF válido!");
	    } else {
	        System.out.println("CPF inválido!");
	    }
	    
	    sc.close();
	}
}
