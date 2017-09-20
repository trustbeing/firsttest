package com.wangcg.util.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper  extends HttpServletRequestWrapper {

	boolean isUpData = false;//判断是否是上传 上传忽略

	/**
	 * Constructs a request object wrapping the given request.
	 *
	 * @param request
	 * @throws IllegalArgumentException if the request is null
	 */
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		String contentType = request.getContentType ();
		if (null != contentType)
			isUpData =contentType.startsWith ("multipart");
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values==null)  {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}
	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	/**
	 * 获取request的属性时，做xss过滤
	 */
	@Override
	public Object getAttribute(String name) {
		Object value = super.getAttribute(name);
		if (null != value && value instanceof String) {
			value = cleanXSS((String) value);
		}
		return value;
	}

	@Override
	public String getHeader(String name) {

		String value = super.getHeader(name);
		if (value == null)
			return null;
		return cleanXSS(value);
	}

	private String cleanXSS(String value) {
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("%3C", "&lt;").replaceAll("%3E", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("%28", "&#40;").replaceAll("%29", "&#41;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}


}
