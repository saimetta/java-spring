package main.caseofstudy.modelprinter.rendering;

import main.caseofstudy.modelprinter.documentstructure.BaseObject;

public interface RenderingSystem {

	void setRenderer(BaseObjectRenderer renderer);
	String render(BaseObject object);
}
