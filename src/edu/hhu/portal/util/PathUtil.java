package edu.hhu.portal.util;

import com.jfinal.kit.PathKit;

public class PathUtil {
	public final static String projectPath = PathKit.getWebRootPath();
	public final static String filePath = PathKit.getWebRootPath()+"\file";
}
