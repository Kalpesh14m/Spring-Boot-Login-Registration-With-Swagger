package com.java.keep.common.util;

import java.time.LocalDateTime;

public class DateUtil {
	private DateUtil() {
	}

	public static LocalDateTime today() {
		return LocalDateTime.now();
	}

}
