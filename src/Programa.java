import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double ipsalario=0, slmensal, ranual;
		double prestservico, impServ;
		double capital, ipcapital;
		double gmedico, geducacionais, gasdedutiveis;
		double ipTotal, ipdevido ,maxdedutivel, abatimento;

// ENTRADAS USUARIO		
		
		System.out.println("Digite a renda anual: ");
		ranual = sc.nextDouble();
		
		System.out.println("Digite a renda anual com prestação de serviço: ");
		prestservico = sc.nextDouble();
		impServ = prestservico * 0.15;
		
		System.out.println("Renda anual com ganho de capital: ");
		capital = sc.nextDouble();
		ipcapital = capital * 0.2;
		
		System.out.println("Gastos médicos: ");
		gmedico = sc.nextDouble();
		
		System.out.println("Gastos educacionais: ");
		geducacionais = sc.nextDouble();
		
		
//		**RELATORIO**
		System.out.println();
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");		

		slmensal = ranual / 12;

		if (slmensal > 0 && slmensal < 3000) {
			System.out.println("Imposto sobre salário: Isento");
		} else if (slmensal > 3000 && slmensal < 5000) {
			ipsalario = slmensal * 12 * 0.10;
			System.out.printf("Imposto sobre salário: %.2f\n", ipsalario);
		}

		else if (slmensal > 5000) {
			ipsalario = slmensal * 12 * 0.20;
			System.out.printf("Imposto sobre salário: %.2f\n", ipsalario);
		}
			
		
//	    CALCULOS
		ipTotal =  (ipsalario + impServ + ipcapital);
		maxdedutivel = ipTotal * 0.3;
		
		gasdedutiveis = gmedico + geducacionais;

		if (gasdedutiveis > maxdedutivel) {
			abatimento = maxdedutivel;
		}
		
		else { 
			abatimento = gasdedutiveis;
		}
			
		ipdevido = ipTotal - abatimento;
		
		
//		CONSOLIDADO DE RENDA
		System.out.printf("Imposto sobre serviços: %.2f\n", impServ);
		System.out.printf("Imposto sobre ganho de capital: %.2f\n", ipcapital);
				
//		DEDUÇOES
		System.out.println();
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f\n", maxdedutivel);
		System.out.printf("Gastos dedutíveis: %.2f\n", gasdedutiveis);
		
//		RESUMO
		System.out.println();
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f\n", ipTotal);
		System.out.printf("Abatimento: %.2f\n", abatimento);
		System.out.printf("Imposto devido: %.2f\n", ipdevido);
		
				
		sc.close();
		
	}

}
