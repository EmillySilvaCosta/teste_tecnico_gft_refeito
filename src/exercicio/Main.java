package exercicio;

import java.text.DecimalFormat;
import java.util.Scanner;

class Pessoa {
	int idade;
	float altura;
	float peso;
}

public class Main {

	public static void main(String[] args) {
		// aqui seleciono qual das questoes quero que apareça
		Questao1();
		// Letras();
		// Mercadinho();
		// Vogal();

	}

//#questao01

	public static void Questao1() {
		// Temos 10 pessoas(Temos que ter pessoa-> criar classe Pessoa) -ok
		int max = 10;

		Pessoa[] pessoas = new Pessoa[max];
		Scanner entrada = new Scanner(System.in);
		int countPessoa50 = 0;
		float sumAltura = 0;
		int countPessoasCom10e20 = 0;
		int countPessoaPeso40 = 0;

		// Para cada pessoa( significa que é um loop)
		for (int i = 0; i < max; i++) {
			// a variavel pessoas do tipo pesso recebe um novo construtor padrao
			Pessoa pessoa = new Pessoa();
			// Pedir ao usuário 3 coisas: idade,altura,peso(pessoa tem que ter esses
			// atributos)-ok
			System.out.println("Digite a idade:");
			pessoa.idade = entrada.nextInt();
			System.out.println("Digite a altura:");
			pessoa.altura = entrada.nextFloat();
			System.out.println("Digite a peso:");
			pessoa.peso = entrada.nextFloat();

			// Se pessoa tem mais de 50 anos de idade-ok
			if (pessoa.idade > 50) {
				// quero contá-la
				countPessoa50 = countPessoa50 + 1;
			}
			// Se pessoa tem entre 10 e 20 anos
			if (pessoa.idade >= 10 && pessoa.idade <= 20) {
				// quero a média da altura entre elas
				countPessoasCom10e20++;
				sumAltura = sumAltura + pessoa.altura;
			}
			// Se pessoa tem peso inferior a 40kg
			if (pessoa.peso < 40) {
				// quero saber a porcentagem total delas
				// tenho que saber quantas pessoas com mais de 40kg tenho
				countPessoaPeso40++;
			}
			
		}
		System.out.println();
		System.out.println("Pessoas com mais de 50 anos: "+countPessoa50);
		System.out.println("media da altura entre 10 e 20 anos: "+sumAltura / countPessoasCom10e20);
		System.out.println("Porcentagem das pessoas com menos de 40kg: "+((float)(countPessoaPeso40 *100)/10)  + "%");
	}

	// #questao02
	public static void Letras() {

		Scanner entrada = new Scanner(System.in);
		char l1, l2;
		System.out.println("Digite uma letra:");
		// obtendo um caracter a partir da entrada(do tipo char)
		l1 = entrada.next().charAt(0);
		System.out.println("Digite outra letra:");
		// por ser do tipo char recebe tanto letra minuscula como maiuscula
		l2 = entrada.next().charAt(0);
		// na tabela ascii a é menor que b, logo se a for maior que b nao esta em ordem
		if (l1 > l2) {
			System.out.println("Não está em ordem alfabetica!");
		} else {
			// aqui ele pega o valor de z(por exemplo) e vai subtrair o valor de a, ou seja(
			// z = 122, a =97)
			// z-a = 25 +1 = 26(seguido alfabeto americano), tenho o total de letras do
			// alfabeto
			System.out.println((l2 - l1) + 1);
		}
	}

	// #questao03
	public static void Mercadinho() {
		Scanner entrada = new Scanner(System.in);
		// criando array com os valores informados
		// cedulas que tenho disponiveis
		int cedulasDisp[] = { 100, 50, 10, 5, 1 };
		// moedas disponiveis
		float moedasDisp[] = { 0.5f, 0.10f, 0.05f, 0.01f };
		int menorCedula = 1;
		float menorMoeda = 0.1f;
		float valorASerPago = 0;
		float valorRecebido = 0;
		int menorNumeroCedulas = 0, menorNumeroMoedas = 0;

		System.out.println("Digite o valor entregue:");
		// recebendo os valores digitados
		valorRecebido = entrada.nextFloat();
		System.out.println("Digite o valor total da compra:");
		valorASerPago = entrada.nextFloat();
		DecimalFormat frmt = new DecimalFormat("0.00");
		// se o valor recebido for menor ao que deve ser pago, preiso de troco
		if (valorRecebido < valorASerPago) {
			float troco = valorRecebido - valorASerPago;
			System.out.println("Troco a ser pago R$" + frmt.format(troco));
			// #cedula
			// enquanto o troco for maior ou igual a menor cedula

			while (troco >= menorCedula) {
				//vou percorrer em todas as cedulas disponiveis
				for (int i = 0; i < cedulasDisp.length; i++) {
					//cedulas disponiveis na posicao i é igual a cedula atual
					int cedulaAtual = cedulasDisp[i];
					if (troco / cedulaAtual >= 1f) {
						int numCedulas = (int) troco / cedulaAtual;
						System.out.println("R$" + cedulaAtual + ".00 x " + numCedulas + "nota");
						troco = troco - cedulaAtual * numCedulas;
						menorNumeroCedulas += numCedulas;
					}
				}
			}
			// #moeda
			while (troco >= menorMoeda) {
				for (int j = 0; j < moedasDisp.length; j++) {
					float moedaAtual = moedasDisp[j];
					if (troco / moedaAtual >= 1f) {
						int numMoedas = (int) (troco / moedaAtual);
						System.out.println("R$" + frmt.format(moedaAtual) + " x " + numMoedas + "centavos");
						troco = troco - moedaAtual * numMoedas;
						menorNumeroMoedas += numMoedas;
					}
				}
			}

			System.out.println("Num Cedulas: " + menorNumeroCedulas + " Num Moedas: " + menorNumeroMoedas);
		}
	}

	// #questao04
	public static void Vogal() {
		Scanner entrada = new Scanner(System.in);
		char letra;
		// recebo uma letra
		System.out.println("Digite uma letra:");
		// guardo a letra
		letra = entrada.next().charAt(0);
//comparo, se essa letra for igual ao caracter a, e, i, o, u então ela é vogal, se nao, é consoante
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
			System.out.println("Você digitou uma vogal!");
		} else {
			System.out.println("Você digitou uma consoante!");
		}

	}

}
