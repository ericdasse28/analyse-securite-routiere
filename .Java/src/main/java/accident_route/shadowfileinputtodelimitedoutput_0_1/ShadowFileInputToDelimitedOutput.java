// ============================================================================
//
// Copyright (c) 2006-2015, Talend Inc.
//
// This source code has been automatically generated by_Talend Open Studio for Data Integration
// / Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package accident_route.shadowfileinputtodelimitedoutput_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: ShadowFileInputToDelimitedOutput Purpose: <br>
 * Description: <br>
 * 
 * @author
 * @version 7.3.1.20200219_1130
 * @status
 */
public class ShadowFileInputToDelimitedOutput implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "ShadowFileInputToDelimitedOutput";
	private final String projectName = "ACCIDENT_ROUTE";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					ShadowFileInputToDelimitedOutput.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(ShadowFileInputToDelimitedOutput.this,
									new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class RowStruct implements routines.system.IPersistableRow<RowStruct> {
		final static byte[] commonByteArrayLock_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput = new byte[0];
		static byte[] commonByteArray_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput = new byte[0];

		public String row0;

		public String getRow0() {
			return this.row0;
		}

		public String row1;

		public String getRow1() {
			return this.row1;
		}

		public String row2;

		public String getRow2() {
			return this.row2;
		}

		public String row3;

		public String getRow3() {
			return this.row3;
		}

		public String row4;

		public String getRow4() {
			return this.row4;
		}

		public String row5;

		public String getRow5() {
			return this.row5;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput.length) {
					if (length < 1024 && commonByteArray_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput.length == 0) {
						commonByteArray_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput = new byte[1024];
					} else {
						commonByteArray_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput, 0, length);
				strReturn = new String(commonByteArray_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_ACCIDENT_ROUTE_ShadowFileInputToDelimitedOutput) {

				try {

					int length = 0;

					this.row0 = readString(dis);

					this.row1 = readString(dis);

					this.row2 = readString(dis);

					this.row3 = readString(dis);

					this.row4 = readString(dis);

					this.row5 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.row0, dos);

				// String

				writeString(this.row1, dos);

				// String

				writeString(this.row2, dos);

				// String

				writeString(this.row3, dos);

				// String

				writeString(this.row4, dos);

				// String

				writeString(this.row5, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("row0=" + row0);
			sb.append(",row1=" + row1);
			sb.append(",row2=" + row2);
			sb.append(",row3=" + row3);
			sb.append(",row4=" + row4);
			sb.append(",row5=" + row5);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(RowStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimitedProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				RowStruct Row = new RowStruct();

				/**
				 * [tFileOutputDelimited begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited", false);
				start_Hash.put("tFileOutputDelimited", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited";

				int tos_count_tFileOutputDelimited = 0;

				String fileName_tFileOutputDelimited = "";
				fileName_tFileOutputDelimited = (new java.io.File(
						"C:/Talend/TOS_DI-Win32-20200219_1130-V7.3.1/workspace/analyse-securite-routiere/ACCIDENT_ROUTE/temp/preview/Referentiel.csv"))
								.getAbsolutePath().replace("\\", "/");
				String fullName_tFileOutputDelimited = null;
				String extension_tFileOutputDelimited = null;
				String directory_tFileOutputDelimited = null;
				if ((fileName_tFileOutputDelimited.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited.lastIndexOf(".") < fileName_tFileOutputDelimited
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited = fileName_tFileOutputDelimited;
						extension_tFileOutputDelimited = "";
					} else {
						fullName_tFileOutputDelimited = fileName_tFileOutputDelimited.substring(0,
								fileName_tFileOutputDelimited.lastIndexOf("."));
						extension_tFileOutputDelimited = fileName_tFileOutputDelimited
								.substring(fileName_tFileOutputDelimited.lastIndexOf("."));
					}
					directory_tFileOutputDelimited = fileName_tFileOutputDelimited.substring(0,
							fileName_tFileOutputDelimited.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited = fileName_tFileOutputDelimited.substring(0,
								fileName_tFileOutputDelimited.lastIndexOf("."));
						extension_tFileOutputDelimited = fileName_tFileOutputDelimited
								.substring(fileName_tFileOutputDelimited.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited = fileName_tFileOutputDelimited;
						extension_tFileOutputDelimited = "";
					}
					directory_tFileOutputDelimited = "";
				}
				boolean isFileGenerated_tFileOutputDelimited = true;
				java.io.File filetFileOutputDelimited = new java.io.File(fileName_tFileOutputDelimited);
				globalMap.put("tFileOutputDelimited_FILE_NAME", fileName_tFileOutputDelimited);
				String[] headColutFileOutputDelimited = new String[6];
				class CSVBasicSet_tFileOutputDelimited {
					private char field_Delim;
					private char row_Delim;
					private char escape;
					private char textEnclosure;
					private boolean useCRLFRecordDelimiter;

					public boolean isUseCRLFRecordDelimiter() {
						return useCRLFRecordDelimiter;
					}

					public void setFieldSeparator(String fieldSep) throws IllegalArgumentException {
						char field_Delim_tFileOutputDelimited[] = null;

						// support passing value (property: Field Separator) by 'context.fs' or
						// 'globalMap.get("fs")'.
						if (fieldSep.length() > 0) {
							field_Delim_tFileOutputDelimited = fieldSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Field Separator must be assigned a char.");
						}
						this.field_Delim = field_Delim_tFileOutputDelimited[0];
					}

					public char getFieldDelim() {
						if (this.field_Delim == 0) {
							setFieldSeparator(";");
						}
						return this.field_Delim;
					}

					public void setRowSeparator(String rowSep) {
						if ("\r\n".equals(rowSep)) {
							useCRLFRecordDelimiter = true;
							return;
						}
						char row_DelimtFileOutputDelimited[] = null;

						// support passing value (property: Row Separator) by 'context.rs' or
						// 'globalMap.get("rs")'.
						if (rowSep.length() > 0) {
							row_DelimtFileOutputDelimited = rowSep.toCharArray();
						} else {
							throw new IllegalArgumentException("Row Separator must be assigned a char.");
						}
						this.row_Delim = row_DelimtFileOutputDelimited[0];
					}

					public char getRowDelim() {
						if (this.row_Delim == 0) {
							setRowSeparator("\n");
						}
						return this.row_Delim;
					}

					public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure)
							throws IllegalArgumentException {
						if (strEscape.length() <= 0) {
							throw new IllegalArgumentException("Escape Char must be assigned a char.");
						}

						if ("".equals(strTextEnclosure))
							strTextEnclosure = "\0";
						char textEnclosure_tFileOutputDelimited[] = null;

						if (strTextEnclosure.length() > 0) {
							textEnclosure_tFileOutputDelimited = strTextEnclosure.toCharArray();
						} else {
							throw new IllegalArgumentException("Text Enclosure must be assigned a char.");
						}

						this.textEnclosure = textEnclosure_tFileOutputDelimited[0];

						if (("\\").equals(strEscape)) {
							this.escape = '\\';
						} else if (strEscape.equals(strTextEnclosure)) {
							this.escape = this.textEnclosure;
						} else {
							// the default escape mode is double escape
							this.escape = this.textEnclosure;
						}

					}

					public char getEscapeChar() {
						return (char) this.escape;
					}

					public char getTextEnclosure() {
						return this.textEnclosure;
					}
				}

				int nb_line_tFileOutputDelimited = 0;
				int splitedFileNo_tFileOutputDelimited = 0;
				int currentRow_tFileOutputDelimited = 0;

				CSVBasicSet_tFileOutputDelimited csvSettings_tFileOutputDelimited = new CSVBasicSet_tFileOutputDelimited();
				csvSettings_tFileOutputDelimited.setFieldSeparator(";");
				csvSettings_tFileOutputDelimited.setRowSeparator("\n");
				csvSettings_tFileOutputDelimited.setEscapeAndTextEnclosure("\\", "\"");
				// create directory only if not exists
				if (directory_tFileOutputDelimited != null && directory_tFileOutputDelimited.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited = new java.io.File(directory_tFileOutputDelimited);
					if (!dir_tFileOutputDelimited.exists()) {
						dir_tFileOutputDelimited.mkdirs();
					}
				}
				com.talend.csv.CSVWriter CsvWritertFileOutputDelimited = null;

				java.io.File fileToDelete_tFileOutputDelimited = new java.io.File(fileName_tFileOutputDelimited);
				if (fileToDelete_tFileOutputDelimited.exists()) {
					fileToDelete_tFileOutputDelimited.delete();
				}
				CsvWritertFileOutputDelimited = new com.talend.csv.CSVWriter(
						new java.io.BufferedWriter(new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(fileName_tFileOutputDelimited, false), "ISO-8859-15")));
				CsvWritertFileOutputDelimited.setSeparator(csvSettings_tFileOutputDelimited.getFieldDelim());
				if (csvSettings_tFileOutputDelimited.isUseCRLFRecordDelimiter()) {
					CsvWritertFileOutputDelimited.setLineEnd("\r\n");
				} else {
					CsvWritertFileOutputDelimited.setLineEnd("" + csvSettings_tFileOutputDelimited.getRowDelim());
				}
				CsvWritertFileOutputDelimited.setEscapeChar(csvSettings_tFileOutputDelimited.getEscapeChar());
				CsvWritertFileOutputDelimited.setQuoteChar(csvSettings_tFileOutputDelimited.getTextEnclosure());
				CsvWritertFileOutputDelimited.setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);

				resourceMap.put("CsvWriter_tFileOutputDelimited", CsvWritertFileOutputDelimited);
				resourceMap.put("nb_line_tFileOutputDelimited", nb_line_tFileOutputDelimited);

				/**
				 * [tFileOutputDelimited begin ] stop
				 */

				/**
				 * [tFileInputDelimited begin ] start
				 */

				ok_Hash.put("tFileInputDelimited", false);
				start_Hash.put("tFileInputDelimited", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited";

				int tos_count_tFileInputDelimited = 0;

				final routines.system.RowState rowstate_tFileInputDelimited = new routines.system.RowState();

				int nb_line_tFileInputDelimited = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited = null;
				int limit_tFileInputDelimited = 50;
				try {

					Object filename_tFileInputDelimited = "C:/Users/DIGINAMIC/Desktop/projet fin de formation/Projet_Accidents/Jeu de donnees/Donnees/Referentiel.csv";
					if (filename_tFileInputDelimited instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited = 0, random_value_tFileInputDelimited = -1;
						if (footer_value_tFileInputDelimited > 0 || random_value_tFileInputDelimited > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/DIGINAMIC/Desktop/projet fin de formation/Projet_Accidents/Jeu de donnees/Donnees/Referentiel.csv",
								"ISO-8859-15", ";", "\n", false, 0, 0, limit_tFileInputDelimited, -1, false);
					} catch (java.lang.Exception e) {

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited != null && fid_tFileInputDelimited.nextRecord()) {
						rowstate_tFileInputDelimited.reset();

						Row = null;

						boolean whetherReject_tFileInputDelimited = false;
						Row = new RowStruct();
						try {

							int columnIndexWithD_tFileInputDelimited = 0;

							columnIndexWithD_tFileInputDelimited = 0;

							Row.row0 = fid_tFileInputDelimited.get(columnIndexWithD_tFileInputDelimited);

							columnIndexWithD_tFileInputDelimited = 1;

							Row.row1 = fid_tFileInputDelimited.get(columnIndexWithD_tFileInputDelimited);

							columnIndexWithD_tFileInputDelimited = 2;

							Row.row2 = fid_tFileInputDelimited.get(columnIndexWithD_tFileInputDelimited);

							columnIndexWithD_tFileInputDelimited = 3;

							Row.row3 = fid_tFileInputDelimited.get(columnIndexWithD_tFileInputDelimited);

							columnIndexWithD_tFileInputDelimited = 4;

							Row.row4 = fid_tFileInputDelimited.get(columnIndexWithD_tFileInputDelimited);

							columnIndexWithD_tFileInputDelimited = 5;

							Row.row5 = fid_tFileInputDelimited.get(columnIndexWithD_tFileInputDelimited);

							if (rowstate_tFileInputDelimited.getException() != null) {
								throw rowstate_tFileInputDelimited.getException();
							}

						} catch (java.lang.Exception e) {
							whetherReject_tFileInputDelimited = true;

							System.err.println(e.getMessage());
							Row = null;

						}

						/**
						 * [tFileInputDelimited begin ] stop
						 */

						/**
						 * [tFileInputDelimited main ] start
						 */

						currentComponent = "tFileInputDelimited";

						tos_count_tFileInputDelimited++;

						/**
						 * [tFileInputDelimited main ] stop
						 */

						/**
						 * [tFileInputDelimited process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited";

						/**
						 * [tFileInputDelimited process_data_begin ] stop
						 */
// Start of branch "Row"
						if (Row != null) {

							/**
							 * [tFileOutputDelimited main ] start
							 */

							currentComponent = "tFileOutputDelimited";

							String[] rowtFileOutputDelimited = new String[6];
							rowtFileOutputDelimited[0] = Row.row0 == null ? null : Row.row0;
							rowtFileOutputDelimited[1] = Row.row1 == null ? null : Row.row1;
							rowtFileOutputDelimited[2] = Row.row2 == null ? null : Row.row2;
							rowtFileOutputDelimited[3] = Row.row3 == null ? null : Row.row3;
							rowtFileOutputDelimited[4] = Row.row4 == null ? null : Row.row4;
							rowtFileOutputDelimited[5] = Row.row5 == null ? null : Row.row5;
							nb_line_tFileOutputDelimited++;
							resourceMap.put("nb_line_tFileOutputDelimited", nb_line_tFileOutputDelimited);
							CsvWritertFileOutputDelimited.writeNext(rowtFileOutputDelimited);

							tos_count_tFileOutputDelimited++;

							/**
							 * [tFileOutputDelimited main ] stop
							 */

							/**
							 * [tFileOutputDelimited process_data_begin ] start
							 */

							currentComponent = "tFileOutputDelimited";

							/**
							 * [tFileOutputDelimited process_data_begin ] stop
							 */

							/**
							 * [tFileOutputDelimited process_data_end ] start
							 */

							currentComponent = "tFileOutputDelimited";

							/**
							 * [tFileOutputDelimited process_data_end ] stop
							 */

						} // End of branch "Row"

						/**
						 * [tFileInputDelimited process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited";

						/**
						 * [tFileInputDelimited process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited end ] start
						 */

						currentComponent = "tFileInputDelimited";

					}
				} finally {
					if (!((Object) ("C:/Users/DIGINAMIC/Desktop/projet fin de formation/Projet_Accidents/Jeu de donnees/Donnees/Referentiel.csv") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited != null) {
							fid_tFileInputDelimited.close();
						}
					}
					if (fid_tFileInputDelimited != null) {
						globalMap.put("tFileInputDelimited_NB_LINE", fid_tFileInputDelimited.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited", true);
				end_Hash.put("tFileInputDelimited", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited end ] stop
				 */

				/**
				 * [tFileOutputDelimited end ] start
				 */

				currentComponent = "tFileOutputDelimited";

				if (CsvWritertFileOutputDelimited != null) {
					CsvWritertFileOutputDelimited.close();
				}

				globalMap.put("tFileOutputDelimited_NB_LINE", nb_line_tFileOutputDelimited);

				resourceMap.put("finish_tFileOutputDelimited", true);

				ok_Hash.put("tFileOutputDelimited", true);
				end_Hash.put("tFileOutputDelimited", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited finally ] start
				 */

				currentComponent = "tFileInputDelimited";

				/**
				 * [tFileInputDelimited finally ] stop
				 */

				/**
				 * [tFileOutputDelimited finally ] start
				 */

				currentComponent = "tFileOutputDelimited";

				if (resourceMap.get("finish_tFileOutputDelimited") == null) {

					com.talend.csv.CSVWriter CsvWritertFileOutputDelimited = (com.talend.csv.CSVWriter) resourceMap
							.get("CsvWriter_tFileOutputDelimited");

					if (CsvWritertFileOutputDelimited != null) {
						CsvWritertFileOutputDelimited.close();
					}

				}

				/**
				 * [tFileOutputDelimited finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Shadow";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final ShadowFileInputToDelimitedOutput ShadowFileInputToDelimitedOutputClass = new ShadowFileInputToDelimitedOutput();

		int exitCode = ShadowFileInputToDelimitedOutputClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("monitoring"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = ShadowFileInputToDelimitedOutput.class.getClassLoader().getResourceAsStream(
					"accident_route/shadowfileinputtodelimitedoutput_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = ShadowFileInputToDelimitedOutput.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				// defaultProps is in order to keep the original context value
				if (context != null && context.isEmpty()) {
					defaultProps.load(inContext);
					context = new ContextProperties(defaultProps);
				}

				inContext.close();
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimitedProcess(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited) {
			globalMap.put("tFileInputDelimited_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : ShadowFileInputToDelimitedOutput");
		}

		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--monitoring") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 44257 characters generated by Talend Open Studio for Data Integration on the
 * 3 avril 2020 à 09:49:18 CEST
 ************************************************************************************************/