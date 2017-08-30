package com.everis.alicante.courses.beca.summer17.friendsnet.utils.converter;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A class with conversion utilities that uses Dozer implementation for
 * automatic conversions.
 */
@Service
public class EntityConverterImpl implements EntityConverter {

	// TODO create a new Mapper to specify the same class loader
	// https://github.com/DozerMapper/dozer/issues/22#issuecomment-15205733

	/**
	 * The mapper.
	 */
	@Autowired
	private Mapper dozerMapper;

	/**
	 * Fills an object of type <T> from an object of type <F>.
	 *
	 * @param <F>
	 *            the generic type
	 * @param <T>
	 *            the generic type
	 * @param source
	 *            the source
	 * @param destination
	 *            the destination
	 * @return the t
	 */
	@Override
	public <F, T> T fill(F source, T destination) {
		if (source == null || destination == null) {
			return null;
		}
		dozerMapper.map(source, destination);
		return destination;
	}

	/**
	 * Creates a list of <T> objects from a list of <F> objects.
	 *
	 * @param <F>
	 *            the generic type
	 * @param <T>
	 *            the generic type
	 * @param fromList
	 *            the from list
	 * @param toClass
	 *            the to class
	 * @param filters
	 *            the filters
	 * @return the list
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <F, T> List<T> convert(final List<F> fromList, final Class<T> toClass,
			final ConversionFilter<T>... filters) {

		List<T> resultList = new ArrayList<T>(fromList.size());

		for (F from : fromList) {
			resultList.add(convert(from, toClass, filters));
		}

		return resultList;
	}

	/**
	 * Creates an instance of type <T> from an object of type <F>.
	 *
	 * @param <F>
	 *            the generic type
	 * @param <T>
	 *            the generic type
	 * @param from
	 *            the from
	 * @param toClass
	 *            the to class
	 * @param filters
	 *            the filters
	 * @return the t
	 */
	@Override
	public <F, T> T convert(F from, final Class<T> toClass,
			@SuppressWarnings("unchecked") final ConversionFilter<T>... filters) {
		if (from == null) {
			return null;
		}

		T conversion = dozerMapper.map(from, toClass);

		for (ConversionFilter<T> filter : filters) {
			filter.post(conversion);
		}

		return conversion;
	}

}
