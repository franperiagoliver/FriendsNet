package com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter;

import java.util.List;

/**
 * The interface Entity converter.
 */
public interface EntityConverter {
	/**
	 * Fill t.
	 *
	 * @param <F>
	 *            the type parameter
	 * @param <T>
	 *            the type parameter
	 * @param source
	 *            the source
	 * @param destination
	 *            the destination
	 * @return the t
	 */
	<F, T> T fill(F source, T destination);

	/**
	 * Convert list.
	 *
	 * @param <F>
	 *            the type parameter
	 * @param <T>
	 *            the type parameter
	 * @param fromList
	 *            the from list
	 * @param toClass
	 *            the to class
	 * @param filters
	 *            the filters
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	<F, T> List<T> convert(List<F> fromList, Class<T> toClass, ConversionFilter<T>... filters);

	/**
	 * Convert t.
	 *
	 * @param <F>
	 *            the type parameter
	 * @param <T>
	 *            the type parameter
	 * @param from
	 *            the from
	 * @param toClass
	 *            the to class
	 * @param filters
	 *            the filters
	 * @return the t
	 */
	<F, T> T convert(F from, Class<T> toClass, @SuppressWarnings("unchecked") ConversionFilter<T>... filters);
}
