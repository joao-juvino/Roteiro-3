package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		/**
		 * Tratamento de alguns erros
		 */
		if (array == null)
			return;
		if (array.length == 0)
			return;
		if (leftIndex >= rightIndex)
			return;

		/**
		 * Calculando o máximo e mínimo do array
		 */
		Integer max = array[leftIndex];
		Integer min = array[leftIndex];
		for (int i = 1; i <= rightIndex; i++) {
			if (array[i] > max)
				max = array[i];
			if (array[i] < min)
				min = array[i];
		}

		/**
		 * Preenchendo as frequências..
		 * No extended counting sort, o cálculo do tamanho do array de frequências é otimizado subtraindo-se
		 * o valor do mínimo desse cálculo.
		 */
		int[] freq = new int[max - min + 1];
		for (int j = leftIndex; j <= rightIndex; j++) {
			freq[array[j] - min]++;
		}

		/**
		 * Fazendo a soma acumulativa
		 */
		for (int k = 1; k < freq.length; k++) {
			freq[k] += freq[k - 1];
		}

		/**
		 * Formando o array ordenado
		 */
		Integer[] ordArray = new Integer[rightIndex - leftIndex + 1];
		for (int l = rightIndex; l >= leftIndex; l--) {
			ordArray[freq[array[l] - min] - 1] = array[l];
			freq[array[l] - min] -= 1;
		}

		/**
		 * Adicionando os valores ordenados no array
		 */
		int ordIndex = 0;
		for (int m = leftIndex; m <= rightIndex; m++) {
			array[m] = ordArray[ordIndex];
			ordIndex++;
		}

	}

}
