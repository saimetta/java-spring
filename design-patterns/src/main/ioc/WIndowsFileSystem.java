package main.ioc;

public class WIndowsFileSystem  implements FileSystem {

	@Override
	public String readfile() {
		return "Windows file system read";
	}

}
