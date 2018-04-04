package com.server.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.Server;
import com.sira.api.deamon.UplancerInfo;
import com.sira.api.error.APIException;

public class FileController extends Server {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req ,
			HttpServletResponse resp)
			throws ServletException,
			IOException {

		BufferedWriter bufferedWriter = null;

		UplancerInfo uplancerInfo = (UplancerInfo) this.getContext().getApplicationContext().getBean("");

		File file;

		try {

			file = new File(uplancerInfo.getUplancer().getFilesDir());

		} catch (APIException e1) {

			throw new ServletException(e1.getLocalizedMessage());

		}

		try {

			Writer out = new FileWriter(file);

			BufferedReader bufferedReader = null;

			bufferedReader = new BufferedReader(req.getReader());

			bufferedWriter = new BufferedWriter(out );
		
			String str;
			
			while((str =bufferedReader.readLine())!=null){
				
				bufferedWriter.write(str);
				
			}

		} catch (Exception e) {

			throw new IOException(e.getLocalizedMessage());

		} finally {

			bufferedWriter.close();

			resp.getWriter().write(file.getName());

		}

	}

}
