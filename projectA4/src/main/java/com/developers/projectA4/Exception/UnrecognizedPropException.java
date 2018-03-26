/*
 * Copyright (C) CBI Mobile (Bahamas) Ltd - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential.
 */

package com.developers.projectA4.Exception;

public class UnrecognizedPropException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnrecognizedPropException(String name) {
		super(String.format("Invalid property is passed " + name));
	}
}
