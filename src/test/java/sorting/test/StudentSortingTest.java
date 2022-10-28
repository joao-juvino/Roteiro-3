package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	private Integer[] vetorValoresNegativosPares;
	private Integer[] vetorValoresNegativosImpares;
	private Integer[] vetorUnarioPositivo;
	private Integer[] vetorUnarioNegativo;
	private Integer[] vetorIgualDeZeros;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorIgualZeros(new Integer[] { 0, 0 ,0 });
		pululaVetorNegativoPar(new Integer[] { -5, 0, 1, -10, 2, 100 });
		pululaVetorNegativoImpar(new Integer[] { -5, -6, -100, -12, -3, -12 });
		populaVetorUnitarioPositivo(new Integer[] { 2 });
		populaVetorUnitarioNegativo(new Integer[] { -2 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação do
	 * aluno
	 */
	private void getImplementation() {
		// this.implementation = new CountingSort();
		this.implementation = new ExtendedCountingSort();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void pululaVetorNegativoPar(Integer[] arrayPadrao) {
		this.vetorValoresNegativosPares = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void pululaVetorNegativoImpar(Integer[] arrayPadrao) {
		this.vetorValoresNegativosImpares = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUnitarioPositivo(Integer[] arrayPadrao) {
		this.vetorUnarioPositivo = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUnitarioNegativo(Integer[] arrayPadrao) {
		this.vetorUnarioNegativo = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	public void populaVetorIgualZeros(Integer[] arrayPadrao) {
		this.vetorIgualDeZeros = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);

		Assert.assertArrayEquals(copy1, array);
	}

	public void partialTest(Integer[] array) {
		Integer[] copy1 = { 30, 28, 7, 11, 26, 29, 4, 22, 23, 31 };
		implementation.sort(array, 2, 5);

		Assert.assertArrayEquals(copy1, array);
	}

	public void partialFailTest01(Integer[] array) {
		Integer[] copy1 = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };

		implementation.sort(array, 7, 6);

		Assert.assertArrayEquals(copy1, array);
	}
	
	public void partialFailTest02(Integer[] array) {
		Integer[] copy1 = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };

		implementation.sort(array, 6, 6);

		Assert.assertArrayEquals(copy1, array);
	}
	
	public void partialFailTest03(Integer[] array) {
		Integer[] copy1 = {};

		implementation.sort(array, 4, 7);

		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testSort06() {
		genericTest(vetorValoresNegativosPares);
	}

	@Test
	public void testSort07() {
		genericTest(vetorValoresNegativosImpares);
	}

	@Test
	public void testSort08() {
		genericTest(vetorUnarioPositivo);
	}

	@Test
	public void testSort09() {
		genericTest(vetorUnarioNegativo);
	}

	@Test
	public void testSort10() {
		partialTest(vetorTamPar);
	}

	@Test
	public void testSort11() {
		partialFailTest01(vetorTamPar);
	}

	@Test
	public void testSort12() {
		partialFailTest02(vetorTamPar);
	}
	
	@Test
	public void testSort13() {
		genericTest(vetorIgualDeZeros);
	}
	
	@Test
	public void testSort14() {
		partialFailTest03(vetorVazio);
	}
	
	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS UMA
	 * PARTE DO ARRAY.
	 */
}