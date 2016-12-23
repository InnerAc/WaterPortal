package edu.hhu.portal.controller;

import java.io.File;

import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;

public class FileController extends Controller{
	public void index(){
		String filename = getPara("file");
		String url = PathKit.getWebRootPath()+"/static/file/"+filename;
		System.out.println(url);
		File file = new File(url);
		if(file.isFile())
			renderFile(file);
		else {
			System.out.println("no file");
		}
	}
}
