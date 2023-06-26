package com.koo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class FileHandlingUtils {
	public static void createDirectory(String folderPath) {
		File file = new File(folderPath);

		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static boolean deleteDirectory(String folderPath) {
		File dir = new File(folderPath);

		if (dir.isDirectory()) {
			String[] child = dir.list();

			for (int i = 0; i < child.length; i++) {
				boolean success = new File(dir, child[i]).delete();
				if (!success) {
					return false;
				}
			}
			return dir.delete();
		}

		return false;
	}

	public static boolean copyDirectory(String sourcePath, String targetPath) throws IOException {
		boolean dirFlag = false;

		File sourceLocation = new File(sourcePath);
		File targetLocation = new File(targetPath);
		byte[] buffer = new byte[1024];
		int len;

		if (sourceLocation.isDirectory()) {
			createDirectory(targetPath);

			String[] child = sourceLocation.list();

			for (int i = 0; i < child.length; i++) {
				copyDirectory(new File(sourceLocation, child[i]).getCanonicalPath(),
						new File(targetLocation, child[i]).getCanonicalPath());
			}
			dirFlag = true;
		} else if (targetLocation.isDirectory()) {
			targetPath = targetLocation.getCanonicalPath() + sourceLocation.getName();

			InputStream inStream = new FileInputStream(sourceLocation);
			OutputStream outStream = new FileOutputStream(targetPath);

			while ((len = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, len);
			}

			inStream.close();
			outStream.close();
			dirFlag = true;
		} else {
			InputStream inStream = new FileInputStream(sourceLocation);
			OutputStream outStream = new FileOutputStream(targetLocation);

			while ((len = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, len);
			}

			inStream.close();
			outStream.close();
			dirFlag = true;
		}
		return dirFlag;
	}

	public static void createFile(String path) throws IOException {
		// Initialize file
		File file = new File(path);
		createFile(file);
	}

	public static void createFile(File file) throws IOException {
		// Create Parent dir if not exists
		FileUtils.forceMkdirParent(file);

		// Check if it is a directory, if yes throw exception
		if (file.isDirectory())
			throw new IOException(
					"File handle specified in argument, is a directory, please check - " + file.getAbsolutePath());

		// Create file if not exists
		if (!file.exists())
			file.createNewFile();
	}

	public static List<String> generateFileList(String rootFileName) throws IOException {
		File fileRoot = new File(rootFileName);
		List<String> fileList = new ArrayList<String>();

		if (fileRoot.isFile()) {
			fileList.add(fileRoot.getCanonicalPath());
		} else {
			for (String fileName : fileRoot.list()) {
				fileList.addAll(generateFileList(new File(fileRoot, fileName).getCanonicalPath()));
			}
		}
		return fileList;
	}

	public static void zipDir(String source, String zipFileName) throws IOException {
		File dirPath = new File(source);

		if (!dirPath.exists())
			throw new IOException("Directory specified by path - " + source + " does not exist.");

		if (!dirPath.isDirectory())
			throw new IOException("Path specifed is not a directory, please recheck. Path - " + source);

		zipIt(source, zipFileName);
	}

	private static void zipIt(String sourcePath, String zipFileName) throws IOException {
		String source = "";

		try {
			source = sourcePath.substring(sourcePath.lastIndexOf("/") + 1, sourcePath.length());
		} catch (Exception e) {
			source = sourcePath;
		}

		byte[] buffer = new byte[1024];
		ZipOutputStream zos = null;

		try {
			zos = new ZipOutputStream(new FileOutputStream(zipFileName));
			FileInputStream in = null;

			for (String fileName : generateFileList(sourcePath)) {
				zos.putNextEntry(new ZipEntry(fileName.substring(fileName.indexOf(source), fileName.length())));

				try {
					in = new FileInputStream(fileName);

					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				} finally {
					in.close();
				}
				zos.closeEntry();
			}
		} finally {
			try {
				zos.close();
			} catch (IOException e) {
			}
		}
	}

	public static String getCSVRowData(String filePath, int rowIndex) throws Exception {
		File file = new File(filePath);

		if (!file.exists()) {
			throw new Exception("CSV File not found");
		}

		if (file.isDirectory()) {
			throw new Exception("File path provided is a directory");
		}

		if (!FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("csv")) {
			throw new Exception("File is not a valid csv file");
		}

		List<String> lines = new ArrayList<String>();
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(file));

		try {
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} finally {
			br.close();
		}

		return lines.get(rowIndex);
	}
}
