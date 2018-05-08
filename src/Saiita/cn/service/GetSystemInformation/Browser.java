package Saiita.cn.service.GetSystemInformation;

public class Browser {
	public final static String[] type = { "Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser" };
	// String msieP = "msie ([\\d.]+)";
	// String firefoxP = "firefox\\/([\\d.]+)";
	// String chromeP = "chrome\\/([\\d.]+)";
	// String operaP = "opera.([\\d.]+)/)";
	// String safariP = "version\\/([\\d.]+).*safari";

	public static String checkAgentIsMobile(String ua) {
		Boolean flag = false;
		if (!ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"))) {
			// ÅÅ³ı Æ»¹û×ÀÃæÏµÍ³
			if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
				for (String item : type) {
					if (ua.contains(item)) {
						return item;
					}
				}
			}
		}
		return ua;
	}

	public String getBrowserName(String agent) {
		String type = checkAgentIsMobile(agent);
		if (type.equals("iPhone") || type.equals("Android") || type.equals("iPod") || type.equals("Windows Phone")
				|| type.equals("MQQBrowser") || type.equals("")) {
			if (agent.indexOf("UCBrowser") > 0) {
				return type + "/" + "UCä¯ÀÀÆ÷";
			} else if (agent.indexOf("SogouMobileBrowser") > 0) {
				return type + "/" + "ËÑ¹·ä¯ÀÀÆ÷";
			}else if (agent.indexOf("Safari") > 0) {
				return type + "/" + "Æ»¹ûä¯ÀÀÆ÷";
			}else if (agent.indexOf("QihooBrowser") > 0) {
				return type + "/" + "360ä¯ÀÀÆ÷";
			}else if (agent.indexOf("baidubrowser") > 0) {
				return type + "/" + "°Ù¶Èä¯ÀÀÆ÷";
			}else if (agent.indexOf("baidubrowser") > 0) {
				return type + "/" + "Opera Miniä¯ÀÀÆ÷";
			}else if (agent.indexOf("OPR") > 0) {
				return type + "/" + "Operaä¯ÀÀÆ÷";
			}
			return type;
		} else {
			if (agent.indexOf("msie 7") > 0) {
				return "IE 7.0";
			} else if (agent.indexOf("msie 8") > 0) {
				return "IE 8.0";
			} else if (agent.indexOf("msie 6") > 0) {
				return "IE 6.0";
			} else if (agent.indexOf("msie 9") > 0) {
				return "IE 9.0";
			} else if (agent.indexOf("msie 10") > 0) {
				return "IE10";
			} else if (agent.indexOf("msie") > 0) {
				return "IE";
			} else if (agent.indexOf("Edge") > 0) {
				return "Windows 10 ÄÚÖÃ Edgeä¯ÀÀÆ÷";
			} else if (agent.indexOf("MetaSr") > 0) {
				return "ËÑ¹·ä¯ÀÀÆ÷";
			} else if (agent.indexOf("QQBrowser") > 0) {
				return "QQBrowser";
			} else if (agent.indexOf("Gecko") > 0 && agent.indexOf("rv:11.0") > 0) {
				return "IE11";
			} else if (agent.indexOf("Chrome") > 0 && agent.indexOf("Safari") > 0) {
				return "¹È¸èä¯ÀÀÆ÷";
			} else {
				return "Others";
			}
		}

	}
}
