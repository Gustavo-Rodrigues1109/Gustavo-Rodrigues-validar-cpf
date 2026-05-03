# 📄 Validador de CPF em Java

Este projeto é um programa simples em Java que verifica se um CPF é válido utilizando a regra oficial de cálculo dos dígitos verificadores.

---

## 🚀 Funcionalidade

O programa:

1. Solicita ao usuário um CPF (apenas números).
2. Verifica se ele possui 11 dígitos.
3. Calcula os dois dígitos verificadores.
4. Compara com os dígitos informados.
5. Informa se o CPF é válido ou inválido.

---

## 🧠 Como funciona

Um CPF possui 11 dígitos:

* Os **9 primeiros** são a base
* Os **2 últimos** são chamados de **dígitos verificadores**

Esses dígitos são calculados usando:

* multiplicações com pesos decrescentes
* operação de módulo 11

---

## 💻 Código

```java
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
        
        // 1º dígito
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
        
        // 2º dígito
        soma = 0;
        
        for (int i = 0; i < 10; i++) {
            int num = CPF.charAt(i) - '0';
            soma += num * (11 - i);
        }
       
        resto = soma % 11;
        
        int digito2;
        
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
       
        // comparação
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
```

---

## ▶️ Como executar

1. Compile o código:

```
javac validar_cpf.java
```

2. Execute:

```
java validar_cpf
```

3. Digite um CPF com 11 números quando solicitado.

---

## ⚠️ Observações

* O programa aceita apenas números (sem pontos ou traços).
* Não valida CPFs com todos os dígitos iguais (ex: 11111111111).
* Ideal para fins de estudo e aprendizado de lógica em Java.

---

## 📚 Conceitos utilizados

* Entrada de dados com `Scanner`
* Estruturas de repetição (`for`)
* Condicionais (`if/else`)
* Operações matemáticas
* Manipulação de caracteres (`charAt`)

---

## 🛠️ Possíveis melhorias

* Aceitar CPF com formatação (ex: 123.456.789-09)
* Criar um método separado para validação
* Adicionar verificação de CPFs inválidos conhecidos
* Criar interface gráfica

---

## 👨‍💻 Autor

Gustavo Rodrigues

---

## 📌 Objetivo

Projeto desenvolvido com foco em aprendizado de lógica de programação e fundamentos da linguagem Java.
