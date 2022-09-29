package com.luxoft.vowelscounter.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormater {

	public static String format(double number) {

		DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
		decimalFormat.applyPattern("#.#");

		return decimalFormat.format(number);

	}
}
