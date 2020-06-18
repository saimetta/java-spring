package main.ioc;

public class ImageService {
	//Replace this for IoC
	//private FileSystem filesystem = new UnixFileSystem();
	private FileSystem filesystem;
	
	public String readImage() {
		return filesystem.readfile();
	}
	
	public void setFileSystem(FileSystem fileSystem) {
		this.filesystem = fileSystem;
	}
}
