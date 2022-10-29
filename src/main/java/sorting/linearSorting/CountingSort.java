package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

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
		 * Preenchendo as frequências
		 */
		int[] freq = new int[max + 1];
		for (int j = leftIndex; j <= rightIndex; j++) {
			freq[array[j]]++;
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
			ordArray[freq[array[l]] - 1] = array[l];
			freq[array[l]] -= 1;
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
