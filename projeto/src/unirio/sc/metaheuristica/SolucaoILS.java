package unirio.sc.metaheuristica;

import java.util.Arrays;

import unirio.sc.busca.SolucaoHC;
import unirio.sc.construtivo.SolucaoCNM;
import unirio.sc.construtivoLista.SolucaoCNMLL;
import unirio.sc.core.SolucaoAbstract;

/**
 * Representa��o de uma solu��o com inteiros
 */
public class SolucaoILS implements SolucaoAbstract {

	// representa o n�mero da gera��o em que a solu��o foi encontrada
	private int location;

	// valor de fitness da solu��o
	private double fitness = 0.00;

	// parte b�sica da representa��o da solu��o
	private int[] valores;

	// quantidade dos grupos
	private int totalGrupos;

	// quantidade de cada item nos grupos
	private int[] qtdItens;
	
	public SolucaoILS(SolucaoILS s) {
		int[] valores = s.getValores();
		this.valores = Arrays.copyOf(valores, valores.length);

		int[] qtdItens = s.getQtdItens();
		this.qtdItens = Arrays.copyOf(qtdItens, qtdItens.length);
		this.totalGrupos = s.getTotalGrupos();
		this.fitness = s.getFitness();
		this.location = s.getLocation();
	}

	public SolucaoILS(SolucaoCNM s) {
		int[] valores = s.getValores();
		this.valores = Arrays.copyOf(valores, valores.length);

		int[] qtdItens = s.getQtdItens();
		this.qtdItens = Arrays.copyOf(qtdItens, qtdItens.length);
		this.totalGrupos = s.getTotalGrupos();
		this.fitness = s.getFitness();
		this.location = s.getLocation();
	}

	public SolucaoILS(SolucaoCNMLL s) {
		int[] valores = s.getValores();
		this.valores = Arrays.copyOf(valores, valores.length);
		
		this.qtdItens = s.getQtdItens(); // j� � alocada uma c�pia na SolucaoCNM com linked list
		this.totalGrupos = s.getTotalGrupos();
		this.fitness = s.getFitness();
		this.location = s.getLocation();
	}

	public SolucaoILS(SolucaoHC s) {
		int[] valores = s.getValores();
		this.valores = Arrays.copyOf(valores, valores.length);

		int[] qtdItens = s.getQtdItens();
		this.qtdItens = Arrays.copyOf(qtdItens, qtdItens.length);
		this.totalGrupos = s.getTotalGrupos();
		this.fitness = s.getFitness();
		this.location = s.getLocation();
	}

	public SolucaoILS(int[] valores, int[] qtdItens, int totalGrupos ) {
		this.valores = valores;
		this.qtdItens = qtdItens;
		this.totalGrupos = totalGrupos;
	}

	public SolucaoILS(int[] valores, int[] qtdItens, int totalGrupos, double fitness, int location ) {
		this.valores = valores;
		this.qtdItens = qtdItens;
		this.totalGrupos = totalGrupos;
		this.fitness = fitness;
		this.location = location;
	}

	public SolucaoILS(int tamanho) {
		this.valores = new int[tamanho];
		this.qtdItens = new int[2 * tamanho];
		this.totalGrupos = 0;
	}
	
	public void setSolucao(int[] valores, int[] qtdItens, int totalGrupos, double fitness, int location) {
		this.valores = valores;
		this.qtdItens = qtdItens;
		this.totalGrupos = totalGrupos;
		this.fitness = fitness;
		this.location = location;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public double getFitness() {
		return fitness;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getLocation() {
		return location;
	}

	public int[] getValores() {
		return this.valores;
	}

	public int getTotalItens() {
		return this.valores.length;
	}

	public void setValores(int[] valores) {
		this.valores = valores;
	}

	public void setTotalGrupos(int totalGrupos) {
		this.totalGrupos = totalGrupos;
	}

	public int getTotalGrupos() {
		return totalGrupos;
	}

	public void setQtdItens(int[] qtdItens, int totalGrupos) {
		this.totalGrupos = totalGrupos;
		this.qtdItens = qtdItens;
	}

	public int[] getQtdItens() {
		return qtdItens;
	}
	
	/**
	 * Utilizado para exibi��o dos resultados
	 */
	public String getString() {
		StringBuilder sb = new StringBuilder("");
		if (this.valores.length > 0) {
			sb.append(String.valueOf(this.valores[0]));
		}
		for (int i = 1; i < valores.length; i++) {
			sb.append(",");
			sb.append(String.valueOf(this.valores[i]));
		}
		return sb.toString();
	}


}
