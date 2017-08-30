//@formatter:off
/**
 *
 * 	Author's name: Enrique Mingorance Cano
 *  Author's contact: enrique.mingorance.cano@everis.com
 *
 */
//@formatter:on
package com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter;

/**
 * The Interface ConversionFilter.
 *
 * @param <T> the generic type
 */
public interface ConversionFilter<T> {

	/**
	 * Operation to perform after the conversion
	 *
	 * @param input the input
	 */
	void post(T input);
}
