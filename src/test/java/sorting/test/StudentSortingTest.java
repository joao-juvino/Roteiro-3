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
	private Integer[] vetorNegativoTamPar;
	private Integer[] vetorNegativoTamImpar;
	private Integer[] vetorUnarioPositivo;
	private Integer[] vetorUnarioNegativo;
	private Integer[] vetorTamParIgualZeros;
	private Integer[] vetorTamImparIgualZeros;
	private Integer[] vetorMisto;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorTamParIgualZeros(new Integer[] { 0, 0, 0, 0 });
		populaVetorTamImparIgualZeros(new Integer[] { 0, 0, 0 });
		pululaVetorNegativoPar(new Integer[] { -5, -2, -1, -10, -2, -100 });
		pululaVetorNegativoImpar(new Integer[] { -5, -6, -100, -12, -3, -12 });
		populaVetorUnitarioPositivo(new Integer[] { 2 });
		populaVetorUnitarioNegativo(new Integer[] { -2 });
		populaVetorMisto(new Integer[] { -1, -10, -3, 0, 18, 194, 0, 1 });

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
		this.vetorNegativoTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void pululaVetorNegativoImpar(Integer[] arrayPadrao) {
		this.vetorNegativoTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUnitarioPositivo(Integer[] arrayPadrao) {
		this.vetorUnarioPositivo = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUnitarioNegativo(Integer[] arrayPadrao) {
		this.vetorUnarioNegativo = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamParIgualZeros(Integer[] arrayPadrao) {
		this.vetorTamParIgualZeros = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	public void populaVetorTamImparIgualZeros(Integer[] arrayPadrao) {
		this.vetorTamImparIgualZeros = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorMisto(Integer[] arrayPadrao) {
		this.vetorMisto = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
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

	public void partialTest(Integer[] array, Integer leftIndex, Integer rightIndex) {
		Integer[] copy1 = Arrays.copyOf(array, array.length);

		if (array.length > 0 && leftIndex < rightIndex)
			Arrays.sort(copy1, leftIndex, rightIndex + 1);

		implementation.sort(array, leftIndex, rightIndex);

		Assert.assertArrayEquals(copy1, array);
	}

	/**
	 * Ordenação possível: vetor de tamanho par
	 */
	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	/**
	 * Ordenação possível: vetor de tamanho ímpar
	 */
	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	/**
	 * Ordenação impossível: vetor vazio
	 */
	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	/**
	 * Ordenação possível: vetor com valores iguais
	 */
	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	/**
	 * Ordenação possível: vetor com valores repetidos
	 */
	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	/**
	 * Ordenação possível: vetor de tamanho par com valores negativos
	 */
	@Test
	public void testSort06() {
		genericTest(vetorNegativoTamPar);
	}

	/**
	 * Ordenação possível: vetor de tamanho ímpar com valores negativos
	 */
	@Test
	public void testSort07() {
		genericTest(vetorNegativoTamImpar);
	}

	/**
	 * Ordenação possível: vetor unário positivo
	 */
	@Test
	public void testSort08() {
		genericTest(vetorUnarioPositivo);
	}

	/**
	 * Ordenação possível: vetor unário negativo
	 */
	@Test
	public void testSort09() {
		genericTest(vetorUnarioNegativo);
	}

	/**
	 * Ordenação possível: vetor com valores mistos
	 */
	@Test
	public void testSort10() {
		genericTest(vetorMisto);
	}

	/**
	 * Ordenação possível: vetor quantidade par de zeros
	 */
	@Test
	public void testSort11() {
		genericTest(vetorTamParIgualZeros);
	}

	/**
	 * Ordenação possível: vetor quantidade ímpar de zeros
	 */
	@Test
	public void testSort12() {
		genericTest(vetorTamImparIgualZeros);
	}

	/**
	 * Vetor de tamanho par.
	 * Ordenação parcial possível.
	 */
	@Test
	public void testSort13() {
		partialTest(vetorTamPar, 2, 6);
	}

	/**
	 * Vetor de tamanho ímpar.
	 * Ordenação parcial possível.
	 */
	@Test
	public void testSort14() {
		partialTest(vetorTamImpar, 4, 7);
	}

	/**
	 * Vetor negativo de tamanho par.
	 * Ordenação parcial possível.
	 */
	@Test
	public void testSort15() {
		partialTest(vetorNegativoTamPar, 0, 3);
	}

	/**
	 * Vetor negativo de tamanho ímpar.
	 * Ordenação parcial possível.
	 */
	@Test
	public void testSort16() {
		partialTest(vetorNegativoTamImpar, 1, 5);
	}

	/**
	 * Ordenação parcial impossível: leftIndex > rightIndex
	 */
	@Test
	public void testSort17() {
		partialTest(vetorTamPar, 7, 6);
	}

	/**
	 * Ordenação parcial possível: leftIndex == rightIndex
	 */
	@Test
	public void testSort18() {
		partialTest(vetorTamPar, 6, 6);
	}

	/**
	 * Ordenação parcial impossível: array vazio
	 */
	@Test
	public void testSort19() {
		partialTest(vetorVazio, 4, 7);
	}

	/**
	 * Ordenação parcial possível: números negativos de vetor misto
	 */
	@Test
	public void testSort20() {
		partialTest(vetorMisto, 0, 2);
	}

	/**
	 * Ordenação parcial possível: números positivos de vetor misto
	 */
	@Test
	public void testSort21() {
		partialTest(vetorMisto, 3, 7);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS UMA
	 * PARTE DO ARRAY.
	 */
}