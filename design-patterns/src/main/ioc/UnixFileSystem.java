package main.ioc;

public class UnixFileSystem implements FileSystem {

	@Override
	public String readfile() {
		return "Unix file system read";
	}

}
