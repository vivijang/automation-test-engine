/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2014, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.systemlogger;

import org.bigtester.ate.GlobalUtils;
import org.bigtester.ate.constant.ExceptionMessage;
import org.bigtester.ate.constant.LogbackTag;
import org.eclipse.jdt.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class LogbackWriter defines ....
 *
 * @author Peidong Hu
 */
public final class LogbackWriter {

	/** The Constant MYLOGGER. */
	@Nullable
	private static final Logger MYLOGGER = LoggerFactory
			.getLogger(LogbackWriter.class);

	/**
	 * Write app error.
	 *
	 * @param msg
	 *            the msg
	 */
	public static void writeAppError(String msg) {

		final Logger mylogger2 = MYLOGGER;
		if (mylogger2 == null) {
			throw GlobalUtils.createNotInitializedException("MYLOGGER"); //NOPMD
		} else {
			if (mylogger2.isErrorEnabled()) {
				mylogger2.error(LogbackTag.TAG_APP_LOG
						+ LogbackTag.TAG_TEST_ERROR + msg);
			} else {
				throw new UnsupportedOperationException(
						ExceptionMessage.MSG_UNSUPPORTED_LOGBACK_LEVEL
								+ "MYLOGGER.isErrorEnabled()");
			}
			
		}

	}

	/**
	 * Write app error.
	 *
	 * @param msg
	 *            the msg
	 */
	public static void writeSysError(String msg) {
		final Logger mylogger2 = MYLOGGER;
		if (mylogger2 == null) {
			throw GlobalUtils.createNotInitializedException("MYLOGGER");
		} else {
			if (mylogger2.isErrorEnabled()) {
				mylogger2.error(LogbackTag.TAG_SYS_LOG + LogbackTag.TAG_TEST_ERROR
						+ msg);
			} else {
				throw new UnsupportedOperationException(
						ExceptionMessage.MSG_UNSUPPORTED_LOGBACK_LEVEL
								+ "MYLOGGER.isErrorEnabled()");
			}
		}
	}

	/**
	 * Write app warning.
	 *
	 * @param msg
	 *            the msg
	 */
	public static void writeAppWarning(String msg) {
		final Logger mylogger2 = MYLOGGER;
		if (mylogger2 == null) {
			throw GlobalUtils.createNotInitializedException("MYLOGGER");
		} else {
			if (mylogger2.isWarnEnabled()) {
				mylogger2.warn(LogbackTag.TAG_APP_LOG + LogbackTag.TAG_TEST_WARNING
						+ msg);
			} else {
				throw new UnsupportedOperationException(
						ExceptionMessage.MSG_UNSUPPORTED_LOGBACK_LEVEL
								+ "MYLOGGER.isWarnEnabled()");
			}
		}
	}

	/**
	 * Write app info.
	 *
	 * @param msg
	 *            the msg
	 */
	public static void writeAppInfo(String msg) {
		final Logger mylogger2 = MYLOGGER;
		if (mylogger2 == null) {
			throw GlobalUtils.createNotInitializedException("MYLOGGER");
		} else {
			if (mylogger2.isInfoEnabled()) {
				mylogger2.info(LogbackTag.TAG_APP_LOG + LogbackTag.TAG_TEST_INFO + msg); // NOPMD
			} else {
				throw new UnsupportedOperationException(
						ExceptionMessage.MSG_UNSUPPORTED_LOGBACK_LEVEL
								+ "MYLOGGER.isInfoEnabled()");
			}
		}
	}

	/**
	 * Write test info.
	 *
	 * @param msg
	 *            the msg
	 */
	public static void writeUnitTestInfo(String msg) {
		final Logger mylogger2 = MYLOGGER;
		if (mylogger2 == null) {
			throw GlobalUtils.createNotInitializedException("MYLOGGER");
		} else {
			
			if (mylogger2.isInfoEnabled()) {
				mylogger2.info(LogbackTag.TAG_APP_LOG + LogbackTag.TAG_UNITTEST_INFO + msg); // NOPMD
			} else {
				throw new UnsupportedOperationException(
						ExceptionMessage.MSG_UNSUPPORTED_LOGBACK_LEVEL
								+ "MYLOGGER.isInfoEnabled()");
			}
		}
	}

	/**
	 * Instantiates a new logback writer.
	 */
	private LogbackWriter() {
		throw new AssertionError();
	}
}
